package kasm.gen.x64

import kasm.ext.ifEmpty
import kasm.ext.ifNull
import kasm.x64.*
import kasm.x64.RegisterType.*
import java.io.BufferedReader
import java.util.*
import kotlin.reflect.KClass

class InstructionGenerator(generator: Generator,
                           val mnemonics: List<String>,
                           val opcode: String,
                           val features: EnumSet<CpuFeature>,
                           val exceptions: EnumSet<CpuException>,
                           val encoding: String,
                           val legacyPrefixes: Array<LegacyPrefix?>,
                           val operands: List<Operand>,
                           val rex: Rex?,
                           val vex: Vex?) {


    companion object {
        val UNAMBIGUOUS_MNEMONICS = setOf("CPUID")
    }

    var className: String

    init {
        if (primaryMnemonic in UNAMBIGUOUS_MNEMONICS) {
            className = primaryMnemonic.toLowerCase().capitalize()
        } else {
            val operands = operands.filterNot { it is FlagsRegisterOperand<*> }
            className = primaryMnemonic.toLowerCase().capitalize() + operands.joinToString("") { it.identifierName }
        }
    }

    fun getAssemblerFunctionName(): String {
        val operands = if (primaryMnemonic in UNAMBIGUOUS_MNEMONICS) {
            emptyList()
        } else {
            operands.filter {
                it.isImplicit && when (it) {
                    is FlagsRegisterOperand<*> -> false
                    is ImplicitRegisterOperand -> {
                        when {
                            it.register is IpRegister                                    -> false
                            GpRegister.isBp(it.register) || GpRegister.isSp(it.register) -> false
                            else                                                         -> true
                        }
                    }
                    else                       -> false
                }
            }
        }
        return primaryMnemonic.toLowerCase() + operands.joinToString("") { it.identifierName }
    }

    val hasMemoryRegisterOperand by lazy {
        operands.any { it is ExplicitMemoryRegisterOperand }
    }

    val primaryMnemonic get() = mnemonics.first()

    fun write(writer: CodeWriter) {

        if (features.any { "AVX512" in it.name }) return

        val parents = mutableListOf("${instructionInterface.name}()")
        if (operands.any { it is ImplicitRegisterOperand && it.register is IpRegister }) {
            parents.add("JumpInstruction")
        }
        if (operands.any { it is ImplicitRegisterOperand && GpRegister.isSp(it.register) }) {
            parents.add("StackInstruction")
        }
        if (operands.any { it is RegisterOperand && it.type.isVectorType }) {
            parents.add("VectorInstruction")
        }
        /*FIXME: risk of false positives/negatives ? */
        if (mnemonics.any { "MOV" in it }) {
            parents.add("MoveInstruction")
        }

        features.forEach {
            parents.add(FeatureInterfaceGenerator.getInterfaceName(it))
        }

        writer.writeBlock("object $className : ${parents.joinToString()}") {
            writer.writeEncodeFunction(explicitOperands, false, CodeWriter.OVERRIDE_FUNCTION_MODIFIER) {
                writeEncodeFunctionBody(writer, false)
            }

            writer.writeTraceFunction(explicitOperands,
                                      memory = false,
                                      modifiers = CodeWriter.OVERRIDE_FUNCTION_MODIFIER) {
                writeTraceFunctionBody(writer, false)
            }

            if (hasMemoryRegisterOperand) {
                writer.writeEncodeFunction(explicitOperands, true, modifiers = CodeWriter.OVERRIDE_FUNCTION_MODIFIER) {
                    writeEncodeFunctionBody(writer, true)
                }

                writer.writeTraceFunction(explicitOperands,
                                          memory = true,
                                          modifiers = CodeWriter.OVERRIDE_FUNCTION_MODIFIER) {
                    writeTraceFunctionBody(writer, true)
                }
            }

            run {
                val bufferParameter = CodeWriter.BUFFER_PARAMETER
                val tracerParameter = CodeWriter.tracerParameter(false)
                val encodingOptionsParameter = CodeWriter.encodingOptionsParameter(false)
                writer.writeFunction("encode",
                                     listOf(bufferParameter,
                                            "model" to "InstructionModel",
                                            encodingOptionsParameter,
                                            tracerParameter), CodeWriter.OVERRIDE_FUNCTION_MODIFIER) {
                    if (!hasMemoryRegisterOperand) {
                        writeEncodeCallWithModel(writer,
                                                 false,
                                                 bufferParameter,
                                                 encodingOptionsParameter,
                                                 tracerParameter)
                    } else {
                        writer.writeBlock("if(model.useAddress())") {
                            writeEncodeCallWithModel(writer,
                                                     true,
                                                     bufferParameter,
                                                     encodingOptionsParameter,
                                                     tracerParameter)
                        }
                        writer.writeBlock("else") {
                            writeEncodeCallWithModel(writer,
                                                     false,
                                                     bufferParameter,
                                                     encodingOptionsParameter,
                                                     tracerParameter)
                        }
                    }
                }
            }

        }
    }

    private fun writeEncodeCallWithModel(writer: CodeWriter,
                                         memory: Boolean,
                                         bufferParameter: Pair<String, String>,
                                         encodingOptionsParameter: Pair<String, String>,
                                         tracerParameter: Pair<String, String>) {
        val parameters = listOf(bufferParameter.first) + explicitOperands.mapIndexed { index, operand ->
            val operandSize = operand.size.toInt()
            val argumentList = "($index, ${operand.isRead}, ${operand.isWritten})"
            when (operand) {
                is ExplicitMemoryRegisterOperand -> if (memory) "model.getAddress$operandSize$argumentList" else getModelMethodName(
                        operand.type) + argumentList
                is ExplicitMemoryOperand         -> "model.getAddress$operandSize$argumentList"
                is ExplicitVectorMemoryOperand   -> "model.getVectorAddress$argumentList"
                is ExplicitRegisterOperand       -> getModelMethodName(operand.type) + argumentList
                is ExplicitImmediateOperand      -> "model." + when (operand.size) {
                    BitSize._8  -> "getByte"
                    BitSize._16 -> "getShort"
                    BitSize._32 -> "getInt"
                    BitSize._64 -> "getLong"
                    else        -> throw IllegalArgumentException()
                } + "Immediate($index)"
                else                             -> throw IllegalArgumentException(operand::class.toString())
            }
        } + listOf(encodingOptionsParameter.first, tracerParameter.first)

        writer.writeCall("encode", parameters)
    }

    private fun getModelMethodName(type: RegisterType): String {
        return "model." + when (type) {
            GP64 -> "getGpRegister64"
            GP32 -> "getGpRegister32"
            GP16 -> "getGpRegister16"
            GP8  -> "getGpRegister8"
            MM   -> "getMmRegister"
            ZMM  -> "getZmmRegister"
            YMM  -> "getYmmRegister"
            XMM  -> "getXmmRegister"
            else -> throw IllegalArgumentException()
        }
    }

    val explicitOperands: List<ExplicitOperand> by lazy { operands.filterIsInstance<ExplicitOperand>() }
    private val instructionInterface = generator.getInstructionInterface(explicitOperands)


    private fun findEncodingOperand(letter: Char): ExplicitOperand? {
        return encoding.indexOf(letter).let {
            explicitOperands.getOrNull(it)
        }
    }

    private val oOperand by lazy {
        findEncodingOperand('O')
    }

    private val regOperand by lazy {
        encoding.indexOfAny(charArrayOf('R', 'O')).let {
            explicitOperands.getOrNull(it)
        }
    }

    private val secondRegOperand by lazy {
        if (encoding.count { it == 'R' } == 1) return@lazy null
        encoding.lastIndexOf('R').let {
            explicitOperands.getOrNull(it)
        }
    }

    private val rmOperand by lazy {
        findEncodingOperand('M')
    }

    private val vexOperand by lazy {
        findEncodingOperand('V')
    }

    private val immOperand by lazy {
        when (encoding) {
            "FD", "TD", "D" -> explicitOperands.first()
            else            -> findEncodingOperand('I')
        }
    }

    private fun Register.qualifiedName(): String {
        if (this is SubRegister<*, *>) {
            return this.topLevelRegister.qualifiedName()
        }
        return this.javaClass.name + "." + this.name
    }

    private fun Enum<*>.qualifiedName(): String {
        return this.javaClass.name + "." + this.name
    }

    private fun writeTraceFunctionBody(writer: CodeWriter, memory: Boolean) {
        writer.println("tracer.beginTracing()")

        for (feature in features) {
            writer.writeCall("tracer.traceFeature", listOf("CpuFeature.${feature.name}"))
        }

        loop@ for (operand in operands) {
            if (operand is FlagsRegisterOperand<*>) continue@loop
            writeTraceCall(writer, operand, memory, false)
        }

        operands.filterIsInstance<FlagsRegisterOperand<*>>().forEach {
            it.readFlags.toList().forEach {
                writer.writeCall("tracer.traceRead", listOf(it.qualifiedName()))
            }
        }

        loop@ for (operand in operands) {
            if (operand is FlagsRegisterOperand<*>) continue@loop
            writeTraceCall(writer, operand, memory, true)
        }

        operands.filterIsInstance<FlagsRegisterOperand<*>>().forEach {
            it.alwaysWrittenFlags.toList().forEach {
                writer.writeCall("tracer.traceWrite", listOf(it.qualifiedName(), "true"))
            }
            it.sometimesWrittenFlags.toList().forEach {
                writer.writeCall("tracer.traceWrite", listOf(it.qualifiedName(), "false"))
            }
        }

        writer.println("tracer.endTracing()")
    }

    private fun writeTraceCall(writer: CodeWriter, operand: Operand, memory: Boolean, write: Boolean) {
        if (write && !operand.isWritten) return
        if (!write && !operand.isRead) return

        val parameter = if (memory) {
            operand.parameterVariants.memoryVariant
        } else {
            operand.parameterVariants.registerVariant
        }

        val functionName = "tracer.trace" + if (write) "Write" else "Read"

        val name = when (operand) {
            is ImplicitImmediateOperand      -> operand.value.toString() + "L"
            is ImplicitRegisterOperand       -> operand.register.qualifiedName()
            is ImplicitMemoryOperand         -> "Address${operand.size.toInt()}(${operand.baseRegister.qualifiedName()}, ${operand.indexRegister?.qualifiedName() ?: "null"})"
            is ExplicitImmediateOperand      -> parameter!!.name + if (operand.size != BitSize._64) ".toLong()" else ""
            is ExplicitRegisterOperand       -> parameter!!.name + if (operand.type.isSubRegisterType) ".topLevelRegister" else ""
            is ExplicitMemoryRegisterOperand -> parameter!!.name + if (!memory && operand.type.isSubRegisterType) ".topLevelRegister" else ""
            else                             -> parameter!!.name
        }

        val haveAddressParameter = (memory && operand is ExplicitMemoryRegisterOperand) || operand is ExplicitMemoryOperand || operand is ImplicitMemoryOperand || operand is ExplicitVectorMemoryOperand

        val rangeOrSizeParamter = when (operand) {
            is ExplicitImmediateOperand -> "BitSize." + operand.size
            is ImplicitImmediateOperand -> "null"
            else                        -> {
                if (haveAddressParameter) {
                    null
                } else {
                    if (write) {
                        when (operand) {
                            is ImplicitRegisterOperand       -> operand.writtenBits
                            is ExplicitRegisterOperand       -> operand.writtenBits
                            is ExplicitMemoryRegisterOperand -> if (memory) operand.writtenMemoryBits else (operand.writtenRegisterBits)
                            else                             -> throw IllegalStateException()
                        }
                    } else {
                        when (operand) {
                            is ImplicitRegisterOperand       -> operand.readBits
                            is ExplicitRegisterOperand       -> operand.readBits
                            is ExplicitMemoryRegisterOperand -> operand.readRegisterBits
                            else                             -> throw IllegalStateException(operand::class.toString())
                        }
                    }?.let {
                        "BitRange." + it
                    } ?: "null"
                }
            }
        }

        val implicitParameter = if (haveAddressParameter) null else if (operand.isImplicit) "true" else "false"

        val parameters = mutableListOf(name, implicitParameter, rangeOrSizeParamter)
        if (write && !haveAddressParameter) {
            parameters.add(if (operand.isAlwaysWritten) "true" else "false")
        }
        writer.writeCall(functionName, parameters.filterNotNull())
    }

    private fun writeEncodeFunctionBody(writer: CodeWriter, memory: Boolean) {
        writer.print("if(tracer != null) ")
        writer.writeEncodeCall("trace", listOf("tracer"), explicitOperands, listOf(), memory)

        run {
            val parameters = listOf("buffer",
                                    "options.legacyPrefixOrder") + legacyPrefixes.mapIndexed { index, legacyPrefix ->
                if (legacyPrefix == null) {
                    val group = index + 1
                    "options.${if (group == 4) "encodedL" else "l"}egacyPrefix$group"
                } else {
                    legacyPrefix::class.qualifiedName!!
                }
            }

            writer.writeCall("Encoding.encodeLegacyPrefixes", parameters)
        }

        rex?.let {
            val functionName = "RexPrefix." + rexVexEncodeFunctionSuffix() + (if (regOperand?.size == BitSize._8 || rmOperand?.size == BitSize._8) "8" else "") + ".encode" + when {
                it.mandatory -> "Mandatory"
                else         -> ""
            }

            val parameters = mutableListOf("buffer", "options")
            if (it.mandatory) parameters.add(rex.w!!.toString())

            //val parameters = listOf("buffer", "options", rex.mandatory.toString(), rex.w?.toString() ?: "options.rexW")
            writer.writeEncodeCall(functionName, parameters, listOf(regOperand, rmOperand).filterNotNull(), memory)
        }
//        writer.writeEncodeFunctionCall(functionName, explicitOperands, memory)

        vex?.let {
            val functionName = "VexPrefix." + rexVexEncodeFunctionSuffix() + ".encode"
            val parameters = listOf("buffer", "options",
                                    vex.w?.toString() ?: "options.rexW",
                                    vex.m.toString(),
                                    vex.l?.toString() ?: "options.vexL",
                                    vex.p.toString())

            writer.writeEncodeCall(functionName,
                                   parameters,
                                   listOf(regOperand, rmOperand, vexOperand).filterNotNull(),
                                   memory)
        }



        run {
            val byteRegex = "^(\\p{XDigit}{2})(\\+r[bwdq])?$".toRegex()
            val opcodeBytes = opcode.split(" ").mapNotNull {
                byteRegex.matchEntire(it)?.let { matchResult ->
                    matchResult.groups[1]?.value
                }
            }.toMutableList()

//            if("+" in opcodeBytes.last()) {
//                val (oOpcodeByte, oFlag) = opcodeBytes.last().split("+")
//                opcodeBytes[opcodeBytes.lastIndex] = oOpcodeByte
//            }

            val functionName = "Encoding.encodeOpcode" + oOperand.ifNull("", "O")
            val parameters = mutableListOf("buffer")
            opcodeBytes.mapTo(parameters) { "0x" + it }

            writer.writeEncodeCall(functionName, parameters, listOf(oOperand).filterNotNull(), memory)
        }

        rmOperand?.let {
            val byte = """/(r|\d|\?)""".toRegex().find(opcode)!!.let {
                it.groups[1]!!.value
            }

            val operands = mutableListOf(rmOperand)
            val parameters = mutableListOf("buffer", "options")

            if (byte == "r") {
                operands.add(0, regOperand!!)
            } else if (byte == "?") {
            } else if (byte.first().isDigit()) {
                parameters.add(byte)
            } else {
                throw RuntimeException(byte)
            }

            val functionName = "ModRmSib.encode"
            writer.writeEncodeCall(functionName, parameters, operands.filterNotNull(), memory)
        }

        run {
            val regex = """\b[ic][bwdoq]""".toRegex()

            regex.find(opcode)?.let {
                val iOperand = immOperand!!
                val functionName = "Encoding.encodeImmediate" + iOperand.size!!.toInt()
                val parameters = listOf("buffer")
                val operands = listOf(iOperand)
                writer.writeEncodeCall(functionName, parameters, operands, memory)
            }

            if ("/is4" in opcode) {
                val functionName = "Encoding.encodeRegisterImmediate"
                val parameters = listOf("buffer")
                val operands = listOf(secondRegOperand!!)
                writer.writeEncodeCall(functionName, parameters, operands, memory)
            }
        }

    }

    private fun rexVexEncodeFunctionSuffix(): String {
        return listOf(regOperand?.let { "Reg" },
                      rmOperand?.let { "Rm" },
                      vexOperand?.let { "Vex" }).filterNotNull().joinToString("").ifEmpty("Np")
    }

    fun resolveNameConflict() {
        className += encoding.toLowerCase().capitalize()
    }
}


