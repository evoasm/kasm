package kasm.gen.x64

import kasm.x64.*
import java.util.*
import java.util.regex.Matcher
import kotlin.reflect.KClass

class OperandParser(val pair: Pair<String, String>, val haveVex: Boolean) {

    companion object {

        val IMM_OP_REGEXP = """^(imm|rel)(\d+)?$""".toRegex()
        val MEM_OP_REGEXP = """^m(\d*)$""".toRegex()
        val MOFFS_OP_REGEXP = """^moffs(\d+)$""".toRegex()
        val VSIB_OP_REGEXP = """^vm(?:\d+)(x|y)(\d+)$""".toRegex()
        val REG_OP_REGEXP = """^(?<reg1>xmm|ymm|zmm|mm)(?:\[(?<rangeMin>\d+)\.\.(?<rangeMax>\d+)\])?$|^(?<reg2>r)(?<regSize>8|16|32|64)$""".toRegex()
        val RM_OP_REGEXP = """^(?:(?<reg1>xmm|ymm|zmm|mm)|(?<reg2>r)(?<regSize>8|16|32|64)?)/m(?<memSize>\d+)$""".toRegex()
    }

    private var name = pair.first
    private var isEncoded = "e" in pair.second
    private var isMnemonic = "m" in pair.second
    private var isRead = "r" in pair.second
    private var isSometimesWritten = "w?" in pair.second
    private val isAlwaysWritten = !isSometimesWritten && "w" in pair.second
    private val isWritten = isAlwaysWritten || isSometimesWritten

    private fun parseImplicitRegister(registerName: String): Generator.ImplicitRegister {
        var readBits: BitRange? = null
        var writtenBits: BitRange? = null

        val size = when (registerName) {
            "RAX", "RCX", "RDX", "RBX", "RSP", "RBP", "RSI", "RDI", "RIP" -> BitSize._64
            "EAX", "ECX", "EDX", "EBX", "ESI", "EDI" -> {
                writtenBits = BitRange._0_63
                BitSize._32
            }
            "AX", "CX", "DX", "SP", "BP", "SI", "DI" -> BitSize._16
            "CL", "SIL", "DIL" -> BitSize._8
            "AL" -> {
                readBits = BitRange._0_7
                writtenBits = BitRange._0_7
                BitSize._8
            }
            "AH" -> {
                readBits = BitRange._8_15
                writtenBits = BitRange._8_15
                BitSize._8
            }
            "XMM0" -> {
                writtenBits = if (haveVex) {
                    BitRange._0_511
                } else {
                    BitRange._0_127
                }
                BitSize._128
            }
            else -> throw IllegalArgumentException("unexpected register '$registerName'")
        }

        val register: Register = when (registerName) {
            "RAX" -> GpRegister64.RAX
            "EAX" -> GpRegister32.EAX
            "AX" -> GpRegister16.AX
            "AL" -> GpRegister8.AL
            "AH" -> GpRegister8.AL
            "RCX" -> GpRegister64.RCX
            "ECX" -> GpRegister32.ECX
            "CX" -> GpRegister16.CX
            "CL" -> GpRegister8.CL
            "RDX" -> GpRegister64.RDX
            "EDX" -> GpRegister32.EDX
            "DX" -> GpRegister16.DX
            "RBX" -> GpRegister64.RBX
            "EBX" -> GpRegister32.EBX
            "RSP" -> GpRegister64.RSP
            "SP" -> GpRegister16.SP
            "RBP" -> GpRegister64.RBP
            "BP" -> GpRegister16.BP
            "RSI" -> GpRegister64.RSI
            "ESI" -> GpRegister32.ESI
            "SI" -> GpRegister16.SI
            "SIL" -> GpRegister8.SIL
            "RDI" -> GpRegister64.RDI
            "EDI" -> GpRegister32.EDI
            "DI" -> GpRegister16.DI
            "DIL" -> GpRegister8.DIL
            "RIP" -> IpRegister.RIP
            "XMM0" -> XmmRegister.XMM0
            else -> throw IllegalArgumentException("unexpected register '$registerName'")
        }
        return Generator.ImplicitRegister(register, size, (readBits ?: size.toBitRange()).takeIf { isRead }, (writtenBits ?: size.toBitRange()).takeIf { isWritten })
    }

