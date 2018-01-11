package kasm.x64

import kasm.Structure

import kasm.x64.GpRegister64.*
import kasm.x64.MmRegister.*
import kasm.x64.XmmRegister.*
import kasm.x64.YmmRegister.*

class CpuState(val includeRip: Boolean = false, val includeRsp: Boolean = false, val includeMxcsr: Boolean = false, val includeRflags: Boolean = false) {

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

    var mm0 by fields.mm0
    var mm1 by fields.mm1
    var mm2 by fields.mm2
    var mm3 by fields.mm3
    var mm4 by fields.mm4
    var mm5 by fields.mm5
    var mm6 by fields.mm6
    var mm7 by fields.mm7

    var zmm0 by fields.zmm0
    var zmm1 by fields.zmm1
    var zmm2 by fields.zmm2
    var zmm3 by fields.zmm3
    var zmm4 by fields.zmm4
    var zmm5 by fields.zmm5
    var zmm6 by fields.zmm6
    var zmm7 by fields.zmm7
    var zmm8 by fields.zmm8
    var zmm9 by fields.zmm9
    var zmm10 by fields.zmm10
    var zmm11 by fields.zmm11
    var zmm12 by fields.zmm12
    var zmm13 by fields.zmm13
    var zmm14 by fields.zmm14
    var zmm15 by fields.zmm15
    var zmm16 by fields.zmm16
    var zmm17 by fields.zmm17
    var zmm18 by fields.zmm18
    var zmm19 by fields.zmm19
    var zmm20 by fields.zmm20
    var zmm21 by fields.zmm21
    var zmm22 by fields.zmm22
    var zmm23 by fields.zmm23
    var zmm24 by fields.zmm24
    var zmm25 by fields.zmm25
    var zmm26 by fields.zmm26
    var zmm27 by fields.zmm27
    var zmm28 by fields.zmm28
    var zmm29 by fields.zmm29
    var zmm30 by fields.zmm30
    var zmm31 by fields.zmm31

    var xmm0 by fields.xmm0
    var xmm1 by fields.xmm1
    var xmm2 by fields.xmm2
    var xmm3 by fields.xmm3
    var xmm4 by fields.xmm4
    var xmm5 by fields.xmm5
    var xmm6 by fields.xmm6
    var xmm7 by fields.xmm7
    var xmm8 by fields.xmm8
    var xmm9 by fields.xmm9
    var xmm10 by fields.xmm10
    var xmm11 by fields.xmm11
    var xmm12 by fields.xmm12
    var xmm13 by fields.xmm13
    var xmm14 by fields.xmm14
    var xmm15 by fields.xmm15

    var ymm0 by fields.ymm0
    var ymm1 by fields.ymm1
    var ymm2 by fields.ymm2
    var ymm3 by fields.ymm3
    var ymm4 by fields.ymm4
    var ymm5 by fields.ymm5
    var ymm6 by fields.ymm6
    var ymm7 by fields.ymm7
    var ymm8 by fields.ymm8
    var ymm9 by fields.ymm9
    var ymm10 by fields.ymm10
    var ymm11 by fields.ymm11
    var ymm12 by fields.ymm12
    var ymm13 by fields.ymm13
    var ymm14 by fields.ymm14
    var ymm15 by fields.ymm15

    var rflags by fields.rflags
    var rip by fields.rip
    var mxcsr by fields.mxcsr

