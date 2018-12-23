package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object RdseedR64 : R64Instruction(), RdseedInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 7, register)
  }
  private val features = enumSetOf(RDSEED)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDSEED)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister64(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister64(0, false, true))
  }
}
object RetRspRip : NullaryInstruction(), JumpInstruction, StackInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xC3)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceImplicitRead(kasm.x64.GpRegister64.RSP, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.GpRegister64.RSP, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.IpRegister.RIP, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object RetImm16RspRip : Imm16Instruction(), JumpInstruction, StackInstruction {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xC2)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, 0, BitSize.BITS_16)
    tracer.traceImplicitRead(kasm.x64.GpRegister64.RSP, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.GpRegister64.RSP, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.IpRegister.RIP, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getShortImmediate(0))
  }
}
object RorxR32Rm32Imm8 : R32R32m32Imm8Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 3, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object RorxR64Rm64Imm8 : R64R64m64Imm8Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 3, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object RoundpdXmmXmmm128Imm8 : XmmXmmm128Imm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x09)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundpdXmmXmmm128Imm8 : XmmXmmm128Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundpdYmmYmmm256Imm8 : YmmYmmm256Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object RoundpsXmmXmmm128Imm8 : XmmXmmm128Imm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x08)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundpsXmmXmmm128Imm8 : XmmXmmm128Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundpsYmmYmmm256Imm8 : YmmYmmm256Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object RoundsdXmm0To63Xmmm64Imm8 : XmmXmmm64Imm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0B)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0B)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundsdXmmXmmXmmm64Imm8 : XmmXmmXmmm64Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0B)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x0B)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false), parameters.getByteImmediate(3))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3))
    }
  }
}
object RoundssXmm0To31Xmmm32Imm8 : XmmXmmm32Imm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0A)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0A)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object VroundssXmmXmmXmmm32Imm8 : XmmXmmXmmm32Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false), parameters.getByteImmediate(3))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3))
    }
  }
}
