package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object CmoveR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x44)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x44)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmoveR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x44)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x44)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovgR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovgR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovgR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4F)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovgeR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovgeR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovgeR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4D)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovlR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovlR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovlR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4C)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovleR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovleR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovleR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceRead(kasm.x64.RflagsField.ZF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovneR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovneR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovneR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x45)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovnoR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovnoR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovnoR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x41)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovnpR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovnpR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovnpR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovnsR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovnsR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovnsR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x49)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovoR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object CmovoR32Rm32 : R32R32mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getAddress32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object CmovoR64Rm64 : R64R64mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register1, false, BitRange._0_63, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x40)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, false, BitRange._0_63, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddress64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object CmovpR16Rm16 : R16R16mInstruction(), MoveInstruction, CmovInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(CMOV)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(register2, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register1, false, BitRange._0_15, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x4A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.CMOV)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.RflagsField.CF)
    tracer.traceWrite(register, false, BitRange._0_15, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getAddress16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, false, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
