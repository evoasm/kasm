package kasm.x64

import java.nio.ByteBuffer
import kasm.ext.*
import kasm.x64.CpuFeature.*

abstract class AbstractAssembler: InstructionTracer {
  abstract val buffer: ByteBuffer
  fun adcAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun adcAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun adcEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun adcRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun adc(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adc(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adc(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adc(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adcx(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcxR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adcx(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcxR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun addAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun addAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun addEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun addRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun add(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun add(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun add(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun add(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun add(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun addpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vaddpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun addps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vaddps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun addsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun addss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun addsubpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsubpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddsubpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vaddsubpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun addsubps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsubpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaddsubps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vaddsubps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun adox(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdoxR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun adox(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdoxR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun aesdec(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesdecXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaesdec(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesdecXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun aesdeclast(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesdeclastXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaesdeclast(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesdeclastXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun aesenc(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesencXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaesenc(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesencXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun aesenclast(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesenclastXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaesenclast(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesenclastXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun aesimc(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesimcXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vaesimc(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesimcXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun aeskeygenassist(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AeskeygenassistXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vaeskeygenassist(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaeskeygenassistXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun andAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun andAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun andEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun andRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun and(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun and(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun and(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun and(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun and(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun andn(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnR32R32Rm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun andn(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnR64R64Rm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun andpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vandpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vandpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun andps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vandps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vandps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun andnpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vandnpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vandnpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun andnps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vandnps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vandnps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun blendpd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendpdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vblendpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vblendpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun bextr(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BextrR32Rm32R32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun bextr(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BextrR64Rm64R64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun blendps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendpsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vblendps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vblendps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun blendvpdXmm0(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendvpdXmmXmmm128Xmm0.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vblendvpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, register4: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpdXmmXmmXmmm128Xmm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun vblendvpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, register4: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpdYmmYmmYmmm256Ymm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun blendvpsXmm0(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendvpsXmmXmmm128Xmm0.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vblendvps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, register4: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpsXmmXmmXmmm128Xmm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun vblendvps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, register4: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpsYmmYmmYmmm256Ymm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun blsi(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsiR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun blsi(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsiR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun blsmsk(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsmskR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun blsmsk(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsmskR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun blsr(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsrR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun blsr(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsrR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsf(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsf(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsf(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsr(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsr(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bsr(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bswap(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BswapR32.encode(buffer, register, options, tracer = this)
  }
  fun bswap(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BswapR64.encode(buffer, register, options, tracer = this)
  }
  fun bt(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bt(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bt(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bt(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bt(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bt(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btc(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btc(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btc(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btc(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btc(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btc(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btr(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btr(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btr(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun btr(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btr(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun btr(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bts(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bts(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bts(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun bts(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bts(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bts(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun bzhi(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BzhiR32Rm32R32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun bzhi(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BzhiR64Rm64R64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun call(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CallRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun call(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CallRm64Rip.encode(buffer, register, options, tracer = this)
  }
  fun cbwAx(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CbwAx.encode(buffer, options, tracer = this)
  }
  fun cwdeEax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CwdeEax.encode(buffer, options, tracer = this)
  }
  fun cdqeRax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CdqeRax.encode(buffer, options, tracer = this)
  }
  fun clc(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Clc.encode(buffer, options, tracer = this)
  }
  fun cld(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cld.encode(buffer, options, tracer = this)
  }
  fun clflush(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ClflushM8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun clflushopt(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ClflushoptM8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun cmc(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cmc.encode(buffer, options, tracer = this)
  }
  fun cmova(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmova(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmova(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovae(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovae(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovae(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovc(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovc(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovc(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovbe(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovbe(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovbe(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmove(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmove(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmove(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovg(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovg(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovg(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovge(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovge(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovge(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovl(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovl(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovl(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovle(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovle(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovle(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovne(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovne(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovne(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovno(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovno(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovno(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovnp(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovnp(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovnp(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovns(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovns(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovns(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovo(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovo(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovo(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovp(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovp(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovp(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovs(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovs(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmovs(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmpAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun cmpAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun cmpEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun cmpRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun cmp(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmp(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmp(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmp(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmppd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmppdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vcmppd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vcmppd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun cmpps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmppsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vcmpps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vcmpps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun cmpsbnorepSilDil(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpsbnorepSilSilDilDil.encode(buffer, options, tracer = this)
  }
  fun cmpswnorepSiDi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpswnorepSiSiDiDi.encode(buffer, options, tracer = this)
  }
  fun cmpsdnorepEsiEdi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpsdnorepEsiEsiEdiEdi.encode(buffer, options, tracer = this)
  }
  fun cmpsqnorepRsiRdi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpsqnorepRsiRsiRdiRdi.encode(buffer, options, tracer = this)
  }
  fun cmpsd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpsdXmm0To63Xmmm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vcmpsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmpsdXmmXmmXmmm64Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun cmpss(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpssXmm0To31Xmmm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vcmpss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmpssXmmXmmXmmm32Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun cmpxchgAl(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm8R8Al.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmpxchgAx(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm16R16Ax.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmpxchgEax(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm32R32Eax.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmpxchgRax(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm64R64Rax.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cmpxchg8bEdxEaxEcxEbx(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cmpxchg8bM64EdxEaxEcxEbx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun cmpxchg16bRdxRaxRcxRbx(addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cmpxchg16bM128RdxRaxRcxRbx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun comisd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ComisdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcomisd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcomisdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun comiss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ComissXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcomiss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcomissXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cpuid(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CpuidEaxEbxEcxEdx.encode(buffer, options, tracer = this)
  }
  fun crc32(register1: GpRegister32, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun crc32(register1: GpRegister32, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun crc32(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun crc32(register1: GpRegister64, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R64Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun crc32(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtdq2pd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtdq2pdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtdq2pd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2pdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtdq2pd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2pdYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtdq2ps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtdq2psXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtdq2ps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2psXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtdq2ps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2psYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtpd2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtpd2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtpd2dq(register1: XmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2dqXmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtpd2pi(register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2piMmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtpd2ps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2psXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtpd2ps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2psXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtpd2ps(register1: XmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2psXmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtpi2pd(register1: XmmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpi2pdXmmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtpi2ps(register1: XmmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpi2psXmm0To63Mmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtps2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtps2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtps2dq(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2dqYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtps2pd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2pdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtps2pd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2pdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtps2pd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2pdYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtps2pi(register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2piMmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtsd2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2siR32Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtsd2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2siR64Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtsd2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2siR32Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtsd2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2siR64Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtsd2ss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2ssXmm0To31Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtsd2ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2ssXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun cvtsi2sd(register1: XmmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2sdXmm0To63Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtsi2sd(register1: XmmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2sdXmm0To63Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtsi2sd(register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2sdXmmXmmRm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vcvtsi2sd(register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2sdXmmXmmRm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun cvtsi2ss(register1: XmmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2ssXmm0To31Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtsi2ss(register1: XmmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2ssXmm0To31Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtsi2ss(register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2ssXmmXmmRm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vcvtsi2ss(register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2ssXmmXmmRm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun cvtss2sd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2sdXmm0To63Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtss2sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2sdXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun cvtss2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2siR32Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvtss2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2siR64Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtss2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2siR32Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtss2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2siR64Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttpd2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttpd2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttpd2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttpd2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttpd2dq(register1: XmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttpd2dqXmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttpd2pi(register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttpd2piMmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttps2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttps2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttps2dq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttps2dqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttps2dq(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttps2dqYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttps2pi(register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttps2piMmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttsd2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttsd2siR32Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttsd2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttsd2siR64Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttsd2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttsd2siR32Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttsd2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttsd2siR64Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttss2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttss2siR32Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cvttss2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttss2siR64Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttss2si(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttss2siR32Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvttss2si(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttss2siR64Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun cwdDxAx(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CwdDxAx.encode(buffer, options, tracer = this)
  }
  fun cdqEdxEax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CdqEdxEax.encode(buffer, options, tracer = this)
  }
  fun cqoRdxRax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CqoRdxRax.encode(buffer, options, tracer = this)
  }
  fun dec(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm8.encode(buffer, register, options, tracer = this)
  }
  fun dec(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm16.encode(buffer, register, options, tracer = this)
  }
  fun dec(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm32.encode(buffer, register, options, tracer = this)
  }
  fun dec(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm64.encode(buffer, register, options, tracer = this)
  }
  fun divAx(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm8Ax.encode(buffer, register, options, tracer = this)
  }
  fun divAxDx(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm16AxDx.encode(buffer, register, options, tracer = this)
  }
  fun divEdxEax(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm32EdxEax.encode(buffer, register, options, tracer = this)
  }
  fun divRdxRax(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm64RdxRax.encode(buffer, register, options, tracer = this)
  }
  fun divpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vdivpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vdivpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun divps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vdivps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vdivps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun divsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vdivsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun divss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vdivss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun dppd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DppdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vdppd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun dpps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DppsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vdpps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vdpps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun enterq(immediate1: Short, immediate2: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    EnterqImm16Imm8RspRbp.encode(buffer, immediate1, immediate2, options, tracer = this)
  }
  fun enterwSpBp(immediate1: Short, immediate2: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    EnterwImm16Imm8SpBp.encode(buffer, immediate1, immediate2, options, tracer = this)
  }
  fun extractps(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ExtractpsRm32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vextractps(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VextractpsRm32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun haddpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HaddpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vhaddpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vhaddpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun haddps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HaddpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vhaddps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vhaddps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun hsubpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HsubpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vhsubpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vhsubpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun hsubps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HsubpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vhsubps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vhsubps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun idivAx(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm8Ax.encode(buffer, register, options, tracer = this)
  }
  fun idivAxDx(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm16AxDx.encode(buffer, register, options, tracer = this)
  }
  fun idivEdxEax(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm32EdxEax.encode(buffer, register, options, tracer = this)
  }
  fun idivRdxRax(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm64RdxRax.encode(buffer, register, options, tracer = this)
  }
  fun imulAx(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm8Ax.encode(buffer, register, options, tracer = this)
  }
  fun imulAxDx(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm16AxDx.encode(buffer, register, options, tracer = this)
  }
  fun imulEdxEax(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm32EdxEax.encode(buffer, register, options, tracer = this)
  }
  fun imulRdxRax(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm64RdxRax.encode(buffer, register, options, tracer = this)
  }
  fun imul(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun imul(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun imul(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun imul(register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun imul(register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun imul(register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun imul(register1: GpRegister16, register2: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16Imm16.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun imul(register1: GpRegister32, register2: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32Imm32.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun imul(register1: GpRegister64, register2: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64Imm32.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun inc(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm8.encode(buffer, register, options, tracer = this)
  }
  fun inc(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm16.encode(buffer, register, options, tracer = this)
  }
  fun inc(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm32.encode(buffer, register, options, tracer = this)
  }
  fun inc(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm64.encode(buffer, register, options, tracer = this)
  }
  fun insertps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    InsertpsXmmXmmm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vinsertps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VinsertpsXmmXmmXmmm32Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun ja(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JaRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jae(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JaeRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jb(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JbRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jbe(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JbeRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jecxz(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JecxzRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun je(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JeRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jg(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JgRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jge(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JgeRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JlRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jle(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JleRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jne(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JneRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jno(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnoRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jnp(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnpRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jns(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnsRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jo(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JoRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jp(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JpRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun js(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JsRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun ja(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JaRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jae(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JaeRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jb(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JbRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jbe(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JbeRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun je(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JeRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jg(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JgRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jge(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JgeRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jl(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JlRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jle(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JleRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jne(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JneRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jno(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnoRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jnp(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnpRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jns(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JnsRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jo(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JoRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jp(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JpRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun js(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JsRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jmp(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JmpRel8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jmp(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JmpRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun jmp(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JmpRm64Rip.encode(buffer, register, options, tracer = this)
  }
  fun lahfAh(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LahfAh.encode(buffer, options, tracer = this)
  }
  fun lddqu(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LddquXmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vlddqu(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VlddquXmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vlddqu(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VlddquYmmM256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun ldmxcsr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LdmxcsrM32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun vldmxcsr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VldmxcsrM32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun lea(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LeaR16M16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun lea(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LeaR32M32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun lea(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LeaR64M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun leavewSpBp(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LeavewSpBp.encode(buffer, options, tracer = this)
  }
  fun leaveq(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LeaveqRspRbp.encode(buffer, options, tracer = this)
  }
  fun lfence(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Lfence.encode(buffer, options, tracer = this)
  }
  fun lodsbSil(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LodsbSilSil.encode(buffer, options, tracer = this)
  }
  fun lodswSi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LodswSiSi.encode(buffer, options, tracer = this)
  }
  fun lodsdEsi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LodsdEsiEsi.encode(buffer, options, tracer = this)
  }
  fun lodsqRsi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LodsqRsiRsi.encode(buffer, options, tracer = this)
  }
  fun loopRcx(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LoopRel8Rcx.encode(buffer, immediate, options, tracer = this)
  }
  fun loopeRcx(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LoopeRel8Rcx.encode(buffer, immediate, options, tracer = this)
  }
  fun loopneRcx(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LoopneRel8Rcx.encode(buffer, immediate, options, tracer = this)
  }
  fun lzcnt(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun lzcnt(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun lzcnt(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun maskmovdquRdi(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaskmovdquXmmXmmRdiRdi.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmaskmovdquRdi(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovdquXmmXmmRdiRdi.encode(buffer, register1, register2, options, tracer = this)
  }
  fun maskmovqRdi(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaskmovqMmMmRdiRdi.encode(buffer, register1, register2, options, tracer = this)
  }
  fun maxpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmaxpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmaxpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun maxps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmaxps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmaxps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun maxsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmaxsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun maxss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmaxss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mfence(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Mfence.encode(buffer, options, tracer = this)
  }
  fun minpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vminpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vminpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun minps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vminps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vminps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun minsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vminsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun minss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vminss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mov(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun mov(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun mov(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun mov(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movabsAl(offset: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovabsAlMoffs8.encode(buffer, offset, options, tracer = this)
  }
  fun movabsAx(offset: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovabsAxMoffs16.encode(buffer, offset, options, tracer = this)
  }
  fun movabsEax(offset: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovabsEaxMoffs32.encode(buffer, offset, options, tracer = this)
  }
  fun movabsRax(offset: Long, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovabsRaxMoffs64.encode(buffer, offset, options, tracer = this)
  }
  fun mov(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun mov(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun mov(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun mov(register: GpRegister64, immediate: Long, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR64Imm64.encode(buffer, register, immediate, options, tracer = this)
  }
  fun mov(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun movapd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovapd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovapd(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movaps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovaps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovaps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movbe(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeR16M16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movbe(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeR32M32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movbe(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeR64M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movbe(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeM16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movbe(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeM32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movbe(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovbeM64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movd(register1: MmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdMmRm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq(register1: MmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqMmRm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movd(register1: GpRegister32, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdRm32Mm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq(register1: GpRegister64, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqRm64Mm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movd(register1: XmmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdXmmRm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq(register1: XmmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqXmmRm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movd(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdRm32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqRm64Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovd(register1: XmmRegister, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdXmmRm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovq(register1: XmmRegister, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqXmmRm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovd(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdRm32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovq(register1: GpRegister64, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqRm64Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movddup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovddupXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovddup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovddupXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovddup(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovddupYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movdqa(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdqaXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovdqa(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovdqa(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movdqu(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdquXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovdqu(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovdqu(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movdq2q(register1: MmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Movdq2qMmXmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movhlps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovhlpsXmm0To63Xmm64To127.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovhlps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovhlpsXmmXmm64To127Xmm64To127.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun movhpd(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovhpdXmm64To127M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovhpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovhpdXmmXmm0To63M64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun movhpd(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovhpdM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovhpd(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovhpdM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movhps(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovhpsXmm64To127M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovhps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovhpsXmmXmm0To63M64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun movhps(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovhpsM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovhps(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovhpsM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movlhps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovlhpsXmm64To127Xmm0To63.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovlhps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovlhpsXmmXmm0To63Xmm0To63.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun movlpd(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovlpdXmm0To63M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovlpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovlpdXmmXmm64To127M64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun movlpd(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovlpdM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovlpd(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovlpdM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movlps(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovlpsXmm0To63M64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovlps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovlpsXmmXmm64To127M64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun movlps(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovlpsM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovlps(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovlpsM64Xmm0To63.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movmskpd(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovmskpdR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovmskpd(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovmskpdR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovmskpd(register1: GpRegister32, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovmskpdR32Ymm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movmskps(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovmskpsR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovmskps(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovmskpsR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovmskps(register1: GpRegister32, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovmskpsR32Ymm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movntdqa(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntdqaXmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovntdqa(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntdqaXmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovntdqa(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntdqaYmmM256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movntdq(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntdqM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntdq(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntdqM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntdq(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntdqM256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movnti(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntiM32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movnti(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntiM64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movntpd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntpdM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntpd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntpdM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntpd(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntpdM256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movntps(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntpsM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntps(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntpsM128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovntps(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovntpsM256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movntq(addressExpression: AddressExpression64, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovntqM64Mm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movq2dq(register1: XmmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Movq2dqXmmMm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsbSilDil(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsbSilSilDilDil.encode(buffer, options, tracer = this)
  }
  fun movswSiDi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovswSiSiDiDi.encode(buffer, options, tracer = this)
  }
  fun movsdEsiEdi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsdEsiEsiEdiEdi.encode(buffer, options, tracer = this)
  }
  fun movsqRsiRdi(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsqRsiRsiRdiRdi.encode(buffer, options, tracer = this)
  }
  fun movsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsdXmmXmmXmm.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmovsd(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsdXmmM64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovsd(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsdM64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movshdup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovshdupXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovshdup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovshdupXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovshdup(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovshdupYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsldup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsldupXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovsldup(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsldupXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovsldup(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsldupYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovssXmmXmmXmm.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmovss(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovssXmmM32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovss(addressExpression: AddressExpression32, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovssM32Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movsx(register1: GpRegister16, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR16Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsx(register1: GpRegister32, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR32Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsx(register1: GpRegister64, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR64Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsx(register1: GpRegister32, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR32Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsx(register1: GpRegister64, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR64Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movsxd(register1: GpRegister64, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxdR64Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movupd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovupd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovupd(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movups(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovups(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmovups(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movzx(register1: GpRegister16, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR16Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movzx(register1: GpRegister32, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR32Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movzx(register1: GpRegister64, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR64Rm8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movzx(register1: GpRegister32, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR32Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun movzx(register1: GpRegister64, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR64Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun mpsadbw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MpsadbwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vmpsadbw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmpsadbwXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vmpsadbw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmpsadbwYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun mulAx(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm8Ax.encode(buffer, register, options, tracer = this)
  }
  fun mulAxDx(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm16AxDx.encode(buffer, register, options, tracer = this)
  }
  fun mulEdxEax(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm32EdxEax.encode(buffer, register, options, tracer = this)
  }
  fun mulRdxRax(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm64RdxRax.encode(buffer, register, options, tracer = this)
  }
  fun mulpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmulpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmulpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mulps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmulps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vmulps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mulsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmulsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mulss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vmulss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mulxEdx(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulxR32R32Rm32Edx.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun mulxRdx(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulxR64R64Rm64Rdx.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun neg(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm8.encode(buffer, register, options, tracer = this)
  }
  fun neg(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm16.encode(buffer, register, options, tracer = this)
  }
  fun neg(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm32.encode(buffer, register, options, tracer = this)
  }
  fun neg(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm64.encode(buffer, register, options, tracer = this)
  }
  fun nop(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Nop.encode(buffer, options, tracer = this)
  }
  fun nop(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NopRm16.encode(buffer, register, options, tracer = this)
  }
  fun nop(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NopRm32.encode(buffer, register, options, tracer = this)
  }
  fun not(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm8.encode(buffer, register, options, tracer = this)
  }
  fun not(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm16.encode(buffer, register, options, tracer = this)
  }
  fun not(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm32.encode(buffer, register, options, tracer = this)
  }
  fun not(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm64.encode(buffer, register, options, tracer = this)
  }
  fun orAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun orAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun orEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun orRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun or(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun or(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun or(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun or(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun or(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun orpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vorpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vorpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun orps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vorps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vorps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pabsb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pabsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pabsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pabsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pabsd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pabsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsb(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsbYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsw(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabswYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpabsd(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsdYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun packsswb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PacksswbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun packsswb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PacksswbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun packssdw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackssdwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun packssdw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackssdwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpacksswb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpacksswbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpackssdw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackssdwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpacksswb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpacksswbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpackssdw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackssdwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun packusdw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackusdwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpackusdw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackusdwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpackusdw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackusdwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun packuswb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackuswbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun packuswb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackuswbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpackuswb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackuswbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpackuswb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackuswbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun paddb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadddXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpaddb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadddXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadddYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun paddsb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddsbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpaddsb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddsbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddsb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddsbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun paddusb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddusbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddusb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddusbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddusw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadduswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun paddusw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadduswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpaddusb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddusbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddusw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadduswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddusb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddusbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpaddusw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadduswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun palignr(register1: MmRegister, register2: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PalignrMmMmm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun palignr(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PalignrXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpalignr(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpalignrXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpalignr(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpalignrYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun pand(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pand(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpand(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpand(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pandn(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandnMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pandn(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandnXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpandn(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandnXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpandn(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandnYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pause(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Pause.encode(buffer, options, tracer = this)
  }
  fun pavgb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pavgb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pavgw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pavgw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpavgb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpavgw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpavgb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpavgw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pblendvbXmm0(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PblendvbXmmXmmm128Xmm0.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpblendvb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, register4: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendvbXmmXmmXmmm128Xmm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun vpblendvb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, register4: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendvbYmmYmmYmmm256Ymm.encode(buffer, register1, register2, register3, register4, options, tracer = this)
  }
  fun pblendw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PblendwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpblendw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendwXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpblendw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendwYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun pclmulqdq(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PclmulqdqXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpclmulqdq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpclmulqdqXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun pcmpeqb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpeqb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpeqw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpeqw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpeqd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpeqd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpcmpeqb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pcmpeqq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpcmpeqq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpeqq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pcmpestriRaxRdxRcx(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpestriXmmXmmm128Imm8RaxRdxRcx.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpcmpestriRaxRdxRcx(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpestriXmmXmmm128Imm8RaxRdxRcx.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pcmpestrmRaxRdxXmm0(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpestrmXmmXmmm128Imm8RaxRdxXmm0.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpcmpestrmRaxRdxXmm0(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpestrmXmmXmmm128Imm8RaxRdxXmm0.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pcmpgtb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpgtb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpgtw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpgtw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpgtd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pcmpgtd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpcmpgtb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pcmpgtq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpcmpgtq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpcmpgtq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pcmpistriRcx(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpistriXmmXmmm128Imm8Rcx.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpcmpistriRcx(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpistriXmmXmmm128Imm8Rcx.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pcmpistrmXmm0(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpistrmXmmXmmm128Imm8Xmm0.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpcmpistrmXmm0(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpistrmXmmXmmm128Imm8Xmm0.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pdep(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PdepR32R32Rm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pdep(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PdepR64R64Rm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pext(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextR32R32Rm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pext(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextR64R64Rm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pextrb(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrbR32m8XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pextrd(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrdRm32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pextrq(register1: GpRegister64, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrqRm64XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpextrb(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrbR32m8XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpextrd(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrdRm32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpextrq(register1: GpRegister64, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrqRm64XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pextrw(register1: GpRegister32, register2: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrwR32MmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pextrw(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrwR32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpextrw(register1: GpRegister32, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrwR32XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun phaddw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phaddw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phaddd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhadddMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phaddd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhadddXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vphaddw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphaddd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphadddXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphaddw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphaddd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphadddYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun phaddsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phaddsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vphaddsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphaddsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun phminposuw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhminposuwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vphminposuw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphminposuwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phsubw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phsubw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phsubd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phsubd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vphsubw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphsubd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphsubw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphsubd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun phsubsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun phsubsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vphsubsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vphsubsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pinsrb(register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrbXmmR32m8Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pinsrd(register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrdXmmRm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pinsrq(register1: XmmRegister, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrqXmmRm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpinsrb(register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrbXmmXmmR32m8Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpinsrd(register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrdXmmXmmRm32Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpinsrq(register1: XmmRegister, register2: XmmRegister, register3: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrqXmmXmmRm64Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun pinsrw(register1: MmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrwMmR32m16Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pinsrw(register1: XmmRegister, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrwXmmR32m16Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpinsrw(register1: XmmRegister, register2: XmmRegister, register3: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrwXmmXmmR32m16Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun pmaddubsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddubswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaddubsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddubswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmaddubsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddubswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaddubsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddubswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmaddwd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddwdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaddwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddwdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmaddwd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddwdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaddwd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddwdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmaxsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaxsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaxsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaxsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxsdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmaxsb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxsb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxsd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmaxub(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxubMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaxub(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxubXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmaxuw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxuwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmaxub(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxubXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxuw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxuwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxub(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxubYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxuw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxuwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmaxud(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxudXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmaxud(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxudXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmaxud(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxudYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pminsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pminsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pminsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpminsb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminsb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pminsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminsdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpminsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminsd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pminub(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminubMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pminub(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminubXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pminuw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminuwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpminub(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminubXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminuw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminuwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminub(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminubYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminuw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminuwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pminud(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminudXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpminud(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminudXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpminud(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminudYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmovmskb(register1: GpRegister32, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovmskbR32Mm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovmskb(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovmskbR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovmskb(register1: GpRegister32, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovmskbR32Xmm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovmskb(register1: GpRegister32, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovmskbR32Ymm.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbwXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxbd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbdXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxbq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbqXmmXmmm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxwdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxwq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxwqXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovsxdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxdqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbwXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbdXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbqXmmXmmm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxwq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwqXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxdqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbw(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbwYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbdYmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxbq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbqYmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxwd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwdYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxwq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwqYmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovsxdq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxdqYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbwXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxbd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbdXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxbq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbqXmmXmmm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxwdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxwq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxwqXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmovzxdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxdqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbwXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbdXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbqXmmXmmm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxwq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwqXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxdqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbw(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbwYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbdYmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxbq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbqYmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxwd(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwdYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxwq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwqYmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmovzxdq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxdqYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmuldq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuldqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmuldq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuldqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmuldq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuldqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmulhrsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhrswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmulhrsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhrswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmulhrsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhrswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmulhrsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhrswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmulhuw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhuwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmulhuw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhuwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmulhuw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhuwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmulhuw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhuwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmulhw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmulhw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmulhw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmulhw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmulld(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulldXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmulld(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulldXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmulld(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulldYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmullw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmullwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmullw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmullwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmullw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmullwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmullw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmullwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pmuludq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuludqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pmuludq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuludqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpmuludq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuludqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpmuludq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuludqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pop(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopR16Rsp.encode(buffer, register, options, tracer = this)
  }
  fun pop(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopR64Rsp.encode(buffer, register, options, tracer = this)
  }
  fun popcnt(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun popcnt(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun popcnt(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun popf(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopfRsp.encode(buffer, options, tracer = this)
  }
  fun popfq(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopfqRsp.encode(buffer, options, tracer = this)
  }
  fun por(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PorMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun por(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PorXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpor(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VporXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpor(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VporYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun prefetcht0(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Prefetcht0M8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun prefetcht1(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Prefetcht1M8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun prefetcht2(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Prefetcht2M8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun prefetchnta(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PrefetchntaM8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun prefetchw(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PrefetchwM8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun prefetchwt1(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Prefetchwt1M8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun psadbw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsadbwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psadbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsadbwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsadbw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsadbwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsadbw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsadbwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pshufb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pshufb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpshufb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpshufb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pshufd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshufd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshufd(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufdYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pshufhw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufhwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshufhw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufhwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshufhw(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufhwYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pshuflw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshuflwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshuflw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshuflwXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpshuflw(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshuflwYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun pshufw(register1: MmRegister, register2: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufwMmMmm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psignb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psignb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psignw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psignw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psignd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsigndMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psignd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsigndXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsignb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsignw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsignd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsigndXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsignb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsignw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsignd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsigndYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun pslldq(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldqXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun vpslldq(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldqXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpslldq(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldqYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psllw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psllw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psllw(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psllw(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun pslld(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pslld(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pslld(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun pslld(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psllq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psllq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psllq(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psllq(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun vpsllw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpslld(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpslld(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsllq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllq(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsllw(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllw(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpslld(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpslld(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsllq(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllq(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psraw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psraw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psraw(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psraw(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrad(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrad(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrad(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrad(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun vpsraw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsraw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrad(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrad(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsraw(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsraw(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrad(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrad(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psrldq(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldqXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun vpsrldq(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldqXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrldq(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldqYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psrlw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrlw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrlw(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrlw(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrld(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrld(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrld(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrld(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrlq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrlq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psrlq(register: MmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqMmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun psrlq(register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqXmmImm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun vpsrlw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlw(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrld(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrld(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrlq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlq(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqXmmXmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrlw(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlw(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrld(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrld(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpsrlq(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqYmmYmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlq(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqYmmYmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun psubb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsubb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun psubq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsubq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun psubsb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubsbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubsb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubsbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubsw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubsw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsubsb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubsbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubsw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubsb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubsbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubsw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun psubusb(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubusbMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubusb(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubusbXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubusw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubuswMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun psubusw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubuswXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpsubusb(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubusbXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubusw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubuswXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubusb(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubusbYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsubusw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubuswYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun ptest(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PtestXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vptest(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VptestXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vptest(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VptestYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhbw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhbwMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhbwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhwd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhwdMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhwdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhdq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhdqMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhdqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckhqdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhqdqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpunpckhbw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhbwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhwd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhwdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhdq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhdqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhqdq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhqdqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhbw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhbwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhwd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhwdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhdq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhdqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckhqdq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhqdqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun punpcklbw(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklbwMmMmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpcklbw(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklbwXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpcklwd(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklwdMmMmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpcklwd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklwdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckldq(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckldqMmMmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpckldq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckldqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun punpcklqdq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklqdqXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpunpcklbw(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklbwXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpcklwd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklwdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckldq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckldqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpcklqdq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklqdqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpcklbw(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklbwYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpcklwd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklwdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpckldq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckldqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpunpcklqdq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklqdqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun push(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushR16Rsp.encode(buffer, register, options, tracer = this)
  }
  fun push(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushR64Rsp.encode(buffer, register, options, tracer = this)
  }
  fun push(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushImm8Rsp.encode(buffer, immediate, options, tracer = this)
  }
  fun push(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushImm16Rsp.encode(buffer, immediate, options, tracer = this)
  }
  fun push(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushImm32Rsp.encode(buffer, immediate, options, tracer = this)
  }
  fun pushf(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushfRsp.encode(buffer, options, tracer = this)
  }
  fun pushfq(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushfqRsp.encode(buffer, options, tracer = this)
  }
  fun pxor(register1: MmRegister, register2: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PxorMmMmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun pxor(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PxorXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpxor(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpxorXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpxor(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpxorYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun rcl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm81.encode(buffer, register, options, tracer = this)
  }
  fun rclCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcl(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm161.encode(buffer, register, options, tracer = this)
  }
  fun rclCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcl(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm321.encode(buffer, register, options, tracer = this)
  }
  fun rcl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm641.encode(buffer, register, options, tracer = this)
  }
  fun rclCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun rclCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcl(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcl(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcr(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm81.encode(buffer, register, options, tracer = this)
  }
  fun rcrCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcr(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcr(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm161.encode(buffer, register, options, tracer = this)
  }
  fun rcrCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcr(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcr(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm321.encode(buffer, register, options, tracer = this)
  }
  fun rcr(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm641.encode(buffer, register, options, tracer = this)
  }
  fun rcrCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcrCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun rcr(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcr(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rol(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm81.encode(buffer, register, options, tracer = this)
  }
  fun rolCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun rol(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rol(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm161.encode(buffer, register, options, tracer = this)
  }
  fun rolCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun rol(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rol(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm321.encode(buffer, register, options, tracer = this)
  }
  fun rol(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm641.encode(buffer, register, options, tracer = this)
  }
  fun rolCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun rolCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun rol(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rol(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun ror(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm81.encode(buffer, register, options, tracer = this)
  }
  fun rorCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun ror(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun ror(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm161.encode(buffer, register, options, tracer = this)
  }
  fun rorCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun ror(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun ror(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm321.encode(buffer, register, options, tracer = this)
  }
  fun ror(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm641.encode(buffer, register, options, tracer = this)
  }
  fun rorCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun rorCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun ror(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun ror(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun rcpps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcppsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrcpps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcppsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrcpps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcppsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun rcpss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcpssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrcpss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcpssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun rdrand(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdrandR16.encode(buffer, register, options, tracer = this)
  }
  fun rdrand(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdrandR32.encode(buffer, register, options, tracer = this)
  }
  fun rdrand(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdrandR64.encode(buffer, register, options, tracer = this)
  }
  fun rdseed(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdseedR16.encode(buffer, register, options, tracer = this)
  }
  fun rdseed(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdseedR32.encode(buffer, register, options, tracer = this)
  }
  fun rdseed(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RdseedR64.encode(buffer, register, options, tracer = this)
  }
  fun ret(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RetRspRip.encode(buffer, options, tracer = this)
  }
  fun ret(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RetImm16RspRip.encode(buffer, immediate, options, tracer = this)
  }
  fun rorx(register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorxR32Rm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun rorx(register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorxR64Rm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun roundpd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundpdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundpd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundpd(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpdYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun roundps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundpsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundps(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpsYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun roundsd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundsdXmm0To63Xmmm64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundsdXmmXmmXmmm64Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun roundss(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundssXmm0To31Xmmm32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vroundss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundssXmmXmmXmmm32Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun rsqrtps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RsqrtpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrsqrtps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrsqrtps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtpsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun rsqrtss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RsqrtssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vrsqrtss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun sahfAh(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SahfAh.encode(buffer, options, tracer = this)
  }
  fun sal(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm81.encode(buffer, register, options, tracer = this)
  }
  fun salCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun sal(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sal(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm161.encode(buffer, register, options, tracer = this)
  }
  fun salCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun sal(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sal(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm321.encode(buffer, register, options, tracer = this)
  }
  fun sal(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm641.encode(buffer, register, options, tracer = this)
  }
  fun salCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun salCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun sal(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sal(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sar(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm81.encode(buffer, register, options, tracer = this)
  }
  fun sarCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun sar(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sar(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm161.encode(buffer, register, options, tracer = this)
  }
  fun sarCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun sar(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sar(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm321.encode(buffer, register, options, tracer = this)
  }
  fun sar(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm641.encode(buffer, register, options, tracer = this)
  }
  fun sarCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun sarCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun sar(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sar(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun shr(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm81.encode(buffer, register, options, tracer = this)
  }
  fun shrCl(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm8Cl.encode(buffer, register, options, tracer = this)
  }
  fun shr(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun shr(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm161.encode(buffer, register, options, tracer = this)
  }
  fun shrCl(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm16Cl.encode(buffer, register, options, tracer = this)
  }
  fun shr(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun shr(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm321.encode(buffer, register, options, tracer = this)
  }
  fun shr(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm641.encode(buffer, register, options, tracer = this)
  }
  fun shrCl(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm32Cl.encode(buffer, register, options, tracer = this)
  }
  fun shrCl(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm64Cl.encode(buffer, register, options, tracer = this)
  }
  fun shr(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun shr(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sarx(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarxR32Rm32R32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun shlx(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShlxR32Rm32R32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun shrx(register1: GpRegister32, register2: GpRegister32, register3: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrxR32Rm32R32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun sarx(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarxR64Rm64R64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun shlx(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShlxR64Rm64R64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun shrx(register1: GpRegister64, register2: GpRegister64, register3: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrxR64Rm64R64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun sbbAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun sbbAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun sbbEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun sbbRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sbb(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sbb(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sbb(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sbb(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun scasbSilDilAl(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ScasbSilDilDilAl.encode(buffer, options, tracer = this)
  }
  fun scaswSiDiAx(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ScaswSiDiDiAx.encode(buffer, options, tracer = this)
  }
  fun scasdEsiEdiEax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ScasdEsiEdiEdiEax.encode(buffer, options, tracer = this)
  }
  fun scasqRsiRdiRax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ScasqRsiRdiRdiRax.encode(buffer, options, tracer = this)
  }
  fun seta(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetaRm8.encode(buffer, register, options, tracer = this)
  }
  fun setae(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetaeRm8.encode(buffer, register, options, tracer = this)
  }
  fun setb(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetbRm8.encode(buffer, register, options, tracer = this)
  }
  fun setbe(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetbeRm8.encode(buffer, register, options, tracer = this)
  }
  fun sete(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SeteRm8.encode(buffer, register, options, tracer = this)
  }
  fun setg(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetgRm8.encode(buffer, register, options, tracer = this)
  }
  fun setge(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetgeRm8.encode(buffer, register, options, tracer = this)
  }
  fun setnge(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetngeRm8.encode(buffer, register, options, tracer = this)
  }
  fun setle(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetleRm8.encode(buffer, register, options, tracer = this)
  }
  fun setne(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetneRm8.encode(buffer, register, options, tracer = this)
  }
  fun setno(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetnoRm8.encode(buffer, register, options, tracer = this)
  }
  fun setpo(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetpoRm8.encode(buffer, register, options, tracer = this)
  }
  fun setns(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetnsRm8.encode(buffer, register, options, tracer = this)
  }
  fun seto(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetoRm8.encode(buffer, register, options, tracer = this)
  }
  fun setp(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetpRm8.encode(buffer, register, options, tracer = this)
  }
  fun sets(register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetsRm8.encode(buffer, register, options, tracer = this)
  }
  fun sfence(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sfence.encode(buffer, options, tracer = this)
  }
  fun sha1rnds4(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1rnds4XmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun sha1nexte(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1nexteXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sha1msg1(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1msg1XmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sha1msg2(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1msg2XmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sha256rnds2Xmm0(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256rnds2XmmXmmm128Xmm0.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sha256msg1(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256msg1XmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sha256msg2(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256msg2XmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shld(register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm16R16Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shldCl(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm16R16Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shld(register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm32R32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shld(register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm64R64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shldCl(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm32R32Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shldCl(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm64R64Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shrd(register1: GpRegister16, register2: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm16R16Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shrdCl(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm16R16Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shrd(register1: GpRegister32, register2: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm32R32Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shrd(register1: GpRegister64, register2: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm64R64Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun shrdCl(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm32R32Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shrdCl(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm64R64Cl.encode(buffer, register1, register2, options, tracer = this)
  }
  fun shufpd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShufpdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vshufpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vshufpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun shufps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShufpsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vshufps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vshufps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun sqrtpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtpd(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpdYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sqrtps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sqrtsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun sqrtss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsqrtss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun stc(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Stc.encode(buffer, options, tracer = this)
  }
  fun std(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Std.encode(buffer, options, tracer = this)
  }
  fun stmxcsr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    StmxcsrM32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun vstmxcsr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VstmxcsrM32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun stosbSilDilAl(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    StosbSilDilDilAl.encode(buffer, options, tracer = this)
  }
  fun stoswSiDiAx(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    StoswSiDiDiAx.encode(buffer, options, tracer = this)
  }
  fun stosdEsiEdiEax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    StosdEsiEdiEdiEax.encode(buffer, options, tracer = this)
  }
  fun stosqRsiRdiRax(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    StosqRsiRdiRdiRax.encode(buffer, options, tracer = this)
  }
  fun subAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun subAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun subEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun subRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun sub(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sub(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sub(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun sub(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun subpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsubpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vsubpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun subps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsubps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vsubps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun subsd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubsdXmm0To63Xmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsubsd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubsdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun subss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubssXmm0To31Xmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vsubss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun testAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun testAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun testEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun testRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun test(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun test(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun test(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun test(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun test(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun test(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun test(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun test(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun tzcnt(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR16Rm16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun tzcnt(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR32Rm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun tzcnt(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR64Rm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun ucomisd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UcomisdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vucomisd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VucomisdXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun ucomiss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UcomissXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vucomiss(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VucomissXmmXmmm32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun ud2(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Ud2.encode(buffer, options, tracer = this)
  }
  fun unpckhpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpckhpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vunpckhpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vunpckhpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun unpckhps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpckhpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vunpckhps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vunpckhps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun unpcklpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpcklpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vunpcklpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vunpcklpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun unpcklps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpcklpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vunpcklps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vunpcklps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vbroadcastss(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VbroadcastssXmmM32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vbroadcastss(register: YmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VbroadcastssYmmM32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vbroadcastsd(register: YmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VbroadcastsdYmmM64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vbroadcastf128(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vbroadcastf128YmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtph2ps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtph2psXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtph2ps(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtph2psYmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vcvtps2ph(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2phXmmm64XmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vcvtps2ph(register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2phXmmm128YmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vextractf128(register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vextractf128Xmmm128YmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vextracti128(register1: XmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vextracti128Xmmm128YmmImm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vfmadd132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd132sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd132ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd213ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmadd231ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmaddsub231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsubadd231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub132ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub213ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfmsub231ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd132ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd213ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmadd231ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231pd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231pd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231ps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231psXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231ps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231psYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231sd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231sdXmmXmmXmmm64.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub132ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub213ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vfnmsub231ss(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231ssXmmXmmXmmm32.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vgatherdpd(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherdpdXmmVm32x64Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherqpd(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherqpdXmmVm64x64Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherdpd(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherdpdYmmVm32x64Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherqpd(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherqpdYmmVm64y64Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherdps(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherdpsXmmVm32x32Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherqps(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherqpsXmmVm64x32Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vgatherdps(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VgatherdpsYmmVm32y32Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherdd(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherddXmmVm32x32Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherqd(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherqdXmmVm64x32Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherdd(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherddYmmVm32y32Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherdq(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherdqXmmVm32x64Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherqq(register1: XmmRegister, vectorAddressExpression: VectorAddressExpression, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherqqXmmVm64x64Xmm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherdq(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherdqYmmVm32x64Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vpgatherqq(register1: YmmRegister, vectorAddressExpression: VectorAddressExpression, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpgatherqqYmmVm64y64Ymm.encode(buffer, register1, vectorAddressExpression, register2, options, tracer = this)
  }
  fun vinsertf128(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vinsertf128YmmYmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vinserti128(register1: YmmRegister, register2: YmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vinserti128YmmYmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vmaskmovps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpsXmmXmmM128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaskmovps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpsYmmYmmM256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaskmovpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpdXmmXmmM128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaskmovpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpdYmmYmmM256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaskmovps(addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpsM128XmmXmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vmaskmovps(addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpsM256YmmYmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vmaskmovpd(addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpdM128XmmXmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vmaskmovpd(addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaskmovpdM256YmmYmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vpblendd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblenddXmmXmmXmmm128Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpblendd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblenddYmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpbroadcastq(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpbroadcastqXmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vpbroadcastq(register1: YmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpbroadcastqYmmXmmm64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vbroadcasti128(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vbroadcasti128YmmM128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vperm2f128(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vperm2f128YmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vperm2i128(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vperm2i128YmmYmmYmmm256Imm8.encode(buffer, register1, register2, register3, immediate, options, tracer = this)
  }
  fun vpermd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermilpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermilpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermilpd(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpermilpd(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpermilps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermilps(register1: XmmRegister, register2: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsXmmXmmm128Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpermilps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermilps(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpermpd(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermpdYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpermps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpermq(register1: YmmRegister, register2: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermqYmmYmmm256Imm8.encode(buffer, register1, register2, immediate, options, tracer = this)
  }
  fun vpmaskmovd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovdXmmXmmM128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaskmovd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovdYmmYmmM256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaskmovq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovqXmmXmmM128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaskmovq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovqYmmYmmM256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaskmovd(addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovdM128XmmXmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vpmaskmovd(addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovdM256YmmYmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vpmaskmovq(addressExpression: AddressExpression128, register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovqM128XmmXmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vpmaskmovq(addressExpression: AddressExpression256, register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaskmovqM256YmmYmm.encode(buffer, addressExpression, register1, register2, options, tracer = this)
  }
  fun vpsllvd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllvq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllvd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsllvq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsravd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsravdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsravd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsravdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlvd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlvq(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvqXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlvd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vpsrlvq(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvqYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vtestps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vtestps(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpsYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vtestpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vtestpd(register1: YmmRegister, register2: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpdYmmYmmm256.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vzeroall(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vzeroall.encode(buffer, options, tracer = this)
  }
  fun vzeroupper(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vzeroupper.encode(buffer, options, tracer = this)
  }
  fun xabort(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XabortImm8Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun xadd(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xadd(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xadd(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xadd(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xbegin(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XbeginRel16Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun xbegin(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XbeginRel32Rip.encode(buffer, immediate, options, tracer = this)
  }
  fun xchgAx(register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgAxR16.encode(buffer, register, options, tracer = this)
  }
  fun xchgEax(register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgEaxR32.encode(buffer, register, options, tracer = this)
  }
  fun xchgRax(register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRaxR64.encode(buffer, register, options, tracer = this)
  }
  fun xchg(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xchg(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xchg(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xchg(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xend(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Xend.encode(buffer, options, tracer = this)
  }
  fun xlatbAl(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XlatbAlRbxAl.encode(buffer, options, tracer = this)
  }
  fun xorAl(immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorAlImm8.encode(buffer, immediate, options, tracer = this)
  }
  fun xorAx(immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorAxImm16.encode(buffer, immediate, options, tracer = this)
  }
  fun xorEax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorEaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun xorRax(immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRaxImm32.encode(buffer, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm8Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16Imm16.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64Imm32.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64Imm8.encode(buffer, register, immediate, options, tracer = this)
  }
  fun xor(register1: GpRegister8, register2: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm8R8.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xor(register1: GpRegister16, register2: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16R16.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xor(register1: GpRegister32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32R32.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xor(register1: GpRegister64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64R64.encode(buffer, register1, register2, options, tracer = this)
  }
  fun xorpd(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorpdXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vxorpd(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpdXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vxorpd(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpdYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun xorps(register1: XmmRegister, register2: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorpsXmmXmmm128.encode(buffer, register1, register2, options, tracer = this)
  }
  fun vxorps(register1: XmmRegister, register2: XmmRegister, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpsXmmXmmXmmm128.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun vxorps(register1: YmmRegister, register2: YmmRegister, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpsYmmYmmYmmm256.encode(buffer, register1, register2, register3, options, tracer = this)
  }
  fun xtest(options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Xtest.encode(buffer, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun adc(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun adc(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adc(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adc(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adc(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adcx(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcxR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adcx(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdcxR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun add(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun add(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun add(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun add(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun add(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun addpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vaddpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun addps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vaddps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun addsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun addss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun addsubpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsubpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddsubpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vaddsubpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun addsubps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AddsubpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaddsubps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vaddsubps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaddsubpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun adox(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdoxR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun adox(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AdoxR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun aesdec(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesdecXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaesdec(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesdecXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun aesdeclast(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesdeclastXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaesdeclast(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesdeclastXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun aesenc(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesencXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaesenc(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesencXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun aesenclast(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesenclastXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaesenclast(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesenclastXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun aesimc(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AesimcXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vaesimc(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaesimcXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun aeskeygenassist(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AeskeygenassistXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vaeskeygenassist(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VaeskeygenassistXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun and(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun and(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun and(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun and(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun and(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun andn(register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnR32R32Rm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun andn(register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnR64R64Rm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun andpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vandpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vandpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun andps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vandps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vandps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun andnpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vandnpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vandnpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun andnps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    AndnpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vandnps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vandnps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VandnpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun blendpd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendpdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vblendpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vblendpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun bextr(register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BextrR32Rm32R32.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun bextr(register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BextrR64Rm64R64.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun blendps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendpsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vblendps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vblendps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendpsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun blendvpdXmm0(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendvpdXmmXmmm128Xmm0.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vblendvpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpdXmmXmmXmmm128Xmm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun vblendvpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpdYmmYmmYmmm256Ymm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun blendvpsXmm0(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlendvpsXmmXmmm128Xmm0.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vblendvps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpsXmmXmmXmmm128Xmm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun vblendvps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VblendvpsYmmYmmYmmm256Ymm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun blsi(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsiR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun blsi(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsiR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun blsmsk(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsmskR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun blsmsk(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsmskR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun blsr(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsrR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun blsr(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BlsrR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsf(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsf(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsf(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsfR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsr(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsr(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bsr(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BsrR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bt(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btc(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtcRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun btr(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtrRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bts(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BtsRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun bzhi(register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BzhiR32Rm32R32.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun bzhi(register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    BzhiR64Rm64R64.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun call(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CallRm64Rip.encode(buffer, addressExpression, options, tracer = this)
  }
  fun cmova(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmova(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmova(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovae(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovae(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovae(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovaeR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovc(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovc(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovc(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovcR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovbe(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovbe(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovbe(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovbeR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmove(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmove(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmove(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmoveR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovg(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovg(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovg(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovge(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovge(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovge(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovgeR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovl(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovl(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovl(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovlR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovle(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovle(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovle(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovleR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovne(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovne(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovne(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovneR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovno(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovno(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovno(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnoR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovnp(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovnp(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovnp(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnpR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovns(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovns(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovns(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovnsR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovo(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovo(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovo(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovoR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovp(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovp(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovp(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovpR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovs(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovs(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmovs(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmovsR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmp(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmp(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmp(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmp(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmp(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cmppd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmppdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vcmppd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vcmppd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun cmpps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmppsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vcmpps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vcmpps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmppsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun cmpsd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpsdXmm0To63Xmmm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vcmpsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmpsdXmmXmmXmmm64Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun cmpss(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpssXmm0To31Xmmm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vcmpss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcmpssXmmXmmXmmm32Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun cmpxchgAl(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm8R8Al.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmpxchgAx(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm16R16Ax.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmpxchgEax(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm32R32Eax.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun cmpxchgRax(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    CmpxchgRm64R64Rax.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun comisd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ComisdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcomisd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcomisdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun comiss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ComissXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcomiss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VcomissXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun crc32(register: GpRegister32, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun crc32(register: GpRegister32, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun crc32(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun crc32(register: GpRegister64, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R64Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun crc32(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Crc32R64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtdq2pd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtdq2pdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtdq2pd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2pdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtdq2pd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2pdYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtdq2ps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtdq2psXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtdq2ps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2psXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtdq2ps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtdq2psYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtpd2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtpd2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtpd2dq(register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2dqXmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtpd2pi(register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2piMmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtpd2ps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpd2psXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtpd2ps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2psXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtpd2ps(register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtpd2psXmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtpi2pd(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpi2pdXmmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtpi2ps(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtpi2psXmm0To63Mmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtps2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtps2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtps2dq(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2dqYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtps2pd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2pdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtps2pd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2pdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtps2pd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2pdYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtps2pi(register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtps2piMmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtsd2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2siR32Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtsd2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2siR64Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtsd2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2siR32Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtsd2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2siR64Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtsd2ss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsd2ssXmm0To31Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtsd2ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsd2ssXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun cvtsi2sd(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2sdXmm0To63Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtsi2sd(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2sdXmm0To63Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtsi2sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2sdXmmXmmRm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vcvtsi2sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2sdXmmXmmRm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun cvtsi2ss(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2ssXmm0To31Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtsi2ss(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtsi2ssXmm0To31Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtsi2ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2ssXmmXmmRm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vcvtsi2ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtsi2ssXmmXmmRm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun cvtss2sd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2sdXmm0To63Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtss2sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2sdXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun cvtss2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2siR32Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvtss2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvtss2siR64Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtss2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2siR32Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtss2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtss2siR64Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttpd2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttpd2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttpd2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttpd2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttpd2dq(register: XmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttpd2dqXmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttpd2pi(register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttpd2piMmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttps2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttps2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttps2dq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttps2dqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttps2dq(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttps2dqYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttps2pi(register: MmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttps2piMmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttsd2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttsd2siR32Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttsd2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttsd2siR64Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttsd2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttsd2siR32Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttsd2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttsd2siR64Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttss2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttss2siR32Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun cvttss2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Cvttss2siR64Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttss2si(register: GpRegister32, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttss2siR32Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvttss2si(register: GpRegister64, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvttss2siR64Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun dec(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun dec(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm16.encode(buffer, addressExpression, options, tracer = this)
  }
  fun dec(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun dec(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DecRm64.encode(buffer, addressExpression, options, tracer = this)
  }
  fun divAx(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm8Ax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun divAxDx(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm16AxDx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun divEdxEax(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm32EdxEax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun divRdxRax(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivRm64RdxRax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun divpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vdivpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vdivpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun divps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vdivps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vdivps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun divsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vdivsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun divss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DivssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vdivss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdivssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun dppd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DppdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vdppd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun dpps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    DppsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vdpps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vdpps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VdppsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun extractps(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ExtractpsRm32XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vextractps(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VextractpsRm32XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun haddpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HaddpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vhaddpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vhaddpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun haddps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HaddpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vhaddps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vhaddps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhaddpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun hsubpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HsubpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vhsubpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vhsubpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun hsubps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    HsubpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vhsubps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vhsubps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VhsubpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun idivAx(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm8Ax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun idivAxDx(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm16AxDx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun idivEdxEax(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm32EdxEax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun idivRdxRax(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IdivRm64RdxRax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun imulAx(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm8Ax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun imulAxDx(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm16AxDx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun imulEdxEax(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm32EdxEax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun imulRdxRax(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulRm64RdxRax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun imul(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun imul(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun imul(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun imul(register: GpRegister16, addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun imul(register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun imul(register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun imul(register: GpRegister16, addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR16Rm16Imm16.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun imul(register: GpRegister32, addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR32Rm32Imm32.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun imul(register: GpRegister64, addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ImulR64Rm64Imm32.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun inc(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun inc(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm16.encode(buffer, addressExpression, options, tracer = this)
  }
  fun inc(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun inc(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    IncRm64.encode(buffer, addressExpression, options, tracer = this)
  }
  fun insertps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    InsertpsXmmXmmm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vinsertps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VinsertpsXmmXmmXmmm32Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun jmp(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    JmpRm64Rip.encode(buffer, addressExpression, options, tracer = this)
  }
  fun lzcnt(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun lzcnt(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun lzcnt(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    LzcntR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun maxpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmaxpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaxpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun maxps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmaxps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmaxps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun maxsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmaxsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun maxss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MaxssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmaxss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmaxssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun minpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vminpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vminpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun minps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vminps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vminps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun minsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vminsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun minss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MinssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vminss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VminssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun mov(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun mov(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun mov(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun mov(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun mov(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun movapd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movapd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapdXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovapd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovapd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovapd(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovapd(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapdYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movaps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movaps(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovapsXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovaps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovaps(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovaps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovaps(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovapsYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movd(register: MmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdMmRm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqMmRm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movd(addressExpression: AddressExpression32, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdRm32Mm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movq(addressExpression: AddressExpression64, register: MmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqRm64Mm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movd(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdXmmRm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movq(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqXmmRm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movd(addressExpression: AddressExpression32, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdRm32Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movq(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqRm64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovd(register: XmmRegister, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdXmmRm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovq(register: XmmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqXmmRm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovd(addressExpression: AddressExpression32, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdRm32Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovq(addressExpression: AddressExpression64, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqRm64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movddup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovddupXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovddup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovddupXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovddup(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovddupYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movdqa(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdqaXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movdqa(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdqaXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovdqa(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovdqa(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovdqa(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovdqa(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdqaYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movdqu(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdquXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movdqu(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovdquXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovdqu(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovdqu(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovdqu(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovdqu(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovdquYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movq(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovqXmmm64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovq(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovqXmmm64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsdXmmm64Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movshdup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovshdupXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovshdup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovshdupXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovshdup(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovshdupYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsldup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsldupXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovsldup(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsldupXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovsldup(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovsldupYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movss(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovssXmmm32Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movsx(register: GpRegister16, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR16Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsx(register: GpRegister32, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR32Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsx(register: GpRegister64, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR64Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsx(register: GpRegister32, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR32Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsx(register: GpRegister64, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxR64Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movsxd(register: GpRegister64, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovsxdR64Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movupd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movupd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupdXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovupd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovupd(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovupd(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovupd(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupdYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movups(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movups(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovupsXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovups(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovups(addressExpression: AddressExpression128, register: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsXmmm128Xmm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun vmovups(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmovups(addressExpression: AddressExpression256, register: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmovupsYmmm256Ymm.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun movzx(register: GpRegister16, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR16Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movzx(register: GpRegister32, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR32Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movzx(register: GpRegister64, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR64Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movzx(register: GpRegister32, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR32Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun movzx(register: GpRegister64, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MovzxR64Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun mpsadbw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MpsadbwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vmpsadbw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmpsadbwXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vmpsadbw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmpsadbwYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun mulAx(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm8Ax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun mulAxDx(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm16AxDx.encode(buffer, addressExpression, options, tracer = this)
  }
  fun mulEdxEax(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm32EdxEax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun mulRdxRax(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulRm64RdxRax.encode(buffer, addressExpression, options, tracer = this)
  }
  fun mulpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmulpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmulpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mulps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmulps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vmulps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mulsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmulsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mulss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vmulss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VmulssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mulxEdx(register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulxR32R32Rm32Edx.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun mulxRdx(register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    MulxR64R64Rm64Rdx.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun neg(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun neg(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm16.encode(buffer, addressExpression, options, tracer = this)
  }
  fun neg(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun neg(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NegRm64.encode(buffer, addressExpression, options, tracer = this)
  }
  fun nop(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NopRm16.encode(buffer, addressExpression, options, tracer = this)
  }
  fun nop(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NopRm32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun not(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun not(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm16.encode(buffer, addressExpression, options, tracer = this)
  }
  fun not(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm32.encode(buffer, addressExpression, options, tracer = this)
  }
  fun not(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    NotRm64.encode(buffer, addressExpression, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun or(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun or(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun or(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun or(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun or(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun orpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vorpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vorpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun orps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    OrpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vorps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vorps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VorpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pabsb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pabsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pabsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pabsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pabsd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pabsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PabsdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsb(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsbYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsw(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabswYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpabsd(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpabsdYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun packsswb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PacksswbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun packsswb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PacksswbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun packssdw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackssdwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun packssdw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackssdwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpacksswb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpacksswbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpackssdw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackssdwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpacksswb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpacksswbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpackssdw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackssdwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun packusdw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackusdwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpackusdw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackusdwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpackusdw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackusdwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun packuswb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackuswbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun packuswb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PackuswbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpackuswb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackuswbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpackuswb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpackuswbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun paddb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadddXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpaddb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadddXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadddYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun paddsb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddsbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpaddsb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddsbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddsb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddsbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun paddusb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddusbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddusb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PaddusbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddusw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadduswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun paddusw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PadduswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpaddusb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddusbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddusw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadduswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddusb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpaddusbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpaddusw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpadduswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun palignr(register: MmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PalignrMmMmm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun palignr(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PalignrXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpalignr(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpalignrXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpalignr(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpalignrYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun pand(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pand(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpand(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpand(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pandn(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandnMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pandn(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PandnXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpandn(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandnXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpandn(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpandnYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pavgb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pavgb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pavgw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pavgw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PavgwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpavgb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpavgw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpavgb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpavgw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpavgwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pblendvbXmm0(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PblendvbXmmXmmm128Xmm0.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpblendvb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, register3: XmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendvbXmmXmmXmmm128Xmm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun vpblendvb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, register3: YmmRegister, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendvbYmmYmmYmmm256Ymm.encode(buffer, register1, register2, addressExpression, register3, options, tracer = this)
  }
  fun pblendw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PblendwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpblendw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendwXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpblendw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblendwYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun pclmulqdq(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PclmulqdqXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpclmulqdq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpclmulqdqXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun pcmpeqb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpeqb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpeqw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpeqw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpeqd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpeqd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpcmpeqb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pcmpeqq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpeqqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpcmpeqq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpeqq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpeqqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pcmpestriRaxRdxRcx(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpestriXmmXmmm128Imm8RaxRdxRcx.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpcmpestriRaxRdxRcx(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpestriXmmXmmm128Imm8RaxRdxRcx.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pcmpestrmRaxRdxXmm0(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpestrmXmmXmmm128Imm8RaxRdxXmm0.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpcmpestrmRaxRdxXmm0(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpestrmXmmXmmm128Imm8RaxRdxXmm0.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pcmpgtb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpgtb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpgtw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpgtw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpgtd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pcmpgtd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpcmpgtb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pcmpgtq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpgtqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpcmpgtq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpcmpgtq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpgtqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pcmpistriRcx(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpistriXmmXmmm128Imm8Rcx.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpcmpistriRcx(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpistriXmmXmmm128Imm8Rcx.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pcmpistrmXmm0(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PcmpistrmXmmXmmm128Imm8Xmm0.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpcmpistrmXmm0(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpcmpistrmXmmXmmm128Imm8Xmm0.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pdep(register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PdepR32R32Rm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pdep(register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PdepR64R64Rm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pext(register1: GpRegister32, register2: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextR32R32Rm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pext(register1: GpRegister64, register2: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextR64R64Rm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pextrb(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrbR32m8XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun pextrd(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrdRm32XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun pextrq(addressExpression: AddressExpression64, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrqRm64XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vpextrb(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrbR32m8XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vpextrd(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrdRm32XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vpextrq(addressExpression: AddressExpression64, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrqRm64XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun pextrw(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PextrwR32m16XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vpextrw(addressExpression: AddressExpression32, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpextrwR32m16XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun phaddw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phaddw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phaddd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhadddMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phaddd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhadddXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vphaddw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphaddd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphadddXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphaddw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphaddd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphadddYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun phaddsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phaddsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhaddswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vphaddsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphaddsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphaddswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun phminposuw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhminposuwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vphminposuw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphminposuwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phsubw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phsubw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phsubd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phsubd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vphsubw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphsubd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphsubw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphsubd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun phsubsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun phsubsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PhsubswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vphsubsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vphsubsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VphsubswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pinsrb(register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrbXmmR32m8Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pinsrd(register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrdXmmRm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pinsrq(register: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrqXmmRm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpinsrb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrbXmmXmmR32m8Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpinsrd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrdXmmXmmRm32Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpinsrq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrqXmmXmmRm64Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun pinsrw(register: MmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrwMmR32m16Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pinsrw(register: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PinsrwXmmR32m16Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpinsrw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpinsrwXmmXmmR32m16Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun pmaddubsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddubswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaddubsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddubswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmaddubsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddubswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaddubsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddubswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmaddwd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddwdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaddwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaddwdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmaddwd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddwdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaddwd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaddwdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmaxsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaxsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaxsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaxsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxsdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmaxsb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxsb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxsd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxsdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmaxub(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxubMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaxub(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxubXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmaxuw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxuwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmaxub(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxubXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxuw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxuwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxub(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxubYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxuw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxuwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmaxud(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmaxudXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmaxud(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxudXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmaxud(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmaxudYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pminsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pminsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pminsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpminsb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminsb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pminsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminsdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpminsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminsd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminsdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pminub(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminubMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pminub(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminubXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pminuw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminuwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpminub(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminubXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminuw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminuwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminub(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminubYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminuw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminuwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pminud(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PminudXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpminud(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminudXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpminud(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpminudYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmovsxbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbwXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovsxbd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbdXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovsxbq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxbqXmmXmmm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovsxwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxwdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovsxwq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxwqXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovsxdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovsxdqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbwXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbdXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbqXmmXmmm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxwq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwqXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxdqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbw(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbwYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbdYmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxbq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxbqYmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxwd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwdYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxwq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxwqYmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovsxdq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovsxdqYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbwXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxbd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbdXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxbq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxbqXmmXmmm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxwdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxwq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxwqXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmovzxdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmovzxdqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbwXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbdXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbqXmmXmmm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxwq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwqXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxdqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbw(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbwYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbdYmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxbq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxbqYmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxwd(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwdYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxwq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxwqYmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmovzxdq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmovzxdqYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmuldq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuldqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmuldq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuldqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmuldq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuldqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmulhrsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhrswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmulhrsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhrswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmulhrsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhrswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmulhrsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhrswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmulhuw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhuwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmulhuw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhuwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmulhuw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhuwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmulhuw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhuwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmulhw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmulhw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulhwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmulhw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmulhw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulhwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmulld(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmulldXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmulld(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulldXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmulld(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmulldYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmullw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmullwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmullw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmullwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmullw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmullwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmullw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmullwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pmuludq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuludqMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pmuludq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PmuludqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpmuludq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuludqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpmuludq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpmuludqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pop(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopRm16Rsp.encode(buffer, addressExpression, options, tracer = this)
  }
  fun pop(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopRm64Rsp.encode(buffer, addressExpression, options, tracer = this)
  }
  fun popcnt(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun popcnt(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun popcnt(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PopcntR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun por(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PorMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun por(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PorXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpor(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VporXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpor(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VporYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psadbw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsadbwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psadbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsadbwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsadbw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsadbwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsadbw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsadbwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pshufb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pshufb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpshufb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpshufb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun pshufd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshufd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshufd(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufdYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pshufhw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufhwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshufhw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufhwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshufhw(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshufhwYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pshuflw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshuflwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshuflw(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshuflwXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpshuflw(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpshuflwYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun pshufw(register: MmRegister, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PshufwMmMmm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun psignb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psignb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psignw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psignw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsignwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psignd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsigndMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psignd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsigndXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsignb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsignw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsignd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsigndXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsignb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsignw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsignwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsignd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsigndYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psllw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psllw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pslld(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pslld(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PslldXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psllq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psllq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsllqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsllw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpslld(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllwYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpslld(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpslldYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllqYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psraw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psraw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrawXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrad(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrad(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsradXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsraw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrad(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsraw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrawYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrad(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsradYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psrlw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrlw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrld(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrld(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrldXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrlq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psrlq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsrlqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsrlw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrld(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlwYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrld(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrldYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlqYmmYmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psubb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsubb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psubq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubqMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsubq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psubsb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubsbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubsb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubsbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubsw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubsw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsubsb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubsbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubsw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubsb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubsbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubsw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun psubusb(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubusbMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubusb(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubusbXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubusw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubuswMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun psubusw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PsubuswXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpsubusb(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubusbXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubusw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubuswXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubusb(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubusbYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsubusw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsubuswYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun ptest(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PtestXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vptest(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VptestXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vptest(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VptestYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhbw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhbwMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhbwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhwd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhwdMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhwdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhdq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhdqMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhdqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckhqdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckhqdqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpunpckhbw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhbwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhwd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhwdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhdq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhdqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhqdq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhqdqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhbw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhbwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhwd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhwdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhdq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhdqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckhqdq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckhqdqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun punpcklbw(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklbwMmMmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpcklbw(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklbwXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpcklwd(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklwdMmMmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpcklwd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklwdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckldq(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckldqMmMmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpckldq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpckldqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun punpcklqdq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PunpcklqdqXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpunpcklbw(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklbwXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpcklwd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklwdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckldq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckldqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpcklqdq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklqdqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpcklbw(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklbwYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpcklwd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklwdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpckldq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpckldqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpunpcklqdq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpunpcklqdqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun push(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushRm16Rsp.encode(buffer, addressExpression, options, tracer = this)
  }
  fun push(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PushRm64Rsp.encode(buffer, addressExpression, options, tracer = this)
  }
  fun pxor(register: MmRegister, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PxorMmMmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun pxor(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    PxorXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpxor(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpxorXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpxor(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpxorYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rclCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rclCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rclCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rclCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcl(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RclRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcrCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcrCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcrCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcrCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcr(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcrRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rolCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rolCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rolCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rolCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rol(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RolRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rorCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rorCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rorCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun rorCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun ror(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun rcpps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcppsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrcpps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcppsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrcpps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcppsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun rcpss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RcpssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrcpss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrcpssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun rorx(register: GpRegister32, addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorxR32Rm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun rorx(register: GpRegister64, addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RorxR64Rm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun roundpd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundpdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundpd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundpd(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpdYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun roundps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundpsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundps(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundpsYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun roundsd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundsdXmm0To63Xmmm64Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundsdXmmXmmXmmm64Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun roundss(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RoundssXmm0To31Xmmm32Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vroundss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VroundssXmmXmmXmmm32Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun rsqrtps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RsqrtpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrsqrtps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrsqrtps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtpsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun rsqrtss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    RsqrtssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vrsqrtss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VrsqrtssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun salCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun salCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun salCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun salCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sal(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SalRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sarCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sarCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sarCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sarCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sar(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm81.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shrCl(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm8Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm161.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shrCl(addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm16Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm321.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm641.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shrCl(addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm32Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shrCl(addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm64Cl.encode(buffer, addressExpression, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun shr(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sarx(register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarxR32Rm32R32.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun shlx(register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShlxR32Rm32R32.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun shrx(register1: GpRegister32, addressExpression: AddressExpression32, register2: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrxR32Rm32R32.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun sarx(register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SarxR64Rm64R64.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun shlx(register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShlxR64Rm64R64.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun shrx(register1: GpRegister64, addressExpression: AddressExpression64, register2: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrxR64Rm64R64.encode(buffer, register1, addressExpression, register2, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sbb(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sbb(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sbb(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sbb(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sbb(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SbbR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun seta(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetaRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setae(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetaeRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setb(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetbRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setbe(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetbeRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sete(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SeteRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setg(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetgRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setge(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetgeRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setnge(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetngeRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setle(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetleRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setne(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetneRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setno(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetnoRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setpo(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetpoRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setns(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetnsRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun seto(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetoRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun setp(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetpRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sets(addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SetsRm8.encode(buffer, addressExpression, options, tracer = this)
  }
  fun sha1rnds4(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1rnds4XmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun sha1nexte(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1nexteXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sha1msg1(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1msg1XmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sha1msg2(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha1msg2XmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sha256rnds2Xmm0(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256rnds2XmmXmmm128Xmm0.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sha256msg1(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256msg1XmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sha256msg2(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Sha256msg2XmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun shld(addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm16R16Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shldCl(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm16R16Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shld(addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm32R32Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shld(addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm64R64Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shldCl(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm32R32Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shldCl(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShldRm64R64Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shrd(addressExpression: AddressExpression16, register: GpRegister16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm16R16Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shrdCl(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm16R16Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shrd(addressExpression: AddressExpression32, register: GpRegister32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm32R32Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shrd(addressExpression: AddressExpression64, register: GpRegister64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm64R64Imm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun shrdCl(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm32R32Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shrdCl(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShrdRm64R64Cl.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun shufpd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShufpdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vshufpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpdXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vshufpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpdYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun shufps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    ShufpsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vshufps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpsXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vshufps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VshufpsYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun sqrtpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtpd(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpdYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sqrtps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtpsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sqrtsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun sqrtss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SqrtssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsqrtss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsqrtssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sub(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun sub(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sub(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sub(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun sub(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun subpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsubpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vsubpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun subps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsubps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vsubps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun subsd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubsdXmm0To63Xmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsubsd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubsdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun subss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    SubssXmm0To31Xmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vsubss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VsubssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun test(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TestRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun tzcnt(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun tzcnt(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun tzcnt(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    TzcntR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun ucomisd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UcomisdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vucomisd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VucomisdXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun ucomiss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UcomissXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vucomiss(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VucomissXmmXmmm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun unpckhpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpckhpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vunpckhpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vunpckhpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun unpckhps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpckhpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vunpckhps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vunpckhps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpckhpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun unpcklpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpcklpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vunpcklpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vunpcklpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun unpcklps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    UnpcklpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vunpcklps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vunpcklps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VunpcklpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vcvtph2ps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtph2psXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtph2ps(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtph2psYmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vcvtps2ph(addressExpression: AddressExpression128, register: XmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2phXmmm64XmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vcvtps2ph(addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vcvtps2phXmmm128YmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vextractf128(addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vextractf128Xmmm128YmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vextracti128(addressExpression: AddressExpression128, register: YmmRegister, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vextracti128Xmmm128YmmImm8.encode(buffer, addressExpression, register, immediate, options, tracer = this)
  }
  fun vfmadd132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd132sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd132ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd132ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd213ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd213ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmadd231ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmadd231ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmaddsub231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmaddsub231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsubadd231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsubadd231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub132ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub132ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub213ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub213ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfmsub231ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfmsub231ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd132ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd132ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd213ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd213ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmadd231ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmadd231ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231pd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231pdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231pd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231pdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231ps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231psXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231ps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231psYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231sd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231sdXmmXmmXmmm64.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub132ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub132ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub213ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub213ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vfnmsub231ss(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vfnmsub231ssXmmXmmXmmm32.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vinsertf128(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vinsertf128YmmYmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vinserti128(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vinserti128YmmYmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpblendd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblenddXmmXmmXmmm128Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpblendd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpblenddYmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpbroadcastq(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpbroadcastqXmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vpbroadcastq(register: YmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpbroadcastqYmmXmmm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vperm2f128(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vperm2f128YmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vperm2i128(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    Vperm2i128YmmYmmYmmm256Imm8.encode(buffer, register1, register2, addressExpression, immediate, options, tracer = this)
  }
  fun vpermd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermilpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermilpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermilpd(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpermilpd(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpdYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpermilps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermilps(register: XmmRegister, addressExpression: AddressExpression128, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsXmmXmmm128Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpermilps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermilps(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermilpsYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpermpd(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermpdYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpermps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpermq(register: YmmRegister, addressExpression: AddressExpression256, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpermqYmmYmmm256Imm8.encode(buffer, register, addressExpression, immediate, options, tracer = this)
  }
  fun vpsllvd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllvq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllvd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsllvq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsllvqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsravd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsravdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsravd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsravdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlvd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlvq(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvqXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlvd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vpsrlvq(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VpsrlvqYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vtestps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vtestps(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpsYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vtestpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vtestpd(register: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VtestpdYmmYmmm256.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun xadd(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xadd(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xadd(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xadd(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XaddRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xchg(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xchg(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xchg(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xchg(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XchgRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression8, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm8Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression16, immediate: Short, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16Imm16.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression32, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression64, immediate: Int, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64Imm32.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression16, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression32, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression64, immediate: Byte, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64Imm8.encode(buffer, addressExpression, immediate, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression8, register: GpRegister8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm8R8.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression16, register: GpRegister16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm16R16.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression32, register: GpRegister32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm32R32.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xor(addressExpression: AddressExpression64, register: GpRegister64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorRm64R64.encode(buffer, addressExpression, register, options, tracer = this)
  }
  fun xor(register: GpRegister8, addressExpression: AddressExpression8, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorR8Rm8.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun xor(register: GpRegister16, addressExpression: AddressExpression16, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorR16Rm16.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun xor(register: GpRegister32, addressExpression: AddressExpression32, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorR32Rm32.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun xor(register: GpRegister64, addressExpression: AddressExpression64, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorR64Rm64.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun xorpd(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorpdXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vxorpd(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpdXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vxorpd(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpdYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun xorps(register: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    XorpsXmmXmmm128.encode(buffer, register, addressExpression, options, tracer = this)
  }
  fun vxorps(register1: XmmRegister, register2: XmmRegister, addressExpression: AddressExpression128, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpsXmmXmmXmmm128.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
  fun vxorps(register1: YmmRegister, register2: YmmRegister, addressExpression: AddressExpression256, options: EncodingOptions = EncodingOptions.DEFAULT)  {
    VxorpsYmmYmmYmmm256.encode(buffer, register1, register2, addressExpression, options, tracer = this)
  }
}
