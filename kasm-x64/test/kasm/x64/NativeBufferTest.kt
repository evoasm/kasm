package kasm.x64

import kasm.Buffer
import kasm.NativeBuffer
import kasm.SegmentationFaultException
import kasm.ZeroDivisionException
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

}