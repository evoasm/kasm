package kasm.x64

import java.nio.ByteBuffer

abstract class AbstractInstruction {
    abstract fun encode(buffer: ByteBuffer,
                        parameters: InstructionParameters,
                        options: EncodingOptions = EncodingOptions.DEFAULT,
                        tracer: InstructionTracer? = null)

    abstract fun trace(tracer: InstructionTracer, parameters: InstructionParameters)
    abstract fun isSupported() : Boolean

}

interface JumpInstruction
interface MoveInstruction
interface StackInstruction
interface VectorInstruction
