package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object Fldl2eSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xEA)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
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
object FldpiSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xEB)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
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
object Fldlg2St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xEC)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
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
object Fldln2St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xED)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
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
object FldzSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xEE)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
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
object FldcwM2byte : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 5, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceWrite(kasm.x64.X87ControlField.IM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.DM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.ZM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.OM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.UM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.PM, false)
    tracer.traceWrite(kasm.x64.X87ControlField.PC, false)
    tracer.traceWrite(kasm.x64.X87ControlField.RC, false)
    tracer.traceWrite(kasm.x64.X87ControlField.X, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression16(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression16(0, true, false))
  }
}
object FldenvM28byte : M224Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression28Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression28Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
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
    encode(buffer, parameters.getAddressExpression28Bytes(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression28Bytes(0, true, false))
  }
}
object FmulM32fpSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD8)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FmulM64fpSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDC)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FmulSt0Sti : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xD8, 0xC8, register)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceRead(register, 0, BitRange.BITS_0_79)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FmulStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDC, 0xC8, register)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(register, 0, BitRange.BITS_0_79)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceWrite(register, 0, BitRange.BITS_0_79, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getX87Register(0, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, true, true))
  }
}
object FmulpStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDE, 0xC8, register)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(register, 0, BitRange.BITS_0_79)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(register, 0, BitRange.BITS_0_79, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getX87Register(0, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, true, true))
  }
}
object FmulpSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDE, 0xC9)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST1, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST1, BitRange.BITS_0_63, true)
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
object FimulM32intSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDA)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FimulM16intSt0 : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDE)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression16(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression16(0, true, false))
  }
}
