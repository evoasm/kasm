package kasm.x64

import kasm.Buffer
import org.junit.jupiter.api.Test
import kasm.x64.GpRegister32.*
import org.junit.jupiter.api.Assertions.*

internal class AssemblerTest {

    companion object {
        private val NOP2_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66)
        private val NOP4_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._8)
        private val NOP5_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._8)
        private val NOP6_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66, displacementSize = DisplacementSize._8)
        private val NOP7_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._32)
        private val NOP8_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._32)
        private val NOP9_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66, displacementSize = DisplacementSize._32)
    }

    @Test
    fun nop() {
        val buffer1 = Buffer(1024)
        val buffer2 = Buffer(1024)

        val assembler1 = Assembler(buffer1)
        val assembler2 = Assembler(buffer2)

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, EAX, Scale._1, 0), NOP9_OPTIONS)
            assembler2.nop(9)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, EAX, Scale._1, 0), NOP8_OPTIONS)
            assembler2.nop(8)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, 0), NOP7_OPTIONS)
            assembler2.nop(7)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, EAX, Scale._1, 0), NOP6_OPTIONS)
            assembler2.nop(6)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, EAX, Scale._1,0), NOP5_OPTIONS)
            assembler2.nop(5)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, 0), NOP4_OPTIONS)
            assembler2.nop(4)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(Address32(EAX, 0))
            assembler2.nop(3)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop(NOP2_OPTIONS)
            assembler2.nop(2)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }

        run {
            buffer1.clear()
            buffer2.clear()

            assembler1.nop()
            assembler2.nop(1)

            assertArrayEquals(buffer1.toArray(), buffer2.toArray())
        }








    }
}