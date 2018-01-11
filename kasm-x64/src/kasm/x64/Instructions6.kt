package kasm.x64

import kasm.Buffer

object MovapsXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovapsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x28)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x28)
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
object VmovapsXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register2, register1)
    Encoding.encodeOpcode(buffer, 0x29)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x29)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovapsYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x28)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x28)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovapsYmmm256Ymm : YmmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register2, register1)
    Encoding.encodeOpcode(buffer, 0x29)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x29)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object MovbeR16M16 : R16M16Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, register: GpRegister16, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF0)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, address: Address16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister16(0, false, true), model.getAddress16(1, true, false), options, tracer)
  }
}
object MovbeR32M32 : R32M32Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, register: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF0)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getAddress32(1, true, false), options, tracer)
  }
}
object MovbeR64M64 : R64M64Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, register: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF0)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister64(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object MovbeM16R16 : M16R16Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, address: Address16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF1)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress16(0, false, true), model.getGpRegister16(1, true, false), options, tracer)
  }
}
object MovbeM32R32 : M32R32Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, address: Address32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF1)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
  }
}
object MovbeM64R64 : M64R64Instruction(), MoveInstruction, MovbeInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF1)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MOVBE)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
  }
}
object MovdMmRm32 : MmR32mInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, false, true), model.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object MovqMmRm64 : MmR64mInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object MovdRm32Mm : R32mMmInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object MovqRm64Mm : R64mMmInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object MovdXmmRm32 : XmmR32mInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object MovqXmmRm64 : XmmR64mInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object MovdRm32Xmm : R32mXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object MovqRm64Xmm : R64mXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdXmmRm32 : XmmR32mInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object VmovqXmmRm64 : XmmR64mInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x6E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object VmovdRm32Xmm : R32mXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovqRm64Xmm : R64mXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7E)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 1, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object MovddupXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE3)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE3)
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
object VmovddupXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x12)
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
object VmovddupYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object MovdqaXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
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
object MovdqaXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdqaXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6F)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x6F)
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
object VmovdqaXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdqaYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x6F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdqaYmmm256Ymm : YmmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object MovdquXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
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
object MovdquXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdquXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6F)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x6F)
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
object VmovdquXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdquYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x6F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x6F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovdquYmmm256Ymm : YmmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register2, register1)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object Movdq2qMmXmm : MmXmmInstruction(), VectorInstruction, MoveInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovhlpsXmm0To63Xmm64To127 : XmmXmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._64_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovhlpsXmmXmm64To127Xmm64To127 : XmmXmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._64_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._64_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
  }
}
object MovhpdXmm64To127M64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x16)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._64_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object VmovhpdXmmXmm0To63M64 : XmmXmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress64(2, true, false), options, tracer)
  }
}
object MovhpdM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x17)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovhpdM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x17)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovhpsXmm64To127M64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x16)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._64_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object VmovhpsXmmXmm0To63M64 : XmmXmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress64(2, true, false), options, tracer)
  }
}
object MovhpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x17)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovhpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x17)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovlhpsXmm64To127Xmm0To63 : XmmXmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x16)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._64_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovlhpsXmmXmm0To63Xmm0To63 : XmmXmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
  }
}
object MovlpdXmm0To63M64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object VmovlpdXmmXmm64To127M64 : XmmXmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._64_127)
    tracer.traceRead(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), model.getAddress64(2, true, false), options, tracer)
  }
}
object MovlpdM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x13)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovlpdM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovlpsXmm0To63M64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object VmovlpsXmmXmm64To127M64 : XmmXmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._64_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getAddress64(2, true, false), options, tracer)
  }
}
object MovlpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x13)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovlpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovmskpdR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovmskpdR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovmskpdR32Ymm : R32YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
  }
}
object MovmskpsR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovmskpsR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovmskpsR32Ymm : R32YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
  }
}
object MovntdqaXmmM128 : XmmM128Instruction(), VectorInstruction, MoveInstruction, Sse4_1Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x2A)
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
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
  }
}
object VmovntdqaXmmM128 : XmmM128Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x2A)
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
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
  }
}
object VmovntdqaYmmM256 : YmmM256Instruction(), VectorInstruction, MoveInstruction, Avx2Instruction {
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x2A)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
  }
}
object MovntdqM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE7)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntdqM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0xE7)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntdqM256Ymm : M256YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0xE7)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
  }
}
object MovntiM32R32 : M32R32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, address: Address32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC3)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
  }
}
object MovntiM64R64 : M64R64Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC3)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
  }
}
object MovntpdM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntpdM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntpdM256Ymm : M256YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
  }
}
object MovntpsM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntpsM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmovntpsM256Ymm : M256YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address256, register: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, address)
    Encoding.encodeOpcode(buffer, 0x2B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address256, register: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress256(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
  }
}
object MovntqM64Mm : M64MmInstruction(), VectorInstruction, MoveInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE7)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: MmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getMmRegister(1, true, false), options, tracer)
  }
}
object MovqMmMmm64 : MmMmmInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: MmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x6F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getMmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object MovqMmm64Mm : MmmMmInstruction(), VectorInstruction, MoveInstruction, MmxInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: MmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.MMX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getMmRegister(0, false, true), model.getMmRegister(1, true, false), options, tracer)
    }
  }
}
object MovqXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x7E)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
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
object VmovqXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x7E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x7E)
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
object MovqXmmm64Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD6)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD6)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovqXmmm64Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0xD6)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
    Encoding.encodeOpcode(buffer, 0xD6)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object Movq2dqXmmMm : XmmMmInstruction(), VectorInstruction, MoveInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xD6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getMmRegister(1, true, false), options, tracer)
  }
}
object MovsbSilSilDilDil : NullaryInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA4)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_7)
    tracer.traceRead(Address8(kasm.x64.GpRegister64.RSI, null))
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_7)
    tracer.traceRead(Address8(kasm.x64.GpRegister64.RDI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDI, true, BitRange._0_7, true)
    tracer.traceWrite(Address8(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object MovswSiSiDiDi : NullaryInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA5)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_15)
    tracer.traceRead(Address16(kasm.x64.GpRegister64.RSI, null))
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_15)
    tracer.traceRead(Address16(kasm.x64.GpRegister64.RDI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDI, true, BitRange._0_15, true)
    tracer.traceWrite(Address16(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object MovsdEsiEsiEdiEdi : NullaryInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA5)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_31)
    tracer.traceRead(Address32(kasm.x64.GpRegister64.RSI, null))
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_31)
    tracer.traceRead(Address32(kasm.x64.GpRegister64.RDI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDI, true, BitRange._0_63, true)
    tracer.traceWrite(Address32(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object MovsqRsiRsiRdiRdi : NullaryInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA5)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_63)
    tracer.traceRead(Address64(kasm.x64.GpRegister64.RSI, null))
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_63)
    tracer.traceRead(Address64(kasm.x64.GpRegister64.RDI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDI, true, BitRange._0_63, true)
    tracer.traceWrite(Address64(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object MovsdXmm0To63Xmmm64 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x10)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x10)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
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
object MovsdXmmm64Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x11)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x11)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress128(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmovsdXmmXmmXmm : XmmXmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x10)
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
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
  }
}
object VmovsdXmmM64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, options.vexL, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x10)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object VmovsdXmmXmmXmmMvr : XmmXmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 3, register3, register1, register2)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register3, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, false, true), model.getXmmRegister(1, true, false), model.getXmmRegister(2, true, false), options, tracer)
  }
}
object VmovsdM64Xmm : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, address: Address64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, options.vexL, 3, register, address)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress64(0, false, true), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MovshdupXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse3Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x16)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE3)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x16)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE3)
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
object VmovshdupXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x16)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x16)
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
object VmovshdupYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register1, register2)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 2, register, address)
    Encoding.encodeOpcode(buffer, 0x16)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getYmmRegister(0, false, true), model.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
