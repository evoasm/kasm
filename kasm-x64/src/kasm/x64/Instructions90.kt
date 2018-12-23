package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object SetoRm8 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x90)
    ModRmSib.encode(buffer, options, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x90)
    ModRmSib.encode(buffer, options, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.OF)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression8(0, false, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, false, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression8(0, false, true))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, false, true))
    }
  }
}
object SetpRm8 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x9A)
    ModRmSib.encode(buffer, options, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x9A)
    ModRmSib.encode(buffer, options, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.PF)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression8(0, false, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, false, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression8(0, false, true))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, false, true))
    }
  }
}
object SetsRm8 : R8m8Instruction() {
  override fun encode(buffer: ByteBuffer, register: GpRegister8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, register)
    Encoding.encodeOpcode(buffer, 0x0F, 0x98)
    ModRmSib.encode(buffer, options, register)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: GpRegister8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(register, 0, BitRange.BITS_0_7, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression8, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Rm8.encode(buffer, options, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x98)
    ModRmSib.encode(buffer, options, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression8)  {
    tracer.beginTracing()
    tracer.traceRead(kasm.x64.RflagsField.SF)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddressExpression8(0, false, true), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister8(0, false, true), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression8(0, false, true))
    }
    else {
      trace(tracer, parameters.getGpRegister8(0, false, true))
    }
  }
}
object Sfence : NullaryInstruction() {
  override fun encode(buffer: ByteBuffer, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.Np.encode(buffer, options)
    Encoding.encodeOpcode(buffer, 0x0F, 0xAE, 0xF8)
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
object Sha1rnds4XmmXmmm128Imm8 : XmmXmmm128Imm8Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0xCC)
    ModRmSib.encode(buffer, options, register1, register2)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x3A, 0xCC)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getAddressExpression128(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object Sha1nexteXmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xC8)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xC8)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
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
object Sha1msg1XmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xC9)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xC9)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
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
object Sha1msg2XmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCA)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCA)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
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
object Sha256rnds2XmmXmmm128Xmm0 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCB)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceImplicitRead(kasm.x64.XmmRegister.XMM0, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCB)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register, 0, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 1)
    tracer.traceImplicitRead(kasm.x64.XmmRegister.XMM0, BitRange.BITS_0_127)
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
object Sha256msg1XmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCC)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCC)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
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
object Sha256msg2XmmXmmm128 : XmmXmmm128Instruction(), VectorInstruction, ShaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCD)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SHA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0xCD)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SHA)
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
object ShldRm16R16Imm8 : R16m16R16Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register1, 0, BitRange.BITS_0_15)
    tracer.traceRead(register2, 1, BitRange.BITS_0_15)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_15, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(register, 1, BitRange.BITS_0_15)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(addressExpression, 0)
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
      encode(buffer, parameters.getAddressExpression16(0, true, true), parameters.getGpRegister16(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression16(0, true, true), parameters.getGpRegister16(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object ShldRm16R16Cl : R16m16R16Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister16, register2: GpRegister16, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA5)
    ModRmSib.encode(buffer, options, register2, register1)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister16, register2: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(register1, 0, BitRange.BITS_0_15)
    tracer.traceRead(register2, 1, BitRange.BITS_0_15)
    tracer.traceImplicitRead(kasm.x64.GpRegister8.CL, BitRange.BITS_0_7)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_15, true)
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
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA5)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression16, register: GpRegister16)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(register, 1, BitRange.BITS_0_15)
    tracer.traceImplicitRead(kasm.x64.GpRegister8.CL, BitRange.BITS_0_7)
    tracer.traceWrite(addressExpression, 0)
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
      encode(buffer, parameters.getAddressExpression16(0, true, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression16(0, true, true), parameters.getGpRegister16(1, true, false))
    }
    else {
      trace(tracer, parameters.getGpRegister16(0, true, true), parameters.getGpRegister16(1, true, false))
    }
  }
}
object ShldRm32R32Imm8 : R32m32R32Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register1, 0, BitRange.BITS_0_31)
    tracer.traceRead(register2, 1, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(register, 1, BitRange.BITS_0_31)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(addressExpression, 0)
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
      encode(buffer, parameters.getAddressExpression32(0, true, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression32(0, true, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getGpRegister32(0, true, true), parameters.getGpRegister32(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
object ShldRm64R64Imm8 : R64m64R64Imm8Instruction() {
  override fun encode(buffer: ByteBuffer, register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>()
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister64, register2: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(register1, 0, BitRange.BITS_0_63)
    tracer.traceRead(register2, 1, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.traceWrite(kasm.x64.RflagsField.OF, false)
    tracer.traceWrite(kasm.x64.RflagsField.SF, false)
    tracer.traceWrite(kasm.x64.RflagsField.ZF, false)
    tracer.traceWrite(kasm.x64.RflagsField.PF, false)
    tracer.traceWrite(kasm.x64.RflagsField.CF, false)
    tracer.traceWrite(kasm.x64.RflagsField.AF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encodeMandatory(buffer, options, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xA4)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceRead(addressExpression, 0)
    tracer.traceRead(register, 1, BitRange.BITS_0_63)
    tracer.traceRead(immediate, 2, BitSize.BITS_8)
    tracer.traceWrite(addressExpression, 0)
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
      encode(buffer, parameters.getAddressExpression64(0, true, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getAddressExpression64(0, true, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2))
    }
    else {
      trace(tracer, parameters.getGpRegister64(0, true, true), parameters.getGpRegister64(1, true, false), parameters.getByteImmediate(2))
    }
  }
}
