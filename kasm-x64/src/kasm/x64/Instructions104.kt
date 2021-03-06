package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

object Vfnmsub231sdXmmXmmXmmm64 : XmmXmmXmmm64Instruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xBF)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_63)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xBF)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression64(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object Vfnmsub132ssXmmXmmXmmm32 : XmmXmmXmmm32Instruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0x9F)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x9F)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object Vfnmsub213ssXmmXmmXmmm32 : XmmXmmXmmm32Instruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xAF)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xAF)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object Vfnmsub231ssXmmXmmXmmm32 : XmmXmmXmmm32Instruction(), VectorInstruction, FmaInstruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, register3)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, register3, register2)
    Encoding.encodeOpcode(buffer, 0xBF)
    ModRmSib.encode(buffer, options, register1, register3)
  }
  private val features = enumSetOf(FMA)
  override fun isSupported(): Boolean  {
    return CpuId.features.containsAll(features)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, register3: XmmRegister)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(register3, 2, BitRange.BITS_0_31)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, register2, addressExpression)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, options.vexL, 1, register1, addressExpression, register2)
    Encoding.encodeOpcode(buffer, 0xBF)
    ModRmSib.encode(buffer, options, register1, addressExpression)
  }
  override fun trace(tracer: InstructionTracer, register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32)  {
    tracer.beginTracing()
    tracer.traceFeature(CpuFeature.FMA)
    tracer.traceRead(register1, 0, BitRange.BITS_0_127)
    tracer.traceRead(register2, 1, BitRange.BITS_0_127)
    tracer.traceRead(addressExpression, 2)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(kasm.x64.MxcsrField.PE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.UE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.OE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.DE, false)
    tracer.traceWrite(kasm.x64.MxcsrField.IE, false)
    tracer.endTracing()
  }
  override fun encode(buffer: ByteBuffer, parameters: InstructionParameters, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(parameters.useSibd()) {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false), options, tracer)
    }
    else {
      encode(buffer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false), options, tracer)
    }
  }
  override fun trace(tracer: InstructionTracer, parameters: InstructionParameters)  {
    if(parameters.useSibd()) {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getAddressExpression32(2, true, false))
    }
    else {
      trace(tracer, parameters.getXmmRegister(0, true, true), parameters.getXmmRegister(1, true, false), parameters.getXmmRegister(2, true, false))
    }
  }
}
object VgatherdpdXmmVm32x64Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x92)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VgatherqpdXmmVm64x64Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x93)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VgatherdpdYmmVm32x64Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x92)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_255, true)
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
object VgatherqpdYmmVm64y64Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 1, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x93)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_255, true)
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
object VgatherdpsXmmVm32x32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x92)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VgatherqpsXmmVm64x32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x93)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VgatherdpsYmmVm32y32Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x92)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_255, true)
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
object VgatherqpsXmmVm64y32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, vectorAddressExpression, register2)
    Encoding.encodeOpcode(buffer, 0x93)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VpgatherddXmmVm32x32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, vectorAddressExpression, register2)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VpgatherqdXmmVm64x32Xmm : XmmVmXmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 0, 1, register1, vectorAddressExpression, register2)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_127)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_511, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_511, true)
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
object VpgatherddYmmVm32y32Ymm : YmmVmYmmInstruction(), VectorInstruction, Avx2Instruction {
  override fun encode(buffer: ByteBuffer, register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions, tracer: InstructionTracer?)  {
    if(tracer != null) trace(tracer, register1, vectorAddressExpression, register2)
    Encoding.encodeLegacyPrefixes(buffer, options.legacyPrefixOrder, options.legacyPrefix1, options.legacyPrefix2, options.legacyPrefix3, options.encodedLegacyPrefix4)
    VexPrefix.RegRmVex.encode(buffer, options, 0, 2, 1, 1, register1, vectorAddressExpression, register2)
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
    tracer.traceRead(register2, 2, BitRange.BITS_0_255)
    tracer.traceWrite(register1, 0, BitRange.BITS_0_255, true)
    tracer.traceWrite(register2, 2, BitRange.BITS_0_255, true)
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
