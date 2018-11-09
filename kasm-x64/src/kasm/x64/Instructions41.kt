package kasm.x64

import java.nio.ByteBuffer

object RolRm16Cl : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm321 : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 0, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm641 : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 0, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm32Cl : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm64Cl : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm32Imm8 : R32mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RolRm64Imm8 : R64mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 0, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm81 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD0)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD0)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm8Cl : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD2)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm8Imm8 : R8m8Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC0)
    ModRmSib.encode(buffer, options, 1, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC0)
    ModRmSib.encode(buffer, options, 1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm161 : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm16Cl : R16mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm321 : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm641 : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(1L, true, null)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm32Cl : R32mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm64Cl : R64mInstruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD3)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.GpRegister64.RCX, true, BitRange._0_7)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm32Imm8 : R32mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register.topLevelRegister, false, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RorRm64Imm8 : R64mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, register)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0xC1)
    ModRmSib.encode(buffer, options, 1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceRead(kasm.x64.Rflag.CF)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.Rflag.OF, false)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
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
object RcppsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x53)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x53)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrcppsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x53)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_127)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x53)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrcppsYmmYmmm256 : YmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x53)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_255)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x53)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddress256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
    }
  }
}
object RcpssXmm0To31Xmmm32 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x53)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2.topLevelRegister, false, BitRange._0_31)
    tracer.traceWrite(register1.topLevelRegister, false, BitRange._0_31, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x53)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_31, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VrcpssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 2, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x53)
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
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, options.vexL, 2, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x53)
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
object RdrandR16 : R16Instruction(), RdrandInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 6, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDRAND)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister16(0, false, true), options, tracer)
  }
}
object RdrandR32 : R32Instruction(), RdrandInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 6, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDRAND)
    tracer.traceWrite(register.topLevelRegister, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), options, tracer)
  }
}
object RdrandR64 : R64Instruction(), RdrandInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 6, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDRAND)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.Rflag.OF, true)
    tracer.traceWrite(kasm.x64.Rflag.SF, true)
    tracer.traceWrite(kasm.x64.Rflag.ZF, true)
    tracer.traceWrite(kasm.x64.Rflag.PF, true)
    tracer.traceWrite(kasm.x64.Rflag.AF, true)
    tracer.traceWrite(kasm.x64.Rflag.CF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister64(0, false, true), options, tracer)
  }
}
object RdseedR16 : R16Instruction(), RdseedInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 7, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDSEED)
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
    encode(buffer, parameters.getGpRegister16(0, false, true), options, tracer)
  }
}
object RdseedR32 : R32Instruction(), RdseedInstruction {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC7)
    ModRmSib.encode(buffer, options, 7, register)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RDSEED)
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
    encode(buffer, parameters.getGpRegister32(0, false, true), options, tracer)
  }
}