class InstructionInterfaceGenerator(val operands: List<ExplicitOperand>) {

    fun write(writer: CodeWriter) {
        writer.writeBlock("abstract class ${name} : Instruction()") {

            writer.writeEncodeFunction(operands, false, CodeWriter.ABSTRACT_FUNCTION_MODIFIER)
            writer.writeTraceFunction(operands, false, CodeWriter.ABSTRACT_FUNCTION_MODIFIER)
            if (operands.any { it is ExplicitMemoryRegisterOperand }) {
                writer.writeEncodeFunction(operands, true, CodeWriter.ABSTRACT_FUNCTION_MODIFIER)
                writer.writeTraceFunction(operands, true, CodeWriter.ABSTRACT_FUNCTION_MODIFIER)
            }
        }

    }

    val name: String by lazy {
        fun registerAbbreviation(registerType: RegisterType, registerSize: BitSize): String {
            return when (registerType) {
                ZMM  -> "Zmm"
                YMM  -> "Ymm"
                XMM  -> "Xmm"
                GP8  -> "R8"
                GP16 -> "R16"
                GP32 -> "R32"
                GP64 -> "R64"
                MM   -> "Mm"
                else -> throw IllegalArgumentException(registerType.toString())
            }
        }

        operands.mapNotNull { operand ->
            val size = if (operand.size == BitSize._8 || operand is ExplicitImmediateOperand) {
                operand.size?.toInt().toString()
            } else {
                ""
            }

            if (operand.isImplicit) return@mapNotNull null

            when (operand) {
                is ExplicitMemoryOperand         -> "M" + operand.size.toInt()
                is ExplicitMemoryRegisterOperand -> registerAbbreviation(operand.type, operand.size) + "m"
                is ExplicitRegisterOperand       -> registerAbbreviation(operand.type, operand.size)
                is ExplicitVectorMemoryOperand   -> "Vm"
                is ExplicitImmediateOperand      -> "Imm"
                else                             -> throw IllegalArgumentException(operand.toString())
            } + size
        }.let {
            if (it.isEmpty()) {
                listOf("Nullary")
            } else {
                it
            }
        }.joinToString("") + "Instruction"

    }
}