    fun toOperandSize(size: Int): BitSize {
        return when (size) {
            8 -> BitSize._8
            16 -> BitSize._16
            32 -> BitSize._32
            64 -> BitSize._64
            128 -> BitSize._128
            256 -> BitSize._256
            512 -> BitSize._512
            else -> throw IllegalArgumentException("invalid size $size")
        }
    }

    private inline fun match(regex: Regex, string: String, action: (Matcher) -> Unit) {
        val matcher = regex.toPattern().matcher(string)
        if (matcher.matches()) {
            action(matcher)
        }
    }

//    private fun concretizeMemoryRegisterOperand(operand: ExplicitMemoryRegisterOperand, memory: Boolean): Operand {
//        if (memory) {
//            return ExplicitMemoryOperand(operand.size, operand.writtenBits, operand.isAlwaysWritten, operand.isSometimesWritten, operand.isRead, operand.name)
//        } else {
//            return ExplicitRegisterOperand(operand.size, operand.writtenBits, operand.isAlwaysWritten, operand.isSometimesWritten, operand.isRead, operand.registerVariant, operand.type, operand.name)
//        }
//    }


    fun parse(): Operand {

        val nameAsInt = name.toIntOrNull()
        if (nameAsInt != null) {
            return implicitImmediateOperand(nameAsInt)
        }

        if (name.toUpperCase() == name) {
            return parseImplicitOperand()
        } else {
            return parseExplicitOperand()
        }
    }

    private fun implicitImmediateOperand(immediateValue: Int): Operand {
        return ImplicitImmediateOperand(immediateValue.toLong())
    }


    private fun bitRangeFromRange(wordRange: IntRange): BitRange {
        return when (wordRange) {
            (0..31) -> BitRange._0_31
            (0..63) -> BitRange._0_63
            (64..127) -> BitRange._64_127
            else -> throw IllegalArgumentException()
        }
    }


    private fun parseRegisterSizeAndType(registerType: String, directSize: Int?): Pair<BitSize, RegisterType> {
        return when (registerType) {
            "r" -> toOperandSize(directSize!!) to when (directSize) {
                8 -> RegisterType.GP8
                16 -> RegisterType.GP16
                32 -> RegisterType.GP32
                64 -> RegisterType.GP64
                else -> throw IllegalArgumentException()
            }
            "xmm" -> BitSize._128 to RegisterType.XMM
            "ymm" -> BitSize._256 to RegisterType.YMM
            "zmm" -> BitSize._512 to RegisterType.ZMM
            "mm" -> BitSize._64 to RegisterType.MM
            else -> throw IllegalArgumentException("unexpected operand '$registerType'")
        }
    }

    private fun parseExplicitOperand(): Operand {
        match(IMM_OP_REGEXP, name) {
            val immediateSize = toOperandSize(it.group(2).toInt())
            return ExplicitImmediateOperand(immediateSize, name)
        }

        match(RM_OP_REGEXP, name) {
            val indirectSize = it.group("memSize")!!.toInt()
            val directSize = it.group("regSize").let {
                if (it == null) {
                    indirectSize
                } else {
                    it.toInt()
                }
            }

            val registerType = (it.group("reg1") ?: it.group("reg2"))!!
            val (size, type) = parseRegisterSizeAndType(registerType, directSize)

            val accessedMemoryBits = toOperandSize(indirectSize).toBitRange()
            val accessedRegisterBits = toOperandSize(directSize).toBitRange()

            val writtenMemoryBits = accessedMemoryBits
            val writtenRegisterBits = when (type) {
            // 32-bit GP registers clear upper double word (i.e. write to it)
                RegisterType.GP32 -> BitRange._0_63
                RegisterType.XMM -> if (haveVex) BitRange._0_511 else accessedRegisterBits
                else -> accessedRegisterBits
            }

            val readMemoryBits = accessedMemoryBits
            val readRegisterBits = accessedRegisterBits

            return ExplicitMemoryRegisterOperand(size,
                    readMemoryBits.takeIf { isRead },
                    readRegisterBits.takeIf { isRead },
                    writtenMemoryBits.takeIf { isWritten },
                    writtenRegisterBits.takeIf { isWritten },
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    type,
                    name)
        }

        match(REG_OP_REGEXP, name) {
            val registerType = (it.group("reg1") ?: it.group("reg2"))!!
            val accessedBitsAsRange = if (it.group("rangeMin") != null) {
                (it.group("rangeMin").toInt()..it.group("rangeMax").toInt())
            } else {
                null
            }
            val directSize = it.group("regSize")?.toInt()

            val (size, type) = parseRegisterSizeAndType(registerType, directSize)

            val accessedBits = if (accessedBitsAsRange != null) {
                bitRangeFromRange(accessedBitsAsRange)
            } else size.toBitRange()

            val readBits = accessedBits
            val writtenBits = when (type) {
                RegisterType.GP32 -> BitRange._0_63
                RegisterType.XMM -> if (haveVex) BitRange._0_511 else accessedBits
                else -> accessedBits
            }

            return ExplicitRegisterOperand(size,
                    readBits.takeIf { isRead },
                    writtenBits.takeIf { isWritten },
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    type,
                    name)
        }

        match(MEM_OP_REGEXP, name) {
            val size = toOperandSize(it.group(1).toInt())
            val accessedBits = size.toBitRange()

            return ExplicitMemoryOperand(size,
                    accessedBits.takeIf { isRead },
                    accessedBits.takeIf { isWritten },
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    name)
        }

        match(MOFFS_OP_REGEXP, name) {
            val size = toOperandSize(it.group(1).toInt())
            return ExplicitImmediateOperand(size, name, isOffset = true)
        }

        match(VSIB_OP_REGEXP, name) {
            val (size, type) = parseRegisterSizeAndType(it.group(1) + "mm", null)
            val accessedBits = size.toBitRange()
            return ExplicitVectorMemoryOperand(size,
                    accessedBits.takeIf { isRead },
                    accessedBits.takeIf { isWritten },
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    type,
                    name)
        }

        throw IllegalArgumentException("unmatched operator '$name'")
    }

