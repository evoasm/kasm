package kasm.x64

import kasm.Buffer
import kasm.Structure
import kasm.ext.alignUp

class Assembler(override val buffer: Buffer) : AbstractAssembler() {

    companion object {
        val SYSV_CALLEE_SAVED_REGISTERS = listOf(
                GpRegister64.RBP,
                GpRegister64.RBX,
                GpRegister64.R12,
                GpRegister64.R13,
                GpRegister64.R14,
                GpRegister64.R15)

        val DEFAULT_SCRATCH_REGISTERS = listOf(GpRegister64.RDI, GpRegister64.RSI)

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

    class JumpSite(val buffer: Buffer) {
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

    var scratchRegisters = DEFAULT_SCRATCH_REGISTERS

    fun mov(register: GpRegister64, field: Structure.LongField, vararg indices: Int) {
        val scratchRegister = if (register == scratchRegisters[0]) {
            scratchRegisters[1]
        } else {
            scratchRegisters[0]
        }
        mov(scratchRegister, field.getAddress(*indices))
        mov(register, Address64(scratchRegister))
    }

    fun mov(field: Structure.LongField, vararg indices: Int, register: GpRegister64) {
        mov(field, register, 0)
    }

    fun mov(field: Structure.LongField, register: GpRegister64, vararg indices: Int) {
        val scratchRegister = if (register == scratchRegisters[0]) {
            scratchRegisters[1]
        } else {
            scratchRegisters[0]
        }

        mov(scratchRegister, field.getAddress(*indices))
        mov(Address64(scratchRegister), register)
    }

    fun mov(register: MmRegister, field: Structure.Vector64Field, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        movq(register, Address64(scratchRegisters.first()))
    }

    fun mov(field: Structure.Vector64Field, register: MmRegister, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        movq(Address64(scratchRegisters.first()), register)
    }

    fun mov(register: XmmRegister, field: Structure.Vector128Field, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        movdqa(register, Address128(scratchRegisters.first()))
    }

    fun mov(field: Structure.Vector128Field, register: XmmRegister, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        movdqa(Address128(scratchRegisters.first()), register)
    }

    fun mov(register: YmmRegister, field: Structure.Vector256Field, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        vmovdqa(register, Address256(scratchRegisters.first()))
    }

    fun mov(field: Structure.Vector256Field, register: YmmRegister, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        vmovdqa(Address256(scratchRegisters.first()), register)
    }

    fun mov(register: IpRegister, field: Structure.LongField, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        jmp(scratchRegisters.first())
    }

    fun mov(field: Structure.LongField, register: IpRegister, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        lea(scratchRegisters[2], Address64(IpRegister.RIP))
        mov(Address64(scratchRegisters.first()), scratchRegisters[2])
    }

    fun mov(field: Structure.LongField, register: RflagsRegister, vararg indices: Int) {
        pushfq()
        pop(scratchRegisters[2])
        mov(scratchRegisters.first(), field.getAddress(*indices))
        mov(Address64(scratchRegisters.first()), scratchRegisters[2])
    }

    fun mov(register: RflagsRegister, field: Structure.LongField, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        mov(scratchRegisters[2], Address64(scratchRegisters.first()))
        push(scratchRegisters[2])
        popfq()
    }

    fun mov(field: Structure.IntField, register: MxcsrRegister, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        stmxcsr(Address32(scratchRegisters.first()))
    }

    fun mov(register: MxcsrRegister, field: Structure.IntField, vararg indices: Int) {
        mov(scratchRegisters.first(), field.getAddress(*indices))
        ldmxcsr(Address32(scratchRegisters.first()))
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
                    buffer.putBytes(NOP9)
                    remaining -= 9
                }

                remaining >= 8 -> {
                    buffer.putBytes(NOP8)
                    remaining -= 8
                }

                remaining >= 7 -> {
                    buffer.putBytes(NOP7)
                    remaining -= 7
                }

                remaining >= 6 -> {
                    buffer.putBytes(NOP6)
                    remaining -= 6
                }

                remaining >= 5 -> {
                    buffer.putBytes(NOP5)
                    remaining -= 5
                }

                remaining >= 4 -> {
                    buffer.putBytes(NOP4)
                    remaining -= 4
                }

                remaining >= 3 -> {
                    buffer.putBytes(NOP3)
                    remaining -= 3
                }

                remaining >= 2 -> {
                    buffer.putBytes(NOP2)
                    remaining -= 2
                }

                else           -> {
                    buffer.putByte(NOP1)
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