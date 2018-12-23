package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object FstStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDD, 0xD0, register)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceWrite(register, 0, BitRange.BITS_0_79, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getX87Register(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, false, true))
  }
}
object FstpM32fpSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression, 0)
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
object FstpM64fpSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 3, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression, 0)
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
object FstpM80fpSt0 : M80Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression80, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDB)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression80)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceImplicitRead(kasm.x64.X87Register.ST0, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(addressExpression, 0)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression80(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression80(0, false, true))
  }
}
object FstpStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDD, 0xD8, register)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    encode(buffer, parameters.getX87Register(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, false, true))
  }
}
object FstcwM2byte : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x9B, 0xD9)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87ControlField.IM)
    tracer.traceRead(kasm.x64.X87ControlField.DM)
    tracer.traceRead(kasm.x64.X87ControlField.ZM)
    tracer.traceRead(kasm.x64.X87ControlField.OM)
    tracer.traceRead(kasm.x64.X87ControlField.UM)
    tracer.traceRead(kasm.x64.X87ControlField.PM)
    tracer.traceRead(kasm.x64.X87ControlField.PC)
    tracer.traceRead(kasm.x64.X87ControlField.RC)
    tracer.traceRead(kasm.x64.X87ControlField.X)
    tracer.traceWrite(addressExpression, 0)
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
object FnstcwM2byte : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87ControlField.IM)
    tracer.traceRead(kasm.x64.X87ControlField.DM)
    tracer.traceRead(kasm.x64.X87ControlField.ZM)
    tracer.traceRead(kasm.x64.X87ControlField.OM)
    tracer.traceRead(kasm.x64.X87ControlField.UM)
    tracer.traceRead(kasm.x64.X87ControlField.PM)
    tracer.traceRead(kasm.x64.X87ControlField.PC)
    tracer.traceRead(kasm.x64.X87ControlField.RC)
    tracer.traceRead(kasm.x64.X87ControlField.X)
    tracer.traceWrite(addressExpression, 0)
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
object FstenvM28byte : M224Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression28Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x9B, 0xD9)
    ModRmSib.encode(buffer, options, 6, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression28Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression28Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression28Bytes(0, false, true))
  }
}
object FnstenvM28byte : M224Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression28Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD9)
    ModRmSib.encode(buffer, options, 6, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression28Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression28Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression28Bytes(0, false, true))
  }
}
object FstswM2byte : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x9B, 0xDD)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceWrite(addressExpression, 0)
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
object FstswAx : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x9B, 0xDF, 0xE0)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceImplicitWrite(kasm.x64.GpRegister16.AX, BitRange.BITS_0_15, true)
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
object FnstswM2byte : M16Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDD)
    ModRmSib.encode(buffer, options, 7, addressExpression)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceWrite(addressExpression, 0)
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
object FnstswAx : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDF, 0xE0)
  }
  private val features = enumSetOf(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
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
    tracer.traceImplicitWrite(kasm.x64.GpRegister16.AX, BitRange.BITS_0_15, true)
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
object FsubM32fpSt0 : M32Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xD8)
    ModRmSib.encode(buffer, options, 4, addressExpression)
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
object FsubM64fpSt0 : M64Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0xDC)
    ModRmSib.encode(buffer, options, 4, addressExpression)
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
