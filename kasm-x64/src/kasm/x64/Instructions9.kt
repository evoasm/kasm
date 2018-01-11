package kasm.x64

import kasm.Buffer

object VpcmpgtdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x66)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x66)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpcmpgtbYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x64)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x64)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpcmpgtwYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x65)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x65)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpcmpgtdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x66)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x66)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PcmpgtqXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x37)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x37)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpcmpgtqXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x37)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x37)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpcmpgtqYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x37)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x37)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PcmpistriXmmXmmm128Imm8Rcx : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x63)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x63)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, false), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpcmpistriXmmXmmm128Imm8Rcx : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x63)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x63)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, false), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PcmpistrmXmmXmmm128Imm8Xmm0 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x62)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.ZmmRegister.ZMM0, true, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x62)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.ZmmRegister.ZMM0, true, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, false), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpcmpistrmXmmXmmm128Imm8Xmm0 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x62)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.ZmmRegister.ZMM0, true, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x62)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.ZmmRegister.ZMM0, true, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, false), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PdepR32R32Rm32 : R32R32R32mInstruction(), Bmi2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), model.getAddress32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), model.getGpRegister32(2, true, false), options, tracer)
    }
  }
}
object PdepR64R64Rm64 : R64R64R64mInstruction(), Bmi2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), model.getAddress64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), model.getGpRegister64(2, true, false), options, tracer)
    }
  }
}
object PextR32R32Rm32 : R32R32R32mInstruction(), Bmi2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 2, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), model.getAddress32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), model.getGpRegister32(2, true, false), options, tracer)
    }
  }
}
object PextR64R64Rm64 : R64R64R64mInstruction(), Bmi2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 2, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), model.getAddress64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), model.getGpRegister64(2, true, false), options, tracer)
    }
  }
}
object PextrbR32m8XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x14)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x14)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PextrdRm32XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x16)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x16)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PextrqRm64XmmImm8 : R64mXmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x16)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x16)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpextrbR32m8XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpextrdRm32XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpextrqRm64XmmImm8 : R64mXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PextrwR32MmImm8 : R32MmImm8Instruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC5)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getMmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PextrwR32XmmImm8 : R32XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC5)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PextrwR32m16XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x15)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x15)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpextrwR32XmmImm8 : R32XmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0xC5)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpextrwR32m16XmmImm8 : R32mXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PhaddwMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x01)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x01)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhaddwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x01)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x01)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PhadddMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x02)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x02)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhadddXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x02)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x02)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VphaddwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x01)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x01)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphadddXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x02)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x02)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphaddwYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x01)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x01)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphadddYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x02)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x02)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PhaddswMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x03)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x03)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhaddswXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x03)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x03)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VphaddswXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x03)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x03)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphaddswYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x03)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x03)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PhminposuwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x41)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x41)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VphminposuwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x41)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x41)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PhsubwMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x05)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x05)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhsubwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x05)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x05)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PhsubdMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x06)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x06)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhsubdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x06)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x06)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VphsubwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x05)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x05)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphsubdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x06)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x06)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphsubwYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x05)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x05)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphsubdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x06)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x06)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PhsubswMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x07)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x07)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PhsubswXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x07)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x07)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VphsubswXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x07)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x07)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VphsubswYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x07)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x07)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, true, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PinsrbXmmR32m8Imm8 : XmmR32mImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x20)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x20)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getGpRegister32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PinsrdXmmRm32Imm8 : XmmR32mImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x22)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x22)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getGpRegister32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PinsrqXmmRm64Imm8 : XmmR64mImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x22)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x22)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress64(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getGpRegister64(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpinsrbXmmXmmR32m8Imm8 : XmmXmmR32mImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x20)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x20)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getGpRegister32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object VpinsrdXmmXmmRm32Imm8 : XmmXmmR32mImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x22)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x22)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getGpRegister32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object VpinsrqXmmXmmRm64Imm8 : XmmXmmR64mImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 3, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x22)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 3, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x22)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress64(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getGpRegister64(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object PinsrwMmR32m16Imm8 : MmR32mImm8Instruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC4)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC4)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getGpRegister32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PinsrwXmmR32m16Imm8 : XmmR32mImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC4)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC4)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getGpRegister32(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpinsrwXmmXmmR32m16Imm8 : XmmXmmR32mImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xC4)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xC4)
    ModRmSib.encode(buffer, options, register1, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getAddress32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), model.getGpRegister32(2, true, false), model.getByteImmediate(3), options, tracer)
    }
  }
}
object PmaddubswMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x04)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x04)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaddubswXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x04)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x04)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSSE3)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpmaddubswXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x04)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x04)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaddubswYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x04)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x04)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PmaddwdMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF5)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF5)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaddwdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF5)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF5)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpmaddwdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaddwdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF5)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PmaxswMmMmm64 : MmMmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEE)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEE)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaxsbXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3C)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3C)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaxswXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEE)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEE)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaxsdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpmaxsbXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3C)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3C)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxswXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xEE)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xEE)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxsdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3D)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxsbYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3C)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3C)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxswYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xEE)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xEE)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxsdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PmaxubMmMmm64 : MmMmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDE)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDE)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaxubXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDE)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDE)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PmaxuwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpmaxubXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xDE)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xDE)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxuwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3E)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3E)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxubYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xDE)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xDE)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxuwYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3E)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3E)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PmaxudXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x3F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpmaxudXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3F)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpmaxudYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x3F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x3F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PminswMmMmm64 : MmMmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEA)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEA)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object PminsbXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x38)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x38)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object PminswXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEA)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xEA)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpminsbXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x38)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x38)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpminswXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xEA)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xEA)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpminsbYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x38)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x38)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpminswYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xEA)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xEA)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PminsdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x39)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x39)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, true, true), model.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, true, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VpminsdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x39)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x39)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpminsdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x39)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x39)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object PminubMmMmm64 : MmMmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDA)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xDA)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, true, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, true, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
