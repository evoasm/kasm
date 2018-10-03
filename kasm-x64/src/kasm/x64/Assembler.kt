package kasm.x64

import kasm.ExecutableBuffer
import kasm.ext.alignUp
import java.nio.ByteBuffer

class Assembler(override val buffer: ByteBuffer) : AbstractAssembler() {

    constructor(buffer: ExecutableBuffer) : this(buffer.byteBuffer)

    companion object {
        val SYSV_CALLEE_SAVED_REGISTERS = listOf(
                GpRegister64.RBP,
                GpRegister64.RBX,
                GpRegister64.R12,
                GpRegister64.R13,
                GpRegister64.R14,
                GpRegister64.R15)

        private val NOP1: Byte = 0x90.toByte()
        private val NOP2 = byteArrayOf(0x66, 0x90.toByte())
        private val NOP3 = byteArrayOf(0x0F, 0x1F, 0x00)
        private val NOP4 = byteArrayOf(0x0F, 0x1F, 0x40, 0x00)
        private val NOP5 = byteArrayOf(0x0F, 0x1F, 0x44, 0x00, 0x00)
        private val NOP6 = byteArrayOf(0x66, 0x0F, 0x1F, 0x44, 0x00, 0x00)
        private val NOP7 = byteArrayOf(0x0F, 0x1F, 0x80.toByte(), 0x00, 0x00, 0x00, 0x00)
        private val NOP8 = byteArrayOf(0x0F, 0x1F, 0x84.toByte(), 0x00, 0x00, 0x00, 0x00, 0x00)
        private val NOP9 = byteArrayOf(0x66, 0x0F, 0x1F, 0x84.toByte(), 0x00, 0x00, 0x00, 0x00, 0x00)
    }


    class JumpSite(val buffer: ByteBuffer) {
        private val offset = buffer.position()

        fun link(jumpTargetOffset: Int) {
            buffer.putInt(jumpTargetOffset - 2, jumpTargetOffset - this.offset)
        }
    }

    fun ifEqual(ifBlock: Assembler.() -> Unit) {
        jne(0xdeadbeef.toInt())
        val offset1 = buffer.position()
        ifBlock()
        val offset2 = buffer.position()

        buffer.putInt(offset1 - 4, offset2 - offset1)
    }

    fun ifEqual(ifBlock: Assembler.() -> Unit, elseBlock: Assembler.() -> Unit) {
        je(0xdeadbeef.toInt())
        val offset1 = buffer.position()
        elseBlock()
        jmp(0xdeadbeef.toInt())
        val offset2 = buffer.position()
        ifBlock()
        val offset3 = buffer.position()

        buffer.putInt(offset1 - 4, offset2 - offset1)
        buffer.putInt(offset2 - 4, offset3 - offset2)
    }

    fun je(): JumpSite {
        je(0xdeadbeef.toInt())
        return JumpSite(buffer)
    }

    fun jmp(): JumpSite {
        jmp(0xdeadbeef.toInt())
        return JumpSite(buffer)
    }

    inline fun pushed(registers: List<GpRegister64>, action: Assembler.() -> Unit) {
        for (register in registers) {
            push(register)
        }

        action()

        for (index in registers.lastIndex downTo 0) {
            pop(registers[index])
        }
    }

    inline fun pushed(vararg registers: GpRegister64, action: Assembler.() -> Unit) {
        for (register in registers) {
            push(register)
        }

        action()

        for (index in registers.lastIndex downTo 0) {
            pop(registers[index])
        }
    }

    inline fun pushed(register: GpRegister64, action: Assembler.() -> Unit) {
        push(register)
        action()
        pop(register)
    }

    fun load(address: Long, register: GpRegister64) {
        check(address <= Int.MAX_VALUE)
        mov(register, Address64(address.toInt()))
    }

    fun load(address: Long, register: GpRegister64, scratchRegister: GpRegister64) {
        check(register != scratchRegister)
        mov(scratchRegister, address)
        mov(register, Address64(scratchRegister))
    }

    fun load(address: Long, register: MmRegister) {
        check(address <= Int.MAX_VALUE)
        movq(register, Address64(address.toInt()))
    }

    fun load(address: Long, register: MmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        movq(register, Address64(scratchRegister))
    }

    fun load(address: Long, register: XmmRegister) {
        check(address <= Int.MAX_VALUE)
        movdqa(register, Address128(address.toInt()))
    }

    fun load(address: Long, register: XmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        movdqa(register, Address128(scratchRegister))
    }

    fun load(address: Long, register: YmmRegister) {
        check(address <= Int.MAX_VALUE)
        vmovdqa(register, Address256(address.toInt()))
    }

    fun load(address: Long, register: YmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        vmovdqa(register, Address256(scratchRegister))
    }

