package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object AdcAlImm8 : Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x14)
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
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getByteImmediate(0), options, tracer)
  }
}
object AdcAxImm16 : Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.traceRead(kasm.x64.Rflag.CF)
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
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
}
object AdcEaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.traceRead(kasm.x64.Rflag.CF)
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
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object AdcRaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0x15)
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
    tracer.traceRead(kasm.x64.Rflag.CF)
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
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object AdcRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object AdcRm16Imm16 : R16mImm16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
  }
}
object AdcRm32Imm32 : R32mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
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
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object AdcRm64Imm32 : R64mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, register)
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
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object AdcRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object AdcRm32Imm8 : R32mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
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
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object AdcRm64Imm8 : R64mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
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
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 2, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object AdcRm8R8 : R8m8R88Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x10)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_7)
    tracer.traceRead(register2, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x10)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress8(0, true, true), parameters.getGpRegister8(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, false), options, tracer)
    }
  }
}
object AdcRm16R16 : R16mR16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_15)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object AdcRm32R32 : R32mR32Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_31)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object AdcRm64R64 : R64mR64Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x11)
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
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x11)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object AdcR8Rm8 : R88R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister8, register2: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_7)
    tracer.traceRead(register2, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_7, true)
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
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getAddress8(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, false), options, tracer)
    }
  }
}
object AdcR16Rm16 : R16R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_15)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, true)
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
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_15, true)
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
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getAddress16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
}
object AdcR32Rm32 : R32R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_31)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
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
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(addressExpression)
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
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object AdcR64Rm64 : R64R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
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
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(addressExpression)
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
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object AdcxR32Rm32 : R32R32mInstruction(), AdxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(ADX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ADX)
    tracer.traceRead(register1, false, BitRange._0_31)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF6)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ADX)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getAddress32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false), options, tracer)
    }
  }
}
object AdcxR64Rm64 : R64R64mInstruction(), AdxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(ADX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ADX)
    tracer.traceRead(register1, false, BitRange._0_63)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xF6)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.ADX)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getAddress64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
}
object AddAlImm8 : Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x04)
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
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getByteImmediate(0), options, tracer)
  }
}
object AddAxImm16 : Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x05)
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
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
}
object AddEaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x05)
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
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object AddRaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0x05)
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
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
}
object AddRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
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
      encode(buffer, parameters.getAddress8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
object AddRm16Imm16 : R16mImm16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
  }
}
object AddRm32Imm32 : R32mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
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
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object AddRm64Imm32 : R64mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x81)
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
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
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
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getIntImmediate(1), options, tracer)
    }
  }
}
object AddRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.SF, false)
    tracer.traceWrite(kasm.x64.Rflag.ZF, false)
    tracer.traceWrite(kasm.x64.Rflag.PF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.traceWrite(kasm.x64.Rflag.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
}
