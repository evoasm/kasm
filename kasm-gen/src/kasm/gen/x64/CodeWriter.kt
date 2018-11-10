package kasm.gen.x64

import java.io.PrintWriter
import java.util.*

class CodeWriter(val printWriter: PrintWriter) : Appendable by printWriter {

    private var indentation = 0
    private var afterNewLine = false

    fun indentationString() = writeIndention(StringBuilder()).toString()
    private fun <A: Appendable> writeIndention(buffer: A) = 0.until(indentation).map { " " }.joinTo(buffer,"")

    fun println(value: String) {
        printNewlineIfNeeded()
        printWriter.println(value)
        afterNewLine = true
    }

    fun println() {
        printNewlineIfNeeded()
        printWriter.println()
        afterNewLine = true
    }

    fun print(value: String) {
        printNewlineIfNeeded()
        printWriter.print(value)
    }

    private fun printNewlineIfNeeded() {
        if (afterNewLine) {
            writeIndention(this)
            afterNewLine = false
        }
    }

    fun indent(indentation: Int? = null, body: () -> Unit) {
        val originalIndentation = this.indentation
        if (indentation != null) {
            this.indentation = indentation
        } else {
            this.indentation += 2
        }

        body()

        this.indentation = originalIndentation
    }

    enum class FunctionModifier {
        OVERRIDE,
        ABSTRACT
    }

    private fun String?.addSpaceIfPresent() : String {
        if(this != null && isNotEmpty()) {
            return this + " "
        } else {
            return ""
        }
    }

    fun writeFunction(functionName: String,
                      parameters: List<Pair<String, String>>,
                      modifiers: EnumSet<FunctionModifier>,
                      returnType : String? = null,
                      body: (() -> Unit)?) {
        print(modifiers.joinToString(" ") { it.name.toLowerCase() }.addSpaceIfPresent())
        print("fun $functionName(")
        print(parameters.map {
            "${it.first}: ${it.second}"
        }.joinToString(", "))
        print(")")
        if(returnType != null) {
            print(": ${returnType}")
        }
        if (body != null) {
            writeBlock(" ", body)
        } else {
            println()
        }
    }

    fun writeBlock(body: () -> Unit) {
        writeBlock(null, body)
    }

    fun writeBlock(prefix: String? = null, body: () -> Unit) {
        println("${prefix.addSpaceIfPresent()}{")
        indent(null, body)
        println("}")
    }

    fun writeEncodeFunction(operands: List<ExplicitOperand>,
                            memory: Boolean = false,
                            modifiers: EnumSet<FunctionModifier> = NO_FUNCTION_MODIFIERS,
                            body: (() -> Unit)? = null) {
        val postParameters = mutableListOf<Pair<String, String>>()
        val override = FunctionModifier.OVERRIDE in modifiers
        postParameters.add(encodingOptionsParameter(!override))
        postParameters.add(tracerParameter(!override))

        writeEncodeFunction("encode", listOf(BUFFER_PARAMETER), operands, postParameters, memory, modifiers, body)
    }

    fun writeTraceFunction(operands: List<ExplicitOperand>,
                           memory: Boolean = false,
                           modifiers: EnumSet<FunctionModifier> = NO_FUNCTION_MODIFIERS,
                           body: (() -> Unit)? = null) {
        writeEncodeFunction("trace",
                listOf("tracer" to "InstructionTracer"),
                operands,
                listOf(),
                memory,
                modifiers,
                body)
    }


    fun writeEncodeFunction(functionName: String,
                            parameters: List<Pair<String, String>>,
                            operands: List<ExplicitOperand>,
                            postParameters: List<Pair<String, String>> = listOf(),
                            memory: Boolean = false,
                            modifiers: EnumSet<FunctionModifier> = NO_FUNCTION_MODIFIERS,
                            body: (() -> Unit)? = null) {
        val parameters_ = parameters.toMutableList()
        parameters_.addAll(encodeFunctionParameters(operands, memory))
        parameters_.addAll(postParameters)
        writeFunction(functionName, parameters_, modifiers, null, body)
    }

    companion object {
        internal fun encodeFunctionParameters(operands: List<ExplicitOperand>,
                                              memory: Boolean): List<Pair<String, String>> {
            return operands.map {
                encodeFunctionParameter(it, memory)
            }
        }

        fun encodingOptionsParameter(withDefault: Boolean): Pair<String, String> {
            return "options" to if (!withDefault) "EncodingOptions" else "EncodingOptions = EncodingOptions.DEFAULT"
        }

        fun tracerParameter(withDefault: Boolean) : Pair<String, String> {
            return "tracer" to if (!withDefault) "InstructionTracer?" else "InstructionTracer? = null"
        }

        private fun encodeFunctionParameter(operand: Operand, memory: Boolean): Pair<String, String> {
            return if (memory) {
                operand.parameterVariants.memoryVariant
            } else {
                operand.parameterVariants.registerVariant
            }!!.let {
                it.name to it.type
            }
        }

        @JvmField
        val OVERRIDE_FUNCTION_MODIFIER = EnumSet.of(FunctionModifier.OVERRIDE)

        @JvmField
        val ABSTRACT_FUNCTION_MODIFIER = EnumSet.of(FunctionModifier.ABSTRACT)

        @JvmField
        val NO_FUNCTION_MODIFIERS = EnumSet.noneOf(FunctionModifier::class.java)

        @JvmField
        val BUFFER_PARAMETER = "buffer" to "ByteBuffer"
    }

    fun writeCall(functionName: String, parameters: List<String>) {
        print(functionName)
        print("(")
        print(parameters.joinToString(", "))
        println(")")
    }

    fun writeEncodeCall(functionName: String,
                        parameters: List<String>,
                        operands: List<ExplicitOperand>,
                        memory: Boolean) {
        writeEncodeCall(functionName, parameters, operands, listOf(), memory)
    }

    fun writeEncodeCall(functionName: String,
                        parameters: List<String>,
                        operands: List<ExplicitOperand>,
                        postParameter: List<String> = listOf(),
                        memory: Boolean) {
        val encodeParameters = operands.map {
            it.let { encodeFunctionParameter(it, memory).first }
        }
        val allParameters = parameters + encodeParameters + postParameter
        writeCall(functionName, allParameters)
    }
}