class InstructionsParser(val generator: Generator, val bufferedReader: BufferedReader) {
    fun parse(): List<InstructionGenerator> {
        return bufferedReader.useLines { lines ->
            val instructionNames = mutableSetOf<String>()

            val instructions = lines.mapIndexedNotNull { index, line ->
                if (index == 0) return@mapIndexedNotNull null
                InstructionParser(generator, line.split(",").map { it.trim() }).parse()
            }.toList()

            instructions.forEach {
                if (it.className in instructionNames) {
                    it.resolveNameConflict()
                } else {
                    instructionNames.add(it.className)
                }
            }

            instructions
        }

    }
}

class InstructionParser(val generator: Generator, val row: List<String>) {
    fun parse(): InstructionGenerator? {
        val features = parseFeatures(Generator.splitToList(row, Generator.Column.FEATURES))
        if (features.any { "AVX512" in it.name }) {
            return null
        }

        val mnemonics = row[Generator.Column.MNEMONICS.ordinal].split("/")
        if (mnemonics.isEmpty()) throw RuntimeException()

        val exceptions = parseExceptions(Generator.splitToList(row, Generator.Column.EXCEPTIONS))

        val encoding = row[Generator.Column.ENCODING.ordinal]

        val opcode = row[Generator.Column.OPCODE.ordinal]

        val rex = parseRex(opcode, encoding, Generator.splitToPairList(row, Generator.Column.PREFIXES))
        val vex = parseVex(opcode)

        val legacyPrefixes = parseLegacyPrefixes(Generator.splitToPairList(row, Generator.Column.PREFIXES))
        val operands = parseOperands(Generator.splitToPairList(row, Generator.Column.OPERANDS), vex != null)


        return InstructionGenerator(generator,
                                    mnemonics,
                                    opcode,
                                    features,
                                    exceptions,
                                    encoding,
                                    legacyPrefixes,
                                    operands,
                                    rex,
                                    vex)
    }

