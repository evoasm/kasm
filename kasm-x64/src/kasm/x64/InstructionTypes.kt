package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

abstract class XmmmYmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte)
}
abstract class YmmM32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression32)
}
abstract class Imm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, immediate: Int)
}
abstract class R64R64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)
}
abstract class XmmM64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)
}
abstract class MmmMmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: MmRegister)
}
abstract class R64R64mR64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64)
}
abstract class YmmYmmXmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128)
}
abstract class R32MmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: MmRegister, immediate: Byte)
}
abstract class Imm16Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, immediate1: Short, immediate2: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, immediate1: Short, immediate2: Byte)
}
abstract class M256YmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression256, register: YmmRegister)
}
abstract class R32R32mImm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Int)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Int)
}
abstract class M64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)
}
abstract class XmmR64mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister64, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64, immediate: Byte)
}
abstract class R64mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)
}
abstract class MmR32mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression32, immediate: Byte)
}
abstract class R64Imm64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Long, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Long)
}
abstract class XmmXmmR64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64)
}
abstract class XmmXmmR32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32)
}
abstract class R8Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)
}
abstract class XmmmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister)
}
abstract class R64mXmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: XmmRegister, immediate: Byte)
}
abstract class M128Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128)
}
abstract class M128XmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister)
}
abstract class YmmYmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)
}
abstract class R16mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)
}
abstract class XmmR64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)
}
abstract class R32XmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression128)
}
abstract class MmMmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)
}
abstract class M32R32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)
}
abstract class R32MmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: MmRegister)
}
abstract class XmmR32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32)
}
abstract class XmmXmmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)
}
abstract class R64mR64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)
}
abstract class XmmYmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression256)
}
abstract class R64mXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: XmmRegister)
}
abstract class R16mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)
}
abstract class R32mImm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)
}
abstract class YmmYmmYmmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte)
}
abstract class R16R16mImm16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16, immediate: Short)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16, immediate: Short)
}
abstract class Imm16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, immediate: Short)
}
abstract class MmMmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression64, immediate: Byte)
}
abstract class R64R32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression32)
}
abstract class M4096Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression512Bytes, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression512Bytes)
}
abstract class R16R16mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16, immediate: Byte)
}
abstract class R32mR32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)
}
abstract class MmR64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression64)
}
abstract class Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, immediate: Byte)
}
abstract class M16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)
}
abstract class M80Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression80, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression80)
}
abstract class R32mXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: XmmRegister)
}
abstract class R64R16mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister16)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression16)
}
abstract class YmmVmYmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister)
}
abstract class R32R32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)
}
abstract class M32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)
}
abstract class M64MmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: MmRegister)
}
abstract class Imm64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, offset: Long, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, offset: Long)
}
abstract class R64mMmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: MmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: MmRegister)
}
abstract class R32R32mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte)
}
abstract class MmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: XmmRegister)
}
abstract class R32R16mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister16)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression16)
}
abstract class XmmXmmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)
}
abstract class R32R8mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression8)
}
abstract class R32mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)
}
abstract class R32XmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)
}
abstract class XmmVmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister)
}
abstract class M64XmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: XmmRegister)
}
abstract class YmmYmmM256Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)
}
abstract class XmmR32mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte)
}
abstract class R8mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)
}
abstract class XmmXmmM128Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)
}
abstract class XmmXmmR64mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, immediate: Byte)
}
abstract class R16mR16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)
}
abstract class XmmXmmXmmmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, register4: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, register4: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, register3: XmmRegister)
}
abstract class NullaryInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer)
}
abstract class R32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)
}
abstract class R32XmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)
}
abstract class R16mR16Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte)
}
abstract class M16R16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)
}
abstract class XmmXmmXmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)
}
abstract class R64XmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression128)
}
abstract class R32R32R32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32)
}
abstract class YmmmYmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression256, register: YmmRegister)
}
abstract class MmR32mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression32)
}
abstract class XmmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)
}
abstract class R16mImm16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)
}
abstract class R64R64mImm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Int)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Int)
}
abstract class YmmM256Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256)
}
abstract class R16Imm16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)
}
abstract class R32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32)
}
abstract class M8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)
}
abstract class R32Imm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)
}
abstract class MmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)
}
abstract class R64R64mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte)
}
abstract class XmmM32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32)
}
abstract class YmmYmmXmmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte)
}
abstract class MmMmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression64)
}
abstract class XmmM128Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)
}
abstract class XmmmXmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister, immediate: Byte)
}
abstract class R32YmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: YmmRegister)
}
abstract class R8mR8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, register: GpRegister8)
}
abstract class R8mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)
}
abstract class XmmXmmXmmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)
}
abstract class M128XmmXmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister)
}
abstract class R64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)
}
abstract class M256YmmYmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister)
}
abstract class R64M64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)
}
abstract class R32M32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)
}
abstract class XmmXmmM64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64)
}
abstract class X87Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: X87Register)
}
abstract class MmXmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: MmRegister, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression128)
}
abstract class R64R64R64mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64)
}
abstract class R32mXmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte)
}
abstract class YmmXmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression128)
}
abstract class R64mR64Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte)
}
abstract class R32R32mR32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32)
}
abstract class XmmMmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: MmRegister)
}
abstract class M224Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression28Bytes, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression28Bytes)
}
abstract class XmmXmmR32mImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte)
}
abstract class YmmM64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression64)
}
abstract class M864Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression108Bytes, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression108Bytes)
}
abstract class R64mImm32Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Int)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)
}
abstract class XmmXmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)
}
abstract class R8R8mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister8, addressExpression: AddressExpression8)
}
abstract class R32mMmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: MmRegister)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: MmRegister)
}
abstract class YmmM128Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression128)
}
abstract class YmmYmmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte)
}
abstract class R16R16mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)
}
abstract class R32mR32Imm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Byte)
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte)
}
abstract class XmmMmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: MmRegister)
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)
}
abstract class R16R8mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression8)
}
abstract class YmmYmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)
  abstract fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256)
}
abstract class M32XmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: XmmRegister)
}
abstract class R16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16)
}
abstract class R64R8mInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister8)
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression8)
}
abstract class YmmYmmYmmmYmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, register4: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, register4: YmmRegister)
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, register3: YmmRegister)
}
abstract class R16M16Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)
}
abstract class YmmYmmYmmmInstruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)
  abstract fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)
}
abstract class R64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: GpRegister64)
}
abstract class XmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)
}
abstract class XmmXmmImm8Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)
}
abstract class M64R64Instruction : Instruction() {
  abstract fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT, tracer: InstructionTracer? = null)
  abstract fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)
}
abstract class Instruction: AbstractInstruction() {
  companion object {
    val all = listOf(
      AdcAlImm8,
      AdcAxImm16,
      AdcEaxImm32,
      AdcRaxImm32,
      AdcRm8Imm8,
      AdcRm16Imm16,
      AdcRm32Imm32,
      AdcRm64Imm32,
      AdcRm16Imm8,
      AdcRm32Imm8,
      AdcRm64Imm8,
      AdcRm8R8,
      AdcRm16R16,
      AdcRm32R32,
      AdcRm64R64,
      AdcR8Rm8,
      AdcR16Rm16,
      AdcR32Rm32,
      AdcR64Rm64,
      AdcxR32Rm32,
      AdcxR64Rm64,
      AddAlImm8,
      AddAxImm16,
      AddEaxImm32,
      AddRaxImm32,
      AddRm8Imm8,
      AddRm16Imm16,
      AddRm32Imm32,
      AddRm64Imm32,
      AddRm16Imm8,
      AddRm32Imm8,
      AddRm64Imm8,
      AddRm8R8,
      AddRm16R16,
      AddRm32R32,
      AddRm64R64,
      AddR8Rm8,
      AddR16Rm16,
      AddR32Rm32,
      AddR64Rm64,
      AddpdXmmXmmm128,
      VaddpdXmmXmmXmmm128,
      VaddpdYmmYmmYmmm256,
      AddpsXmmXmmm128,
      VaddpsXmmXmmXmmm128,
      VaddpsYmmYmmYmmm256,
      AddsdXmm0To63Xmmm64,
      VaddsdXmmXmmXmmm64,
      AddssXmm0To31Xmmm32,
      VaddssXmmXmmXmmm32,
      AddsubpdXmmXmmm128,
      VaddsubpdXmmXmmXmmm128,
      VaddsubpdYmmYmmYmmm256,
      AddsubpsXmmXmmm128,
      VaddsubpsXmmXmmXmmm128,
      VaddsubpsYmmYmmYmmm256,
      AdoxR32Rm32,
      AdoxR64Rm64,
      AesdecXmmXmmm128,
      VaesdecXmmXmmXmmm128,
      AesdeclastXmmXmmm128,
      VaesdeclastXmmXmmXmmm128,
      AesencXmmXmmm128,
      VaesencXmmXmmXmmm128,
      AesenclastXmmXmmm128,
      VaesenclastXmmXmmXmmm128,
      AesimcXmmXmmm128,
      VaesimcXmmXmmm128,
      AeskeygenassistXmmXmmm128Imm8,
      VaeskeygenassistXmmXmmm128Imm8,
      AndAlImm8,
      AndAxImm16,
      AndEaxImm32,
      AndRaxImm32,
      AndRm8Imm8,
      AndRm16Imm16,
      AndRm32Imm32,
      AndRm64Imm32,
      AndRm16Imm8,
      AndRm32Imm8,
      AndRm64Imm8,
      AndRm8R8,
      AndRm16R16,
      AndRm32R32,
      AndRm64R64,
      AndR8Rm8,
      AndR16Rm16,
      AndR32Rm32,
      AndR64Rm64,
      AndnR32R32Rm32,
      AndnR64R64Rm64,
      AndpdXmmXmmm128,
      VandpdXmmXmmXmmm128,
      VandpdYmmYmmYmmm256,
      AndpsXmmXmmm128,
      VandpsXmmXmmXmmm128,
      VandpsYmmYmmYmmm256,
      AndnpdXmmXmmm128,
      VandnpdXmmXmmXmmm128,
      VandnpdYmmYmmYmmm256,
      AndnpsXmmXmmm128,
      VandnpsXmmXmmXmmm128,
      VandnpsYmmYmmYmmm256,
      BlendpdXmmXmmm128Imm8,
      VblendpdXmmXmmXmmm128Imm8,
      VblendpdYmmYmmYmmm256Imm8,
      BextrR32Rm32R32,
      BextrR64Rm64R64,
      BlendpsXmmXmmm128Imm8,
      VblendpsXmmXmmXmmm128Imm8,
      VblendpsYmmYmmYmmm256Imm8,
      BlendvpdXmmXmmm128Xmm0,
      VblendvpdXmmXmmXmmm128Xmm,
      VblendvpdYmmYmmYmmm256Ymm,
      BlendvpsXmmXmmm128Xmm0,
      VblendvpsXmmXmmXmmm128Xmm,
      VblendvpsYmmYmmYmmm256Ymm,
      BlsiR32Rm32,
      BlsiR64Rm64,
      BlsmskR32Rm32,
      BlsmskR64Rm64,
      BlsrR32Rm32,
      BlsrR64Rm64,
      BsfR16Rm16,
      BsfR32Rm32,
      BsfR64Rm64,
      BsrR16Rm16,
      BsrR32Rm32,
      BsrR64Rm64,
      BswapR32,
      BswapR64,
      BtRm16R16,
      BtRm32R32,
      BtRm64R64,
      BtRm16Imm8,
      BtRm32Imm8,
      BtRm64Imm8,
      BtcRm16R16,
      BtcRm32R32,
      BtcRm64R64,
      BtcRm16Imm8,
      BtcRm32Imm8,
      BtcRm64Imm8,
      BtrRm16R16,
      BtrRm32R32,
      BtrRm64R64,
      BtrRm16Imm8,
      BtrRm32Imm8,
      BtrRm64Imm8,
      BtsRm16R16,
      BtsRm32R32,
      BtsRm64R64,
      BtsRm16Imm8,
      BtsRm32Imm8,
      BtsRm64Imm8,
      BzhiR32Rm32R32,
      BzhiR64Rm64R64,
      CallRel32Rip,
      CallRm64Rip,
      CbwAx,
      CwdeEax,
      CdqeRax,
      Clc,
      Cld,
      ClflushM8,
      ClflushoptM8,
      Cmc,
      CmovaR16Rm16,
      CmovaR32Rm32,
      CmovaR64Rm64,
      CmovaeR16Rm16,
      CmovaeR32Rm32,
      CmovaeR64Rm64,
      CmovcR16Rm16,
      CmovcR32Rm32,
      CmovcR64Rm64,
      CmovbeR16Rm16,
      CmovbeR32Rm32,
      CmovbeR64Rm64,
      CmoveR16Rm16,
      CmoveR32Rm32,
      CmoveR64Rm64,
      CmovgR16Rm16,
      CmovgR32Rm32,
      CmovgR64Rm64,
      CmovgeR16Rm16,
      CmovgeR32Rm32,
      CmovgeR64Rm64,
      CmovlR16Rm16,
      CmovlR32Rm32,
      CmovlR64Rm64,
      CmovleR16Rm16,
      CmovleR32Rm32,
      CmovleR64Rm64,
      CmovneR16Rm16,
      CmovneR32Rm32,
      CmovneR64Rm64,
      CmovnoR16Rm16,
      CmovnoR32Rm32,
      CmovnoR64Rm64,
      CmovnpR16Rm16,
      CmovnpR32Rm32,
      CmovnpR64Rm64,
      CmovnsR16Rm16,
      CmovnsR32Rm32,
      CmovnsR64Rm64,
      CmovoR16Rm16,
      CmovoR32Rm32,
      CmovoR64Rm64,
      CmovpR16Rm16,
      CmovpR32Rm32,
      CmovpR64Rm64,
      CmovsR16Rm16,
      CmovsR32Rm32,
      CmovsR64Rm64,
      CmpAlImm8,
      CmpAxImm16,
      CmpEaxImm32,
      CmpRaxImm32,
      CmpRm8Imm8,
      CmpRm16Imm16,
      CmpRm32Imm32,
      CmpRm64Imm32,
      CmpRm16Imm8,
      CmpRm32Imm8,
      CmpRm64Imm8,
      CmpRm8R8,
      CmpRm16R16,
      CmpRm32R32,
      CmpRm64R64,
      CmpR8Rm8,
      CmpR16Rm16,
      CmpR32Rm32,
      CmpR64Rm64,
      CmppdXmmXmmm128Imm8,
      VcmppdXmmXmmXmmm128Imm8,
      VcmppdYmmYmmYmmm256Imm8,
      CmppsXmmXmmm128Imm8,
      VcmppsXmmXmmXmmm128Imm8,
      VcmppsYmmYmmYmmm256Imm8,
      CmpsbnorepSilSilDilDil,
      CmpswnorepSiSiDiDi,
      CmpsdnorepEsiEsiEdiEdi,
      CmpsqnorepRsiRsiRdiRdi,
      CmpsdXmm0To63Xmmm64Imm8,
      VcmpsdXmmXmmXmmm64Imm8,
      CmpssXmm0To31Xmmm32Imm8,
      VcmpssXmmXmmXmmm32Imm8,
      CmpxchgRm8R8Al,
      CmpxchgRm16R16Ax,
      CmpxchgRm32R32Eax,
      CmpxchgRm64R64Rax,
      Cmpxchg8bM64EdxEaxEcxEbx,
      Cmpxchg16bM128RdxRaxRcxRbx,
      ComisdXmmXmmm64,
      VcomisdXmmXmmm64,
      ComissXmmXmmm32,
      VcomissXmmXmmm32,
      CpuidEaxEbxEcxEdx,
      Crc32R32Rm8,
      Crc32R32Rm16,
      Crc32R32Rm32,
      Crc32R64Rm8,
      Crc32R64Rm64,
      Cvtdq2pdXmmXmmm64,
      Vcvtdq2pdXmmXmmm64,
      Vcvtdq2pdYmmXmmm128,
      Cvtdq2psXmmXmmm128,
      Vcvtdq2psXmmXmmm128,
      Vcvtdq2psYmmYmmm256,
      Cvtpd2dqXmmXmmm128,
      Vcvtpd2dqXmmXmmm128,
      Vcvtpd2dqXmmYmmm256,
      Cvtpd2piMmXmmm128,
      Cvtpd2psXmmXmmm128,
      Vcvtpd2psXmmXmmm128,
      Vcvtpd2psXmmYmmm256,
      Cvtpi2pdXmmMmm64,
      Cvtpi2psXmm0To63Mmm64,
      Cvtps2dqXmmXmmm128,
      Vcvtps2dqXmmXmmm128,
      Vcvtps2dqYmmYmmm256,
      Cvtps2pdXmmXmmm64,
      Vcvtps2pdXmmXmmm64,
      Vcvtps2pdYmmXmmm128,
      Cvtps2piMmXmmm64,
      Cvtsd2siR32Xmmm64,
      Cvtsd2siR64Xmmm64,
      Vcvtsd2siR32Xmmm64,
      Vcvtsd2siR64Xmmm64,
      Cvtsd2ssXmm0To31Xmmm64,
      Vcvtsd2ssXmmXmmXmmm64,
      Cvtsi2sdXmm0To63Rm32,
      Cvtsi2sdXmm0To63Rm64,
      Vcvtsi2sdXmmXmmRm32,
      Vcvtsi2sdXmmXmmRm64,
      Cvtsi2ssXmm0To31Rm32,
      Cvtsi2ssXmm0To31Rm64,
      Vcvtsi2ssXmmXmmRm32,
      Vcvtsi2ssXmmXmmRm64,
      Cvtss2sdXmm0To63Xmmm32,
      Vcvtss2sdXmmXmmXmmm32,
      Cvtss2siR32Xmmm32,
      Cvtss2siR64Xmmm32,
      Vcvtss2siR32Xmmm32,
      Vcvtss2siR64Xmmm32,
      Cvttpd2dqXmmXmmm128,
      Vcvttpd2dqXmmXmmm128,
      Vcvttpd2dqXmmYmmm256,
      Cvttpd2piMmXmmm128,
      Cvttps2dqXmmXmmm128,
      Vcvttps2dqXmmXmmm128,
      Vcvttps2dqYmmYmmm256,
      Cvttps2piMmXmmm64,
      Cvttsd2siR32Xmmm64,
      Cvttsd2siR64Xmmm64,
      Vcvttsd2siR32Xmmm64,
      Vcvttsd2siR64Xmmm64,
      Cvttss2siR32Xmmm32,
      Cvttss2siR64Xmmm32,
      Vcvttss2siR32Xmmm32,
      Vcvttss2siR64Xmmm32,
      CwdDxAx,
      CdqEdxEax,
      CqoRdxRax,
      DecRm8,
      DecRm16,
      DecRm32,
      DecRm64,
      DivRm8Ax,
      DivRm16AxDx,
      DivRm32EdxEax,
      DivRm64RdxRax,
      DivpdXmmXmmm128,
      VdivpdXmmXmmXmmm128,
      VdivpdYmmYmmYmmm256,
      DivpsXmmXmmm128,
      VdivpsXmmXmmXmmm128,
      VdivpsYmmYmmYmmm256,
      DivsdXmm0To63Xmmm64,
      VdivsdXmmXmmXmmm64,
      DivssXmm0To31Xmmm32,
      VdivssXmmXmmXmmm32,
      DppdXmmXmmm128Imm8,
      VdppdXmmXmmXmmm128Imm8,
      DppsXmmXmmm128Imm8,
      VdppsXmmXmmXmmm128Imm8,
      VdppsYmmYmmYmmm256Imm8,
      EnterqImm16Imm8RspRbp,
      EnterwImm16Imm8SpBp,
      ExtractpsRm32XmmImm8,
      VextractpsRm32XmmImm8,
      HaddpdXmmXmmm128,
      VhaddpdXmmXmmXmmm128,
      VhaddpdYmmYmmYmmm256,
      HaddpsXmmXmmm128,
      VhaddpsXmmXmmXmmm128,
      VhaddpsYmmYmmYmmm256,
      HsubpdXmmXmmm128,
      VhsubpdXmmXmmXmmm128,
      VhsubpdYmmYmmYmmm256,
      HsubpsXmmXmmm128,
      VhsubpsXmmXmmXmmm128,
      VhsubpsYmmYmmYmmm256,
      IdivRm8Ax,
      IdivRm16AxDx,
      IdivRm32EdxEax,
      IdivRm64RdxRax,
      ImulRm8Ax,
      ImulRm16AxDx,
      ImulRm32EdxEax,
      ImulRm64RdxRax,
      ImulR16Rm16,
      ImulR32Rm32,
      ImulR64Rm64,
      ImulR16Rm16Imm8,
      ImulR32Rm32Imm8,
      ImulR64Rm64Imm8,
      ImulR16Rm16Imm16,
      ImulR32Rm32Imm32,
      ImulR64Rm64Imm32,
      IncRm8,
      IncRm16,
      IncRm32,
      IncRm64,
      InsertpsXmmXmmm32Imm8,
      VinsertpsXmmXmmXmmm32Imm8,
      JaRel8Rip,
      JaeRel8Rip,
      JbRel8Rip,
      JbeRel8Rip,
      JecxzRel8Rip,
      JaRel8RipD,
      JgRel8Rip,
      JgeRel8Rip,
      JlRel8Rip,
      JleRel8Rip,
      JneRel8Rip,
      JnoRel8Rip,
      JnpRel8Rip,
      JnsRel8Rip,
      JoRel8Rip,
      JpRel8Rip,
      JsRel8Rip,
      JaRel32Rip,
      JaeRel32Rip,
      JbRel32Rip,
      JbeRel32Rip,
      JeRel32Rip,
      JgRel32Rip,
      JgeRel32Rip,
      JlRel32Rip,
      JleRel32Rip,
      JneRel32Rip,
      JnoRel32Rip,
      JnpRel32Rip,
      JnsRel32Rip,
      JoRel32Rip,
      JpRel32Rip,
      JsRel32Rip,
      JmpRel8Rip,
      JmpRel32Rip,
      JmpRm64Rip,
      LahfAh,
      LddquXmmM128,
      VlddquXmmM128,
      VlddquYmmM256,
      LdmxcsrM32,
      VldmxcsrM32,
      LeaR16M16,
      LeaR32M32,
      LeaR64M64,
      LeavewSpBp,
      LeaveqRspRbp,
      Lfence,
      LodsbSilSil,
      LodswSiSi,
      LodsdEsiEsi,
      LodsqRsiRsi,
      LoopRel8Rcx,
      LoopeRel8Rcx,
      LoopneRel8Rcx,
      LzcntR16Rm16,
      LzcntR32Rm32,
      LzcntR64Rm64,
      MaskmovdquXmmXmmRdiRdi,
      VmaskmovdquXmmXmmRdiRdi,
      MaskmovqMmMmRdiRdi,
      MaxpdXmmXmmm128,
      VmaxpdXmmXmmXmmm128,
      VmaxpdYmmYmmYmmm256,
      MaxpsXmmXmmm128,
      VmaxpsXmmXmmXmmm128,
      VmaxpsYmmYmmYmmm256,
      MaxsdXmm0To63Xmmm64,
      VmaxsdXmmXmmXmmm64,
      MaxssXmm0To31Xmmm32,
      VmaxssXmmXmmXmmm32,
      Mfence,
      MinpdXmmXmmm128,
      VminpdXmmXmmXmmm128,
      VminpdYmmYmmYmmm256,
      MinpsXmmXmmm128,
      VminpsXmmXmmXmmm128,
      VminpsYmmYmmYmmm256,
      MinsdXmm0To63Xmmm64,
      VminsdXmmXmmXmmm64,
      MinssXmm0To31Xmmm32,
      VminssXmmXmmXmmm32,
      MovRm8R8,
      MovRm16R16,
      MovRm32R32,
      MovRm64R64,
      MovR8Rm8,
      MovR16Rm16,
      MovR32Rm32,
      MovR64Rm64,
      MovabsAlMoffs8,
      MovabsAxMoffs16,
      MovabsEaxMoffs32,
      MovabsRaxMoffs64,
      MovabsMoffs8Al,
      MovabsMoffs16Ax,
      MovabsMoffs32Eax,
      MovabsMoffs64Rax,
      MovR8Imm8,
      MovR16Imm16,
      MovR32Imm32,
      MovR64Imm64,
      MovRm8Imm8,
      MovRm16Imm16,
      MovRm32Imm32,
      MovRm64Imm32,
      MovapdXmmXmmm128,
      MovapdXmmm128Xmm,
      VmovapdXmmXmmm128,
      VmovapdXmmm128Xmm,
      VmovapdYmmYmmm256,
      VmovapdYmmm256Ymm,
      MovapsXmmXmmm128,
      MovapsXmmm128Xmm,
      VmovapsXmmXmmm128,
      VmovapsXmmm128Xmm,
      VmovapsYmmYmmm256,
      VmovapsYmmm256Ymm,
      MovbeR16M16,
      MovbeR32M32,
      MovbeR64M64,
      MovbeM16R16,
      MovbeM32R32,
      MovbeM64R64,
      MovdMmRm32,
      MovqMmRm64,
      MovdRm32Mm,
      MovqRm64Mm,
      MovdXmmRm32,
      MovqXmmRm64,
      MovdRm32Xmm,
      MovqRm64Xmm,
      VmovdXmmRm32,
      VmovqXmmRm64,
      VmovdRm32Xmm,
      VmovqRm64Xmm,
      MovddupXmmXmmm64,
      VmovddupXmmXmmm64,
      VmovddupYmmYmmm256,
      MovdqaXmmXmmm128,
      MovdqaXmmm128Xmm,
      VmovdqaXmmXmmm128,
      VmovdqaXmmm128Xmm,
      VmovdqaYmmYmmm256,
      VmovdqaYmmm256Ymm,
      MovdquXmmXmmm128,
      MovdquXmmm128Xmm,
      VmovdquXmmXmmm128,
      VmovdquXmmm128Xmm,
      VmovdquYmmYmmm256,
      VmovdquYmmm256Ymm,
      Movdq2qMmXmm,
      MovhlpsXmm0To63Xmm64To127,
      VmovhlpsXmmXmm64To127Xmm64To127,
      MovhpdXmm64To127M64,
      VmovhpdXmmXmm0To63M64,
      MovhpdM64Xmm0To63,
      VmovhpdM64Xmm0To63,
      MovhpsXmm64To127M64,
      VmovhpsXmmXmm0To63M64,
      MovhpsM64Xmm0To63,
      VmovhpsM64Xmm0To63,
      MovlhpsXmm64To127Xmm0To63,
      VmovlhpsXmmXmm0To63Xmm0To63,
      MovlpdXmm0To63M64,
      VmovlpdXmmXmm64To127M64,
      MovlpdM64Xmm0To63,
      VmovlpdM64Xmm0To63,
      MovlpsXmm0To63M64,
      VmovlpsXmmXmm64To127M64,
      MovlpsM64Xmm0To63,
      VmovlpsM64Xmm0To63,
      MovmskpdR32Xmm,
      VmovmskpdR32Xmm,
      VmovmskpdR32Ymm,
      MovmskpsR32Xmm,
      VmovmskpsR32Xmm,
      VmovmskpsR32Ymm,
      MovntdqaXmmM128,
      VmovntdqaXmmM128,
      VmovntdqaYmmM256,
      MovntdqM128Xmm,
      VmovntdqM128Xmm,
      VmovntdqM256Ymm,
      MovntiM32R32,
      MovntiM64R64,
      MovntpdM128Xmm,
      VmovntpdM128Xmm,
      VmovntpdM256Ymm,
      MovntpsM128Xmm,
      VmovntpsM128Xmm,
      VmovntpsM256Ymm,
      MovntqM64Mm,
      MovqMmMmm64,
      MovqMmm64Mm,
      MovqXmmXmmm64,
      VmovqXmmXmmm64,
      MovqXmmm64Xmm,
      VmovqXmmm64Xmm,
      Movq2dqXmmMm,
      MovsbSilSilDilDil,
      MovswSiSiDiDi,
      MovsdEsiEsiEdiEdi,
      MovsqRsiRsiRdiRdi,
      MovsdXmm0To63Xmmm64,
      MovsdXmmm64Xmm,
      VmovsdXmmXmmXmm,
      VmovsdXmmM64,
      VmovsdXmmXmmXmmMvr,
      VmovsdM64Xmm,
      MovshdupXmmXmmm128,
      VmovshdupXmmXmmm128,
      VmovshdupYmmYmmm256,
      MovsldupXmmXmmm128,
      VmovsldupXmmXmmm128,
      VmovsldupYmmYmmm256,
      MovssXmm0To31Xmmm32,
      VmovssXmmXmmXmm,
      VmovssXmmM32,
      MovssXmmm32Xmm,
      VmovssXmmXmmXmmMvr,
      VmovssM32Xmm,
      MovsxR16Rm8,
      MovsxR32Rm8,
      MovsxR64Rm8,
      MovsxR32Rm16,
      MovsxR64Rm16,
      MovsxdR64Rm32,
      MovupdXmmXmmm128,
      MovupdXmmm128Xmm,
      VmovupdXmmXmmm128,
      VmovupdXmmm128Xmm,
      VmovupdYmmYmmm256,
      VmovupdYmmm256Ymm,
      MovupsXmmXmmm128,
      MovupsXmmm128Xmm,
      VmovupsXmmXmmm128,
      VmovupsXmmm128Xmm,
      VmovupsYmmYmmm256,
      VmovupsYmmm256Ymm,
      MovzxR16Rm8,
      MovzxR32Rm8,
      MovzxR64Rm8,
      MovzxR32Rm16,
      MovzxR64Rm16,
      MpsadbwXmmXmmm128Imm8,
      VmpsadbwXmmXmmXmmm128Imm8,
      VmpsadbwYmmYmmYmmm256Imm8,
      MulRm8Ax,
      MulRm16AxDx,
      MulRm32EdxEax,
      MulRm64RdxRax,
      MulpdXmmXmmm128,
      VmulpdXmmXmmXmmm128,
      VmulpdYmmYmmYmmm256,
      MulpsXmmXmmm128,
      VmulpsXmmXmmXmmm128,
      VmulpsYmmYmmYmmm256,
      MulsdXmm0To63Xmmm64,
      VmulsdXmmXmmXmmm64,
      MulssXmm0To31Xmmm32,
      VmulssXmmXmmXmmm32,
      MulxR32R32Rm32Edx,
      MulxR64R64Rm64Rdx,
      NegRm8,
      NegRm16,
      NegRm32,
      NegRm64,
      Nop,
      NopRm16,
      NopRm32,
      NotRm8,
      NotRm16,
      NotRm32,
      NotRm64,
      OrAlImm8,
      OrAxImm16,
      OrEaxImm32,
      OrRaxImm32,
      OrRm8Imm8,
      OrRm16Imm16,
      OrRm32Imm32,
      OrRm64Imm32,
      OrRm16Imm8,
      OrRm32Imm8,
      OrRm64Imm8,
      OrRm8R8,
      OrRm16R16,
      OrRm32R32,
      OrRm64R64,
      OrR8Rm8,
      OrR16Rm16,
      OrR32Rm32,
      OrR64Rm64,
      OrpdXmmXmmm128,
      VorpdXmmXmmXmmm128,
      VorpdYmmYmmYmmm256,
      OrpsXmmXmmm128,
      VorpsXmmXmmXmmm128,
      VorpsYmmYmmYmmm256,
      PabsbMmMmm64,
      PabsbXmmXmmm128,
      PabswMmMmm64,
      PabswXmmXmmm128,
      PabsdMmMmm64,
      PabsdXmmXmmm128,
      VpabsbXmmXmmm128,
      VpabswXmmXmmm128,
      VpabsdXmmXmmm128,
      VpabsbYmmYmmm256,
      VpabswYmmYmmm256,
      VpabsdYmmYmmm256,
      PacksswbMmMmm64,
      PacksswbXmmXmmm128,
      PackssdwMmMmm64,
      PackssdwXmmXmmm128,
      VpacksswbXmmXmmXmmm128,
      VpackssdwXmmXmmXmmm128,
      VpacksswbYmmYmmYmmm256,
      VpackssdwYmmYmmYmmm256,
      PackusdwXmmXmmm128,
      VpackusdwXmmXmmXmmm128,
      VpackusdwYmmYmmYmmm256,
      PackuswbMmMmm64,
      PackuswbXmmXmmm128,
      VpackuswbXmmXmmXmmm128,
      VpackuswbYmmYmmYmmm256,
      PaddbMmMmm64,
      PaddwMmMmm64,
      PaddbXmmXmmm128,
      PaddwXmmXmmm128,
      PadddXmmXmmm128,
      PaddqXmmXmmm128,
      VpaddbXmmXmmXmmm128,
      VpaddwXmmXmmXmmm128,
      VpadddXmmXmmXmmm128,
      VpaddqXmmXmmXmmm128,
      VpaddbYmmYmmYmmm256,
      VpaddwYmmYmmYmmm256,
      VpadddYmmYmmYmmm256,
      VpaddqYmmYmmYmmm256,
      PaddsbMmMmm64,
      PaddsbXmmXmmm128,
      PaddswMmMmm64,
      PaddswXmmXmmm128,
      VpaddsbXmmXmmXmmm128,
      VpaddswXmmXmmXmmm128,
      VpaddsbYmmYmmYmmm256,
      VpaddswYmmYmmYmmm256,
      PaddusbMmMmm64,
      PaddusbXmmXmmm128,
      PadduswMmMmm64,
      PadduswXmmXmmm128,
      VpaddusbXmmXmmXmmm128,
      VpadduswXmmXmmXmmm128,
      VpaddusbYmmYmmYmmm256,
      VpadduswYmmYmmYmmm256,
      PalignrMmMmm64Imm8,
      PalignrXmmXmmm128Imm8,
      VpalignrXmmXmmXmmm128Imm8,
      VpalignrYmmYmmYmmm256Imm8,
      PandMmMmm64,
      PandXmmXmmm128,
      VpandXmmXmmXmmm128,
      VpandYmmYmmYmmm256,
      PandnMmMmm64,
      PandnXmmXmmm128,
      VpandnXmmXmmXmmm128,
      VpandnYmmYmmYmmm256,
      Pause,
      PavgbMmMmm64,
      PavgbXmmXmmm128,
      PavgwMmMmm64,
      PavgwXmmXmmm128,
      VpavgbXmmXmmXmmm128,
      VpavgwXmmXmmXmmm128,
      VpavgbYmmYmmYmmm256,
      VpavgwYmmYmmYmmm256,
      PblendvbXmmXmmm128Xmm0,
      VpblendvbXmmXmmXmmm128Xmm,
      VpblendvbYmmYmmYmmm256Ymm,
      PblendwXmmXmmm128Imm8,
      VpblendwXmmXmmXmmm128Imm8,
      VpblendwYmmYmmYmmm256Imm8,
      PclmulqdqXmmXmmm128Imm8,
      VpclmulqdqXmmXmmXmmm128Imm8,
      PcmpeqbMmMmm64,
      PcmpeqbXmmXmmm128,
      PcmpeqwMmMmm64,
      PcmpeqwXmmXmmm128,
      PcmpeqdMmMmm64,
      PcmpeqdXmmXmmm128,
      VpcmpeqbXmmXmmXmmm128,
      VpcmpeqwXmmXmmXmmm128,
      VpcmpeqdXmmXmmXmmm128,
      VpcmpeqbYmmYmmYmmm256,
      VpcmpeqwYmmYmmYmmm256,
      VpcmpeqdYmmYmmYmmm256,
      PcmpeqqXmmXmmm128,
      VpcmpeqqXmmXmmXmmm128,
      VpcmpeqqYmmYmmYmmm256,
      PcmpestriXmmXmmm128Imm8RaxRdxRcx,
      VpcmpestriXmmXmmm128Imm8RaxRdxRcx,
      PcmpestrmXmmXmmm128Imm8RaxRdxXmm0,
      VpcmpestrmXmmXmmm128Imm8RaxRdxXmm0,
      PcmpgtbMmMmm64,
      PcmpgtbXmmXmmm128,
      PcmpgtwMmMmm64,
      PcmpgtwXmmXmmm128,
      PcmpgtdMmMmm64,
      PcmpgtdXmmXmmm128,
      VpcmpgtbXmmXmmXmmm128,
      VpcmpgtwXmmXmmXmmm128,
      VpcmpgtdXmmXmmXmmm128,
      VpcmpgtbYmmYmmYmmm256,
      VpcmpgtwYmmYmmYmmm256,
      VpcmpgtdYmmYmmYmmm256,
      PcmpgtqXmmXmmm128,
      VpcmpgtqXmmXmmXmmm128,
      VpcmpgtqYmmYmmYmmm256,
      PcmpistriXmmXmmm128Imm8Rcx,
      VpcmpistriXmmXmmm128Imm8Rcx,
      PcmpistrmXmmXmmm128Imm8Xmm0,
      VpcmpistrmXmmXmmm128Imm8Xmm0,
      PdepR32R32Rm32,
      PdepR64R64Rm64,
      PextR32R32Rm32,
      PextR64R64Rm64,
      PextrbR32m8XmmImm8,
      PextrdRm32XmmImm8,
      PextrqRm64XmmImm8,
      VpextrbR32m8XmmImm8,
      VpextrdRm32XmmImm8,
      VpextrqRm64XmmImm8,
      PextrwR32MmImm8,
      PextrwR32XmmImm8,
      PextrwR32m16XmmImm8,
      VpextrwR32XmmImm8,
      VpextrwR32m16XmmImm8,
      PhaddwMmMmm64,
      PhaddwXmmXmmm128,
      PhadddMmMmm64,
      PhadddXmmXmmm128,
      VphaddwXmmXmmXmmm128,
      VphadddXmmXmmXmmm128,
      VphaddwYmmYmmYmmm256,
      VphadddYmmYmmYmmm256,
      PhaddswMmMmm64,
      PhaddswXmmXmmm128,
      VphaddswXmmXmmXmmm128,
      VphaddswYmmYmmYmmm256,
      PhminposuwXmmXmmm128,
      VphminposuwXmmXmmm128,
      PhsubwMmMmm64,
      PhsubwXmmXmmm128,
      PhsubdMmMmm64,
      PhsubdXmmXmmm128,
      VphsubwXmmXmmXmmm128,
      VphsubdXmmXmmXmmm128,
      VphsubwYmmYmmYmmm256,
      VphsubdYmmYmmYmmm256,
      PhsubswMmMmm64,
      PhsubswXmmXmmm128,
      VphsubswXmmXmmXmmm128,
      VphsubswYmmYmmYmmm256,
      PinsrbXmmR32m8Imm8,
      PinsrdXmmRm32Imm8,
      PinsrqXmmRm64Imm8,
      VpinsrbXmmXmmR32m8Imm8,
      VpinsrdXmmXmmRm32Imm8,
      VpinsrqXmmXmmRm64Imm8,
      PinsrwMmR32m16Imm8,
      PinsrwXmmR32m16Imm8,
      VpinsrwXmmXmmR32m16Imm8,
      PmaddubswMmMmm64,
      PmaddubswXmmXmmm128,
      VpmaddubswXmmXmmXmmm128,
      VpmaddubswYmmYmmYmmm256,
      PmaddwdMmMmm64,
      PmaddwdXmmXmmm128,
      VpmaddwdXmmXmmXmmm128,
      VpmaddwdYmmYmmYmmm256,
      PmaxswMmMmm64,
      PmaxsbXmmXmmm128,
      PmaxswXmmXmmm128,
      PmaxsdXmmXmmm128,
      VpmaxsbXmmXmmXmmm128,
      VpmaxswXmmXmmXmmm128,
      VpmaxsdXmmXmmXmmm128,
      VpmaxsbYmmYmmYmmm256,
      VpmaxswYmmYmmYmmm256,
      VpmaxsdYmmYmmYmmm256,
      PmaxubMmMmm64,
      PmaxubXmmXmmm128,
      PmaxuwXmmXmmm128,
      VpmaxubXmmXmmXmmm128,
      VpmaxuwXmmXmmXmmm128,
      VpmaxubYmmYmmYmmm256,
      VpmaxuwYmmYmmYmmm256,
      PmaxudXmmXmmm128,
      VpmaxudXmmXmmXmmm128,
      VpmaxudYmmYmmYmmm256,
      PminswMmMmm64,
      PminsbXmmXmmm128,
      PminswXmmXmmm128,
      VpminsbXmmXmmXmmm128,
      VpminswXmmXmmXmmm128,
      VpminsbYmmYmmYmmm256,
      VpminswYmmYmmYmmm256,
      PminsdXmmXmmm128,
      VpminsdXmmXmmXmmm128,
      VpminsdYmmYmmYmmm256,
      PminubMmMmm64,
      PminubXmmXmmm128,
      PminuwXmmXmmm128,
      VpminubXmmXmmXmmm128,
      VpminuwXmmXmmXmmm128,
      VpminubYmmYmmYmmm256,
      VpminuwYmmYmmYmmm256,
      PminudXmmXmmm128,
      VpminudXmmXmmXmmm128,
      VpminudYmmYmmYmmm256,
      PmovmskbR32Mm,
      PmovmskbR32Xmm,
      VpmovmskbR32Xmm,
      VpmovmskbR32Ymm,
      PmovsxbwXmmXmmm64,
      PmovsxbdXmmXmmm32,
      PmovsxbqXmmXmmm16,
      PmovsxwdXmmXmmm64,
      PmovsxwqXmmXmmm32,
      PmovsxdqXmmXmmm64,
      VpmovsxbwXmmXmmm64,
      VpmovsxbdXmmXmmm32,
      VpmovsxbqXmmXmmm16,
      VpmovsxwdXmmXmmm64,
      VpmovsxwqXmmXmmm32,
      VpmovsxdqXmmXmmm64,
      VpmovsxbwYmmXmmm128,
      VpmovsxbdYmmXmmm64,
      VpmovsxbqYmmXmmm32,
      VpmovsxwdYmmXmmm128,
      VpmovsxwqYmmXmmm64,
      VpmovsxdqYmmXmmm128,
      PmovzxbwXmmXmmm64,
      PmovzxbdXmmXmmm32,
      PmovzxbqXmmXmmm16,
      PmovzxwdXmmXmmm64,
      PmovzxwqXmmXmmm32,
      PmovzxdqXmmXmmm64,
      VpmovzxbwXmmXmmm64,
      VpmovzxbdXmmXmmm32,
      VpmovzxbqXmmXmmm16,
      VpmovzxwdXmmXmmm64,
      VpmovzxwqXmmXmmm32,
      VpmovzxdqXmmXmmm64,
      VpmovzxbwYmmXmmm128,
      VpmovzxbdYmmXmmm64,
      VpmovzxbqYmmXmmm32,
      VpmovzxwdYmmXmmm128,
      VpmovzxwqYmmXmmm64,
      VpmovzxdqYmmXmmm128,
      PmuldqXmmXmmm128,
      VpmuldqXmmXmmXmmm128,
      VpmuldqYmmYmmYmmm256,
      PmulhrswMmMmm64,
      PmulhrswXmmXmmm128,
      VpmulhrswXmmXmmXmmm128,
      VpmulhrswYmmYmmYmmm256,
      PmulhuwMmMmm64,
      PmulhuwXmmXmmm128,
      VpmulhuwXmmXmmXmmm128,
      VpmulhuwYmmYmmYmmm256,
      PmulhwMmMmm64,
      PmulhwXmmXmmm128,
      VpmulhwXmmXmmXmmm128,
      VpmulhwYmmYmmYmmm256,
      PmulldXmmXmmm128,
      VpmulldXmmXmmXmmm128,
      VpmulldYmmYmmYmmm256,
      PmullwMmMmm64,
      PmullwXmmXmmm128,
      VpmullwXmmXmmXmmm128,
      VpmullwYmmYmmYmmm256,
      PmuludqMmMmm64,
      PmuludqXmmXmmm128,
      VpmuludqXmmXmmXmmm128,
      VpmuludqYmmYmmYmmm256,
      PopRm16Rsp,
      PopRm64Rsp,
      PopR16Rsp,
      PopR64Rsp,
      PopcntR16Rm16,
      PopcntR32Rm32,
      PopcntR64Rm64,
      PopfRsp,
      PopfqRsp,
      PorMmMmm64,
      PorXmmXmmm128,
      VporXmmXmmXmmm128,
      VporYmmYmmYmmm256,
      Prefetcht0M8,
      Prefetcht1M8,
      Prefetcht2M8,
      PrefetchntaM8,
      PrefetchwM8,
      Prefetchwt1M8,
      PsadbwMmMmm64,
      PsadbwXmmXmmm128,
      VpsadbwXmmXmmXmmm128,
      VpsadbwYmmYmmYmmm256,
      PshufbMmMmm64,
      PshufbXmmXmmm128,
      VpshufbXmmXmmXmmm128,
      VpshufbYmmYmmYmmm256,
      PshufdXmmXmmm128Imm8,
      VpshufdXmmXmmm128Imm8,
      VpshufdYmmYmmm256Imm8,
      PshufhwXmmXmmm128Imm8,
      VpshufhwXmmXmmm128Imm8,
      VpshufhwYmmYmmm256Imm8,
      PshuflwXmmXmmm128Imm8,
      VpshuflwXmmXmmm128Imm8,
      VpshuflwYmmYmmm256Imm8,
      PshufwMmMmm64Imm8,
      PsignbMmMmm64,
      PsignbXmmXmmm128,
      PsignwMmMmm64,
      PsignwXmmXmmm128,
      PsigndMmMmm64,
      PsigndXmmXmmm128,
      VpsignbXmmXmmXmmm128,
      VpsignwXmmXmmXmmm128,
      VpsigndXmmXmmXmmm128,
      VpsignbYmmYmmYmmm256,
      VpsignwYmmYmmYmmm256,
      VpsigndYmmYmmYmmm256,
      PslldqXmmImm8,
      VpslldqXmmXmmImm8,
      VpslldqYmmYmmImm8,
      PsllwMmMmm64,
      PsllwXmmXmmm128,
      PsllwMmImm8,
      PsllwXmmImm8,
      PslldMmMmm64,
      PslldXmmXmmm128,
      PslldMmImm8,
      PslldXmmImm8,
      PsllqMmMmm64,
      PsllqXmmXmmm128,
      PsllqMmImm8,
      PsllqXmmImm8,
      VpsllwXmmXmmXmmm128,
      VpsllwXmmXmmImm8,
      VpslldXmmXmmXmmm128,
      VpslldXmmXmmImm8,
      VpsllqXmmXmmXmmm128,
      VpsllqXmmXmmImm8,
      VpsllwYmmYmmXmmm128,
      VpsllwYmmYmmImm8,
      VpslldYmmYmmXmmm128,
      VpslldYmmYmmImm8,
      VpsllqYmmYmmXmmm128,
      VpsllqYmmYmmImm8,
      PsrawMmMmm64,
      PsrawXmmXmmm128,
      PsrawMmImm8,
      PsrawXmmImm8,
      PsradMmMmm64,
      PsradXmmXmmm128,
      PsradMmImm8,
      PsradXmmImm8,
      VpsrawXmmXmmXmmm128,
      VpsrawXmmXmmImm8,
      VpsradXmmXmmXmmm128,
      VpsradXmmXmmImm8,
      VpsrawYmmYmmXmmm128,
      VpsrawYmmYmmImm8,
      VpsradYmmYmmXmmm128,
      VpsradYmmYmmImm8,
      PsrldqXmmImm8,
      VpsrldqXmmXmmImm8,
      VpsrldqYmmYmmImm8,
      PsrlwMmMmm64,
      PsrlwXmmXmmm128,
      PsrlwMmImm8,
      PsrlwXmmImm8,
      PsrldMmMmm64,
      PsrldXmmXmmm128,
      PsrldMmImm8,
      PsrldXmmImm8,
      PsrlqMmMmm64,
      PsrlqXmmXmmm128,
      PsrlqMmImm8,
      PsrlqXmmImm8,
      VpsrlwXmmXmmXmmm128,
      VpsrlwXmmXmmImm8,
      VpsrldXmmXmmXmmm128,
      VpsrldXmmXmmImm8,
      VpsrlqXmmXmmXmmm128,
      VpsrlqXmmXmmImm8,
      VpsrlwYmmYmmXmmm128,
      VpsrlwYmmYmmImm8,
      VpsrldYmmYmmXmmm128,
      VpsrldYmmYmmImm8,
      VpsrlqYmmYmmXmmm128,
      VpsrlqYmmYmmImm8,
      PsubbMmMmm64,
      PsubbXmmXmmm128,
      PsubwMmMmm64,
      PsubwXmmXmmm128,
      PsubdMmMmm64,
      PsubdXmmXmmm128,
      VpsubbXmmXmmXmmm128,
      VpsubwXmmXmmXmmm128,
      VpsubdXmmXmmXmmm128,
      VpsubbYmmYmmYmmm256,
      VpsubwYmmYmmYmmm256,
      VpsubdYmmYmmYmmm256,
      PsubqMmMmm64,
      PsubqXmmXmmm128,
      VpsubqXmmXmmXmmm128,
      VpsubqYmmYmmYmmm256,
      PsubsbMmMmm64,
      PsubsbXmmXmmm128,
      PsubswMmMmm64,
      PsubswXmmXmmm128,
      VpsubsbXmmXmmXmmm128,
      VpsubswXmmXmmXmmm128,
      VpsubsbYmmYmmYmmm256,
      VpsubswYmmYmmYmmm256,
      PsubusbMmMmm64,
      PsubusbXmmXmmm128,
      PsubuswMmMmm64,
      PsubuswXmmXmmm128,
      VpsubusbXmmXmmXmmm128,
      VpsubuswXmmXmmXmmm128,
      VpsubusbYmmYmmYmmm256,
      VpsubuswYmmYmmYmmm256,
      PtestXmmXmmm128,
      VptestXmmXmmm128,
      VptestYmmYmmm256,
      PunpckhbwMmMmm64,
      PunpckhbwXmmXmmm128,
      PunpckhwdMmMmm64,
      PunpckhwdXmmXmmm128,
      PunpckhdqMmMmm64,
      PunpckhdqXmmXmmm128,
      PunpckhqdqXmmXmmm128,
      VpunpckhbwXmmXmmXmmm128,
      VpunpckhwdXmmXmmXmmm128,
      VpunpckhdqXmmXmmXmmm128,
      VpunpckhqdqXmmXmmXmmm128,
      VpunpckhbwYmmYmmYmmm256,
      VpunpckhwdYmmYmmYmmm256,
      VpunpckhdqYmmYmmYmmm256,
      VpunpckhqdqYmmYmmYmmm256,
      PunpcklbwMmMmm32,
      PunpcklbwXmmXmmm128,
      PunpcklwdMmMmm32,
      PunpcklwdXmmXmmm128,
      PunpckldqMmMmm32,
      PunpckldqXmmXmmm128,
      PunpcklqdqXmmXmmm128,
      VpunpcklbwXmmXmmXmmm128,
      VpunpcklwdXmmXmmXmmm128,
      VpunpckldqXmmXmmXmmm128,
      VpunpcklqdqXmmXmmXmmm128,
      VpunpcklbwYmmYmmYmmm256,
      VpunpcklwdYmmYmmYmmm256,
      VpunpckldqYmmYmmYmmm256,
      VpunpcklqdqYmmYmmYmmm256,
      PushRm16Rsp,
      PushRm64Rsp,
      PushR16Rsp,
      PushR64Rsp,
      PushImm8Rsp,
      PushImm16Rsp,
      PushImm32Rsp,
      PushfRsp,
      PushfqRsp,
      PxorMmMmm64,
      PxorXmmXmmm128,
      VpxorXmmXmmXmmm128,
      VpxorYmmYmmYmmm256,
      RclRm81,
      RclRm8Cl,
      RclRm8Imm8,
      RclRm161,
      RclRm16Cl,
      RclRm16Imm8,
      RclRm321,
      RclRm641,
      RclRm32Cl,
      RclRm64Cl,
      RclRm32Imm8,
      RclRm64Imm8,
      RcrRm81,
      RcrRm8Cl,
      RcrRm8Imm8,
      RcrRm161,
      RcrRm16Cl,
      RcrRm16Imm8,
      RcrRm321,
      RcrRm641,
      RcrRm32Cl,
      RcrRm64Cl,
      RcrRm32Imm8,
      RcrRm64Imm8,
      RolRm81,
      RolRm8Cl,
      RolRm8Imm8,
      RolRm161,
      RolRm16Cl,
      RolRm16Imm8,
      RolRm321,
      RolRm641,
      RolRm32Cl,
      RolRm64Cl,
      RolRm32Imm8,
      RolRm64Imm8,
      RorRm81,
      RorRm8Cl,
      RorRm8Imm8,
      RorRm161,
      RorRm16Cl,
      RorRm16Imm8,
      RorRm321,
      RorRm641,
      RorRm32Cl,
      RorRm64Cl,
      RorRm32Imm8,
      RorRm64Imm8,
      RcppsXmmXmmm128,
      VrcppsXmmXmmm128,
      VrcppsYmmYmmm256,
      RcpssXmm0To31Xmmm32,
      VrcpssXmmXmmXmmm32,
      RdrandR16,
      RdrandR32,
      RdrandR64,
      RdseedR16,
      RdseedR32,
      RdseedR64,
      RetRspRip,
      RetImm16RspRip,
      RorxR32Rm32Imm8,
      RorxR64Rm64Imm8,
      RoundpdXmmXmmm128Imm8,
      VroundpdXmmXmmm128Imm8,
      VroundpdYmmYmmm256Imm8,
      RoundpsXmmXmmm128Imm8,
      VroundpsXmmXmmm128Imm8,
      VroundpsYmmYmmm256Imm8,
      RoundsdXmm0To63Xmmm64Imm8,
      VroundsdXmmXmmXmmm64Imm8,
      RoundssXmm0To31Xmmm32Imm8,
      VroundssXmmXmmXmmm32Imm8,
      RsqrtpsXmmXmmm128,
      VrsqrtpsXmmXmmm128,
      VrsqrtpsYmmYmmm256,
      RsqrtssXmm0To31Xmmm32,
      VrsqrtssXmmXmmXmmm32,
      SahfAh,
      SalRm81,
      SalRm8Cl,
      SalRm8Imm8,
      SalRm161,
      SalRm16Cl,
      SalRm16Imm8,
      SalRm321,
      SalRm641,
      SalRm32Cl,
      SalRm64Cl,
      SalRm32Imm8,
      SalRm64Imm8,
      SarRm81,
      SarRm8Cl,
      SarRm8Imm8,
      SarRm161,
      SarRm16Cl,
      SarRm16Imm8,
      SarRm321,
      SarRm641,
      SarRm32Cl,
      SarRm64Cl,
      SarRm32Imm8,
      SarRm64Imm8,
      SalRm161M,
      SalRm16ClM,
      SalRm321M,
      SalRm641M,
      SalRm32ClM,
      SalRm64ClM,
      ShrRm81,
      ShrRm8Cl,
      ShrRm8Imm8,
      ShrRm161,
      ShrRm16Cl,
      ShrRm16Imm8,
      ShrRm321,
      ShrRm641,
      ShrRm32Cl,
      ShrRm64Cl,
      ShrRm32Imm8,
      ShrRm64Imm8,
      SarxR32Rm32R32,
      ShlxR32Rm32R32,
      ShrxR32Rm32R32,
      SarxR64Rm64R64,
      ShlxR64Rm64R64,
      ShrxR64Rm64R64,
      SbbAlImm8,
      SbbAxImm16,
      SbbEaxImm32,
      SbbRaxImm32,
      SbbRm8Imm8,
      SbbRm16Imm16,
      SbbRm32Imm32,
      SbbRm64Imm32,
      SbbRm16Imm8,
      SbbRm32Imm8,
      SbbRm64Imm8,
      SbbRm8R8,
      SbbRm16R16,
      SbbRm32R32,
      SbbRm64R64,
      SbbR8Rm8,
      SbbR16Rm16,
      SbbR32Rm32,
      SbbR64Rm64,
      ScasbSilDilDilAl,
      ScaswSiDiDiAx,
      ScasdEsiEdiEdiEax,
      ScasqRsiRdiRdiRax,
      SetaRm8,
      SetaeRm8,
      SetbRm8,
      SetbeRm8,
      SeteRm8,
      SetgRm8,
      SetgeRm8,
      SetngeRm8,
      SetleRm8,
      SetneRm8,
      SetnoRm8,
      SetpoRm8,
      SetnsRm8,
      SetoRm8,
      SetpRm8,
      SetsRm8,
      Sfence,
      Sha1rnds4XmmXmmm128Imm8,
      Sha1nexteXmmXmmm128,
      Sha1msg1XmmXmmm128,
      Sha1msg2XmmXmmm128,
      Sha256rnds2XmmXmmm128Xmm0,
      Sha256msg1XmmXmmm128,
      Sha256msg2XmmXmmm128,
      ShldRm16R16Imm8,
      ShldRm16R16Cl,
      ShldRm32R32Imm8,
      ShldRm64R64Imm8,
      ShldRm32R32Cl,
      ShldRm64R64Cl,
      ShrdRm16R16Imm8,
      ShrdRm16R16Cl,
      ShrdRm32R32Imm8,
      ShrdRm64R64Imm8,
      ShrdRm32R32Cl,
      ShrdRm64R64Cl,
      ShufpdXmmXmmm128Imm8,
      VshufpdXmmXmmXmmm128Imm8,
      VshufpdYmmYmmYmmm256Imm8,
      ShufpsXmmXmmm128Imm8,
      VshufpsXmmXmmXmmm128Imm8,
      VshufpsYmmYmmYmmm256Imm8,
      SqrtpdXmmXmmm128,
      VsqrtpdXmmXmmm128,
      VsqrtpdYmmYmmm256,
      SqrtpsXmmXmmm128,
      VsqrtpsXmmXmmm128,
      VsqrtpsYmmYmmm256,
      SqrtsdXmm0To63Xmmm64,
      VsqrtsdXmmXmmXmmm64,
      SqrtssXmm0To31Xmmm32,
      VsqrtssXmmXmmXmmm32,
      Stc,
      Std,
      StmxcsrM32,
      VstmxcsrM32,
      StosbSilDilDilAl,
      StoswSiDiDiAx,
      StosdEsiEdiEdiEax,
      StosqRsiRdiRdiRax,
      SubAlImm8,
      SubAxImm16,
      SubEaxImm32,
      SubRaxImm32,
      SubRm8Imm8,
      SubRm16Imm16,
      SubRm32Imm32,
      SubRm64Imm32,
      SubRm16Imm8,
      SubRm32Imm8,
      SubRm64Imm8,
      SubRm8R8,
      SubRm16R16,
      SubRm32R32,
      SubRm64R64,
      SubR8Rm8,
      SubR16Rm16,
      SubR32Rm32,
      SubR64Rm64,
      SubpdXmmXmmm128,
      VsubpdXmmXmmXmmm128,
      VsubpdYmmYmmYmmm256,
      SubpsXmmXmmm128,
      VsubpsXmmXmmXmmm128,
      VsubpsYmmYmmYmmm256,
      SubsdXmm0To63Xmmm64,
      VsubsdXmmXmmXmmm64,
      SubssXmm0To31Xmmm32,
      VsubssXmmXmmXmmm32,
      TestAlImm8,
      TestAxImm16,
      TestEaxImm32,
      TestRaxImm32,
      TestRm8Imm8,
      TestRm16Imm16,
      TestRm32Imm32,
      TestRm64Imm32,
      TestRm8R8,
      TestRm16R16,
      TestRm32R32,
      TestRm64R64,
      TzcntR16Rm16,
      TzcntR32Rm32,
      TzcntR64Rm64,
      UcomisdXmmXmmm64,
      VucomisdXmmXmmm64,
      UcomissXmmXmmm32,
      VucomissXmmXmmm32,
      Ud2,
      UnpckhpdXmmXmmm128,
      VunpckhpdXmmXmmXmmm128,
      VunpckhpdYmmYmmYmmm256,
      UnpckhpsXmmXmmm128,
      VunpckhpsXmmXmmXmmm128,
      VunpckhpsYmmYmmYmmm256,
      UnpcklpdXmmXmmm128,
      VunpcklpdXmmXmmXmmm128,
      VunpcklpdYmmYmmYmmm256,
      UnpcklpsXmmXmmm128,
      VunpcklpsXmmXmmXmmm128,
      VunpcklpsYmmYmmYmmm256,
      VbroadcastssXmmM32,
      VbroadcastssYmmM32,
      VbroadcastsdYmmM64,
      Vbroadcastf128YmmM128,
      Vcvtph2psXmmXmmm64,
      Vcvtph2psYmmXmmm128,
      Vcvtps2phXmmm64XmmImm8,
      Vcvtps2phXmmm128YmmImm8,
      Vextractf128Xmmm128YmmImm8,
      Vextracti128Xmmm128YmmImm8,
      Vfmadd132pdXmmXmmXmmm128,
      Vfmadd213pdXmmXmmXmmm128,
      Vfmadd231pdXmmXmmXmmm128,
      Vfmadd132pdYmmYmmYmmm256,
      Vfmadd213pdYmmYmmYmmm256,
      Vfmadd231pdYmmYmmYmmm256,
      Vfmadd132psXmmXmmXmmm128,
      Vfmadd213psXmmXmmXmmm128,
      Vfmadd231psXmmXmmXmmm128,
      Vfmadd132psYmmYmmYmmm256,
      Vfmadd213psYmmYmmYmmm256,
      Vfmadd231psYmmYmmYmmm256,
      Vfmadd132sdXmmXmmXmmm64,
      Vfmadd213sdXmmXmmXmmm64,
      Vfmadd231sdXmmXmmXmmm64,
      Vfmadd132ssXmmXmmXmmm32,
      Vfmadd213ssXmmXmmXmmm32,
      Vfmadd231ssXmmXmmXmmm32,
      Vfmaddsub132pdXmmXmmXmmm128,
      Vfmaddsub213pdXmmXmmXmmm128,
      Vfmaddsub231pdXmmXmmXmmm128,
      Vfmaddsub132pdYmmYmmYmmm256,
      Vfmaddsub213pdYmmYmmYmmm256,
      Vfmaddsub231pdYmmYmmYmmm256,
      Vfmaddsub132psXmmXmmXmmm128,
      Vfmaddsub213psXmmXmmXmmm128,
      Vfmaddsub231psXmmXmmXmmm128,
      Vfmaddsub132psYmmYmmYmmm256,
      Vfmaddsub213psYmmYmmYmmm256,
      Vfmaddsub231psYmmYmmYmmm256,
      Vfmsubadd132pdXmmXmmXmmm128,
      Vfmsubadd213pdXmmXmmXmmm128,
      Vfmsubadd231pdXmmXmmXmmm128,
      Vfmsubadd132pdYmmYmmYmmm256,
      Vfmsubadd213pdYmmYmmYmmm256,
      Vfmsubadd231pdYmmYmmYmmm256,
      Vfmsubadd132psXmmXmmXmmm128,
      Vfmsubadd213psXmmXmmXmmm128,
      Vfmsubadd231psXmmXmmXmmm128,
      Vfmsubadd132psYmmYmmYmmm256,
      Vfmsubadd213psYmmYmmYmmm256,
      Vfmsubadd231psYmmYmmYmmm256,
      Vfmsub132pdXmmXmmXmmm128,
      Vfmsub213pdXmmXmmXmmm128,
      Vfmsub231pdXmmXmmXmmm128,
      Vfmsub132pdYmmYmmYmmm256,
      Vfmsub213pdYmmYmmYmmm256,
      Vfmsub231pdYmmYmmYmmm256,
      Vfmsub132psXmmXmmXmmm128,
      Vfmsub213psXmmXmmXmmm128,
      Vfmsub231psXmmXmmXmmm128,
      Vfmsub132psYmmYmmYmmm256,
      Vfmsub213psYmmYmmYmmm256,
      Vfmsub231psYmmYmmYmmm256,
      Vfmsub132sdXmmXmmXmmm64,
      Vfmsub213sdXmmXmmXmmm64,
      Vfmsub231sdXmmXmmXmmm64,
      Vfmsub132ssXmmXmmXmmm32,
      Vfmsub213ssXmmXmmXmmm32,
      Vfmsub231ssXmmXmmXmmm32,
      Vfnmadd132pdXmmXmmXmmm128,
      Vfnmadd213pdXmmXmmXmmm128,
      Vfnmadd231pdXmmXmmXmmm128,
      Vfnmadd132pdYmmYmmYmmm256,
      Vfnmadd213pdYmmYmmYmmm256,
      Vfnmadd231pdYmmYmmYmmm256,
      Vfnmadd132psXmmXmmXmmm128,
      Vfnmadd213psXmmXmmXmmm128,
      Vfnmadd231psXmmXmmXmmm128,
      Vfnmadd132psYmmYmmYmmm256,
      Vfnmadd213psYmmYmmYmmm256,
      Vfnmadd231psYmmYmmYmmm256,
      Vfnmadd132sdXmmXmmXmmm64,
      Vfnmadd213sdXmmXmmXmmm64,
      Vfnmadd231sdXmmXmmXmmm64,
      Vfnmadd132ssXmmXmmXmmm32,
      Vfnmadd213ssXmmXmmXmmm32,
      Vfnmadd231ssXmmXmmXmmm32,
      Vfnmsub132pdXmmXmmXmmm128,
      Vfnmsub213pdXmmXmmXmmm128,
      Vfnmsub231pdXmmXmmXmmm128,
      Vfnmsub132pdYmmYmmYmmm256,
      Vfnmsub213pdYmmYmmYmmm256,
      Vfnmsub231pdYmmYmmYmmm256,
      Vfnmsub132psXmmXmmXmmm128,
      Vfnmsub213psXmmXmmXmmm128,
      Vfnmsub231psXmmXmmXmmm128,
      Vfnmsub132psYmmYmmYmmm256,
      Vfnmsub213psYmmYmmYmmm256,
      Vfnmsub231psYmmYmmYmmm256,
      Vfnmsub132sdXmmXmmXmmm64,
      Vfnmsub213sdXmmXmmXmmm64,
      Vfnmsub231sdXmmXmmXmmm64,
      Vfnmsub132ssXmmXmmXmmm32,
      Vfnmsub213ssXmmXmmXmmm32,
      Vfnmsub231ssXmmXmmXmmm32,
      VgatherdpdXmmVm32x64Xmm,
      VgatherqpdXmmVm64x64Xmm,
      VgatherdpdYmmVm32x64Ymm,
      VgatherqpdYmmVm64y64Ymm,
      VgatherdpsXmmVm32x32Xmm,
      VgatherqpsXmmVm64x32Xmm,
      VgatherdpsYmmVm32y32Ymm,
      VgatherqpsXmmVm64y32Xmm,
      VpgatherddXmmVm32x32Xmm,
      VpgatherqdXmmVm64x32Xmm,
      VpgatherddYmmVm32y32Ymm,
      VpgatherqdXmmVm64y32Xmm,
      VpgatherdqXmmVm32x64Xmm,
      VpgatherqqXmmVm64x64Xmm,
      VpgatherdqYmmVm32x64Ymm,
      VpgatherqqYmmVm64y64Ymm,
      Vinsertf128YmmYmmXmmm128Imm8,
      Vinserti128YmmYmmXmmm128Imm8,
      VmaskmovpsXmmXmmM128,
      VmaskmovpsYmmYmmM256,
      VmaskmovpdXmmXmmM128,
      VmaskmovpdYmmYmmM256,
      VmaskmovpsM128XmmXmm,
      VmaskmovpsM256YmmYmm,
      VmaskmovpdM128XmmXmm,
      VmaskmovpdM256YmmYmm,
      VpblenddXmmXmmXmmm128Imm8,
      VpblenddYmmYmmYmmm256Imm8,
      VpbroadcastqXmmXmmm64,
      VpbroadcastqYmmXmmm64,
      Vbroadcasti128YmmM128,
      Vperm2f128YmmYmmYmmm256Imm8,
      Vperm2i128YmmYmmYmmm256Imm8,
      VpermdYmmYmmYmmm256,
      VpermilpdXmmXmmXmmm128,
      VpermilpdYmmYmmYmmm256,
      VpermilpdXmmXmmm128Imm8,
      VpermilpdYmmYmmm256Imm8,
      VpermilpsXmmXmmXmmm128,
      VpermilpsXmmXmmm128Imm8,
      VpermilpsYmmYmmYmmm256,
      VpermilpsYmmYmmm256Imm8,
      VpermpdYmmYmmm256Imm8,
      VpermpsYmmYmmYmmm256,
      VpermqYmmYmmm256Imm8,
      VpmaskmovdXmmXmmM128,
      VpmaskmovdYmmYmmM256,
      VpmaskmovqXmmXmmM128,
      VpmaskmovqYmmYmmM256,
      VpmaskmovdM128XmmXmm,
      VpmaskmovdM256YmmYmm,
      VpmaskmovqM128XmmXmm,
      VpmaskmovqM256YmmYmm,
      VpsllvdXmmXmmXmmm128,
      VpsllvqXmmXmmXmmm128,
      VpsllvdYmmYmmYmmm256,
      VpsllvqYmmYmmYmmm256,
      VpsravdXmmXmmXmmm128,
      VpsravdYmmYmmYmmm256,
      VpsrlvdXmmXmmXmmm128,
      VpsrlvqXmmXmmXmmm128,
      VpsrlvdYmmYmmYmmm256,
      VpsrlvqYmmYmmYmmm256,
      VtestpsXmmXmmm128,
      VtestpsYmmYmmm256,
      VtestpdXmmXmmm128,
      VtestpdYmmYmmm256,
      Vzeroall,
      Vzeroupper,
      XabortImm8Rip,
      XaddRm8R8,
      XaddRm16R16,
      XaddRm32R32,
      XaddRm64R64,
      XbeginRel16Rip,
      XbeginRel32Rip,
      XchgAxR16,
      XchgEaxR32,
      XchgRaxR64,
      XchgRm8R8,
      XchgRm16R16,
      XchgRm32R32,
      XchgRm64R64,
      Xend,
      XlatbAlRbxAl,
      XorAlImm8,
      XorAxImm16,
      XorEaxImm32,
      XorRaxImm32,
      XorRm8Imm8,
      XorRm16Imm16,
      XorRm32Imm32,
      XorRm64Imm32,
      XorRm16Imm8,
      XorRm32Imm8,
      XorRm64Imm8,
      XorRm8R8,
      XorRm16R16,
      XorRm32R32,
      XorRm64R64,
      XorR8Rm8,
      XorR16Rm16,
      XorR32Rm32,
      XorR64Rm64,
      XorpdXmmXmmm128,
      VxorpdXmmXmmXmmm128,
      VxorpdYmmYmmYmmm256,
      XorpsXmmXmmm128,
      VxorpsXmmXmmXmmm128,
      VxorpsYmmYmmYmmm256,
      Xtest,
      Emms,
      F2xm1St0,
      FabsSt0,
      FaddM32fpSt0,
      FaddM64fpSt0,
      FaddSt0Sti,
      FaddStiSt0,
      FaddpStiSt0,
      FaddpSt0St1,
      FiaddM32intSt0,
      FiaddM16intSt0,
      FbldM80decSt0,
      FbstpM80bcd,
      FchsSt0,
      Fclex,
      Fnclex,
      FcmovbSt0Sti,
      FcmoveSt0Sti,
      FcmovbeSt0Sti,
      FcmovuSt0Sti,
      FcmovnbSt0Sti,
      FcmovneSt0Sti,
      FcmovnbeSt0Sti,
      FcmovnuSt0Sti,
      FcomM32fpSt0,
      FcomM64fpSt0,
      FcomStiSt0,
      FcomSt0,
      FcompM32fpSt0,
      FcompM64fpSt0,
      FcompStiSt0,
      FcompSt0,
      FcomppSt0,
      FcomiSt0Sti,
      FcomipSt0Sti,
      FucomiSt0Sti,
      FucomipSt0Sti,
      FcosSt0,
      Fdecstp,
      FdivM32fpSt0,
      FdivM64fpSt0,
      FdivSt0Sti,
      FdivStiSt0,
      FdivpStiSt0,
      FdivpSt0St1,
      FidivM32intSt0,
      FidivM16intSt0,
      FdivrM32fpSt0,
      FdivrM64fpSt0,
      FdivrSt0Sti,
      FdivrStiSt0,
      FdivrpStiSt0,
      FdivrpSt0St1,
      FidivrM32intSt0,
      FidivrM16intSt0,
      FfreeSti,
      FicomM16intSt0,
      FicomM32intSt0,
      FicompM16intSt0,
      FicompM32intSt0,
      FildM16intSt0,
      FildM32intSt0,
      FildM64intSt0,
      Fincstp,
      Finit,
      Fninit,
      FistM16intSt0,
      FistM32intSt0,
      FistpM16intSt0,
      FistpM32intSt0,
      FistpM64intSt0,
      FisttpM16intSt0,
      FisttpM32intSt0,
      FisttpM64intSt0,
      FldM32fpSt0,
      FldM64fpSt0,
      FldM80fpSt0,
      FldStiSt0,
      Fld1St0,
      Fldl2tSt0,
      Fldl2eSt0,
      FldpiSt0,
      Fldlg2St0,
      Fldln2St0,
      FldzSt0,
      FldcwM2byte,
      FldenvM14/28byte,
      FmulM32fpSt0,
      FmulM64fpSt0,
      FmulSt0Sti,
      FmulStiSt0,
      FmulpStiSt0,
      FmulpSt0St1,
      FimulM32intSt0,
      FimulM16intSt0,
      Fnop,
      FpatanSt0St1,
      FpremSt0St1,
      Fprem1St0St1,
      FptanSt0,
      FrndintSt0,
      FrstorM94/108byteStxStxStxStxStxStxStxStx,
      FsaveM94/108byteStxStxStxStxStxStxStxStx,
      FnsaveM94/108byteStxStxStxStxStxStxStxStx,
      FscaleSt0St1,
      FsinSt0,
      FsincosSt0St1,
      FsqrtSt0St1,
      FstM32fpSt0,
      FstM64fpSt0,
      FstStiSt0,
      FstpM32fpSt0,
      FstpM64fpSt0,
      FstpM80fpSt0,
      FstpStiSt0,
      FstcwM2byte,
      FnstcwM2byte,
      FstenvM14/28byte,
      FnstenvM14/28byte,
      FstswM2byte,
      FstswAx,
      FnstswM2byte,
      FnstswAx,
      FsubM32fpSt0,
      FsubM64fpSt0,
      FsubSt0Sti,
      FsubStiSt0,
      FsubpStiSt0,
      FsubpSt0St1,
      FisubM32intSt0,
      FisubM16intSt0,
      FsubrM32fpSt0,
      FsubrM64fpSt0,
      FsubrSt0Sti,
      FsubrStiSt0,
      FsubrpStiSt0,
      FsubrpSt0St1,
      FisubrM32intSt0,
      FisubrM16intSt0,
      FtstSt0,
      FucomStiSt0,
      FucomSt1St0,
      FucompStiSt0,
      FucompSt1St0,
      FucomppSt1St0,
      FxamSt0,
      FxchStiSt0,
      FxchSt0St1,
      FxrstorM512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx,
      Fxrstor64M512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx,
      FxsaveM512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx,
      Fxsave64M512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx,
      FxtractSt0St1,
      Fyl2xSt1St0,
      Fyl2xp1St1St0    )
  }
}
interface ClfshInstruction
interface SseInstruction
interface Sse2Instruction
interface Sse3Instruction
interface PclmulqdqInstruction
interface Ssse3Instruction
interface FmaInstruction
interface Cx16Instruction
interface Sse4_1Instruction
interface Sse4_2Instruction
interface MovbeInstruction
interface PopcntInstruction
interface AesInstruction
interface AvxInstruction
interface F16cInstruction
interface RdrandInstruction
interface Bmi1Instruction
interface HleInstruction
interface Avx2Instruction
interface Bmi2Instruction
interface RtmInstruction
interface RdseedInstruction
interface AdxInstruction
interface ClflushoptInstruction
interface ShaInstruction
interface FpuInstruction
interface Cx8Instruction
interface CmovInstruction
interface MmxInstruction
interface FxsrInstruction
interface LahfLmInstruction
interface AbmInstruction
interface PrfchwInstruction
