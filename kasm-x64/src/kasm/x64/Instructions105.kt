package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object VpgatherqdXmmVm64y32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x91)
    ModRmSib.encode(buffer, options, register1, vectorAddressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(vectorAddressExpression, 1)
    tracer.traceRead(register2, 0, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.RflagsField.RF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true))
  }
}
object VpgatherdqXmmVm32x64Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x90)
    ModRmSib.encode(buffer, options, register1, vectorAddressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(vectorAddressExpression, 1)
    tracer.traceRead(register2, 0, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.RflagsField.RF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true))
  }
}
object VpgatherqqXmmVm64x64Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x91)
    ModRmSib.encode(buffer, options, register1, vectorAddressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(vectorAddressExpression, 1)
    tracer.traceRead(register2, 0, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.RflagsField.RF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getXmmRegister(2, true, true))
  }
}
object VpgatherdqYmmVm32x64Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x90)
    ModRmSib.encode(buffer, options, register1, vectorAddressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_255)
    tracer.traceRead(vectorAddressExpression, 1)
    tracer.traceRead(register2, 0, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.RflagsField.RF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getYmmRegister(2, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getYmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getYmmRegister(2, true, true))
  }
}
object VpgatherqqYmmVm64y64Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x91)
    ModRmSib.encode(buffer, options, register1, vectorAddressExpression)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register1, 0, BitRange.BITS_0_255)
    tracer.traceRead(vectorAddressExpression, 1)
    tracer.traceRead(register2, 0, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(kasm.x64.RflagsField.RF, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getYmmRegister(2, true, true), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getYmmRegister(0, true, true), parameters.getVectorAddress(1, true, false), parameters.getYmmRegister(2, true, true))
  }
}
object Vinsertf128YmmYmmXmmm128Imm8 : YmmYmmXmmm128Imm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x18)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(register3, 2, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x18)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(addressExpression, 2)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), parameters.getByteImmediate(3))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3))
    }
  }
}
object Vinserti128YmmYmmXmmm128Imm8 : YmmYmmXmmm128Imm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x38)
    ModRmSib.encode(buffer, options, register1, register3)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(register3, 2, BitRange.BITS_0_127)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 3, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x38)
    ModRmSib.encode(buffer, options, register1, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceRead(addressExpression, 2)
    tracer.traceRead(immediate, 3, BitSize.BITS_8)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), parameters.getByteImmediate(3))
    }
    else {
      trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), parameters.getByteImmediate(3))
    }
  }
}
object VmaskmovpsXmmXmmM128 : XmmXmmM128Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x2C)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
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
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false))
  }
}
object VmaskmovpsYmmYmmM256 : YmmYmmM256Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x2C)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
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
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false))
  }
}
object VmaskmovpdXmmXmmM128 : XmmXmmM128Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x2D)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
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
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression128(2, true, false))
  }
}
object VmaskmovpdYmmYmmM256 : YmmYmmM256Instruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x2D)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
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
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddressExpression256(2, true, false))
  }
}
object VmaskmovpsM128XmmXmm : M128XmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register2, addressExpression, register1)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register2, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 1, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
  }
}
object VmaskmovpsM256YmmYmm : M256YmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register2, addressExpression, register1)
    Encoding.encodeOpcode(buffer, 0x2E)
    ModRmSib.encode(buffer, options, register2, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 1, BitRange.BITS_0_255)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression256(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression256(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false))
  }
}
object VmaskmovpdM128XmmXmm : M128XmmXmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register2, addressExpression, register1)
    Encoding.encodeOpcode(buffer, 0x2F)
    ModRmSib.encode(buffer, options, register2, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 1, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression128(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
  }
}
object VmaskmovpdM256YmmYmm : M256YmmYmmInstruction(), VectorInstruction, MoveInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register2, addressExpression, register1)
    Encoding.encodeOpcode(buffer, 0x2F)
    ModRmSib.encode(buffer, options, register2, addressExpression)
  }
  private val features = enumSetOf(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register1, 1, BitRange.BITS_0_255)
    tracer.traceRead(register2, 1, BitRange.BITS_0_255)
    tracer.traceWrite(addressExpression, 0)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getAddressExpression256(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    trace(tracer, parameters.getAddressExpression256(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false))
  }
}
