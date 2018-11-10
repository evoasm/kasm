package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object UnpcklpsXmmXmmm128 : XmmXmmmInstruction(), VectorInstruction, SseInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register1, register2)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(SSE)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    RexPrefix.RegRm.encode(buffer, options, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x0F, 0x14)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.SSE)
    tracer.traceRead(register, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_127, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object VunpcklpsXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 0, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object VunpcklpsYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 1, 1, 0, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x14)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object VbroadcastssXmmM32 : XmmM32Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x18)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddress32(1, true, false), options, tracer)
  }
}
object VbroadcastssYmmM32 : YmmM32Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x18)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddress32(1, true, false), options, tracer)
  }
}
object VbroadcastsdYmmM64 : YmmM64Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x19)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddress64(1, true, false), options, tracer)
  }
}
object Vbroadcastf128YmmM128 : YmmM128Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x1A)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_255, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
  }
}
object Vcvtph2psXmmXmmm64 : XmmXmmmInstruction(), VectorInstruction, F16cInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 0, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(F16C)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register2, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object Vcvtph2psYmmXmmm128 : YmmXmmmInstruction(), VectorInstruction, F16cInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 1, 1, register1, register2)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register1, register2)
  }
  private val features = enumSetOf<CpuFeature>(F16C)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 2, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x13)
    ModRmSib.encode(buffer, options, register, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register: YmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getAddress128(1, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), options, tracer)
    }
  }
}
object Vcvtps2phXmmm64XmmImm8 : XmmmXmmImm8Instruction(), VectorInstruction, F16cInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x1D)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(F16C)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: XmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 0, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x1D)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: XmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register, false, BitRange._0_127)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress128(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getXmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
}
object Vcvtps2phXmmm128YmmImm8 : XmmmYmmImm8Instruction(), VectorInstruction, F16cInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x1D)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(F16C)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x1D)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.F16C)
    tracer.traceRead(register, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress128(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
}
object Vextractf128Xmmm128YmmImm8 : XmmmYmmImm8Instruction(), VectorInstruction, AvxInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x19)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(AVX)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x19)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX)
    tracer.traceRead(register, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress128(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
}
object Vextracti128Xmmm128YmmImm8 : XmmmYmmImm8Instruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register2, register1)
    Encoding.encodeOpcode(buffer, 0x39)
    ModRmSib.encode(buffer, options, register2, register1)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  private val features = enumSetOf<CpuFeature>(AVX2)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, addressExpression, register, immediate)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRm.encode(buffer, options, 0, 3, 1, 1, register, addressExpression)
    Encoding.encodeOpcode(buffer, 0x39)
    ModRmSib.encode(buffer, options, register, addressExpression)
    Encoding.encodeImmediate8(buffer, immediate)
  }
  override fun trace(tracer: InstructionTracer, addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.AVX2)
    tracer.traceRead(register, false, BitRange._0_255)
    tracer.traceRead(immediate.toLong(), false, BitSize._8)
    tracer.traceWrite(addressExpression)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getAddress128(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, false, true), parameters.getYmmRegister(1, true, false), parameters.getByteImmediate(2), options, tracer)
    }
  }
}
object Vfmadd132pdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213pdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd231pdXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd132pdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213pdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd231pdYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd132psXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213psXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd231psXmmXmmXmmm128 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_127)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd132psYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x98)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213psYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd231psYmmYmmYmmm256 : YmmYmmYmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, register3: YmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(register3, false, BitRange._0_255)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, options.rexW, 2, 1, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xB8)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_255)
    tracer.traceRead(register2, false, BitRange._0_255)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_255, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getAddress256(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getYmmRegister(0, true, true), parameters.getYmmRegister(1, true, false), parameters.getYmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd132sdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x99)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x99)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213sdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA9)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA9)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd231sdXmmXmmXmmm64 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xB9)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_63)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xB9)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd132ssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x99)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_31)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x99)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
object Vfmadd213ssXmmXmmXmmm32 : XmmXmmXmmmInstruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xA9)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf<CpuFeature>(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(register3, false, BitRange._0_31)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xA9)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, false, BitRange._0_127)
    tracer.traceRead(register2, false, BitRange._0_127)
    tracer.traceRead(addressExpression)
    tracer.traceWrite(register1, false, BitRange._0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrFlag.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrFlag.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddress128(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
}
