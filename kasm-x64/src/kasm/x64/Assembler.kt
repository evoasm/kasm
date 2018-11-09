package kasm.x64

import kasm.Address
import kasm.NativeBuffer
import kasm.address
import kasm.ext.alignUp
import java.nio.ByteBuffer

class Assembler(override val buffer: ByteBuffer) : AbstractAssembler() {

    constructor(buffer: NativeBuffer) : this(buffer.byteBuffer)

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

    private fun requireSmallCodeModel(address: Address) {
        require(address.value <= Int.MAX_VALUE.toULong())
    }

    abstract class LinkPoint<T : Number>(val buffer: ByteBuffer) {
        val offset = buffer.position()

        abstract fun link(value: T)
    }

    open class IntLinkPoint(buffer: ByteBuffer) : LinkPoint<Int>(buffer) {
        override fun link(value: Int) {
            val patchOffset = offset - 4
            buffer.putInt(patchOffset, value)
        }
    }

    class JumpLinkPoint(buffer: ByteBuffer, val relative : Boolean) : IntLinkPoint(buffer) {
        override fun link(value: Int) {
            if(relative) {
                super.link(value - this.offset)
            } else {
                super.link(buffer.address.toInt() + offset)
            }

        }
    }

    class LongLinkPoint(buffer: ByteBuffer) : LinkPoint<Long>(buffer) {
        override fun link(value: Long) {
          val patchOffset = offset - 8
          buffer.putLong(patchOffset, value)
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

    fun mov(register: GpRegister64) : LongLinkPoint {
        mov(register, 0xdeadbeefdeadbeefU.toLong())
        return LongLinkPoint(buffer)
    }

    fun je(): JumpLinkPoint {
        je(0xdeadbeef.toInt())
        return JumpLinkPoint(buffer, relative = true)
    }

    fun jmp(): JumpLinkPoint {
        jmp(0xdeadbeef.toInt())
        return JumpLinkPoint(buffer, relative = true)
    }

    fun jmp(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1): LinkPoint<Int> {
        jmp(AddressExpression64(base, index, scale, 0xdeadbeef.toInt()))
        return JumpLinkPoint(buffer, relative = false)
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

    fun load(address: Address, register: GpRegister64) {
        requireSmallCodeModel(address)
        mov(register, AddressExpression64(address.value.toInt()))
    }

    fun load(address: Address, register: GpRegister64, scratchRegister: GpRegister64) {
        check(register != scratchRegister)
        mov(scratchRegister, address.value.toLong())
        mov(register, AddressExpression64(scratchRegister))
    }

    fun load(address: Address, register: MmRegister) {
        requireSmallCodeModel(address)
        movq(register, AddressExpression64(address.value.toInt()))
    }

    fun load(address: Address, register: MmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        movq(register, AddressExpression64(scratchRegister))
    }

    fun load(address: Address, register: XmmRegister) {
        requireSmallCodeModel(address)
        movdqa(register, AddressExpression128(address.value.toInt()))
    }

    fun load(address: Address, register: XmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        movdqa(register, AddressExpression128(scratchRegister))
    }

    fun load(address: Address, register: YmmRegister) {
        requireSmallCodeModel(address)
        vmovdqa(register, AddressExpression256(address.value.toInt()))
    }

    fun load(address: Address, register: YmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        vmovdqa(register, AddressExpression256(scratchRegister))
    }

    fun load(address: Address, register: IpRegister) {
        requireSmallCodeModel(address)
        jmp(AddressExpression64(address.value.toInt()))
    }

    fun load(address: Address, register: IpRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        jmp(scratchRegister)
    }

    fun load(address: Address, register: RflagsRegister, scratchRegister: GpRegister64) {
        requireSmallCodeModel(address)
        mov(scratchRegister, AddressExpression64(address.value.toInt()))
        push(scratchRegister)
        popfq()
    }

    fun load(address: Address, register: RflagsRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        mov(scratchRegister1, address.value.toLong())
        mov(scratchRegister2, AddressExpression64(scratchRegister1))
        push(scratchRegister2)
        popfq()
    }

    fun load(address: Address, register: MxcsrRegister) {
        requireSmallCodeModel(address)
        ldmxcsr(AddressExpression32(address.value.toInt()))
    }

    fun load(address: Address, register: MxcsrRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        ldmxcsr(AddressExpression32(scratchRegister))
    }

    fun store(address: Address, register: GpRegister64) {
        requireSmallCodeModel(address)
        mov(AddressExpression64(address.value.toInt()), register)
    }

    fun store(address: Address, register: GpRegister64, scratchRegister: GpRegister64) {
        check(register != scratchRegister)
        mov(scratchRegister, address.value.toLong())
        mov(AddressExpression64(scratchRegister), register)
    }

    fun store(address: Address, register: MmRegister) {
        requireSmallCodeModel(address)
        movq(AddressExpression64(address.value.toInt()), register)
    }

    fun store(address: Address, register: MmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        movq(AddressExpression64(scratchRegister), register)
    }

    fun store(address: Address, register: XmmRegister) {
        requireSmallCodeModel(address)
        movdqa(AddressExpression128(address.value.toInt()), register)
    }

    fun store(address: Address, register: XmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        movdqa(AddressExpression128(scratchRegister), register)
    }

    fun store(address: Address, register: YmmRegister) {
        requireSmallCodeModel(address)
        vmovdqa(AddressExpression256(address.value.toInt()), register)
    }

    fun store(address: Address, register: YmmRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        vmovdqa(AddressExpression256(scratchRegister), register)
    }

    fun store(address: Address, register: IpRegister, scratchRegister: GpRegister64) {
        requireSmallCodeModel(address)
        lea(scratchRegister, AddressExpression64(IpRegister.RIP))
        mov(AddressExpression64(address.value.toInt()), scratchRegister)
    }

    fun store(address: Address, register: IpRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        mov(scratchRegister1, address.value.toLong())
        lea(scratchRegister2, AddressExpression64(IpRegister.RIP))
        mov(AddressExpression64(scratchRegister1), scratchRegister2)
    }

    fun store(address: Address, register: RflagsRegister, scratchRegister: GpRegister64) {
        requireSmallCodeModel(address)
        pushfq()
        pop(scratchRegister)
        mov(AddressExpression64(address.value.toInt()), scratchRegister)
    }

    fun store(address: Address, register: RflagsRegister, scratchRegister1: GpRegister64, scratchRegister2: GpRegister64) {
        pushfq()
        pop(scratchRegister2)
        mov(scratchRegister1, address.value.toLong())
        mov(AddressExpression64(scratchRegister1), scratchRegister2)
    }

    fun store(address: Address, register: MxcsrRegister) {
        requireSmallCodeModel(address)
        stmxcsr(AddressExpression32(address.value.toInt()))
    }

    fun store(address: Address, register: MxcsrRegister, scratchRegister: GpRegister64) {
        mov(scratchRegister, address.value.toLong())
        stmxcsr(AddressExpression32(scratchRegister))
    }

    fun align(alignment: UInt) {
        val currentAddress = buffer.address.value + buffer.position().toULong()
        val alignedAddress = currentAddress.alignUp(alignment)
        val nopSize = (alignedAddress - currentAddress).toInt()

        nop(nopSize)
    }

    fun align(alignment: Int) = align(alignment.toUInt())

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

    fun link(linkPoint: Assembler.JumpLinkPoint) {
        linkPoint.link(buffer.position())
    }

}