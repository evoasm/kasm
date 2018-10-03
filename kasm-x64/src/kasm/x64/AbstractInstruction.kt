package kasm.x64

import java.nio.ByteBuffer

abstract class AbstractInstruction {
    abstract fun encode(buffer: ByteBuffer,
                        model: InstructionModel,
                        options: EncodingOptions = EncodingOptions.DEFAULT,
                        tracer: InstructionTracer? = null)

}

interface JumpInstruction
interface MoveInstruction
interface StackInstruction
interface VectorInstruction
