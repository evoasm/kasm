package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object Fnop : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xD0)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FpatanSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF3)
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
object FpremSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF8)
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
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object Fprem1St0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF5)
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
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FptanSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF2)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
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
object FrndintSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xFC)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FrstorM108byteStxStxStxStxStxStxStxStx : M864Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression108Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 4, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression108Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(addressExpression, 0)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST1, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST2, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST3, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST4, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST5, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST6, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST7, BitRange.BITS_0_63, true)
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
    encode(buffer, parameters.getAddressExpression108Bytes(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression108Bytes(0, true, false))
  }
}
object FsaveM108byteStxStxStxStxStxStxStxStx : M864Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression108Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x9B, 0xDD)
    ModRmSib.encode(buffer, options, 6, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression108Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST1, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST2, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST3, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST4, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST5, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST6, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST7, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87ControlField.IM)
    tracer.traceRead(kasm.x64.X87ControlField.DM)
    tracer.traceRead(kasm.x64.X87ControlField.ZM)
    tracer.traceRead(kasm.x64.X87ControlField.OM)
    tracer.traceRead(kasm.x64.X87ControlField.UM)
    tracer.traceRead(kasm.x64.X87ControlField.PM)
    tracer.traceRead(kasm.x64.X87ControlField.PC)
    tracer.traceRead(kasm.x64.X87ControlField.RC)
    tracer.traceRead(kasm.x64.X87ControlField.X)
    tracer.traceRead(kasm.x64.X87StatusField.B)
    tracer.traceRead(kasm.x64.X87StatusField.C3)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceRead(kasm.x64.X87StatusField.C2)
    tracer.traceRead(kasm.x64.X87StatusField.C1)
    tracer.traceRead(kasm.x64.X87StatusField.C0)
    tracer.traceRead(kasm.x64.X87StatusField.ES)
    tracer.traceRead(kasm.x64.X87StatusField.SF)
    tracer.traceRead(kasm.x64.X87StatusField.PE)
    tracer.traceRead(kasm.x64.X87StatusField.UE)
    tracer.traceRead(kasm.x64.X87StatusField.OE)
    tracer.traceRead(kasm.x64.X87StatusField.ZE)
    tracer.traceRead(kasm.x64.X87StatusField.DE)
    tracer.traceRead(kasm.x64.X87StatusField.IE)
    tracer.traceRead(kasm.x64.X87TagField.TAG0)
    tracer.traceRead(kasm.x64.X87TagField.TAG1)
    tracer.traceRead(kasm.x64.X87TagField.TAG2)
    tracer.traceRead(kasm.x64.X87TagField.TAG3)
    tracer.traceRead(kasm.x64.X87TagField.TAG4)
    tracer.traceRead(kasm.x64.X87TagField.TAG5)
    tracer.traceRead(kasm.x64.X87TagField.TAG6)
    tracer.traceRead(kasm.x64.X87TagField.TAG7)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression108Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression108Bytes(0, false, true))
  }
}
object FnsaveM108byteStxStxStxStxStxStxStxStx : M864Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression108Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 6, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression108Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST1, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST2, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST3, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST4, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST5, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST6, BitRange.BITS_0_63)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST7, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87ControlField.IM)
    tracer.traceRead(kasm.x64.X87ControlField.DM)
    tracer.traceRead(kasm.x64.X87ControlField.ZM)
    tracer.traceRead(kasm.x64.X87ControlField.OM)
    tracer.traceRead(kasm.x64.X87ControlField.UM)
    tracer.traceRead(kasm.x64.X87ControlField.PM)
    tracer.traceRead(kasm.x64.X87ControlField.PC)
    tracer.traceRead(kasm.x64.X87ControlField.RC)
    tracer.traceRead(kasm.x64.X87ControlField.X)
    tracer.traceRead(kasm.x64.X87StatusField.B)
    tracer.traceRead(kasm.x64.X87StatusField.C3)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceRead(kasm.x64.X87StatusField.C2)
    tracer.traceRead(kasm.x64.X87StatusField.C1)
    tracer.traceRead(kasm.x64.X87StatusField.C0)
    tracer.traceRead(kasm.x64.X87StatusField.ES)
    tracer.traceRead(kasm.x64.X87StatusField.SF)
    tracer.traceRead(kasm.x64.X87StatusField.PE)
    tracer.traceRead(kasm.x64.X87StatusField.UE)
    tracer.traceRead(kasm.x64.X87StatusField.OE)
    tracer.traceRead(kasm.x64.X87StatusField.ZE)
    tracer.traceRead(kasm.x64.X87StatusField.DE)
    tracer.traceRead(kasm.x64.X87StatusField.IE)
    tracer.traceRead(kasm.x64.X87TagField.TAG0)
    tracer.traceRead(kasm.x64.X87TagField.TAG1)
    tracer.traceRead(kasm.x64.X87TagField.TAG2)
    tracer.traceRead(kasm.x64.X87TagField.TAG3)
    tracer.traceRead(kasm.x64.X87TagField.TAG4)
    tracer.traceRead(kasm.x64.X87TagField.TAG5)
    tracer.traceRead(kasm.x64.X87TagField.TAG6)
    tracer.traceRead(kasm.x64.X87TagField.TAG7)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression108Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression108Bytes(0, false, true))
  }
}
object FscaleSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xFD)
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
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FsinSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xFE)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FsincosSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xFB)
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
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST1, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FsqrtSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xFA)
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
    tracer.traceImplicitWrite(kasm.x64.X87Register.ST0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
object FstM32fpSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression, 0)
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
object FstM64fpSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 2, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
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
