package kasm.x64

import kasm.ByteBuffers
import kasm.toArray
import org.junit.jupiter.api.Test
import kotlin.test.*

import kasm.x64.GpRegister8.*
import kasm.x64.GpRegister16.*
import kasm.x64.GpRegister32.*
import kasm.x64.GpRegister64.*
import kasm.x64.XmmRegister.*
import kasm.x64.YmmRegister.*

import org.junit.jupiter.api.BeforeEach
import java.nio.ByteBuffer

internal class EncodingTest {

    fun assertDisassemblesTo(expectedDisassembly: String, code: ByteArray) {
        val actualDisassembly = disassemble(code)
        assertEquals(expectedDisassembly, actualDisassembly)
    }

    fun assertAssemblesTo(expectedBytes: List<Int>, code: ByteArray) {
        assertEquals(expectedBytes.map { it.toByte() }, code.slice(0 until expectedBytes.size))
    }

    private fun disassemble(code: ByteArray) = Disassembler.disassemble(code)[0].joinToString(" ")

    private lateinit var buffer: ByteBuffer

    @BeforeEach
    fun setup() {
        buffer = ByteBuffers.allocateLittleEndian(1024)
    }

    @Test
    fun direct64() {
        AddR64Rm64.encode(buffer, RAX, RBX)
        assertDisassemblesTo("add rax, rbx", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, RAX, RBX)
        assertDisassemblesTo("add rax, rbx", buffer.toArray())


        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, R12)
        assertDisassemblesTo("add rax, r12", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, RAX, R12)
        assertDisassemblesTo("add rax, r12", buffer.toArray())


        buffer.clear()
        AddR64Rm64.encode(buffer, R11, RBX)
        assertDisassemblesTo("add r11, rbx", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, R11, RBX)
        assertDisassemblesTo("add r11, rbx", buffer.toArray())


