package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object TzcntR64Rm64 : R64R64m64Instruction(), Bmi1Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Rep, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xBC)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(BMI1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.BMI1)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
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
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
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
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, false, true), parameters.getGpRegister64(1, true, false))
    }
  }
}
object UcomisdXmmXmmm64 : XmmXmmm64Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false))
    }
  }
}
object VucomisdXmmXmmm64 : XmmXmmm64Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false))
    }
  }
}
object UcomissXmmXmmm32 : XmmXmmm32Instruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression32(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false))
    }
  }
}
object VucomissXmmXmmm32 : XmmXmmm32Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(kasm.x64.RflagsField.OF, true)
    tracer.traceWrite(kasm.x64.RflagsField.SF, true)
    tracer.traceWrite(kasm.x64.RflagsField.AF, true)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression32(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getAddressExpression32(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, false), parameters.getXmmRegister(1, true, false))
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
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object UnpckhpdXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object VunpckhpdXmmXmmXmmm128 : XmmXmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object VunpckhpdYmmYmmYmmm256 : YmmYmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(register3, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false))
    }
  }
}
object UnpckhpsXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x15)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
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
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object VunpckhpsXmmXmmXmmm128 : XmmXmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object VunpckhpsYmmYmmYmmm256 : YmmYmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x15)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(register3, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false))
    }
  }
}
object UnpcklpdXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object VunpcklpdXmmXmmXmmm128 : XmmXmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object VunpcklpdYmmYmmYmmm256 : YmmYmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(register3, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
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
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false))
    }
  }
}
