package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object ShrRm64Cl : R64m64Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 5, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, 0, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.GpRegister8.CL, BitRange.BITS_0_7)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 5, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitRead(kasm.x64.GpRegister8.CL, BitRange.BITS_0_7)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression64(0, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression64(0, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true))
    }
  }
}
object ShrRm32Imm8 : R32m32Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 5, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, 0, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 5, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression32(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression32(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object ShrRm64Imm8 : R64m64Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 5, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, 0, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 5, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression64(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression64(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object SarxR32Rm32R32 : R32R32m32R32Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 2, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 2, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
  }
}
object ShlxR32Rm32R32 : R32R32m32R32Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
  }
}
object ShrxR32Rm32R32 : R32R32m32R32Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, register3: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 3, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddressExpression32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false), parameters.getGpRegister32(2, true, false))
    }
  }
}
object SarxR64Rm64R64 : R64R64m64R64Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 2, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(register3, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 2, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
  }
}
object ShlxR64Rm64R64 : R64R64m64R64Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(register3, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
  }
}
object ShrxR64Rm64R64 : R64R64m64R64Instruction(), Bmi2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, register2, register3)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, register3: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(register3, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, addressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 3, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xF7)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(register2, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), parameters.getGpRegister64(2, true, false))
    }
  }
}
object SbbAlImm8 : Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x1C)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceImplicitRead(kasm.x64.GpRegister8.AL, BitRange.BITS_0_7)
    tracer.traceRead(immediate, 0, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceImplicitWrite(kasm.x64.GpRegister8.AL, BitRange.BITS_0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getByteImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getByteImmediate(0))
  }
}
object SbbAxImm16 : Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x1D)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceImplicitRead(kasm.x64.GpRegister16.AX, BitRange.BITS_0_15)
    tracer.traceRead(immediate, 0, BitSize.BITS_16)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceImplicitWrite(kasm.x64.GpRegister16.AX, BitRange.BITS_0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getShortImmediate(0))
  }
}
object SbbEaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x1D)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceImplicitRead(kasm.x64.GpRegister32.EAX, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 0, BitSize.BITS_32)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceImplicitWrite(kasm.x64.GpRegister32.EAX, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getIntImmediate(0))
  }
}
object SbbRaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0x1D)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceImplicitRead(kasm.x64.GpRegister64.RAX, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 0, BitSize.BITS_32)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceImplicitWrite(kasm.x64.GpRegister64.RAX, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getIntImmediate(0))
  }
}
object SbbRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 3, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, 0, BitRange.BITS_0_7)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 3, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(immediate, 1, BitSize.BITS_8)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getByteImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression8(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object SbbRm16Imm16 : R16m16Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 3, register)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(register, 0, BitRange.BITS_0_15)
    tracer.traceRead(immediate, 1, BitSize.BITS_16)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 3, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(immediate, 1, BitSize.BITS_16)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getShortImmediate(1), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression16(0, true, true), parameters.getShortImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getShortImmediate(1))
    }
  }
}
