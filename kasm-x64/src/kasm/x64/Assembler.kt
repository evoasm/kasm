package kasm.x64

import kasm.Buffer
import kasm.Structure
import kasm.ext.alignUp
import kasm.x64.GpRegister32.*

class Assembler(override val buffer: Buffer) : AbstractAssembler() {

    companion object {
        val SYSV_CALLEE_SAVED_REGISTERS = arrayOf(
                GpRegister64.RBP,
                GpRegister64.RBX,
                GpRegister64.R12,
                GpRegister64.R13,
                GpRegister64.R14,
                GpRegister64.R15
                                                 )

        private val SCRATCH_REGISTER1 = GpRegister64.RDI
        private val SCRATCH_REGISTER2 = GpRegister64.RSI

        private val NOP2_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66)
        private val NOP6_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66)
        private val NOP9_OPTIONS = EncodingOptions(legacyPrefix3 = LegacyPrefix.Group3._66)
        private val NOP8_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._32)
        private val NOP7_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._32)
        private val NOP4_OPTIONS = EncodingOptions(displacementSize = DisplacementSize._8)

        private val NOP1 : Byte = 0x90.toByte()
        private val NOP2 = byteArrayOf(0x66, 0x90.toByte())
        private val NOP3 = byteArrayOf(0x0F, 0x1F, 0x00)
        private val NOP4 = byteArrayOf(0x0F, 0x1F, 0x40, 0x00)
        private val NOP5 = byteArrayOf(0x0F, 0x1F, 0x44, 0x00, 0x00)
        private val NOP6 = byteArrayOf(0x66, 0x0F, 0x1F, 0x44, 0x00, 0x00)
        private val NOP7 = byteArrayOf(0x0F, 0x1F, 0x80.toByte(), 0x00, 0x00, 0x00, 0x00)
        private val NOP8 = byteArrayOf(0x0F, 0x1F, 0x84.toByte(), 0x00, 0x00, 0x00, 0x00, 0x00)
        private val NOP9 = byteArrayOf(0x66, 0x0F, 0x1F, 0x84.toByte(), 0x00, 0x00, 0x00, 0x00, 0x00)
    }

    inline fun save(vararg registers: GpRegister64, action: Assembler.() -> Unit) {
        for (register in registers) {
            push(register)
        }

        action()

        for (index in registers.lastIndex downTo 0) {
            pop(registers[index])
        }
    }


    fun mov(register: GpRegister64, field: Structure.LongField) {
        val scratchRegister = if (register == SCRATCH_REGISTER1) {
            SCRATCH_REGISTER2
        } else {
            SCRATCH_REGISTER1
        }

        save(scratchRegister) {
            mov(scratchRegister, field.address())
            mov(register, Address64(scratchRegister))
        }
    }

    fun mov(field: Structure.LongField, register: GpRegister64) {
        val scratchRegister = if (register == SCRATCH_REGISTER1) {
            SCRATCH_REGISTER2
        } else {
            SCRATCH_REGISTER1
        }

        save(scratchRegister) {
            mov(scratchRegister, field.address())
            mov(Address64(scratchRegister), register)
        }
    }

    fun mov(register: MmRegister, field: Structure.Vector64Field) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            movq(register, Address64(SCRATCH_REGISTER1))
        }
    }

    fun mov(field: Structure.Vector64Field, register: MmRegister) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            movq(Address64(SCRATCH_REGISTER1), register)
        }
    }

    fun mov(register: XmmRegister, field: Structure.Vector128Field) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            movdqa(register, Address128(SCRATCH_REGISTER1))
        }
    }

    fun mov(field: Structure.Vector128Field, register: XmmRegister) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            movdqa(Address128(SCRATCH_REGISTER1), register)
        }
    }

    fun mov(register: YmmRegister, field: Structure.Vector256Field) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            vmovdqa(register, Address256(SCRATCH_REGISTER1))
        }
    }

    fun mov(field: Structure.Vector256Field, register: YmmRegister) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            vmovdqa(Address256(SCRATCH_REGISTER1), register)
        }
    }

    fun mov(register: IpRegister, field: Structure.LongField) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            jmp(SCRATCH_REGISTER1)
        }
    }

    fun mov(field: Structure.LongField, register: IpRegister) {
        save(SCRATCH_REGISTER1, SCRATCH_REGISTER2) {
            mov(SCRATCH_REGISTER1, field.address())
            lea(SCRATCH_REGISTER2, Address64(IpRegister.RIP))
            mov(Address64(SCRATCH_REGISTER1), SCRATCH_REGISTER2)
        }
    }

    fun mov(field: Structure.LongField, register: RflagsRegister) {
        save(SCRATCH_REGISTER1, SCRATCH_REGISTER2) {
            pushfq()
            pop(SCRATCH_REGISTER2)
            mov(SCRATCH_REGISTER1, field.address())
            mov(Address64(SCRATCH_REGISTER1), SCRATCH_REGISTER2)
        }
    }

    fun mov(register: RflagsRegister, field: Structure.LongField) {
        save(SCRATCH_REGISTER1, SCRATCH_REGISTER2) {
            mov(SCRATCH_REGISTER1, field.address())
            mov(SCRATCH_REGISTER2, Address64(SCRATCH_REGISTER1))
            push(SCRATCH_REGISTER2)
            popfq()
        }
    }

    fun mov(field: Structure.IntField, register: MxcsrRegister) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            stmxcsr(Address32(SCRATCH_REGISTER1))
        }
    }

    fun mov(register: MxcsrRegister, field: Structure.IntField) {
        save(SCRATCH_REGISTER1) {
            mov(SCRATCH_REGISTER1, field.address())
            ldmxcsr(Address32(SCRATCH_REGISTER1))
        }
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
//        mov(register, field.address())
//    }

    inline fun emitStackFrame(action: Assembler.() -> Unit) {
        save(*SYSV_CALLEE_SAVED_REGISTERS, action = action)
        ret()
    }

}