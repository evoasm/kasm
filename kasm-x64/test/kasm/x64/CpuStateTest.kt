package kasm.x64

import kasm.*
import org.junit.jupiter.api.Test
import java.util.concurrent.ThreadLocalRandom
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.test.*

internal class CpuStateTest {

    @Test
    fun save() {
        val buffer = NativeBuffer(1024)

        val cpuState = CpuState()

        val assembler = Assembler(buffer).emitStackFrame {
            mov(GpRegister32.EAX, 0xdead)
            mov(GpRegister32.EDI, 0xbeef)
            mov(GpRegister64.RSI, 0xdeadbeef)
            cpuState.emitSave(this)
        }

        assertEquals(0, cpuState.eax)
        assertEquals(0, cpuState.edi)
        assertEquals(0, cpuState.rsi)

        println(buffer.toByteString())
        buffer.execute()

        assertEquals(0xdead, cpuState.eax)
        assertEquals(0xbeef, cpuState.edi)
        assertEquals(0xdeadbeef, cpuState.rsi)
    }

    @Test
    fun saveRestore() {
        val buffer = NativeBuffer(1024 * 2)

        val cpuState1 = CpuState()

        val random = ThreadLocalRandom.current()

        CpuState::class.declaredMemberProperties.forEach {
            it.isAccessible = true
            it.getDelegate(cpuState1).let {
                when(it) {
                    is LongStructureField -> it.set(random.nextLong())
                    is VectorStructureField -> {
                        val array = ByteArray(it.elementSize)
                        random.nextBytes(array)
                        for(i in array.indices) {
                            it.setByte(i, array[i])
                        }
                    }
                }
            }
        }

        val cpuState2 = CpuState()

        assertNotEquals(cpuState1, cpuState2)

        val assembler = Assembler(buffer).emitStackFrame {
            cpuState1.emitRestore(this)
            cpuState2.emitSave(this)
        }

        println(buffer.toByteString())

        buffer.execute()

        assertEquals(cpuState1, cpuState2)
    }

}