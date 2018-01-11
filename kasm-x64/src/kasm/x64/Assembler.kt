package kasm.x64

import kasm.Buffer
import kasm.Structure

class Assembler(override val buffer: Buffer): AbstractAssembler() {

    companion object {
        val SYSV_CALLE_SAVED_REGISTERS = arrayOf(
                GpRegister64.RBP,
                GpRegister64.RBX,
                GpRegister64.R12,
                GpRegister64.R13,
                GpRegister64.R14,
                GpRegister64.R15
        )

        private val SCRATCH_REGISTER1 = GpRegister64.RDI
        private val SCRATCH_REGISTER2 = GpRegister64.RSI
    }

    inline fun save(vararg registers: GpRegister64, action: Assembler.() -> Unit) {
        for(register in registers) {
            push(register)
        }

        action()

        for(index in registers.lastIndex downTo 0) {
            pop(registers[index])
        }
    }


    fun mov(register: GpRegister64, field: Structure.LongField) {
        val scratchRegister = if(register == SCRATCH_REGISTER1) {
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
        val scratchRegister = if(register == SCRATCH_REGISTER1) {
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


//
//    fun mov(register: XmmRegister, field: Structure.Vector128Field) {
//        mov(register, field.address())
//    }

    inline fun emitStackFrame(action: Assembler.() -> Unit) {
        save(*SYSV_CALLE_SAVED_REGISTERS, action = action)
        ret()
    }

}