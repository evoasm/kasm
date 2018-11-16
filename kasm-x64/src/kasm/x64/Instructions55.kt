package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object XaddRm16R16 : R16mR16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
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
    tracer.traceWrite(register1, false, BitRange._0_15, true)
    tracer.traceWrite(register2, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_15, true)
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
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, true))
    }
  }
}
object XaddRm32R32 : R32mR32Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
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
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, true))
    }
  }
}
object XaddRm64R64 : R64mR64Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xC1)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
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
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, true))
    }
  }
}
object XbeginRel16Rip : Imm16Instruction(), JumpInstruction, RtmInstruction {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0xC7, 0xF8)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(RTM)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RTM)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getShortImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getShortImmediate(0))
  }
}
object XbeginRel32Rip : Imm32Instruction(), JumpInstruction, RtmInstruction {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xC7, 0xF8)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(RTM)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RTM)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceRead(kasm.x64.IpRegister.RIP, true, BitRange._0_63)
    tracer.traceWrite(kasm.x64.IpRegister.RIP, true, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getIntImmediate(0), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getIntImmediate(0))
  }
}
object XchgAxR16 : R16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0x90, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister16.AX, true, BitRange._0_15)
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceWrite(kasm.x64.GpRegister16.AX, true, BitRange._0_15, true)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister16(0, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister16(0, true, true))
  }
}
object XchgEaxR32 : R32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0x90, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister32.EAX, true, BitRange._0_31)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceWrite(kasm.x64.GpRegister32.EAX, true, BitRange._0_63, true)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, true, true))
  }
}
object XchgRaxR64 : R64Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcodeO(buffer, 0x90, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister64.RAX, true, BitRange._0_63)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(kasm.x64.GpRegister64.RAX, true, BitRange._0_63, true)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister64(0, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister64(0, true, true))
  }
}
object XchgRm8R8 : R8mR8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x86)
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
    tracer.traceWrite(register1, false, BitRange._0_7, true)
    tracer.traceWrite(register2, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x86)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress8(0, true, true), parameters.getGpRegister8(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress8(0, true, true), parameters.getGpRegister8(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, true))
    }
  }
}
object XchgRm16R16 : R16mR16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x87)
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
    tracer.traceWrite(register1, false, BitRange._0_15, true)
    tracer.traceWrite(register2, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x87)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_15, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, true))
    }
  }
}
object XchgRm32R32 : R32mR32Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x87)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x87)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, true))
    }
  }
}
object XchgRm64R64 : R64mR64Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x87)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(register2, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x87)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, true))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, true))
    }
  }
}
object Xend : NullaryInstruction(), RtmInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x0F, 0x01, 0xD5)
  }
  private val features = enumSetOf<CpuFeature>(RTM)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.RTM)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object XlatbAlRbxAl : NullaryInstruction() {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD7)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceRead(AddressExpression64(kasm.x64.GpRegister64.RBX, kasm.x64.GpRegister64.RAX))
    tracer.traceWrite(kasm.x64.GpRegister8.AL, true, BitRange._0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object XorAlImm8 : Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x34)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister8.AL, true, BitRange._0_7)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(kasm.x64.GpRegister8.AL, true, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
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
object XorAxImm16 : Imm16Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    Encoding.encodeOpcode(buffer, 0x35)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister16.AX, true, BitRange._0_15)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(kasm.x64.GpRegister16.AX, true, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
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
object XorEaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x35)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.GpRegister32.EAX, true, BitRange._0_31)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(kasm.x64.GpRegister32.EAX, true, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
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
object XorRaxImm32 : Imm32Instruction() {
  override fun encode(buffer: ByteBuffer, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encodeMandatory(buffer, options, 1)
    Encoding.encodeOpcode(buffer, 0x35)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
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
object XorRm8Imm8 : R8mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x80)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress8(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object XorRm16Imm16 : R16mImm16Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate16(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Short)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._16)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress16(0, true, true), parameters.getShortImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getShortImmediate(1))
    }
  }
}
object XorRm32Imm32 : R32mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress32(0, true, true), parameters.getIntImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getIntImmediate(1))
    }
  }
}
object XorRm64Imm32 : R64mImm32Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x81)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate32(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Int)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._32)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress64(0, true, true), parameters.getIntImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getIntImmediate(1))
    }
  }
}
object XorRm16Imm8 : R16mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress16(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object XorRm32Imm8 : R32mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress32(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object XorRm64Imm8 : R64mImm8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, register)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, register)
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
    tracer.traceWrite(register, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x83)
    ModRmSib.encode(buffer, options, 6, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress64(0, true, true), parameters.getByteImmediate(1))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getByteImmediate(1))
    }
  }
}
object XorRm8R8 : R8mR8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x30)
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
    tracer.traceWrite(register1, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x30)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress8(0, true, true), parameters.getGpRegister8(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, false))
    }
  }
}
object XorRm16R16 : R16mR16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x31)
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
    tracer.traceWrite(register1, false, BitRange._0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3._66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x31)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_15)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress16(0, true, true), parameters.getGpRegister16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object XorRm32R32 : R32mR32Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x31)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x31)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_31)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress32(0, true, true), parameters.getGpRegister32(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false))
    }
  }
}
object XorRm64R64 : R64mR64Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x31)
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
    tracer.traceWrite(register1, false, BitRange._0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x31)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression)
    tracer.traceRead(register, false, BitRange._0_63)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddress64(0, true, true), parameters.getGpRegister64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object XorR8Rm8 : R8R8mInstruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister8, register2: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x32)
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
    tracer.traceWrite(register1, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm8.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x32)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(register, false, BitRange._0_7)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_7, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.CF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getAddress8(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, true, true), parameters.getGpRegister8(1, true, false))
    }
  }
}
