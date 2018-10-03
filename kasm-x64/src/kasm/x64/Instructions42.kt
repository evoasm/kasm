package kasm.x64

import java.nio.ByteBuffer

object RdseedR64 : R64Instruction(), RdseedInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 7, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDSEED)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister64(0, false, true), options, tracer)
  }
}
object RetRspRip : NullaryInstruction(), JumpInstruction, StackInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xC3)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RSP, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object RetImm16RspRip : Imm16Instruction(), JumpInstruction, StackInstruction {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xC2)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceRead(kasm.x64.GpRegister64.RSP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RSP, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getShortImmediate(0), options, tracer)
  }
}
object RorxR32Rm32Imm8 : R32R32mImm8Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 3, register, address)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister32(0, false, true), model.getAddress32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object RorxR64Rm64Imm8 : R64R64mImm8Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, address: Address64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 3, register, address)
    Encoding.encodeOpcode(buffer, 0xF0)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, address: Address64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister64(0, false, true), model.getAddress64(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object RoundpdXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x09)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundpdXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundpdYmmYmmm256Imm8 : YmmYmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, address: Address256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x09)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object RoundpsXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x08)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundpsXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundpsYmmYmmm256Imm8 : YmmYmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, address: Address256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x08)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object RoundsdXmm0To63Xmmm64Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0B)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0B)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundsdXmmXmmXmmm64Imm8 : XmmXmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0B)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x0B)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object RoundssXmm0To31Xmmm32Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0A)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x0A)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VroundssXmmXmmXmmm32Imm8 : XmmXmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, options.vexL, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object RsqrtpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x52)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x52)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrsqrtpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrsqrtpsYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object RsqrtssXmm0To31Xmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x52)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x52)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrsqrtssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 2, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x52)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object SahfAh : NullaryInstruction(), LahfLmInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x9E)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.LAHF_LM)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._8_15)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object SalRm81 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD0)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD0)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address8)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress8(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, true, true), options, tracer)
    }
  }
}
object SalRm8Cl : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address8)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress8(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, true, true), options, tracer)
    }
  }
}
object SalRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC0)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xC0)
    ModRmSib.encode(buffer, options, 4, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress8(0, true, true), model.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, true, true), model.getByteImmediate(1), options, tracer)
    }
  }
}
object SalRm161 : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address16)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress16(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, true, true), options, tracer)
    }
  }
}
object SalRm16Cl : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address16)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress16(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, true, true), options, tracer)
    }
  }
}
object SalRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 4, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress16(0, true, true), model.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, true, true), model.getByteImmediate(1), options, tracer)
    }
  }
}
object SalRm321 : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, true, true), options, tracer)
    }
  }
}
object SalRm641 : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, address)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, true, true), options, tracer)
    }
  }
}
object SalRm32Cl : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(address)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, true, true), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, true, true), options, tracer)
    }
  }
}