    fun emitRestore(assembler: Assembler) {

        assembler.apply {
            mov(RAX, fields.rax)
            mov(RCX, fields.rcx)
            mov(RDX, fields.rdx)
            mov(RBX, fields.rbx)
            if (includeRsp) {
                mov(RSP, fields.rsp)
            }
            mov(RBP, fields.rbp)
            mov(RSI, fields.rsi)
            mov(RDI, fields.rdi)
            mov(R8, fields.r8)
            mov(R9, fields.r9)
            mov(R10, fields.r10)
            mov(R11, fields.r11)
            mov(R12, fields.r12)
            mov(R13, fields.r13)
            mov(R14, fields.r14)
            mov(R15, fields.r15)

            mov(MM0, fields.mm0)
            mov(MM1, fields.mm1)
            mov(MM2, fields.mm2)
            mov(MM3, fields.mm3)
            mov(MM4, fields.mm4)
            mov(MM5, fields.mm5)
            mov(MM6, fields.mm6)
            mov(MM7, fields.mm7)

            if (CpuId.supportsAvx512) {
                TODO("Implement AVX512")
//                mov(ZMM0, fields.zmm0)
//                mov(ZMM1, fields.zmm1)
//                mov(ZMM2, fields.zmm2)
//                mov(ZMM3, fields.zmm3)
//                mov(ZMM4, fields.zmm4)
//                mov(ZMM5, fields.zmm5)
//                mov(ZMM6, fields.zmm6)
//                mov(ZMM7, fields.zmm7)
//                mov(ZMM8, fields.zmm8)
//                mov(ZMM9, fields.zmm9)
//                mov(ZMM10, fields.zmm10)
//                mov(ZMM11, fields.zmm11)
//                mov(ZMM12, fields.zmm12)
//                mov(ZMM13, fields.zmm13)
//                mov(ZMM14, fields.zmm14)
//                mov(ZMM15, fields.zmm15)
//                mov(ZMM16, fields.zmm16)
//                mov(ZMM17, fields.zmm17)
//                mov(ZMM18, fields.zmm18)
//                mov(ZMM19, fields.zmm19)
//                mov(ZMM20, fields.zmm20)
//                mov(ZMM21, fields.zmm21)
//                mov(ZMM22, fields.zmm22)
//                mov(ZMM23, fields.zmm23)
//                mov(ZMM24, fields.zmm24)
//                mov(ZMM25, fields.zmm25)
//                mov(ZMM26, fields.zmm26)
//                mov(ZMM27, fields.zmm27)
//                mov(ZMM28, fields.zmm28)
//                mov(ZMM29, fields.zmm29)
//                mov(ZMM30, fields.zmm30)
//                mov(ZMM31, fields.zmm31)
            } else if (CpuId.supportsAvx) {
                mov(YMM0, fields.ymm0)
                mov(YMM1, fields.ymm1)
                mov(YMM2, fields.ymm2)
                mov(YMM3, fields.ymm3)
                mov(YMM4, fields.ymm4)
                mov(YMM5, fields.ymm5)
                mov(YMM6, fields.ymm6)
                mov(YMM7, fields.ymm7)
                mov(YMM8, fields.ymm8)
                mov(YMM9, fields.ymm9)
                mov(YMM10, fields.ymm10)
                mov(YMM11, fields.ymm11)
                mov(YMM12, fields.ymm12)
                mov(YMM13, fields.ymm13)
                mov(YMM14, fields.ymm14)
                mov(YMM15, fields.ymm15)
            } else {
                mov(XMM0, fields.xmm0)
                mov(XMM1, fields.xmm1)
                mov(XMM2, fields.xmm2)
                mov(XMM3, fields.xmm3)
                mov(XMM4, fields.xmm4)
                mov(XMM5, fields.xmm5)
                mov(XMM6, fields.xmm6)
                mov(XMM7, fields.xmm7)
                mov(XMM8, fields.xmm8)
                mov(XMM9, fields.xmm9)
                mov(XMM10, fields.xmm10)
                mov(XMM11, fields.xmm11)
                mov(XMM12, fields.xmm12)
                mov(XMM13, fields.xmm13)
                mov(XMM14, fields.xmm14)
                mov(XMM15, fields.xmm15)
            }


            if (includeRip) mov(IpRegister.RIP, fields.rip)
            if (includeMxcsr) mov(MxcsrRegister.MXCSR, fields.mxcsr)
            if (includeRflags) mov(RflagsRegister.RFLAGS, fields.rflags)
        }
    }

