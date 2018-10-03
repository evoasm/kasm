package kasm.x64

import kasm.Structure

import kasm.x64.GpRegister64.*
import kasm.x64.MmRegister.*
import kasm.x64.XmmRegister.*
import kasm.x64.YmmRegister.*

class CpuState(val includeRip: Boolean = false,
               val includeRsp: Boolean = false,
               val includeMxcsr: Boolean = false,
               val includeRflags: Boolean = false) {

    companion object {
        private val SCRATCH_REGISTERS = listOf(R14, R15)
    }

    class Fields : Structure() {

        val rax = longField()
        val rcx = longField()
        val rdx = longField()
        val rbx = longField()
        val rsp = longField()
        val rbp = longField()
        val rsi = longField()
        val rdi = longField()
        val r8 = longField()
        val r9 = longField()
        val r10 = longField()
        val r11 = longField()
        val r12 = longField()
        val r13 = longField()
        val r14 = longField()
        val r15 = longField()

        val al = byteField(alias = rax)
        val ah = byteField(alias = rax, aliasOffset = 1)
        val cl = byteField(alias = rcx)
        val ch = byteField(alias = rcx, aliasOffset = 1)
        val dl = byteField(alias = rdx)
        val dh = byteField(alias = rdx, aliasOffset = 1)
        val bl = byteField(alias = rbx)
        val bh = byteField(alias = rbx, aliasOffset = 1)
        val spl = byteField(alias = rsp)
        val bpl = byteField(alias = rbp)
        val sil = byteField(alias = rsi)
        val dil = byteField(alias = rdi)
        val r8b = byteField(alias = r8)
        val r9b = byteField(alias = r9)
        val r10b = byteField(alias = r10)
        val r11b = byteField(alias = r11)
        val r12b = byteField(alias = r12)
        val r13b = byteField(alias = r13)
        val r14b = byteField(alias = r14)

        val ax = shortField(alias = rax)
        val cx = shortField(alias = rcx)
        val dx = shortField(alias = rdx)
        val bx = shortField(alias = rbx)
        val sp = shortField(alias = rsp)
        val bp = shortField(alias = rbp)
        val si = shortField(alias = rsi)
        val di = shortField(alias = rdi)
        val r8w = shortField(alias = r8)
        val r9w = shortField(alias = r9)
        val r10w = shortField(alias = r10)
        val r11w = shortField(alias = r11)
        val r12w = shortField(alias = r12)
        val r13w = shortField(alias = r13)
        val r14w = shortField(alias = r14)
        val r15w = shortField(alias = r15)

        val eax = intField(alias = rax)
        val ecx = intField(alias = rcx)
        val edx = intField(alias = rdx)
        val ebx = intField(alias = rbx)
        val esp = intField(alias = rsp)
        val ebp = intField(alias = rbp)
        val esi = intField(alias = rsi)
        val edi = intField(alias = rdi)
        val r8d = intField(alias = r8)
        val r9d = intField(alias = r9)
        val r10d = intField(alias = r10)
        val r11d = intField(alias = r11)
        val r12d = intField(alias = r12)
        val r13d = intField(alias = r13)
        val r14d = intField(alias = r14)
        val r15d = intField(alias = r15)

        val mm0 = vector64Field(alignment = 8)
        val mm1 = vector64Field(alignment = 8)
        val mm2 = vector64Field(alignment = 8)
        val mm3 = vector64Field(alignment = 8)
        val mm4 = vector64Field(alignment = 8)
        val mm5 = vector64Field(alignment = 8)
        val mm6 = vector64Field(alignment = 8)
        val mm7 = vector64Field(alignment = 8)

        val zmm0 = vector512Field(alignment = 32)
        val zmm1 = vector512Field(alignment = 32)
        val zmm2 = vector512Field(alignment = 32)
        val zmm3 = vector512Field(alignment = 32)
        val zmm4 = vector512Field(alignment = 32)
        val zmm5 = vector512Field(alignment = 32)
        val zmm6 = vector512Field(alignment = 32)
        val zmm7 = vector512Field(alignment = 32)
        val zmm8 = vector512Field(alignment = 32)
        val zmm9 = vector512Field(alignment = 32)
        val zmm10 = vector512Field(alignment = 32)
        val zmm11 = vector512Field(alignment = 32)
        val zmm12 = vector512Field(alignment = 32)
        val zmm13 = vector512Field(alignment = 32)
        val zmm14 = vector512Field(alignment = 32)
        val zmm15 = vector512Field(alignment = 32)
        val zmm16 = vector512Field(alignment = 32)
        val zmm17 = vector512Field(alignment = 32)
        val zmm18 = vector512Field(alignment = 32)
        val zmm19 = vector512Field(alignment = 32)
        val zmm20 = vector512Field(alignment = 32)
        val zmm21 = vector512Field(alignment = 32)
        val zmm22 = vector512Field(alignment = 32)
        val zmm23 = vector512Field(alignment = 32)
        val zmm24 = vector512Field(alignment = 32)
        val zmm25 = vector512Field(alignment = 32)
        val zmm26 = vector512Field(alignment = 32)
        val zmm27 = vector512Field(alignment = 32)
        val zmm28 = vector512Field(alignment = 32)
        val zmm29 = vector512Field(alignment = 32)
        val zmm30 = vector512Field(alignment = 32)
        val zmm31 = vector512Field(alignment = 32)

        val xmm0 = vector128Field(alias = zmm0)
        val xmm1 = vector128Field(alias = zmm1)
        val xmm2 = vector128Field(alias = zmm2)
        val xmm3 = vector128Field(alias = zmm3)
        val xmm4 = vector128Field(alias = zmm4)
        val xmm5 = vector128Field(alias = zmm5)
        val xmm6 = vector128Field(alias = zmm6)
        val xmm7 = vector128Field(alias = zmm7)
        val xmm8 = vector128Field(alias = zmm8)
        val xmm9 = vector128Field(alias = zmm9)
        val xmm10 = vector128Field(alias = zmm10)
        val xmm11 = vector128Field(alias = zmm11)
        val xmm12 = vector128Field(alias = zmm12)
        val xmm13 = vector128Field(alias = zmm13)
        val xmm14 = vector128Field(alias = zmm14)
        val xmm15 = vector128Field(alias = zmm15)

        val ymm0 = vector256Field(alias = zmm0)
        val ymm1 = vector256Field(alias = zmm1)
        val ymm2 = vector256Field(alias = zmm2)
        val ymm3 = vector256Field(alias = zmm3)
        val ymm4 = vector256Field(alias = zmm4)
        val ymm5 = vector256Field(alias = zmm5)
        val ymm6 = vector256Field(alias = zmm6)
        val ymm7 = vector256Field(alias = zmm7)
        val ymm8 = vector256Field(alias = zmm8)
        val ymm9 = vector256Field(alias = zmm9)
        val ymm10 = vector256Field(alias = zmm10)
        val ymm11 = vector256Field(alias = zmm11)
        val ymm12 = vector256Field(alias = zmm12)
        val ymm13 = vector256Field(alias = zmm13)
        val ymm14 = vector256Field(alias = zmm14)
        val ymm15 = vector256Field(alias = zmm15)

        val rflags = longField()
        val rip = longField()
        val mxcsr = intField()

    }

    private val fields = Fields()

    var rax by fields.rax
    var rcx by fields.rcx
    var rdx by fields.rdx
    var rbx by fields.rbx
    var rsp by fields.rsp
    var rbp by fields.rbp
    var rsi by fields.rsi
    var rdi by fields.rdi
    var r8 by fields.r8
    var r9 by fields.r9
    var r10 by fields.r10
    var r11 by fields.r11
    var r12 by fields.r12
    var r13 by fields.r13
    var r14 by fields.r14
    var r15 by fields.r15

    var al by fields.al
    var ah by fields.ah
    var cl by fields.cl
    var ch by fields.ch
    var dl by fields.dl
    var dh by fields.dh
    var bl by fields.bl
    var bh by fields.bh
    var spl by fields.spl
    var bpl by fields.bpl
    var sil by fields.sil
    var dil by fields.dil
    var r8b by fields.r8b
    var r9b by fields.r9b
    var r10b by fields.r10b
    var r11b by fields.r11b
    var r12b by fields.r12b
    var r13b by fields.r13b
    var r14b by fields.r14b

    var ax by fields.ax
    var cx by fields.cx
    var dx by fields.dx
    var bx by fields.bx
    var sp by fields.sp
    var bp by fields.bp
    var si by fields.si
    var di by fields.di
    var r8w by fields.r8w
    var r9w by fields.r9w
    var r10w by fields.r10w
    var r11w by fields.r11w
    var r12w by fields.r12w
    var r13w by fields.r13w
    var r14w by fields.r14w
    var r15w by fields.r15w

    var eax by fields.eax
    var ecx by fields.ecx
    var edx by fields.edx
    var ebx by fields.ebx
    var esp by fields.esp
    var ebp by fields.ebp
    var esi by fields.esi
    var edi by fields.edi
    var r8d by fields.r8d
    var r9d by fields.r9d
    var r10d by fields.r10d
    var r11d by fields.r11d
    var r12d by fields.r12d
    var r13d by fields.r13d
    var r14d by fields.r14d
    var r15d by fields.r15d

    val mm0 = fields.mm0
    val mm1 = fields.mm1
    val mm2 = fields.mm2
    val mm3 = fields.mm3
    val mm4 = fields.mm4
    val mm5 = fields.mm5
    val mm6 = fields.mm6
    val mm7 = fields.mm7

    val zmm0 = fields.zmm0
    val zmm1 = fields.zmm1
    val zmm2 = fields.zmm2
    val zmm3 = fields.zmm3
    val zmm4 = fields.zmm4
    val zmm5 = fields.zmm5
    val zmm6 = fields.zmm6
    val zmm7 = fields.zmm7
    val zmm8 = fields.zmm8
    val zmm9 = fields.zmm9
    val zmm10 = fields.zmm10
    val zmm11 = fields.zmm11
    val zmm12 = fields.zmm12
    val zmm13 = fields.zmm13
    val zmm14 = fields.zmm14
    val zmm15 = fields.zmm15
    val zmm16 = fields.zmm16
    val zmm17 = fields.zmm17
    val zmm18 = fields.zmm18
    val zmm19 = fields.zmm19
    val zmm20 = fields.zmm20
    val zmm21 = fields.zmm21
    val zmm22 = fields.zmm22
    val zmm23 = fields.zmm23
    val zmm24 = fields.zmm24
    val zmm25 = fields.zmm25
    val zmm26 = fields.zmm26
    val zmm27 = fields.zmm27
    val zmm28 = fields.zmm28
    val zmm29 = fields.zmm29
    val zmm30 = fields.zmm30
    val zmm31 = fields.zmm31

    val xmm0 = fields.xmm0
    val xmm1 = fields.xmm1
    val xmm2 = fields.xmm2
    val xmm3 = fields.xmm3
    val xmm4 = fields.xmm4
    val xmm5 = fields.xmm5
    val xmm6 = fields.xmm6
    val xmm7 = fields.xmm7
    val xmm8 = fields.xmm8
    val xmm9 = fields.xmm9
    val xmm10 = fields.xmm10
    val xmm11 = fields.xmm11
    val xmm12 = fields.xmm12
    val xmm13 = fields.xmm13
    val xmm14 = fields.xmm14
    val xmm15 = fields.xmm15

    val ymm0 = fields.ymm0
    val ymm1 = fields.ymm1
    val ymm2 = fields.ymm2
    val ymm3 = fields.ymm3
    val ymm4 = fields.ymm4
    val ymm5 = fields.ymm5
    val ymm6 = fields.ymm6
    val ymm7 = fields.ymm7
    val ymm8 = fields.ymm8
    val ymm9 = fields.ymm9
    val ymm10 = fields.ymm10
    val ymm11 = fields.ymm11
    val ymm12 = fields.ymm12
    val ymm13 = fields.ymm13
    val ymm14 = fields.ymm14
    val ymm15 = fields.ymm15

    var rflags by fields.rflags
    var rip by fields.rip
    var mxcsr by fields.mxcsr

    fun emitRestore(assembler: Assembler) {

        assembler.apply {


                load(fields.mm0.address, MM0, R14)
                load(fields.mm1.address, MM1, R14)
                load(fields.mm2.address, MM2, R14)
                load(fields.mm3.address, MM3, R14)
                load(fields.mm4.address, MM4, R14)
                load(fields.mm5.address, MM5, R14)
                load(fields.mm6.address, MM6, R14)
                load(fields.mm7.address, MM7, R14)

                if (CpuId.supportsAvx512) {
                    TODO("Implement AVX512")
//                load(fields.zmm0.address, ZMM0)
//                load(fields.zmm1.address, ZMM1)
//                load(fields.zmm2.address, ZMM2)
//                load(fields.zmm3.address, ZMM3)
//                load(fields.zmm4.address, ZMM4)
//                load(fields.zmm5.address, ZMM5)
//                load(fields.zmm6.address, ZMM6)
//                load(fields.zmm7.address, ZMM7)
//                load(fields.zmm8.address, ZMM8)
//                load(fields.zmm9.address, ZMM9)
//                load(fields.zmm10.address, ZMM10)
//                load(fields.zmm11.address, ZMM11)
//                load(fields.zmm12.address, ZMM12)
//                load(fields.zmm13.address, ZMM13)
//                load(fields.zmm14.address, ZMM14)
//                load(fields.zmm15.address, ZMM15)
//                load(fields.zmm16.address, ZMM16)
//                load(fields.zmm17.address, ZMM17)
//                load(fields.zmm18.address, ZMM18)
//                load(fields.zmm19.address, ZMM19)
//                load(fields.zmm20.address, ZMM20)
//                load(fields.zmm21.address, ZMM21)
//                load(fields.zmm22.address, ZMM22)
//                load(fields.zmm23.address, ZMM23)
//                load(fields.zmm24.address, ZMM24)
//                load(fields.zmm25.address, ZMM25)
//                load(fields.zmm26.address, ZMM26)
//                load(fields.zmm27.address, ZMM27)
//                load(fields.zmm28.address, ZMM28)
//                load(fields.zmm29.address, ZMM29)
//                load(fields.zmm30.address, ZMM30)
//                load(fields.zmm31.address, ZMM31)
                } else if (CpuId.supportsAvx) {
                    load(fields.ymm0.address, YMM0, R14)
                    load(fields.ymm1.address, YMM1, R14)
                    load(fields.ymm2.address, YMM2, R14)
                    load(fields.ymm3.address, YMM3, R14)
                    load(fields.ymm4.address, YMM4, R14)
                    load(fields.ymm5.address, YMM5, R14)
                    load(fields.ymm6.address, YMM6, R14)
                    load(fields.ymm7.address, YMM7, R14)
                    load(fields.ymm8.address, YMM8, R14)
                    load(fields.ymm9.address, YMM9, R14)
                    load(fields.ymm10.address, YMM10, R14)
                    load(fields.ymm11.address, YMM11, R14)
                    load(fields.ymm12.address, YMM12, R14)
                    load(fields.ymm13.address, YMM13, R14)
                    load(fields.ymm14.address, YMM14, R14)
                    load(fields.ymm15.address, YMM15, R14)
                } else {
                    load(fields.xmm0.address, XMM0, R14)
                    load(fields.xmm1.address, XMM1, R14)
                    load(fields.xmm2.address, XMM2, R14)
                    load(fields.xmm3.address, XMM3, R14)
                    load(fields.xmm4.address, XMM4, R14)
                    load(fields.xmm5.address, XMM5, R14)
                    load(fields.xmm6.address, XMM6, R14)
                    load(fields.xmm7.address, XMM7, R14)
                    load(fields.xmm8.address, XMM8, R14)
                    load(fields.xmm9.address, XMM9, R14)
                    load(fields.xmm10.address, XMM10, R14)
                    load(fields.xmm11.address, XMM11, R14)
                    load(fields.xmm12.address, XMM12, R14)
                    load(fields.xmm13.address, XMM13, R14)
                    load(fields.xmm14.address, XMM14, R14)
                    load(fields.xmm15.address, XMM15, R14)
                }

                if (includeMxcsr) load(fields.mxcsr.address, MxcsrRegister.MXCSR, R14)
                if (includeRflags) load(fields.rflags.address, RflagsRegister.RFLAGS, R14, R15)

                load(fields.rax.address, RAX, R14)
                load(fields.rcx.address, RCX, R14)
                load(fields.rdx.address, RDX, R14)
                load(fields.rbx.address, RBX, R14)
                if (includeRsp) {
                    load(fields.rsp.address, RSP, R14)
                }
                load(fields.rbp.address, RBP, R14)
                load(fields.rsi.address, RSI, R14)
                load(fields.rdi.address, RDI, R14)
                load(fields.r8.address, R8, R14)
                load(fields.r9.address, R9, R14)
                load(fields.r10.address, R10, R14)
                load(fields.r11.address, R11, R14)
                load(fields.r12.address, R12, R14)
                load(fields.r13.address, R13, R14)

                load(fields.r14.address, R14, R15)

                pushed(R14) {
                    load(fields.r15.address, R15, R14)
                }

                if (includeRip) load(fields.rip.address, IpRegister.RIP)
            }
    }

    fun emitSave(assembler: Assembler) {

        assembler.apply {
            pushed(R14) {
                store(fields.r15.address, R15, R14)
            }
            pushed(R15) {
                store(fields.r14.address, R14, R15)
            }
            pushed(R14, R15) {
                store(fields.r13.address, R13, R14)
                store(fields.r12.address, R12, R14)
                store(fields.r11.address, R11, R14)
                store(fields.r10.address, R10, R14)
                store(fields.r9.address, R9, R14)
                store(fields.r8.address, R8, R14)
                store(fields.rdi.address, RDI, R14)
                store(fields.rsi.address, RSI, R14)
                store(fields.rbp.address, RBP, R14)
                if (includeRsp) {
                    // FIXME: we modified the stack.address, so what's the point of this?
                    store(fields.rsp.address, RSP, R14)
                }
                store(fields.rbx.address, RBX, R14)
                store(fields.rdx.address, RDX, R14)
                store(fields.rcx.address, RCX, R14)
                store(fields.rax.address, RAX, R14)

                store(fields.mm0.address, MM0, R14)
                store(fields.mm1.address, MM1, R14)
                store(fields.mm2.address, MM2, R14)
                store(fields.mm3.address, MM3, R14)
                store(fields.mm4.address, MM4, R14)
                store(fields.mm5.address, MM5, R14)
                store(fields.mm6.address, MM6, R14)
                store(fields.mm7.address, MM7, R14)

                if (CpuId.supportsAvx512) {
                    TODO("Implement AVX512")
//                store(fields.zmm0.address, ZMM0)
//                store(fields.zmm1.address, ZMM1)
//                store(fields.zmm2.address, ZMM2)
//                store(fields.zmm3.address, ZMM3)
//                store(fields.zmm4.address, ZMM4)
//                store(fields.zmm5.address, ZMM5)
//                store(fields.zmm6.address, ZMM6)
//                store(fields.zmm7.address, ZMM7)
//                store(fields.zmm8.address, ZMM8)
//                store(fields.zmm9.address, ZMM9)
//                store(fields.zmm10.address, ZMM10)
//                store(fields.zmm11.address, ZMM11)
//                store(fields.zmm12.address, ZMM12)
//                store(fields.zmm13.address, ZMM13)
//                store(fields.zmm14.address, ZMM14)
//                store(fields.zmm15.address, ZMM15)
//                store(fields.zmm16.address, ZMM16)
//                store(fields.zmm17.address, ZMM17)
//                store(fields.zmm18.address, ZMM18)
//                store(fields.zmm19.address, ZMM19)
//                store(fields.zmm20.address, ZMM20)
//                store(fields.zmm21.address, ZMM21)
//                store(fields.zmm22.address, ZMM22)
//                store(fields.zmm23.address, ZMM23)
//                store(fields.zmm24.address, ZMM24)
//                store(fields.zmm25.address, ZMM25)
//                store(fields.zmm26.address, ZMM26)
//                store(fields.zmm27.address, ZMM27)
//                store(fields.zmm28.address, ZMM28)
//                store(fields.zmm29.address, ZMM29)
//                store(fields.zmm30.address, ZMM30)
//                store(fields.zmm31.address, ZMM31)
                } else if (CpuId.supportsAvx) {
                    store(fields.ymm0.address, YMM0, R14)
                    store(fields.ymm1.address, YMM1, R14)
                    store(fields.ymm2.address, YMM2, R14)
                    store(fields.ymm3.address, YMM3, R14)
                    store(fields.ymm4.address, YMM4, R14)
                    store(fields.ymm5.address, YMM5, R14)
                    store(fields.ymm6.address, YMM6, R14)
                    store(fields.ymm7.address, YMM7, R14)
                    store(fields.ymm8.address, YMM8, R14)
                    store(fields.ymm9.address, YMM9, R14)
                    store(fields.ymm10.address, YMM10, R14)
                    store(fields.ymm11.address, YMM11, R14)
                    store(fields.ymm12.address, YMM12, R14)
                    store(fields.ymm13.address, YMM13, R14)
                    store(fields.ymm14.address, YMM14, R14)
                    store(fields.ymm15.address, YMM15, R14)
                } else {
                    store(fields.xmm0.address, XMM0, R14)
                    store(fields.xmm1.address, XMM1, R14)
                    store(fields.xmm2.address, XMM2, R14)
                    store(fields.xmm3.address, XMM3, R14)
                    store(fields.xmm4.address, XMM4, R14)
                    store(fields.xmm5.address, XMM5, R14)
                    store(fields.xmm6.address, XMM6, R14)
                    store(fields.xmm7.address, XMM7, R14)
                    store(fields.xmm8.address, XMM8, R14)
                    store(fields.xmm9.address, XMM9, R14)
                    store(fields.xmm10.address, XMM10, R14)
                    store(fields.xmm11.address, XMM11, R14)
                    store(fields.xmm12.address, XMM12, R14)
                    store(fields.xmm13.address, XMM13, R14)
                    store(fields.xmm14.address, XMM14, R14)
                    store(fields.xmm15.address, XMM15, R14)
                }

                if (includeRip) store(fields.rip.address, IpRegister.RIP, R14, R15)
                if (includeMxcsr) store(fields.mxcsr.address, MxcsrRegister.MXCSR, R15)
                if (includeRflags) store(fields.rflags.address, RflagsRegister.RFLAGS, R14, R15)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CpuState

        if (rax != other.rax) return false
        if (rcx != other.rcx) return false
        if (rdx != other.rdx) return false
        if (rbx != other.rbx) return false
        if (includeRsp) if (rsp != other.rsp) return false
        if (rbp != other.rbp) return false
        if (rsi != other.rsi) return false
        if (rdi != other.rdi) return false
        if (r8 != other.r8) return false
        if (r9 != other.r9) return false
        if (r10 != other.r10) return false
        if (r11 != other.r11) return false
        if (r12 != other.r12) return false
        if (r13 != other.r13) return false
        if (r14 != other.r14) return false
        if (r15 != other.r15) return false

        if (mm0 != other.mm0) return false
        if (mm1 != other.mm1) return false
        if (mm2 != other.mm2) return false
        if (mm3 != other.mm3) return false
        if (mm4 != other.mm4) return false
        if (mm5 != other.mm5) return false
        if (mm6 != other.mm6) return false
        if (mm7 != other.mm7) return false

        if (CpuId.supportsAvx512) {
            if (zmm0 != other.zmm0) return false
            if (zmm1 != other.zmm1) return false
            if (zmm2 != other.zmm2) return false
            if (zmm3 != other.zmm3) return false
            if (zmm4 != other.zmm4) return false
            if (zmm5 != other.zmm5) return false
            if (zmm6 != other.zmm6) return false
            if (zmm7 != other.zmm7) return false
            if (zmm8 != other.zmm8) return false
            if (zmm9 != other.zmm9) return false
            if (zmm10 != other.zmm10) return false
            if (zmm11 != other.zmm11) return false
            if (zmm12 != other.zmm12) return false
            if (zmm13 != other.zmm13) return false
            if (zmm14 != other.zmm14) return false
            if (zmm15 != other.zmm15) return false
            if (zmm16 != other.zmm16) return false
            if (zmm17 != other.zmm17) return false
            if (zmm18 != other.zmm18) return false
            if (zmm19 != other.zmm19) return false
            if (zmm20 != other.zmm20) return false
            if (zmm21 != other.zmm21) return false
            if (zmm22 != other.zmm22) return false
            if (zmm23 != other.zmm23) return false
            if (zmm24 != other.zmm24) return false
            if (zmm25 != other.zmm25) return false
            if (zmm26 != other.zmm26) return false
            if (zmm27 != other.zmm27) return false
            if (zmm28 != other.zmm28) return false
            if (zmm29 != other.zmm29) return false
            if (zmm30 != other.zmm30) return false
            if (zmm31 != other.zmm31) return false
        } else if (CpuId.supportsAvx) {
            if (ymm0 != other.ymm0) return false
            if (ymm1 != other.ymm1) return false
            if (ymm2 != other.ymm2) return false
            if (ymm3 != other.ymm3) return false
            if (ymm4 != other.ymm4) return false
            if (ymm5 != other.ymm5) return false
            if (ymm6 != other.ymm6) return false
            if (ymm7 != other.ymm7) return false
            if (ymm8 != other.ymm8) return false
            if (ymm9 != other.ymm9) return false
            if (ymm10 != other.ymm10) return false
            if (ymm11 != other.ymm11) return false
            if (ymm12 != other.ymm12) return false
            if (ymm13 != other.ymm13) return false
            if (ymm14 != other.ymm14) return false
            if (ymm15 != other.ymm15) return false
        } else {
            if (xmm0 != other.xmm0) return false
            if (xmm1 != other.xmm1) return false
            if (xmm2 != other.xmm2) return false
            if (xmm3 != other.xmm3) return false
            if (xmm4 != other.xmm4) return false
            if (xmm5 != other.xmm5) return false
            if (xmm6 != other.xmm6) return false
            if (xmm7 != other.xmm7) return false
            if (xmm8 != other.xmm8) return false
            if (xmm9 != other.xmm9) return false
            if (xmm10 != other.xmm10) return false
            if (xmm11 != other.xmm11) return false
            if (xmm12 != other.xmm12) return false
            if (xmm13 != other.xmm13) return false
            if (xmm14 != other.xmm14) return false
            if (xmm15 != other.xmm15) return false
        }
        if (includeRip && rip != other.rip) return false
        if (includeMxcsr && mxcsr != other.mxcsr) return false
        if (includeRflags && rflags != other.rflags) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 0

        result *= 31 * rax.toInt()
        result *= 31 * rax.toInt()
        result *= 31 * rcx.toInt()
        result *= 31 * rdx.toInt()
        result *= 31 * rbx.toInt()
        if (includeRsp) result *= 31 * rsp.toInt()
        result *= 31 * rbp.toInt()
        result *= 31 * rsi.toInt()
        result *= 31 * rdi.toInt()
        result *= 31 * r8.toInt()
        result *= 31 * r9.toInt()
        result *= 31 * r10.toInt()
        result *= 31 * r11.toInt()
        result *= 31 * r12.toInt()
        result *= 31 * r13.toInt()
        result *= 31 * r14.toInt()
        result *= 31 * r15.toInt()

        result *= 31 * mm0.hashCode()
        result *= 31 * mm1.hashCode()
        result *= 31 * mm2.hashCode()
        result *= 31 * mm3.hashCode()
        result *= 31 * mm4.hashCode()
        result *= 31 * mm5.hashCode()
        result *= 31 * mm6.hashCode()
        result *= 31 * mm7.hashCode()

        if (CpuId.supportsAvx512) {
            TODO("Implement AVX512")
            result *= 31 * zmm0.hashCode()
            result *= 31 * zmm1.hashCode()
            result *= 31 * zmm2.hashCode()
            result *= 31 * zmm3.hashCode()
            result *= 31 * zmm4.hashCode()
            result *= 31 * zmm5.hashCode()
            result *= 31 * zmm6.hashCode()
            result *= 31 * zmm7.hashCode()
            result *= 31 * zmm8.hashCode()
            result *= 31 * zmm9.hashCode()
            result *= 31 * zmm10.hashCode()
            result *= 31 * zmm11.hashCode()
            result *= 31 * zmm12.hashCode()
            result *= 31 * zmm13.hashCode()
            result *= 31 * zmm14.hashCode()
            result *= 31 * zmm15.hashCode()
            result *= 31 * zmm16.hashCode()
            result *= 31 * zmm17.hashCode()
            result *= 31 * zmm18.hashCode()
            result *= 31 * zmm19.hashCode()
            result *= 31 * zmm20.hashCode()
            result *= 31 * zmm21.hashCode()
            result *= 31 * zmm22.hashCode()
            result *= 31 * zmm23.hashCode()
            result *= 31 * zmm24.hashCode()
            result *= 31 * zmm25.hashCode()
            result *= 31 * zmm26.hashCode()
            result *= 31 * zmm27.hashCode()
            result *= 31 * zmm28.hashCode()
            result *= 31 * zmm29.hashCode()
            result *= 31 * zmm30.hashCode()
            result *= 31 * zmm31.hashCode()
        } else if (CpuId.supportsAvx) {
            result *= 31 * ymm0.hashCode()
            result *= 31 * ymm1.hashCode()
            result *= 31 * ymm2.hashCode()
            result *= 31 * ymm3.hashCode()
            result *= 31 * ymm4.hashCode()
            result *= 31 * ymm5.hashCode()
            result *= 31 * ymm6.hashCode()
            result *= 31 * ymm7.hashCode()
            result *= 31 * ymm8.hashCode()
            result *= 31 * ymm9.hashCode()
            result *= 31 * ymm10.hashCode()
            result *= 31 * ymm11.hashCode()
            result *= 31 * ymm12.hashCode()
            result *= 31 * ymm13.hashCode()
            result *= 31 * ymm14.hashCode()
            result *= 31 * ymm15.hashCode()
        } else {
            result *= 31 * xmm0.hashCode()
            result *= 31 * xmm1.hashCode()
            result *= 31 * xmm2.hashCode()
            result *= 31 * xmm3.hashCode()
            result *= 31 * xmm4.hashCode()
            result *= 31 * xmm5.hashCode()
            result *= 31 * xmm6.hashCode()
            result *= 31 * xmm7.hashCode()
            result *= 31 * xmm8.hashCode()
            result *= 31 * xmm9.hashCode()
            result *= 31 * xmm10.hashCode()
            result *= 31 * xmm11.hashCode()
            result *= 31 * xmm12.hashCode()
            result *= 31 * xmm13.hashCode()
            result *= 31 * xmm14.hashCode()
            result *= 31 * xmm15.hashCode()
        }

        if (includeRip) result *= 31 * rip.toInt()
        if (includeMxcsr) result *= 31 * mxcsr
        if (includeRflags) result *= 31 * rflags.toInt()

        return result
    }


}