    fun load(address: Long, register: IpRegister) {
        check(address <= Int.MAX_VALUE)
        jmp(Address64(address.toInt()))
    }

    fun load(address: Long, register: IpRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        jmp(scratchRegister)
    }

    fun load(address: Long, register: RflagsRegister, scratchRegister: GpRegister64) {
        check(address <= Int.MAX_VALUE)
        mov(scratchRegister, Address64(address.toInt()))
        push(scratchRegister)
        popfq()
    }

    fun load(address: Long, register: RflagsRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        mov(scratchRegister1, address)
        mov(scratchRegister2, Address64(scratchRegister1))
        push(scratchRegister2)
        popfq()
    }

    fun load(address: Long, register: MxcsrRegister) {
        check(address <= Int.MAX_VALUE)
        ldmxcsr(Address32(address.toInt()))
    }

    fun load(address: Long, register: MxcsrRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        ldmxcsr(Address32(scratchRegister))
    }

    fun store(address: Long, register: GpRegister64) {
        check(address <= Int.MAX_VALUE)
        mov(Address64(address.toInt()), register)
    }

    fun store(address: Long, register: GpRegister64, scratchRegister: GpRegister64) {
        check(register != scratchRegister)
        mov(scratchRegister, address)
        mov(Address64(scratchRegister), register)
    }

    fun store(address: Long, register: MmRegister) {
        check(address <= Int.MAX_VALUE)
        movq(Address64(address.toInt()), register)
    }

    fun store(address: Long, register: MmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        movq(Address64(scratchRegister), register)
    }

    fun store(address: Long, register: XmmRegister) {
        check(address <= Int.MAX_VALUE)
        movdqa(Address128(address.toInt()), register)
    }

    fun store(address: Long, register: XmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        movdqa(Address128(scratchRegister), register)
    }

    fun store(address: Long, register: YmmRegister) {
        check(address <= Int.MAX_VALUE)
        vmovdqa(Address256(address.toInt()), register)
    }

    fun store(address: Long, register: YmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        vmovdqa(Address256(scratchRegister), register)
    }

    fun store(address: Long, register: IpRegister, scratchRegister: GpRegister64) {
        check(address <= Int.MAX_VALUE)
        lea(scratchRegister, Address64(IpRegister.RIP))
        mov(Address64(address.toInt()), scratchRegister)
    }

    fun store(address: Long, register: IpRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        mov(scratchRegister1, address)
        lea(scratchRegister2, Address64(IpRegister.RIP))
        mov(Address64(scratchRegister1), scratchRegister2)
    }

    fun store(address: Long, register: RflagsRegister, scratchRegister: GpRegister64) {
        check(address < Int.MAX_VALUE)
        pushfq()
        pop(scratchRegister)
        mov(Address64(address.toInt()), scratchRegister)
    }

    fun store(address: Long, register: RflagsRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        pushfq()
        pop(scratchRegister2)
        mov(scratchRegister1, address)
        mov(Address64(scratchRegister1), scratchRegister2)
    }

    fun store(address: Long, register: MxcsrRegister) {
        check(address < Int.MAX_VALUE)
        stmxcsr(Address32(address.toInt()))
    }

    fun store(address: Long, register: MxcsrRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address)
        stmxcsr(Address32(scratchRegister))
    }

    fun align(alignment: Int) {
        buffer.position().also {
            nop(it.alignUp(alignment) - it)
        }
    }

    fun nop(byteSize: Int) {
        var remaining = byteSize
        while (remaining > 0) {
            when {
                remaining >= 9 -> {
                    buffer.put(NOP9)
                    remaining -= 9
                }

                remaining >= 8 -> {
                    buffer.put(NOP8)
                    remaining -= 8
                }

                remaining >= 7 -> {
                    buffer.put(NOP7)
                    remaining -= 7
                }

                remaining >= 6 -> {
                    buffer.put(NOP6)
                    remaining -= 6
                }

                remaining >= 5 -> {
                    buffer.put(NOP5)
                    remaining -= 5
                }

                remaining >= 4 -> {
                    buffer.put(NOP4)
                    remaining -= 4
                }

                remaining >= 3 -> {
                    buffer.put(NOP3)
                    remaining -= 3
                }

                remaining >= 2 -> {
                    buffer.put(NOP2)
                    remaining -= 2
                }

                else           -> {
                    buffer.put(NOP1)
                    remaining--
                }
            }
        }
    }

//
//    fun mov(register: XmmRegister, field: Structure.Vector128Field) {
//        mov(register, field.getAddress(*indices))
//    }

    inline fun emitStackFrame(action: Assembler.() -> Unit) {
        pushed(SYSV_CALLEE_SAVED_REGISTERS, action = action)
        ret()
    }

}