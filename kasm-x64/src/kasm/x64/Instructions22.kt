package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object MovzxR32Rm16 : R32R16mInstruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xB7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xB7)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object MovzxR64Rm16 : R64R16mInstruction(), MoveInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xB7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xB7)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object MpsadbwXmmXmmm128Imm8 : XmmXmmmImm8Instruction(), VectorInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x42)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0x42)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
}
object VmpsadbwXmmXmmXmmm128Imm8 : XmmXmmXmmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x42)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x42)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
}
object VmpsadbwYmmYmmYmmm256Imm8 : YmmYmmYmmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x42)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 3, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x42)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
}
object MulRm8Ax : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 4, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, false), options, tracer)
    }
  }
}
object MulRm16AxDx : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, false), options, tracer)
    }
  }
}
object MulRm32EdxEax : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_31)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_31)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, false), options, tracer)
    }
  }
}
object MulRm64RdxRax : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RDX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress64(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, false), options, tracer)
    }
  }
}
object MulpdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmulpdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VmulpdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object MulpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmulpsXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VmulpsYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object MulsdXmm0To63Xmmm64 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_63)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmulsdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 3, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object MulssXmm0To31Xmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x59)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VmulssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x59)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object MulxR32R32Rm32Edx : R32R32R32mInstruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register3.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(register2.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(register2.topLevelRegister, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, false, true), parameters.getAddress32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, false, true), parameters.getGpRegister32(2, true, false), options, tracer)
    }
  }
}
object MulxR64R64Rm64Rdx : R64R64R64mInstruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RDX, true, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, false, true), parameters.getAddress64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, false, true), parameters.getGpRegister64(2, true, false), options, tracer)
    }
  }
}
object NegRm8 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 3, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), options, tracer)
    }
  }
}
object NegRm16 : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), options, tracer)
    }
  }
}
object NegRm32 : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), options, tracer)
    }
  }
}
object NegRm64 : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress64(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), options, tracer)
    }
  }
}
object Nop : NullaryInstruction() {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x90)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
}
object NopRm16 : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x1F)
    ModRmSib.encode(buffer, options, 0, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x1F)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, false), options, tracer)
    }
  }
}
object NopRm32 : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x1F)
    ModRmSib.encode(buffer, options, 0, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x1F)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, false), options, tracer)
    }
  }
}
object NotRm8 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 2, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), options, tracer)
    }
  }
}
object NotRm16 : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 2, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), options, tracer)
    }
  }
}
