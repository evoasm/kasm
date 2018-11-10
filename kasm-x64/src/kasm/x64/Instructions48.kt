package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object VsubssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x5C)
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
    Encoding.encodeOpcode(buffer, 0x5C)
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
object TestAlImm8 : Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xA8)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getByteImmediate(0), options, tracer)
  }
}
object TestAxImm16 : Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xA9)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
}
object TestEaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xA9)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object TestRaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0xA9)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object TestRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF6)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, false), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, false), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object TestRm16Imm16 : R16mImm16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, false), parameters.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, false), parameters.getShortImmediate(1), options, tracer)
    }
  }
}
object TestRm32Imm32 : R32mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, false), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, false), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object TestRm64Imm32 : R64mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress64(0, true, false), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, false), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object TestRm8R8 : R8m8R88Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x84)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x84)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, false), parameters.getGpRegister8(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, false), parameters.getGpRegister8(1, true, false), options, tracer)
    }
  }
}
object TestRm16R16 : R16mR16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, false), parameters.getGpRegister16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, false), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object TestRm32R32 : R32mR32Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, false), parameters.getGpRegister32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, false), parameters.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object TestRm64R64 : R64mR64Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x85)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress64(0, true, false), parameters.getGpRegister64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, false), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object TzcntR16Rm16 : R16R16mInstruction(), Bmi1Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(BMI1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
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
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
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
      encode(buffer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object TzcntR32Rm32 : R32R32mInstruction(), Bmi1Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(BMI1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
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
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
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
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object TzcntR64Rm64 : R64R64mInstruction(), Bmi1Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(BMI1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
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
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
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
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object UcomisdXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
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
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VucomisdXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object UcomissXmmXmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
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
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VucomissXmmXmmm32 : XmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object Ud2 : NullaryInstruction() {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x0F, 0x0B)
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
object UnpckhpdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
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
object VunpckhpdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
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
object VunpckhpdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
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
object UnpckhpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
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
object VunpckhpsXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
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
object VunpckhpsYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
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
object UnpcklpdXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
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
object VunpcklpdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
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
object VunpcklpdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
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
