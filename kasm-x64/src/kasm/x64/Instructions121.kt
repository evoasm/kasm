package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object FucomStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDD, 0xE0, register)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(register, false, BitRange.BITS_0_79)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
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
object FucomSt1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDD, 0xE1)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
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
object FucompStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xDD, 0xE8, register)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(register, false, BitRange.BITS_0_79)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
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
object FucompSt1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDD, 0xE9)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
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
object FucomppSt1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xDA, 0xE9)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.TOP, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
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
object FxamSt0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xE5)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
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
object FxchStiSt0 : X87Instruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, register: X87Register, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Reg.encode(buffer, options, register)
    Encoding.encodeOpcodeO(buffer, 0xD9, 0xC8, register)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: X87Register)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87StatusField.C3, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C2, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C1, false)
    tracer.traceWrite(kasm.x64.X87StatusField.C0, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getX87Register(0, false, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getX87Register(0, false, false))
  }
}
object FxchSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xC9)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
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
object FxrstorM512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx : M4096Instruction(), VectorInstruction, FpuInstruction, FxsrInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression512Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU, FXSR)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression512Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceFeature(CpuFeature.FXSR)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM0, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM1, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM2, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM3, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM4, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM5, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM6, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM7, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM8, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM9, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM10, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM11, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM12, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM13, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM14, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM15, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM1, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM2, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM3, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM4, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM5, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM6, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM7, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST2, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST3, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST4, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST5, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST6, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST7, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ME, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ZE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.PM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ZM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.MM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.FZ, false)
    tracer.traceWrite(kasm.x64.MxcsrField.RC, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DAZ, false)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression512Bytes(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression512Bytes(0, true, false))
  }
}
object Fxrstor64M512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx : M4096Instruction(), VectorInstruction, FpuInstruction, FxsrInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression512Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE)
    ModRmSib.encode(buffer, options, 1, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU, FXSR)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression512Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceFeature(CpuFeature.FXSR)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM0, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM1, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM2, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM3, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM4, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM5, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM6, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM7, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM8, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM9, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM10, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM11, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM12, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM13, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM14, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.XmmRegister.XMM15, true, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM1, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM2, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM3, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM4, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM5, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM6, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MmRegister.MM7, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST2, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST3, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST4, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST5, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST6, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST7, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ME, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ZE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.PM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.ZM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.MM, false)
    tracer.traceWrite(kasm.x64.MxcsrField.FZ, false)
    tracer.traceWrite(kasm.x64.MxcsrField.RC, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DAZ, false)
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
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression512Bytes(0, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression512Bytes(0, true, false))
  }
}
object FxsaveM512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx : M4096Instruction(), VectorInstruction, FpuInstruction, FxsrInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression512Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU, FXSR)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression512Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceFeature(CpuFeature.FXSR)
    tracer.traceRead(kasm.x64.XmmRegister.XMM0, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM1, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM2, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM3, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM4, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM5, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM6, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM7, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM8, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM9, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM10, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM11, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM12, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM13, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM14, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM15, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.MmRegister.MM0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM2, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM3, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM4, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM5, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM6, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM7, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST2, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST3, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST4, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST5, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST6, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST7, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MxcsrField.PE)
    tracer.traceRead(kasm.x64.MxcsrField.UE)
    tracer.traceRead(kasm.x64.MxcsrField.OE)
    tracer.traceRead(kasm.x64.MxcsrField.ME)
    tracer.traceRead(kasm.x64.MxcsrField.ZE)
    tracer.traceRead(kasm.x64.MxcsrField.DE)
    tracer.traceRead(kasm.x64.MxcsrField.IE)
    tracer.traceRead(kasm.x64.MxcsrField.PM)
    tracer.traceRead(kasm.x64.MxcsrField.UM)
    tracer.traceRead(kasm.x64.MxcsrField.OM)
    tracer.traceRead(kasm.x64.MxcsrField.ZM)
    tracer.traceRead(kasm.x64.MxcsrField.DM)
    tracer.traceRead(kasm.x64.MxcsrField.IM)
    tracer.traceRead(kasm.x64.MxcsrField.MM)
    tracer.traceRead(kasm.x64.MxcsrField.FZ)
    tracer.traceRead(kasm.x64.MxcsrField.RC)
    tracer.traceRead(kasm.x64.MxcsrField.DAZ)
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
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression512Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression512Bytes(0, false, true))
  }
}
object Fxsave64M512byteXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxXmmxMmxMmxMmxMmxMmxMmxMmxMmxStxStxStxStxStxStxStxStx : M4096Instruction(), VectorInstruction, FpuInstruction, FxsrInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression512Bytes, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm.encodeMandatory(buffer, options, 1, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE)
    ModRmSib.encode(buffer, options, 0, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(FPU, FXSR)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression512Bytes)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceFeature(CpuFeature.FXSR)
    tracer.traceRead(kasm.x64.XmmRegister.XMM0, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM1, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM2, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM3, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM4, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM5, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM6, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM7, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM8, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM9, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM10, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM11, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM12, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM13, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM14, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.XmmRegister.XMM15, true, BitRange.BITS_0_127)
    tracer.traceRead(kasm.x64.MmRegister.MM0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM2, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM3, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM4, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM5, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM6, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MmRegister.MM7, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST2, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST3, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST4, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST5, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST6, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST7, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.MxcsrField.PE)
    tracer.traceRead(kasm.x64.MxcsrField.UE)
    tracer.traceRead(kasm.x64.MxcsrField.OE)
    tracer.traceRead(kasm.x64.MxcsrField.ME)
    tracer.traceRead(kasm.x64.MxcsrField.ZE)
    tracer.traceRead(kasm.x64.MxcsrField.DE)
    tracer.traceRead(kasm.x64.MxcsrField.IE)
    tracer.traceRead(kasm.x64.MxcsrField.PM)
    tracer.traceRead(kasm.x64.MxcsrField.UM)
    tracer.traceRead(kasm.x64.MxcsrField.OM)
    tracer.traceRead(kasm.x64.MxcsrField.ZM)
    tracer.traceRead(kasm.x64.MxcsrField.DM)
    tracer.traceRead(kasm.x64.MxcsrField.IM)
    tracer.traceRead(kasm.x64.MxcsrField.MM)
    tracer.traceRead(kasm.x64.MxcsrField.FZ)
    tracer.traceRead(kasm.x64.MxcsrField.RC)
    tracer.traceRead(kasm.x64.MxcsrField.DAZ)
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
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression512Bytes(0, false, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression512Bytes(0, false, true))
  }
}
object FxtractSt0St1 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF4)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
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
object Fyl2xSt1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF1)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
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
object Fyl2xp1St1St0 : NullaryInstruction(), FpuInstruction {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0xD9, 0xF9)
  }
  private val features = enumSetOf<CpuFeature>(FPU)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FPU)
    tracer.traceRead(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87Register.ST0, true, BitRange.BITS_0_63)
    tracer.traceRead(kasm.x64.X87StatusField.TOP)
    tracer.traceWrite(kasm.x64.X87Register.ST1, true, BitRange.BITS_0_63, true)
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
