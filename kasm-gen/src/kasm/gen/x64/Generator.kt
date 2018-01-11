package kasm.gen.x64

import kasm.x64.*
import java.io.BufferedReader
import java.io.File
import java.nio.file.Paths
import java.util.*

class Generator {


    companion object {
        private val REX_ENCODINGS = listOf("M", "O", "R", "NP")


        fun splitToList(row: List<String>, column: Column): MutableList<String> {
            row[column.ordinal].let {
                if (it.isEmpty()) return mutableListOf()
                return it.split(";").mapTo(mutableListOf()) { it.trim() }
            }
        }

        fun splitToPairList(row: List<String>, column: Column): MutableList<Pair<String, String>> {
            return splitToList(row, column).mapTo(mutableListOf()) {
                it.split(":").let {
                    it[0] to it[1]
                }
            }
        }
    }

    data class ImplicitRegister(val register: Register,
                                val size: BitSize,
                                val readBits: BitRange?,
                                val writtenBits: BitRange?)

    lateinit var instructionGenerators: List<InstructionGenerator>

    private fun getOutputFile(fileName: String): File {
        return Paths.get(System.getProperty("user.dir"), "kasm-x64", "src", "kasm", "x64", fileName).toFile()
    }

    fun run() {

        parse(this::class.java.getResourceAsStream("x64.csv").bufferedReader())

        getOutputFile("InstructionTypes.kt").printWriter().use {
            val writer = CodeWriter(it)
            writePackageAndImports(writer)
            writeInstructionTypes(writer)
        }

        instructionGenerators.chunked(100).forEachIndexed { index, list ->
            getOutputFile("Instructions${index + 1}.kt").printWriter().use {
                val writer = CodeWriter(it)
                writePackageAndImports(writer)
                writeInstructions(writer, list)
            }
        }


        getOutputFile("AbstractAssembler.kt").printWriter().use {
            val writer = CodeWriter(it)
            writePackageAndImports(writer)
            writeAbstractAssembler(writer)
        }
    }

    private fun parse(bufferedReader: BufferedReader) {
        instructionGenerators = InstructionsParser(this, bufferedReader).parse()
    }


    enum class Column {
        OPCODE,
        MNEMONICS,
        ENCODING,
        OPERANDS,
        PREFIXES,
        FEATURES,
        EXCEPTIONS
    }

    private fun writeAbstractAssembler(writer: CodeWriter) {
        AssemblerGenerator(instructionGenerators).also {
            it.write(writer)
        }
    }

    private fun writeInstructions(writer: CodeWriter, instructionGenerators: List<InstructionGenerator>) {
        for (instruction in instructionGenerators) {
            instruction.write(writer)
        }
    }

    private fun writeInstructionTypes(writer: CodeWriter) {
        for (instructionInterface in instructionInterfaceGenerators) {
            instructionInterface.write(writer)
        }
        InstructionClassGenerator(instructionGenerators).write(writer)
        FeatureInterfaceGenerator(instructionGenerators).write(writer)
    }

    private fun writePackageAndImports(writer: CodeWriter) {
        writer.println("package kasm.x64")
        writer.println()
        writer.println("import kasm.Buffer")
        writer.println()
    }

    private val instructionInterfacesMap = hashMapOf<String, InstructionInterfaceGenerator>()
    val instructionInterfaceGenerators get() = instructionInterfacesMap.values.toList()

    fun getInstructionInterface(operands: List<ExplicitOperand>): InstructionInterfaceGenerator {
        return InstructionInterfaceGenerator(operands).let {
            instructionInterfacesMap.getOrPut(it.name, { it })
        }
    }
}

class FeatureInterfaceGenerator(val instructionGenerators: List<InstructionGenerator>) {

    companion object {
        fun getInterfaceName(feature: CpuFeature): String {
            return "${feature.name.split("_(?!\\d)".toRegex()).joinToString("") { it.toLowerCase().capitalize() }}Instruction"
        }
    }

    fun write(writer: CodeWriter) {
        val usedFeatures = EnumSet.noneOf(CpuFeature::class.java)

        instructionGenerators.forEach {
            usedFeatures.addAll(it.features)
        }

        usedFeatures.forEach {
            writer.println("interface ${getInterfaceName(it)}")
        }
    }
}

class InstructionClassGenerator(val instructionGenerators: List<InstructionGenerator>) {
    fun write(writer: CodeWriter) {
        writer.writeBlock("abstract class Instruction: AbstractInstruction()") {
            writer.writeBlock("companion object") {
                writer.println("val all = listOf(")
                writer.indent {
                    instructionGenerators.joinTo(writer, ",\n") { writer.indentationString() + it.className }
                }
                writer.println(")")
            }
        }
    }
}

class AssemblerGenerator(val instructionGenerators: List<InstructionGenerator>) {


    private fun buildMap(memory: Boolean): MutableMap<Pair<String, List<Pair<String, String>>>, InstructionGenerator> {
        val map = mutableMapOf<Pair<String, List<Pair<String, String>>>, InstructionGenerator>()
        for (instructionGenerator in instructionGenerators) {
            //            val key = instructionGenerator.mnemonics.first().toLowerCase() to CodeWriter.encodeFunctionParameters(instructionGenerator.explicitOperands, memory)

            if (memory && !instructionGenerator.hasMemoryRegisterOperand) continue

            val encodeFunctionParameters = CodeWriter.encodeFunctionParameters(instructionGenerator.explicitOperands,
                                                                               memory)
            val key = instructionGenerator.getAssemblerFunctionName() to encodeFunctionParameters

            map.get(key).also {
                if (it == null) {
                    map.put(key, instructionGenerator)
                } else {
                    if (!memory) {
                        if (it.hasMemoryRegisterOperand && !instructionGenerator.hasMemoryRegisterOperand) {
                            map.put(key, instructionGenerator)
                        }
                    } else {
                        // SKIP
                    }
                }
            }
        }

        return map
    }

    fun write(writer: CodeWriter) {
        writer.writeBlock("abstract class AbstractAssembler: InstructionTracer") {
            writer.println("abstract val buffer: Buffer")
            write(writer, false)
            write(writer, true)
        }
    }

    private fun write(writer: CodeWriter, memory: Boolean) {
        buildMap(memory).forEach { key, instructionGenerator ->
            writer.writeEncodeFunction(key.first,
                                       emptyList(),
                                       instructionGenerator.explicitOperands,
                                       listOf(CodeWriter.encodingOptionsParameter(true)),
                                       memory = memory) {
                writer.writeEncodeCall("${instructionGenerator.className}.encode",
                                       listOf("buffer"),
                                       instructionGenerator.explicitOperands,
                                       listOf("options", "tracer = this"),
                                       memory)
            }
        }
    }

}

fun main(args: Array<String>) {
    Generator().run()
    println(System.getProperty("user.dir"))
}
