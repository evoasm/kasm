package kasm.x64

import kasm.*
import org.junit.jupiter.api.Test
import kotlin.test.*

import kasm.x64.GpRegister64.*

import org.junit.jupiter.api.BeforeEach

internal class NativeBufferTest {

    private lateinit var buffer: NativeBuffer

    @BeforeEach
    fun setup() {
        buffer = NativeBuffer(1024, true)
    }

    @Test
    fun zeroDivision() {
        Assembler(buffer).emitStackFrame {
            mov(RBX, 0)
            mov(RAX, 0)
            divRdxRax(RBX)
        }

        assertFailsWith<ZeroDivisionException> {
            buffer.execute()
        }
    }

    @Test
    fun segmentationFault() {
        val displacement = 0xdeadL

        Assembler(buffer).emitStackFrame {
            // mov(RBX, Address(displacement))
            movabsRax(displacement)
        }

        val exception = assertFailsWith<SegmentationFaultException> {
            buffer.execute()
        }

        assertEquals(displacement.toLong(), exception.address)
    }

    @Test
    fun executeWithArgument() {
        Assembler(buffer).emitStackFrame {
            add(RDI, 10)
            mov(RAX, RDI)
        }

        assertEquals(10L, buffer.execute(0))
        assertEquals(11L, buffer.execute(1))
        assertEquals(110L, buffer.execute(100))

    }

    @Test
    fun illegalInstruction() {
        var offset = 0

        Assembler(buffer).emitStackFrame {
            offset = buffer.position()
            ud2()
        }

        val exception = assertFailsWith<IllegalInstructionException> {
            buffer.execute()
        }

        assertEquals(buffer.address() + offset, exception.address)
    }
}