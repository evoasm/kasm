package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object MovlpsXmm0To63M64 : XmmM64Instruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x12)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression64(1, true, false))
  }
}
object VmovlpsXmmXmm64To127M64 : XmmXmmM64Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x12)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_64_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false))
  }
}
object MovlpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, 1, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression64(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression64(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovlpsM64Xmm0To63 : M64XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression64, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register, 1, BitRange.BITS_0_63)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression64(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression64(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object MovmskpdR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovmskpdR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovmskpdR32Ymm : R32YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getYmmRegister(1, true, false))
  }
}
object MovmskpsR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovmskpsR32Xmm : R32XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovmskpsR32Ymm : R32YmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: GpRegister32, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 1, 0, register1, register2)
    Encoding.encodeOpcode(buffer, 0x50)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: GpRegister32, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_63, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getGpRegister32(0, false, true), parameters.getYmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getGpRegister32(0, false, true), parameters.getYmmRegister(1, true, false))
  }
}
object MovntdqaXmmM128 : XmmM128Instruction(), VectorInstruction, MoveInstruction, Sse4_1Instruction {
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x38, 0x2A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(SSE4_1)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE4_1)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
  }
}
object VmovntdqaXmmM128 : XmmM128Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getAddressExpression128(1, true, false))
  }
}
object VmovntdqaYmmM256 : YmmM256Instruction(), VectorInstruction, MoveInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 2, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x2A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(addressExpression, 1)
    tracer.traceWrite(register, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getAddressExpression256(1, true, false))
  }
}
object MovntdqM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, Sse2Instruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, kasm.x64.LegacyPrefix.Group3.Pref66, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0xE7)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(SSE2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE2)
    tracer.traceRead(register, 1, BitRange.BITS_0_127)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
object VmovntdqM128Xmm : M128XmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, options.rexW, 1, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0xE7)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register, 1, BitRange.BITS_0_127)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false))
  }
}
