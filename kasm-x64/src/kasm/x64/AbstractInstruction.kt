package kasm.x64

import kasm.Buffer

abstract class AbstractInstruction {
    abstract fun encode(buffer: Buffer,
                        model: InstructionModel,
                        options: EncodingOptions = EncodingOptions.DEFAULT,
                        tracer: InstructionTracer? = null)

}

interface JumpInstruction
interface MoveInstruction
interface StackInstruction
interface VectorInstruction
