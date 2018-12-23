package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object MovabsRaxMoffs64 : Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, offset: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA1)
    Encoding.encodeImmediate64(buffer, offset)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, offset: Long)  {
    tracer.beginTracing()
    tracer.traceRead(offset, 0, BitSize.BITS_64)
    tracer.traceImplicitWrite(kasm.x64.GpRegister64.RAX, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getLongImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getLongImmediate(0))
  }
}
object MovabsMoffs8Al : Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, offset: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA2)
    Encoding.encodeImmediate8(buffer, offset)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, offset: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(offset, 0, BitSize.BITS_8)
    tracer.traceImplicitRead(kasm.x64.GpRegister8.AL, BitRange.BITS_0_7)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getByteImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getByteImmediate(0))
  }
}
object MovabsMoffs16Ax : Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, offset: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate16(buffer, offset)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, offset: Short)  {
    tracer.beginTracing()
    tracer.traceRead(offset, 0, BitSize.BITS_16)
    tracer.traceImplicitRead(kasm.x64.GpRegister16.AX, BitRange.BITS_0_15)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getShortImmediate(0))
  }
}
object MovabsMoffs32Eax : Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, offset: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate32(buffer, offset)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, offset: Int)  {
    tracer.beginTracing()
    tracer.traceRead(offset, 0, BitSize.BITS_32)
    tracer.traceImplicitRead(kasm.x64.GpRegister32.EAX, BitRange.BITS_0_31)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getIntImmediate(0))
  }
}
object MovabsMoffs64Rax : Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, offset: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate64(buffer, offset)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, offset: Long)  {
    tracer.beginTracing()
    tracer.traceRead(offset, 0, BitSize.BITS_64)
    tracer.traceImplicitRead(kasm.x64.GpRegister64.RAX, BitRange.BITS_0_63)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getLongImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getLongImmediate(0))
  }
}
object MovR8Imm8 : R8Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg8.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister8(0, false, true), parameters.getByteImmediate(1), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister8(0, false, true), parameters.getByteImmediate(1))
  }
}
object MovR16Imm16 : R16Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_16)
    tracer.traceWrite(register, 0, BitRange.BITS_0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister16(0, false, true), parameters.getShortImmediate(1), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getShortImmediate(1))
  }
}
object MovR32Imm32 : R32Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_32)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getIntImmediate(1), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getIntImmediate(1))
  }
}
object MovR64Imm64 : R64Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate64(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Long)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_64)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getLongImmediate(1), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getLongImmediate(1))
  }
}
object MovRm8Imm8 : R8m8Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC6)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC6)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression8(0, false, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, false, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression8(0, false, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, false, true), parameters.getByteImmediate(1))
    }
  }
}
object MovRm16Imm16 : R16m16Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_16)
    tracer.traceWrite(register, 0, BitRange.BITS_0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_16)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression16(0, false, true), parameters.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, false, true), parameters.getShortImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression16(0, false, true), parameters.getShortImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getShortImmediate(1))
    }
  }
}
object MovRm32Imm32 : R32m32Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_32)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_32)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression32(0, false, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression32(0, false, true), parameters.getIntImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getIntImmediate(1))
    }
  }
}
object MovRm64Imm32 : R64m64Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_32)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 1, BitSize.BITS_32)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression64(0, false, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression64(0, false, true), parameters.getIntImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getIntImmediate(1))
    }
  }
}
object MovapdXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object MovapdXmmm128Xmm : Xmmm128XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register, 1, BitRange.BITS_0_127)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
