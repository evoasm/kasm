package kasm.x64

import kasm.Buffer

object VpshufbXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x00)
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
    Encoding.encodeOpcode(buffer, 0x00)
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
object VpshufbYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x00)
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
    Encoding.encodeOpcode(buffer, 0x00)
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
object PshufdXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshufdXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshufdYmmYmmm256Imm8 : YmmYmmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PshufhwXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshufhwXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshufhwYmmYmmm256Imm8 : YmmYmmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PshuflwXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshuflwXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object VpshuflwYmmYmmm256Imm8 : YmmYmmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PshufwMmMmm64Imm8 : MmMmmImm8Instruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x70)
    ModRmSib.encode(buffer, options, register, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, false, true), model.getAddress64(1, true, false), model.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, false, true), model.getMmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
    }
  }
}
object PsignbMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x08)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x08)
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
object PsignbXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x08)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x08)
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
object PsignwMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x09)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x09)
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
object PsignwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x09)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x09)
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
object PsigndMmMmm64 : MmMmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x0A)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x0A)
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
object PsigndXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Ssse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x0A)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x0A)
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
object VpsignbXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x08)
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
    Encoding.encodeOpcode(buffer, 0x08)
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
object VpsignwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x09)
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
    Encoding.encodeOpcode(buffer, 0x09)
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
object VpsigndXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
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
    Encoding.encodeOpcode(buffer, 0x0A)
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
object VpsignbYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x08)
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
    Encoding.encodeOpcode(buffer, 0x08)
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
object VpsignwYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x09)
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
    Encoding.encodeOpcode(buffer, 0x09)
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
object VpsigndYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x0A)
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
    Encoding.encodeOpcode(buffer, 0x0A)
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
object PslldqXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 7, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object VpslldqXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 7, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpslldqYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 7, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PsllwMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF1)
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
object PsllwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF1)
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
object PsllwMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsllwXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PslldMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF2)
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
object PslldXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF2)
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
object PslldMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PslldXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsllqMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF3)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF3)
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
object PsllqXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF3)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF3)
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
object PsllqMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsllqXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 6, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object VpsllwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF1)
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
    Encoding.encodeOpcode(buffer, 0xF1)
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
object VpsllwXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpslldXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF2)
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
    Encoding.encodeOpcode(buffer, 0xF2)
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
object VpslldXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsllqXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF3)
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
    Encoding.encodeOpcode(buffer, 0xF3)
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
object VpsllqXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsllwYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF1)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF1)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsllwYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpslldYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF2)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF2)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpslldYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsllqYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF3)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xF3)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsllqYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 6, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PsrawMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xE1)
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
object PsrawXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xE1)
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
object PsrawMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrawXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsradMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xE2)
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
object PsradXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xE2)
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
object PsradMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsradXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 4, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object VpsrawXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xE1)
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
    Encoding.encodeOpcode(buffer, 0xE1)
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
object VpsrawXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 4, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsradXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xE2)
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
    Encoding.encodeOpcode(buffer, 0xE2)
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
object VpsradXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 4, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrawYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xE1)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xE1)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsrawYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 4, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsradYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xE2)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xE2)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsradYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 4, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PsrldqXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 3, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object VpsrldqXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 3, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrldqYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 3, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PsrlwMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD1)
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
object PsrlwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD1)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD1)
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
object PsrlwMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrlwXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x71)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrldMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD2)
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
object PsrldXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD2)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD2)
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
object PsrldMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrldXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x72)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrlqMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD3)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD3)
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
object PsrlqXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD3)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xD3)
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
object PsrlqMmImm8 : MmImm8Instruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register: MmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object PsrlqXmmImm8 : XmmImm8Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x73)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, true), model.getByteImmediate(1), options, tracer)
  }
}
object VpsrlwXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD1)
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
    Encoding.encodeOpcode(buffer, 0xD1)
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
object VpsrlwXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrldXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD2)
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
    Encoding.encodeOpcode(buffer, 0xD2)
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
object VpsrldXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrlqXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD3)
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
    Encoding.encodeOpcode(buffer, 0xD3)
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
object VpsrlqXmmXmmImm8 : XmmXmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrlwYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsrlwYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x71)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrldYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsrldYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x72)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object VpsrlqYmmYmmXmmm128 : YmmYmmXmmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VpsrlqYmmYmmImm8 : YmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RmVex.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x73)
    ModRmSib.encode(buffer, options, 2, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), model.getByteImmediate(2), options, tracer)
  }
}
object PsubbMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF8)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF8)
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
object PsubbXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF8)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF8)
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
object PsubwMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF9)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF9)
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
object PsubwXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF9)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xF9)
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
object PsubdMmMmm64 : MmMmmInstruction(), VectorInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xFA)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xFA)
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
object PsubdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xFA)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0xFA)
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