    fun emitSave(assembler: Assembler) {

        assembler.apply {
            println(fields.rax.offset)
            mov(fields.rax, RAX)
            mov(fields.rcx, RCX)
            mov(fields.rdx, RDX)
            mov(fields.rbx, RBX)
            if (includeRsp) {
                mov(fields.rsp, RSP)
            }
            mov(fields.rbp, RBP)
            mov(fields.rsi, RSI)
            mov(fields.rdi, RDI)
            mov(fields.r8, R8)
            mov(fields.r9, R9)
            mov(fields.r10, R10)
            mov(fields.r11, R11)
            mov(fields.r12, R12)
            mov(fields.r13, R13)
            mov(fields.r14, R14)
            mov(fields.r15, R15)

            mov(fields.mm0, MM0)
            mov(fields.mm1, MM1)
            mov(fields.mm2, MM2)
            mov(fields.mm3, MM3)
            mov(fields.mm4, MM4)
            mov(fields.mm5, MM5)
            mov(fields.mm6, MM6)
            mov(fields.mm7, MM7)

            if (CpuId.supportsAvx512) {
                TODO("Implement AVX512")
//                mov(fields.zmm0, ZMM0)
//                mov(fields.zmm1, ZMM1)
//                mov(fields.zmm2, ZMM2)
//                mov(fields.zmm3, ZMM3)
//                mov(fields.zmm4, ZMM4)
//                mov(fields.zmm5, ZMM5)
//                mov(fields.zmm6, ZMM6)
//                mov(fields.zmm7, ZMM7)
//                mov(fields.zmm8, ZMM8)
//                mov(fields.zmm9, ZMM9)
//                mov(fields.zmm10, ZMM10)
//                mov(fields.zmm11, ZMM11)
//                mov(fields.zmm12, ZMM12)
//                mov(fields.zmm13, ZMM13)
//                mov(fields.zmm14, ZMM14)
//                mov(fields.zmm15, ZMM15)
//                mov(fields.zmm16, ZMM16)
//                mov(fields.zmm17, ZMM17)
//                mov(fields.zmm18, ZMM18)
//                mov(fields.zmm19, ZMM19)
//                mov(fields.zmm20, ZMM20)
//                mov(fields.zmm21, ZMM21)
//                mov(fields.zmm22, ZMM22)
//                mov(fields.zmm23, ZMM23)
//                mov(fields.zmm24, ZMM24)
//                mov(fields.zmm25, ZMM25)
//                mov(fields.zmm26, ZMM26)
//                mov(fields.zmm27, ZMM27)
//                mov(fields.zmm28, ZMM28)
//                mov(fields.zmm29, ZMM29)
//                mov(fields.zmm30, ZMM30)
//                mov(fields.zmm31, ZMM31)
            } else if (CpuId.supportsAvx) {
                mov(fields.ymm0, YMM0)
                mov(fields.ymm1, YMM1)
                mov(fields.ymm2, YMM2)
                mov(fields.ymm3, YMM3)
                mov(fields.ymm4, YMM4)
                mov(fields.ymm5, YMM5)
                mov(fields.ymm6, YMM6)
                mov(fields.ymm7, YMM7)
                mov(fields.ymm8, YMM8)
                mov(fields.ymm9, YMM9)
                mov(fields.ymm10, YMM10)
                mov(fields.ymm11, YMM11)
                mov(fields.ymm12, YMM12)
                mov(fields.ymm13, YMM13)
                mov(fields.ymm14, YMM14)
                mov(fields.ymm15, YMM15)
            } else {
                mov(fields.xmm0, XMM0)
                mov(fields.xmm1, XMM1)
                mov(fields.xmm2, XMM2)
                mov(fields.xmm3, XMM3)
                mov(fields.xmm4, XMM4)
                mov(fields.xmm5, XMM5)
                mov(fields.xmm6, XMM6)
                mov(fields.xmm7, XMM7)
                mov(fields.xmm8, XMM8)
                mov(fields.xmm9, XMM9)
                mov(fields.xmm10, XMM10)
                mov(fields.xmm11, XMM11)
                mov(fields.xmm12, XMM12)
                mov(fields.xmm13, XMM13)
                mov(fields.xmm14, XMM14)
                mov(fields.xmm15, XMM15)
            }

            if (includeRip) mov(fields.rip, IpRegister.RIP)
            if (includeMxcsr) mov(fields.mxcsr, MxcsrRegister.MXCSR)
            if (includeRflags) mov(fields.rflags, RflagsRegister.RFLAGS)
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
        if(includeRsp) if (rsp != other.rsp) return false
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
        if(includeRsp) result *= 31 * rsp.toInt()
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

        if(includeRip) result *= 31 * rip.toInt()
        if(includeMxcsr) result *= 31 * mxcsr
        if(includeRflags) result *= 31 * rflags.toInt()

        return result
    }


}