    private fun parseImplicitOperand(): Operand {
        val indirect = name.startsWith("[")
        val sanitizedOperandNames = name.replace("\\[|\\]".toRegex(), "").split("\\s*\\+\\s*".toRegex())

        val baseRegister = parseImplicitRegister(sanitizedOperandNames[0])
        val indexRegister = if (sanitizedOperandNames.size > 1) parseImplicitRegister(sanitizedOperandNames[1]) else {
            null
        }

        return if (indirect) {
            ImplicitMemoryOperand(baseRegister.size,
                    baseRegister.readBits,
                    baseRegister.writtenBits,
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    baseRegister.register,
                    indexRegister?.register,
                    name)
        } else {
            ImplicitRegisterOperand(baseRegister.size,
                    baseRegister.readBits,
                    baseRegister.writtenBits,
                    isAlwaysWritten,
                    isSometimesWritten,
                    isRead,
                    baseRegister.register,
                    name)
        }
    }


}


class OperandsParser(val list: MutableList<Pair<String, String>>, val haveVex: Boolean) {

    private fun <T : Enum<T>> findEnum(name: String, enumClass: Class<T>): T? {
        return enumClass.enumConstants.find {
            it.name == name
        }
    }

    fun parse(): List<Operand> {

        list.map {
            val operandName = it.first
            val enumKey = findEnum(operandName, Rflag::class.java) ?:
                    findEnum(operandName, MxcsrFlag::class.java) ?:
                    operandName
            Pair(enumKey, it.second)
        }.partition { it.first is CpuFlag }.let {
            return parseNonFlagOperands(it.second as List<Pair<String, String>>) + parseFlagOperands(it.first as List<Pair<CpuFlag, String>>)
        }
    }

    private fun parseNonFlagOperands(nonFlagOperands: List<Pair<String, String>>): List<Operand> {
        return nonFlagOperands.map {
            OperandParser(it, haveVex).parse()
        }.also {
            loadOperandParameters(it)
        }
    }

    private fun parseFlagOperands(flagOperands: List<Pair<CpuFlag, String>>): List<Operand> {
        val (rFlagOperands, mxcsrOperands) = flagOperands.partition { it.first is Rflag }

        val operands = mutableListOf<Operand>()

        if (rFlagOperands.isNotEmpty()) {
            val (readRflags, alwaysWrittenRflags, sometimesWrittenRflags) = partitionFlagOperands<Rflag>(rFlagOperands as List<Pair<Rflag, String>>,
                    Rflag::class)
            operands.add(RflagsOperand(readRflags, alwaysWrittenRflags, sometimesWrittenRflags))
        }

        if (mxcsrOperands.isNotEmpty()) {
            val (readMxcsrFlags, alwaysWrittenMxcsrFlags, sometimesWrittenMxcsrFlags) = partitionFlagOperands<MxcsrFlag>(
                    mxcsrOperands as List<Pair<MxcsrFlag, String>>,
                    MxcsrFlag::class)
            operands.add(MxcsrOperand(readMxcsrFlags, alwaysWrittenMxcsrFlags, sometimesWrittenMxcsrFlags))
        }

        return operands
    }

