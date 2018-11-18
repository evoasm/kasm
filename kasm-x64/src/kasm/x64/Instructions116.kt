package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object Fninit : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDB, 0xE3)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceWrite(kasm.x64.X87ControlField.IM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.DM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.ZM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.OM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.UM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.PM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.PC, false)
    tracer.traceWrite(kasm.x64.X87ControlField.RC, false)
    tracer.traceWrite(kasm.x64.X87ControlField.X, false)
    tracer.traceWrite(kasm.x64.X87StatusField.B, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.traceWrite(kasm.x64.X87StatusField.ES, false)
    tracer.traceWrite(kasm.x64.X87StatusField.SF, false)
    tracer.traceWrite(kasm.x64.X87StatusField.PE, false)
    tracer.traceWrite(kasm.x64.X87StatusField.UE, false)
    tracer.traceWrite(kasm.x64.X87StatusField.OE, false)
    tracer.traceWrite(kasm.x64.X87StatusField.ZE, false)
    tracer.traceWrite(kasm.x64.X87StatusField.DE, false)
    tracer.traceWrite(kasm.x64.X87StatusField.IE, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG0, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG1, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG2, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG3, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG4, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG5, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG6, false)
    tracer.traceWrite(kasm.x64.X87TagField.TAG7, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object FistM16intSt0 : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDF)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression16(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression16(0, false, true))
  }
}
object FistM32intSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDB)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression32(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression32(0, false, true))
  }
}
object FistpM16intSt0 : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDF)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression16(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression16(0, false, true))
  }
}
object FistpM32intSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDB)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression32(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression32(0, false, true))
  }
}
object FistpM64intSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDF)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression64(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression64(0, false, true))
  }
}
object FisttpM16intSt0 : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDF)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression16(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression16(0, false, true))
  }
}
object FisttpM32intSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDB)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression32(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression32(0, false, true))
  }
}
object FisttpM64intSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression64(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression64(0, false, true))
  }
}
object FldM32fpSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression32(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression32(0, true, false))
  }
}
object FldM64fpSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression64(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression64(0, true, false))
  }
}
object FldM80fpSt0 : M80Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression80, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDB)
    ModRmSib.encode(buffer, options, 5, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression80)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression80(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression80(0, true, false))
  }
}
object FldStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xD9, 0xC0, register)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(register, false, BitRange.BITS_0_79)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getX87Register(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, true, false))
  }
}
object Fld1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xE8)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
object Fldl2tSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xE9)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer)
  }
}