    private fun parseOperands(list: MutableList<Pair<String, String>>, haveVex: Boolean): List<Operand> {
        return OperandsParser(list, haveVex).parse()
    }


    private fun parseVex(opcode: String): Vex? {
        if ("VEX" !in opcode) return null

        val vex = opcode.split(" ").first().split(".")

        val vexM = if ("0F38" in vex) {
            0b10
        } else if ("0F3A" in vex) {
            0b11
        } else {
            0b01
        }

        val vexP = if ("66" in vex) {
            0b01
        } else if ("F3" in vex) {
            0b10
        } else if ("F2" in vex) {
            0b11
        } else {
            0b00
        }

        val vexW = if ("W1" in vex) {
            0b01
        } else if ("W0" in vex) {
            0b0
        } else {
            null
        }

//        val vexV = when (encoding) {
//            "RM", "RMI", "XM", "MR", "MRI", "M" -> 0b0000
//            else -> null
//
//        }

        val vexL = if ("LIG" in vex) {
            null
        } else if ("128" in vex) {
            0b0
        } else if ("256" in vex) {
            0b1
        } else if ("LZ" in vex) {
            0b0
        } else {
            throw RuntimeException()
        }

        return Vex(vexW, vexM, vexL, vexP)
    }

    private fun parseRex(opcode: String, encoding: String, prefixes: MutableList<Pair<String, String>>): Rex? {
        val rexPrefix = prefixes.find { it.first == "rex_w" }
        val mustEncodeVex = "VEX" in opcode
        val canEncodeRex = rexPrefix != null || (!mustEncodeVex && listOf("R", "M", "NP", "O").any { it in encoding })

//        if (rexPrefix != null && !canEncodeRex) throw RuntimeException(rexPrefix.toString() + encoding)

        if (!canEncodeRex) return null

        var mandatory: Boolean
        var rexW: Int?
        var optional: Boolean = false

        if (rexPrefix == null) {
            mandatory = false
            rexW = null
        } else {
            val it = rexPrefix.second.split("/")
            mandatory = it[0] == "mandatory"
            optional = it[0] == "optional"
            rexW = if (it[1] == "any") null else it[1].toInt()

        }

        return Rex(w = rexW, mandatory = mandatory, optional = optional)
    }