    private fun <T : Enum<T>> partitionFlagOperands(flagOperands: List<Pair<T, String>>,
                                                    enumClass: KClass<T>): List<EnumSet<T>> {
        val readFlags = EnumSet.noneOf(enumClass.java)
        val alwaysWrittenFlags = EnumSet.noneOf(enumClass.java)
        val sometimesWrittenFlags = EnumSet.noneOf(enumClass.java)

        flagOperands.forEach {
            if ("w" in it.second || "u" in it.second) {
                sometimesWrittenFlags.add(it.first)
            }

            if ("0" in it.second || "1" in it.second) {
                alwaysWrittenFlags.add(it.first)
            }

            if ("r" in it.second) {
                readFlags.add(it.first)
            }
        }

        return listOf(readFlags, alwaysWrittenFlags, sometimesWrittenFlags)
    }


    private fun numericTypeForSize(operandSize: BitSize): String {
        val type = when (operandSize) {
            BitSize._64 -> "Long"
            BitSize._32 -> "Int"
            BitSize._16 -> "Short"
            BitSize._8 -> "Byte"
            else -> throw IllegalArgumentException(operandSize.toString())
        }
        return type
    }

    private fun loadOperandParameters(operands: List<Operand>) {
        operands.zip(operandParameters(operands)) { operand, parameter ->
            operand.parameterVariants.registerVariant = parameter
        }

        operands.zip(operandParameters(operands, memory = true)) { operand, parameter ->
            operand.parameterVariants.memoryVariant = parameter
        }
    }

    private fun operandParameters(operands: List<Operand?>,
                                  memory: Boolean = false,
                                  general: Boolean = false): List<Operand.Parameter?> {
        var registerCounter = 0;
        var immediateCounter = 0;

        val useRegisterCounter = operands.count { it is ExplicitRegisterOperand || (!memory && it is ExplicitMemoryRegisterOperand) } > 1
        val useImmediateCounter = operands.count { it is ExplicitImmediateOperand } > 1

        fun registerOperandParameter(registerType: RegisterType, operandSize: BitSize): Operand.Parameter {
            val type = when (registerType) {
                RegisterType.ZMM -> "ZmmRegister"
                RegisterType.YMM -> "YmmRegister"
                RegisterType.XMM -> "XmmRegister"
                RegisterType.GP64, RegisterType.GP32, RegisterType.GP16, RegisterType.GP8 -> {
                    "GpRegister${operandSize.toInt()}"
                }
                RegisterType.MM -> "MmRegister"
                else -> throw IllegalArgumentException(registerType.toString())
            }
            val parameterName = "register${if (useRegisterCounter) (1 + registerCounter++).toString() else ""}"
            return Operand.Parameter(parameterName, type)
        }

        return operands.map { operand ->
            if (operand == null) return@map null
            if (operand.isImplicit) return@map null

            when (operand) {
                is ExplicitRegisterOperand -> {
                    registerOperandParameter(operand.type, operand.size)
                }

                is ExplicitMemoryRegisterOperand -> {
                    if (memory) {
                        Operand.Parameter("address", "Address" + operand.size.toInt())
                    } else {
                        registerOperandParameter(operand.type, operand.size)
                    }
                }

                is ExplicitVectorMemoryOperand -> {
                    Operand.Parameter("vectorAddress", "VectorAddress")
                }

                is ExplicitMemoryOperand -> {
                    Operand.Parameter("address", "Address" + operand.size.toInt())
                }

                is ExplicitImmediateOperand -> {
                    val type = numericTypeForSize(operand.size)
                    val parameterName = if(operand.isOffset) {
                        "offset"
                    } else {
                        "immediate${if (useImmediateCounter) (1 + immediateCounter++).toString() else ""}"
                    }
                    Operand.Parameter(parameterName, type)
                }

                else -> throw IllegalArgumentException(operand.toString())
            }
        }
    }

}