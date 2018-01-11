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
        val buffer = NativeBuffer(1024, true)

        val cpuState = CpuState()

        val assembler = Assembler(buffer).emitStackFrame {
            mov(GpRegister32.EAX, 0xdead)
            mov(GpRegister32.EDI, 0xbeef)
            mov(GpRegister64.RSI, 0xdeadbeef)
            cpuState.emitSave(this)
        }

        assertEquals(cpuState.eax, 0)
        assertEquals(cpuState.edi, 0)
        assertEquals(cpuState.rsi, 0)

        println(buffer.toByteString())
        buffer.execute()

        assertEquals(cpuState.eax, 0xdead)
        assertEquals(cpuState.edi, 0xbeef)
        assertEquals(cpuState.rsi, 0xdeadbeef)
    }

    @Test
    fun saveRestore() {
        val buffer = NativeBuffer(1024 * 2, true)

        val cpuState1 = CpuState()

        val random = ThreadLocalRandom.current()

        CpuState::class.declaredMemberProperties.forEach {
            it.isAccessible = true
            it.getDelegate(cpuState1).let {
                when(it) {
                    is Structure.LongField -> it.set(random.nextLong())
                    is Structure.Vector64Field -> it.set(Vector64().also{it[0] = random.nextLong()})
                    is Structure.Vector256Field -> it.set(Vector256().also {
                        it[0] = random.nextLong()
                        it[1] = random.nextLong()
                        it[2] = random.nextLong()
                        it[3] = random.nextLong()
                    })
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