    private fun parseLegacyPrefixes(prefixes: MutableList<Pair<String, String>>): Array<LegacyPrefix?> {
        val prefixObjects = arrayOfNulls<LegacyPrefix>(LegacyPrefixGroup.values().size)

        prefixes.forEach {
            val (obligation, _) = it.second.split("/")
            val prefixName = it.first

            val prefixClassName = when (prefixName) {
                "pref66"          -> "_66"
                "pref67"          -> "_67"
                "bt"              -> "BranchTaken"
                "bnt"             -> "BranchNotTaken"
                "lock"            -> "LockPrefix"
                "rep", "prefF3"   -> "Rep"
                "repne", "prefF2" -> "Repne"
                "rex_w"           -> null
                else              -> throw IllegalArgumentException(prefixName)
            }

            prefixClassName ?: return@forEach

            if (obligation == "mandatory") {
                (LegacyPrefix::class.nestedClasses.flatMap { it.nestedClasses }.find {
                    it.simpleName == prefixClassName
                } as KClass<LegacyPrefix>).objectInstance!!.also {
                    prefixObjects[it.prefixGroup.ordinal] = it
                }
            }
        }
        return prefixObjects
    }

    private fun parseFeatures(list: MutableList<String>): EnumSet<CpuFeature> {
        return list.mapTo(EnumSet.noneOf(CpuFeature::class.java)) {
            CpuFeature.valueOf(it)
        }
    }

    private fun parseExceptions(list: MutableList<String>): EnumSet<CpuException> {
        return list.mapTo(EnumSet.noneOf(CpuException::class.java)) {
            CpuException.valueOf(it)
        }
    }

//        private fun instructionIterface(memory: Boolean): String {
//            if(explicitOperands.isEmpty()) return "NullaryInstruction"
//            return encodeFunctionParameters(memory).map { it.second }.joinToString("") + "Instruction"
//        }


}