        buffer.clear()
        AddR64Rm64.encode(buffer, R11, R12)
        assertDisassemblesTo("add r11, r12", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, R11, R12)
        assertDisassemblesTo("add r11, r12", buffer.toArray())
    }

    @Test
    fun direct32() {
        AddR32Rm32.encode(buffer, EAX, EBX)
        assertDisassemblesTo("add eax, ebx", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, EAX, EBX)
        assertDisassemblesTo("add eax, ebx", buffer.toArray())


        buffer.clear()
        AddR32Rm32.encode(buffer, EAX, R12D)
        assertDisassemblesTo("add eax, r12d", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, EAX, R12D)
        assertDisassemblesTo("add eax, r12d", buffer.toArray())


        buffer.clear()
        AddR32Rm32.encode(buffer, R11D, EBX)
        assertDisassemblesTo("add r11d, ebx", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, R11D, EBX)
        assertDisassemblesTo("add r11d, ebx", buffer.toArray())


        buffer.clear()
        AddR32Rm32.encode(buffer, R11D, R12D)
        assertDisassemblesTo("add r11d, r12d", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, R11D, R12D)
        assertDisassemblesTo("add r11d, r12d", buffer.toArray())
    }

    @Test
    fun direct16() {
        AddR16Rm16.encode(buffer, AX, BX)
        assertDisassemblesTo("add ax, bx", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, AX, BX)
        assertDisassemblesTo("add ax, bx", buffer.toArray())


        buffer.clear()
        AddR16Rm16.encode(buffer, AX, R12W)
        assertDisassemblesTo("add ax, r12w", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, AX, R12W)
        assertDisassemblesTo("add ax, r12w", buffer.toArray())


        buffer.clear()
        AddR16Rm16.encode(buffer, R11W, BX)
        assertDisassemblesTo("add r11w, bx", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, R11W, BX)
        assertDisassemblesTo("add r11w, bx", buffer.toArray())


        buffer.clear()
        AddR16Rm16.encode(buffer, R11W, R12W)
        assertDisassemblesTo("add r11w, r12w", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, R11W, R12W)
        assertDisassemblesTo("add r11w, r12w", buffer.toArray())
    }

    @Test
    fun direct8() {
        AddR8Rm8.encode(buffer, AL, BL)
        assertDisassemblesTo("add al, bl", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, AL, BL)
        assertDisassemblesTo("add al, bl", buffer.toArray())


        buffer.clear()
        AddR8Rm8.encode(buffer, AH, BL)
        assertDisassemblesTo("add ah, bl", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, AH, BL)
        assertDisassemblesTo("add ah, bl", buffer.toArray())


        buffer.clear()
        AddR8Rm8.encode(buffer, AH, BH)
        assertDisassemblesTo("add ah, bh", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, AH, BH)
        assertDisassemblesTo("add ah, bh", buffer.toArray())


        buffer.clear()
        AddR8Rm8.encode(buffer, AL, BH)
        assertDisassemblesTo("add al, bh", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, AL, BH)
        assertDisassemblesTo("add al, bh", buffer.toArray())


        buffer.clear()
        AddR8Rm8.encode(buffer, AL, R12B)
        assertDisassemblesTo("add al, r12b", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, AL, R12B)
        assertDisassemblesTo("add al, r12b", buffer.toArray())


        assertFailsWith<IllegalArgumentException> {
            buffer.clear()
            AddR8Rm8.encode(buffer, AH, R12B)
            assertDisassemblesTo("add ah, r12b", buffer.toArray())
        }

        assertFailsWith<IllegalArgumentException> {
            buffer.clear()
            AddRm8R8.encode(buffer, AH, R12B)
            assertDisassemblesTo("add ah, r12b", buffer.toArray())
        }


        buffer.clear()
        AddR8Rm8.encode(buffer, R11B, BL)
        assertDisassemblesTo("add r11b, bl", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, R11B, BL)
        assertDisassemblesTo("add r11b, bl", buffer.toArray())


        assertFailsWith<IllegalArgumentException> {
            buffer.clear()
            AddR8Rm8.encode(buffer, R11B, BH)
            assertDisassemblesTo("add r11b, bh", buffer.toArray())
        }

        assertFailsWith<IllegalArgumentException> {
            buffer.clear()
            AddRm8R8.encode(buffer, R11B, BH)
            assertDisassemblesTo("add r11b, bh", buffer.toArray())
        }


        buffer.clear()
        AddR8Rm8.encode(buffer, R11B, R12B)
        assertDisassemblesTo("add r11b, r12b", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, R11B, R12B)
        assertDisassemblesTo("add r11b, r12b", buffer.toArray())

        buffer.clear()
        AddRm8R8.encode(buffer, SIL, DIL)
        assertDisassemblesTo("add sil, dil", buffer.toArray())

        assertFailsWith<IllegalArgumentException> {
            buffer.clear()
            AddRm8R8.encode(buffer, SIL, BH)
        }
    }

    @Test
    fun baseOnly() {
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(RBX))
        assertDisassemblesTo("add rax, qword ptr [rbx]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, AddressExpression64(RBX), RAX)
        assertDisassemblesTo("add qword ptr [rbx], rax", buffer.toArray())


        buffer.clear()
        AddR64Rm64.encode(buffer, R11, AddressExpression64(R12))
        assertDisassemblesTo("add r11, qword ptr [r12]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, AddressExpression64(R12), R11)
        assertDisassemblesTo("add qword ptr [r12], r11", buffer.toArray())


        buffer.clear()
        AddR32Rm32.encode(buffer, EAX, AddressExpression32(EBX))
        assertDisassemblesTo("add eax, dword ptr [rbx]", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, AddressExpression32(EBX), EAX)
        assertDisassemblesTo("add dword ptr [rbx], eax", buffer.toArray())


        buffer.clear()
        AddR16Rm16.encode(buffer, AX, AddressExpression16(RBX))
        assertDisassemblesTo("add ax, word ptr [rbx]", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, AddressExpression16(RBX), AX)
        assertDisassemblesTo("add word ptr [rbx], ax", buffer.toArray())
    }

    @Test
    fun indexOnly() {
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(null, RBX, Scale._1))
        // Ambiguous output from capstone
        assertDisassemblesTo("add rax, qword ptr [rbx]", buffer.toArray())

        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(null, RBX, Scale._4))
        assertDisassemblesTo("add rax, qword ptr [rbx*4]", buffer.toArray())

        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(null, RBX, Scale._8))
        assertDisassemblesTo("add rax, qword ptr [rbx*8]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, AddressExpression64(null, RBX, Scale._4), RAX)
        assertDisassemblesTo("add qword ptr [rbx*4], rax", buffer.toArray())


        buffer.clear()
        AddR64Rm64.encode(buffer, R11, AddressExpression64(null, R12, Scale._2))
        assertDisassemblesTo("add r11, qword ptr [r12*2]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, AddressExpression64(null, R12, Scale._4, 0x10), R11)
        assertDisassemblesTo("add qword ptr [r12*4 + 0x10], r11", buffer.toArray())


        buffer.clear()
        AddR32Rm32.encode(buffer, EAX, AddressExpression32(null, EBX, Scale._2))
        assertDisassemblesTo("add eax, dword ptr [rbx*2]", buffer.toArray())

        buffer.clear()
        AddRm32R32.encode(buffer, AddressExpression32(null, EBX, Scale._4), EAX)
        assertDisassemblesTo("add dword ptr [rbx*4], eax", buffer.toArray())


        buffer.clear()
        AddR16Rm16.encode(buffer, AX, AddressExpression16(null, RBX, Scale._8, 0x100))
        assertDisassemblesTo("add ax, word ptr [rbx*8 + 0x100]", buffer.toArray())

        buffer.clear()
        AddRm16R16.encode(buffer, AddressExpression16(null, RBX, Scale._4), AX)
        assertDisassemblesTo("add word ptr [rbx*4], ax", buffer.toArray())
    }

    @Test
    fun baseIndexScale() {

        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(RBX, RCX, Scale._4))
        assertDisassemblesTo("add rax, qword ptr [rbx + rcx*4]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer, AddressExpression64(RBX, RCX, Scale._4), RAX)
        assertDisassemblesTo("add qword ptr [rbx + rcx*4], rax", buffer.toArray())

        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(RBX, RCX, Scale._2))
        assertDisassemblesTo("add rax, qword ptr [rbx + rcx*2]", buffer.toArray())

        buffer.clear()
        AddR64Rm64.encode(buffer, RAX, AddressExpression64(RBX, RCX, Scale._8))
        assertDisassemblesTo("add rax, qword ptr [rbx + rcx*8]", buffer.toArray())
    }

    @Test
    fun forcedSib() {
        // SP/R12 always need SIB (i.e. forcing is futile)
        listOf(RSP to true, R12 to true, R11 to false).forEach { (base, equal) ->

            buffer.clear()
            AddR64Rm64.encode(buffer, R10, AddressExpression64(base), options = EncodingOptions.DEFAULT.copy(forceSib = true))
            val withForcedSib = buffer.toArray()

            buffer.clear()
            AddR64Rm64.encode(buffer, R10, AddressExpression64(base), options = EncodingOptions.DEFAULT.copy(forceSib = false))
            val withoutForcedSib = buffer.toArray()

            assert(equal == withoutForcedSib.contentEquals(withForcedSib))

            assertDisassemblesTo("add r10, qword ptr [${base.name.toLowerCase()}]", withForcedSib)
            assertDisassemblesTo("add r10, qword ptr [${base.name.toLowerCase()}]", withoutForcedSib)
        }
    }

    @Test
    fun displacementSize() {
        // Force 32-bit displacement
        buffer.clear()
        AddR64Rm64.encode(buffer, R10, AddressExpression64(R11, 0x10))
        val withAutoDisplacement = buffer.toArray()

        buffer.clear()
        AddR64Rm64.encode(buffer,
                          R10,
                          AddressExpression64(R11, 0x10),
                          options = EncodingOptions.DEFAULT.copy(displacementSize = DisplacementSize._32))
        val with32BitDisplacement = buffer.toArray()

        assertFalse(withAutoDisplacement.contentEquals(with32BitDisplacement))
        assertDisassemblesTo("add r10, qword ptr [r11 + 0x10]", withAutoDisplacement)
        assertDisassemblesTo("add r10, qword ptr [r11 + 0x10]", with32BitDisplacement)
    }

    @Test
    fun legacyPrefixes() {
        AddRm64R64.encode(buffer,
                          AddressExpression64(RAX),
                          RBX,
                          options = EncodingOptions.DEFAULT.copy(legacyPrefix1 = LegacyPrefix.Group1.Lock))
        assertDisassemblesTo("lock add qword ptr [rax], rbx", buffer.toArray())

        buffer.clear()
        IncRm64.encode(buffer,
                       AddressExpression64(R10),
                       options = EncodingOptions.DEFAULT.copy(legacyPrefix1 = LegacyPrefix.Group1.Lock))
        assertDisassemblesTo("lock inc qword ptr [r10]", buffer.toArray())

        buffer.clear()
        AddRm64R64.encode(buffer,
                          AddressExpression64(RAX),
                          RBX,
                          options = EncodingOptions.DEFAULT.copy(legacyPrefix1 = LegacyPrefix.Group1.Lock,
                                                                 legacyPrefix2 = LegacyPrefix.Group2.Es))
        val lockAndEs = buffer.toArray()

        buffer.clear()
        AddRm64R64.encode(buffer,
                          AddressExpression64(RAX),
                          RBX,
                          options = EncodingOptions.DEFAULT.copy(legacyPrefix1 = LegacyPrefix.Group1.Lock,
                                                                 legacyPrefix2 = LegacyPrefix.Group2.Es,
                                                                 legacyPrefixOrder = EncodingOptions.LegacyPrefixOrder.REVERSE))
        val esAndLock = buffer.toArray()

        assertEquals(LegacyPrefix.Group1.Lock.byte, lockAndEs[0])
        assertEquals(LegacyPrefix.Group2.Es.byte, lockAndEs[1])

        assertDisassemblesTo("lock add qword ptr es:[rax], rbx", esAndLock)
        assertDisassemblesTo("lock add qword ptr es:[rax], rbx", lockAndEs)

        assertFalse(lockAndEs.contentEquals(esAndLock))

    }

    @Test
    fun addressSize() {
        buffer.clear()
        AddRm64R64.encode(buffer,
                          AddressExpression64(RAX),
                          RBX,
                          options = EncodingOptions.DEFAULT.copy(addressSize = AddressSize._32))
        assertDisassemblesTo("add dword ptr [eax], rbx", buffer.toArray());

        buffer.clear()
        AddRm64R64.encode(buffer,
                          AddressExpression64(RAX),
                          RBX,
                          options = EncodingOptions.DEFAULT.copy(addressSize = AddressSize._64))
        assertDisassemblesTo("add qword ptr [rax], rbx", buffer.toArray());

        buffer.clear()
        AddRm32R32.encode(buffer,
                          AddressExpression32(EAX),
                          EBX,
                          options = EncodingOptions.DEFAULT.copy(addressSize = AddressSize._32))
        assertDisassemblesTo("add dword ptr [eax], ebx", buffer.toArray());
    }

    @Test
    fun rex() {

        // needs REX (.W), even if not forced
        listOf(false, true).forEach { forceRex ->
            buffer.clear()
            AddR64Rm64.encode(buffer, RAX, RBX, options = EncodingOptions.DEFAULT.copy(forceRex = forceRex))
            val code = buffer.toArray()
            assertDisassemblesTo("add rax, rbx", code)
            assertAssemblesTo(listOf(0x48, 0x03, 0xC3), code)
        }


        // REX.X is free
        listOf(0 to 0x48, 1 to 0x4A).forEach { (rexX, rexByte) ->
            buffer.clear()
            AddR64Rm64.encode(buffer, RAX, RBX, options = EncodingOptions.DEFAULT.copy(rexX = rexX))
            val code = buffer.toArray()
            assertDisassemblesTo("add rax, rbx", code)
            assertAssemblesTo(listOf(rexByte, 0x03, 0xC3), code)
        }

        // REX is optional
        listOf(false to null, true to 0x40).forEach { (forceRex, rexByte) ->
            buffer.clear()
            AddR32Rm32.encode(buffer, EAX, EBX, options = EncodingOptions.DEFAULT.copy(forceRex = forceRex))
            val code = buffer.toArray()
            assertDisassemblesTo("add eax, ebx", code)
            assertAssemblesTo(listOf(rexByte, 0x03, 0xC3).filterNotNull(), code)
        }

        // REX.X is free
        listOf(0 to 0x40, 1 to 0x42).forEach { (rexX, rexByte) ->
            buffer.clear()
            AddR32Rm32.encode(buffer, EAX, EBX, options = EncodingOptions.DEFAULT.copy(rexX = rexX, forceRex = true))
            val code = buffer.toArray()
            assertDisassemblesTo("add eax, ebx", code)
            assertAssemblesTo(listOf(rexByte, 0x03, 0xC3), code)
        }

        // REX.X is free
        listOf(0 to 0x40, 1 to 0x42).forEach { (rexX, rexByte) ->
            buffer.clear()
            AddRm32Imm32.encode(buffer, EAX, 0x10, options = EncodingOptions.DEFAULT.copy(rexX = rexX, forceRex = true))
            val code = buffer.toArray()
            assertDisassemblesTo("add eax, 0x10", code)
            assertAssemblesTo(listOf(rexByte, 0x81, 0xC0, 0x10, 0x00, 0x00, 0x00), code)
        }

        // REX.R is free
        listOf(0 to 0x40, 1 to 0x44).forEach { (rexR, rexByte) ->
            buffer.clear()
            AddRm32Imm32.encode(buffer, EAX, 0x10, options = EncodingOptions.DEFAULT.copy(rexR = rexR, forceRex = true))
            val code = buffer.toArray()
            assertDisassemblesTo("add eax, 0x10", code)
            assertAssemblesTo(listOf(rexByte, 0x81, 0xC0, 0x10, 0x00, 0x00, 0x00), code)
        }
    }

    @Test
    fun immediate() {
        AddRm64Imm8.encode(buffer, RAX, 0xA)
        assertDisassemblesTo("add rax, 0xa", buffer.toArray())

        buffer.clear()
        AddRm64Imm8.encode(buffer, AddressExpression64(RAX), 0xA)
        assertDisassemblesTo("add qword ptr [rax], 0xa", buffer.toArray())

        buffer.clear()
        AddRm64Imm8.encode(buffer, AddressExpression64(RAX), -0xA)
        assertDisassemblesTo("add qword ptr [rax], -0xa", buffer.toArray())
    }

    @Test
    fun vex() {

        Vcvtps2pdXmmXmmm64.encode(buffer, XMM1, XMM2)
        assertAssemblesTo(listOf(0xC5, 0xF8, 0x5A, 0xCA), buffer.toArray())

        buffer.clear()
        Vcvtss2sdXmmXmmXmmm32.encode(buffer, XMM1, XMM2, XMM3)
        assertAssemblesTo(listOf(0xC5, 0xEA, 0x5A, 0xCB), buffer.toArray())

        buffer.clear()
        Vcvttss2siR64Xmmm32.encode(buffer, RDI, XMM13)
        assertAssemblesTo(listOf(0xC4, 0xC1, 0xFA, 0x2C, 0xFD), buffer.toArray())

        buffer.clear()
        Vcvtps2phXmmm64XmmImm8.encode(buffer, XMM1, XMM2, 0x12)
        assertAssemblesTo(listOf(0xC4, 0xE3, 0x79, 0x1D, 0xD1, 0x12), buffer.toArray())

        XmmRegister.values().forEach { xmmRegister ->
            buffer.clear()
            Vcvttss2siR64Xmmm32.encode(buffer, RDI, xmmRegister)
            assertDisassemblesTo("vcvttss2si rdi, xmm${xmmRegister.ordinal}", buffer.toArray())
        }

        buffer.clear()
        VpaddsbYmmYmmYmmm256.encode(buffer, YMM0, YMM1, YMM2)
        assertAssemblesTo(listOf(0xC5, 0xF5, 0xEC, 0xC2), buffer.toArray())

        buffer.clear()
        VpaddsbYmmYmmYmmm256.encode(buffer, YMM0, YMM1, YMM2, EncodingOptions.DEFAULT.copy(forceLongVex = true))
        assertAssemblesTo(listOf(0xC4, 0xE1, 0x75, 0xEC, 0xC2), buffer.toArray())


        buffer.clear()
        VpaddsbYmmYmmYmmm256.encode(buffer, YMM0, YMM1, YMM2)
        assertDisassemblesTo("vpaddsb ymm0, ymm1, ymm2", buffer.toArray())

        buffer.clear()
        VpaddsbYmmYmmYmmm256.encode(buffer, YMM0, YMM1, YMM2, EncodingOptions.DEFAULT.copy(forceLongVex = true))
        assertDisassemblesTo("vpaddsb ymm0, ymm1, ymm2", buffer.toArray())


        buffer.clear()
        VblendvpdXmmXmmXmmm128Xmm.encode(buffer, XMM0, XMM1, XMM2, XMM3)
        assertDisassemblesTo("vblendvpd xmm0, xmm1, xmm2, xmm3", buffer.toArray())

        buffer.clear()
        VblendvpdYmmYmmYmmm256Ymm.encode(buffer, YMM0, YMM1, YMM2, YMM3)
        assertDisassemblesTo("vblendvpd ymm0, ymm1, ymm2, ymm3", buffer.toArray())

    }

    @Test
    fun vsib() {

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM0, VectorAddressExpression(RAX, XMM1, Scale._2), XMM2)
        assertDisassemblesTo("vpgatherdd xmm0, dword ptr [rax + xmm1*2], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM0, VectorAddressExpression(RAX, XMM1), XMM2)
        assertDisassemblesTo("vpgatherdd xmm0, dword ptr [rax + xmm1], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM12, VectorAddressExpression(RAX, XMM1), XMM2)
        assertDisassemblesTo("vpgatherdd xmm12, dword ptr [rax + xmm1], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM12, VectorAddressExpression(R12, XMM1), XMM2)
        assertDisassemblesTo("vpgatherdd xmm12, dword ptr [r12 + xmm1], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM12, VectorAddressExpression(R12, XMM1, Scale._8), XMM2)
        assertDisassemblesTo("vpgatherdd xmm12, dword ptr [r12 + xmm1*8], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddXmmVm32x32Xmm.encode(buffer, XMM12, VectorAddressExpression(RDI, XMM1, Scale._8), XMM2)
        assertDisassemblesTo("vpgatherdd xmm12, dword ptr [rdi + xmm1*8], xmm2", buffer.toArray())

        buffer.clear()
        VpgatherddYmmVm32y32Ymm.encode(buffer, YMM12, VectorAddressExpression(RDI, YMM1, Scale._8), YMM2)
        assertDisassemblesTo("vpgatherdd ymm12, dword ptr [rdi + ymm1*8], ymm2", buffer.toArray())
    }

}