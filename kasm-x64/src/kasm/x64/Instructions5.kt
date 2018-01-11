package kasm.x64

import kasm.Buffer

object JnsRel8Rip : Imm8Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x79, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object JoRel8Rip : Imm8Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x70, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.OF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object JpRel8Rip : Imm8Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x7A, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object JsRel8Rip : Imm8Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x78, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object JaRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x87, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.ZF)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JaeRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x83, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JbRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x82, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JbeRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x86, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.ZF)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JeRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x84, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JgRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8F, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JgeRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8D, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.OF)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JlRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8C, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JleRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8E, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.OF)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceRead(kasm.x64.Rflag.ZF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JneRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x85, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JnoRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x81, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.OF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JnpRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8B, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.PF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JnsRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x89, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JoRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x80, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.OF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JpRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x8A, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JsRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x88, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JmpRel8Rip : Imm8Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xEB, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object JmpRel32Rip : Imm32Instruction(), JumpInstruction {
  override fun encode(buffer: Buffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xE9, 0xcd)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object JmpRm64Rip : R64mInstruction(), JumpInstruction {
  override fun encode(buffer: Buffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xFF)
    ModRmSib.encode(buffer, options, 4, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xFF)
    ModRmSib.encode(buffer, options, 4, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, true, false), options, tracer)
    }
  }
}
object LahfAh : NullaryInstruction(), LahfLmInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x9F)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.LAHF_LM)
    tracer.traceRead(kasm.x64.Rflag.SF)
    tracer.traceRead(kasm.x64.Rflag.ZF)
    tracer.traceRead(kasm.x64.Rflag.PF)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceRead(kasm.x64.Rflag.AF)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._8_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LddquXmmM128 : XmmM128Instruction(), VectorInstruction, Sse3Instruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF0)
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
    encode(buffer, model.getXmmRegister(0, false, true), model.getAddress128(1, true, false), options, tracer)
  }
}
object VlddquXmmM128 : XmmM128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register, address)
    Encoding.encodeOpcode(buffer, 0xF0)
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
object VlddquYmmM256 : YmmM256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register, address)
    Encoding.encodeOpcode(buffer, 0xF0)
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
    encode(buffer, model.getYmmRegister(0, false, true), model.getAddress256(1, true, false), options, tracer)
  }
}
object LdmxcsrM32 : M32Instruction(), SseInstruction {
  override fun encode(buffer: Buffer, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE)
    ModRmSib.encode(buffer, options, 2, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(address)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.ZE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.ZM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.MM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.FZ, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.RC, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DAZ, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress32(0, true, false), options, tracer)
  }
}
object VldmxcsrM32 : M32Instruction(), AvxInstruction {
  override fun encode(buffer: Buffer, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.Rm.encode(buffer, options, options.rexW, 1, 0, 0, address)
    Encoding.encodeOpcode(buffer, 0xAE)
    ModRmSib.encode(buffer, options, 2, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(address)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.ZE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.ZM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.MM, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.FZ, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.RC, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DAZ, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getAddress32(0, true, false), options, tracer)
  }
}
object LeaR16M16 : R16M16Instruction() {
  override fun encode(buffer: Buffer, register: GpRegister16, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x8D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, address: Address16)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister16(0, false, true), model.getAddress16(1, true, false), options, tracer)
  }
}
object LeaR32M32 : R32M32Instruction() {
  override fun encode(buffer: Buffer, register: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x8D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getAddress32(1, true, false), options, tracer)
  }
}
object LeaR64M64 : R64M64Instruction() {
  override fun encode(buffer: Buffer, register: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x8D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister64(0, false, true), model.getAddress64(1, true, false), options, tracer)
  }
}
object LeavewSpBp : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xC9)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSP, true, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RBP, true, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister64.RSP, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RBP, true, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LeaveqRspRbp : NullaryInstruction(), StackInstruction {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xC9)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSP, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RBP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RSP, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RBP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object Lfence : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE, 0xE8)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LodsbSilSil : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xAC)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_7)
    tracer.traceRead(Address8(kasm.x64.GpRegister64.RSI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.IF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LodswSiSi : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xAD)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_15)
    tracer.traceRead(Address16(kasm.x64.GpRegister64.RSI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.IF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LodsdEsiEsi : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xAD)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_31)
    tracer.traceRead(Address32(kasm.x64.GpRegister64.RSI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.IF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LodsqRsiRsi : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xAD)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RSI, true, BitRange._0_63)
    tracer.traceRead(Address64(kasm.x64.GpRegister64.RSI, null))
    tracer.traceWrite(kasm.x64.GpRegister64.RSI, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.IF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object LoopRel8Rcx : Imm8Instruction() {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xE2, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object LoopeRel8Rcx : Imm8Instruction() {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xE1, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object LoopneRel8Rcx : Imm8Instruction() {
  override fun encode(buffer: Buffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xE0, 0xcb)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.GpRegister64.RCX, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object LzcntR16Rm16 : R16R16mInstruction(), AbmInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister16, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, address: Address16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister16(0, false, true), model.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, false, true), model.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object LzcntR32Rm32 : R32R32mInstruction(), AbmInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister32(0, false, true), model.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object LzcntR64Rm64 : R64R64mInstruction(), AbmInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBD)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ABM)
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister64(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object MaskmovdquXmmXmmRdiRdi : XmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_63)
    tracer.traceWrite(Address64(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object VmaskmovdquXmmXmmRdiRdi : XmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_63)
    tracer.traceWrite(Address64(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getXmmRegister(0, true, false), model.getXmmRegister(1, true, false), options, tracer)
  }
}
object MaskmovqMmMmRdiRdi : MmMmInstruction(), VectorInstruction, MoveInstruction {
  override fun encode(buffer: Buffer, register1: MmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RDI, true, BitRange._0_63)
    tracer.traceWrite(Address64(kasm.x64.GpRegister64.RDI, null))
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getMmRegister(0, true, false), model.getMmRegister(1, true, false), options, tracer)
  }
}
object MaxpdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxpdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxpdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MaxpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxpsXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxpsYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MaxsdXmm0To63Xmmm64 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxsdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MaxssXmm0To31Xmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5F)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VmaxssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5F)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object Mfence : NullaryInstruction() {
  override fun encode(buffer: Buffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE, 0xF0)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object MinpdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminpdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminpdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MinpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminpsXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminpsYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, address: Address256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, address: Address256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MinsdXmm0To63Xmmm64 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminsdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MinssXmm0To31Xmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5D)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object VminssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, address, register2)
    Encoding.encodeOpcode(buffer, 0x5D)
    ModRmSib.encode(buffer, options, register1, address)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(address)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
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
object MovRm8R8 : R8m8R88Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x88)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address8, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x88)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address8, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress8(0, false, true), model.getGpRegister8(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, false, true), model.getGpRegister8(1, true, false), options, tracer)
    }
  }
}
object MovRm16R16 : R16mR16Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress16(0, false, true), model.getGpRegister16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, false, true), model.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object MovRm32R32 : R32mR32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object MovRm64R64 : R64mR64Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x89)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object MovR8Rm8 : R88R8m8Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x8A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister8, address: Address8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x8A)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, address: Address8)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister8(0, false, true), model.getAddress8(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, false, true), model.getGpRegister8(1, true, false), options, tracer)
    }
  }
}
object MovR16Rm16 : R16R16mInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister16, address: Address16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, address: Address16)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister16(0, false, true), model.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, false, true), model.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object MovR32Rm32 : R32R32mInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister32, address: Address32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, address: Address32)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister32(0, false, true), model.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object MovR64Rm64 : R64R64mInstruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: GpRegister64, address: Address64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, address)
    Encoding.encodeOpcode(buffer, 0x8B)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, address: Address64)  {
    tracer.beginTracing()
    tracer.traceRead(address)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getGpRegister64(0, false, true), model.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object MovabsAlMoffs8 : Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA0)
    Encoding.encodeImmediate8(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object MovabsAxMoffs16 : Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xA1)
    Encoding.encodeImmediate16(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Short)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._16)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getShortImmediate(0), options, tracer)
  }
}
object MovabsEaxMoffs32 : Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA1)
    Encoding.encodeImmediate32(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Int)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object MovabsRaxMoffs64 : Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA1)
    Encoding.encodeImmediate64(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Long)  {
    tracer.beginTracing()
    tracer.traceRead(offset, false, BitSize._64)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getLongImmediate(0), options, tracer)
  }
}
object MovabsMoffs8Al : Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA2)
    Encoding.encodeImmediate8(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_7)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getByteImmediate(0), options, tracer)
  }
}
object MovabsMoffs16Ax : Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate16(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Short)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._16)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getShortImmediate(0), options, tracer)
  }
}
object MovabsMoffs32Eax : Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate32(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Int)  {
    tracer.beginTracing()
    tracer.traceRead(offset.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_31)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getIntImmediate(0), options, tracer)
  }
}
object MovabsMoffs64Rax : Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, offset: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, offset)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA3)
    Encoding.encodeImmediate64(buffer, offset)
  }
  override fun trace(tracer: InstructionTracer, offset: Long)  {
    tracer.beginTracing()
    tracer.traceRead(offset, false, BitSize._64)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_63)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getLongImmediate(0), options, tracer)
  }
}
object MovR8Imm8 : R88Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg8.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister8(0, false, true), model.getByteImmediate(1), options, tracer)
  }
}
object MovR16Imm16 : R16Imm16Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister16(0, false, true), model.getShortImmediate(1), options, tracer)
  }
}
object MovR32Imm32 : R32Imm32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister32(0, false, true), model.getIntImmediate(1), options, tracer)
  }
}
object MovR64Imm64 : R64Imm64Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister64, immediate: Long, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcodeO(buffer, 0xB8, register)
    Encoding.encodeImmediate64(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Long)  {
    tracer.beginTracing()
    tracer.traceRead(immediate, false, BitSize._64)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, model.getGpRegister64(0, false, true), model.getLongImmediate(1), options, tracer)
  }
}
object MovRm8Imm8 : R8m8Imm8Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC6)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xC6)
    ModRmSib.encode(buffer, options, 0, address)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress8(0, false, true), model.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister8(0, false, true), model.getByteImmediate(1), options, tracer)
    }
  }
}
object MovRm16Imm16 : R16mImm16Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, address)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress16(0, false, true), model.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister16(0, false, true), model.getShortImmediate(1), options, tracer)
    }
  }
}
object MovRm32Imm32 : R32mImm32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, address)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, address)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress32(0, false, true), model.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister32(0, false, true), model.getIntImmediate(1), options, tracer)
    }
  }
}
object MovRm64Imm32 : R64mImm32Instruction(), MoveInstruction {
  override fun encode(buffer: Buffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, address: Address64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, address, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, address)
    Encoding.encodeOpcode(buffer, 0xC7)
    ModRmSib.encode(buffer, options, 0, address)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, address: Address64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(address)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, model: InstructionModel, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(model.useAddress()) {
      encode(buffer, model.getAddress64(0, false, true), model.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, model.getGpRegister64(0, false, true), model.getIntImmediate(1), options, tracer)
    }
  }
}
object MovapdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
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
object MovapdXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
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
    Encoding.encodeOpcode(buffer, 0x0F, 0x29)
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
object VmovapdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
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
object VmovapdXmmm128Xmm : XmmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register2, register1)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, address)
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
object VmovapdYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
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
object VmovapdYmmm256Ymm : YmmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: Buffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register2, register1)
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
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, address)
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
object MovapsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: Buffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: Buffer, register: XmmRegister, address: Address128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, address)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, address)
    Encoding.encodeOpcode(buffer, 0x0F, 0x28)
    ModRmSib.encode(buffer, options, register, address)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, address: Address128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
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
