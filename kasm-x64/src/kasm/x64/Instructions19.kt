package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object Cvtpd2dqXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, kasm.x64.LegacyPrefix.Group1.Repne, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE6)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtpd2dqXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xE6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 3, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0xE6)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtpd2dqXmmYmmm256 : XmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register1, register2)
    Encoding.encodeOpcode(buffer, 0xE6)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 3, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0xE6)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false))
    }
  }
}
object Cvtpd2piMmXmmm128 : MmXmmm128Instruction(), VectorInstruction {
  override fun encode(buffer: ByteBuffer, register1: MmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2D)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: MmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2D)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: MmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getMmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getMmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getMmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getMmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Cvtpd2psXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtpd2psXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtpd2psXmmYmmm256 : XmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false))
    }
  }
}
object Cvtpi2pdXmmMmm64 : XmmMmm64Instruction(), VectorInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getMmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getMmRegister(1, true, false))
    }
  }
}
object Cvtpi2psXmm0To63Mmm64 : XmmMmm64Instruction(), VectorInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: MmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: MmRegister)  {
    tracer.beginTracing()
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x2A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getMmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getMmRegister(1, true, false))
    }
  }
}
object Cvtps2dqXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtps2dqXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtps2dqYmmYmmm256 : YmmYmmm256Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5B)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5B)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false))
    }
  }
}
object Cvtps2pdXmmXmmm64 : XmmXmmm64Instruction(), VectorInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtps2pdXmmXmmm64 : XmmXmmm64Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
object Vcvtps2pdYmmXmmm128 : YmmXmmm128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x5A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getXmmRegister(1, true, false))
    }
  }
}
