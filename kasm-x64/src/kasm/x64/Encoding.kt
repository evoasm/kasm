package kasm.x64

import java.nio.ByteBuffer


abstract class SimpleInstructionTracer : InstructionTracer {

    abstract fun traceWrite(register: Register, index: Int, range: BitRange, always: Boolean)
    abstract fun traceRead(register: Register, index: Int, range: BitRange)
    abstract fun traceImplicitWrite(register: Register, range: BitRange, always: Boolean)
    abstract fun traceImplicitRead(register: Register, range: BitRange)
    abstract fun traceImplicitRead(addressExpression: AddressExpression)
    abstract fun traceWrite(addressExpression: AddressExpression, index: Int)
    abstract fun traceRead(addressExpression: AddressExpression, index: Int)
    abstract override fun traceImplicitRead(immediate: Int)
    abstract override fun traceRead(immediate: Long, index: Int, size: BitSize)
    abstract fun traceWrite(statusOrControlField: StatusOrControlField)
    abstract fun traceRead(statusOrControlField: StatusOrControlField)

    override fun traceWrite(register: GpRegister8, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: GpRegister16, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: GpRegister32, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: GpRegister64, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: XmmRegister, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: YmmRegister, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: MmRegister, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)
    override fun traceWrite(register: X87Register, index: Int, range: BitRange, always: Boolean) = traceWrite(register as Register, index, range, always)

    override fun traceRead(register: GpRegister8, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: GpRegister16, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: GpRegister32, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: GpRegister64, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: XmmRegister, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: YmmRegister, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: MmRegister, index: Int, range: BitRange)  = traceRead(register as Register, index, range)
    override fun traceRead(register: X87Register, index: Int, range: BitRange)  = traceRead(register as Register, index, range)

    override fun traceImplicitWrite(register: GpRegister8, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: GpRegister16, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: GpRegister32, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: GpRegister64, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: XmmRegister, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: YmmRegister, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: MmRegister, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: X87Register, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)
    override fun traceImplicitWrite(register: IpRegister, range: BitRange, always: Boolean)  = traceImplicitWrite(register as Register, range, always)


    override fun traceImplicitRead(register: GpRegister8, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: GpRegister16, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: GpRegister32, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: GpRegister64, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: XmmRegister, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: YmmRegister, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: MmRegister, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: X87Register, range: BitRange)  = traceImplicitRead(register as Register, range)
    override fun traceImplicitRead(register: IpRegister, range: BitRange)  = traceImplicitRead(register as Register, range)


    override fun traceImplicitRead(addressExpression: AddressExpression8)  = traceImplicitRead(addressExpression as AddressExpression)


    override fun traceImplicitRead(addressExpression: AddressExpression16)  = traceImplicitRead(addressExpression as AddressExpression)
    override fun traceImplicitRead(addressExpression: AddressExpression32)  = traceImplicitRead(addressExpression as AddressExpression)
    override fun traceImplicitRead(addressExpression: AddressExpression64)  = traceImplicitRead(addressExpression as AddressExpression)


    override fun traceImplicitWrite(addressExpression: AddressExpression8)  = traceImplicitWrite(addressExpression as AddressExpression)

    abstract fun traceImplicitWrite(addressExpression: AddressExpression)

    override fun traceImplicitWrite(addressExpression: AddressExpression16)  = traceImplicitWrite(addressExpression as AddressExpression)
    override fun traceImplicitWrite(addressExpression: AddressExpression32)  = traceImplicitWrite(addressExpression as AddressExpression)
    override fun traceImplicitWrite(addressExpression: AddressExpression64)  = traceImplicitWrite(addressExpression as AddressExpression)


    override fun traceWrite(addressExpression: AddressExpression80, index: Int)  = traceWrite(addressExpression as AddressExpression, index)


    override fun traceWrite(addressExpression: AddressExpression64, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression32, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression16, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression8, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression128, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression256, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression512, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression28Bytes, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression108Bytes, index: Int)  = traceWrite(addressExpression as AddressExpression, index)
    override fun traceWrite(addressExpression: AddressExpression512Bytes, index: Int)  = traceWrite(addressExpression as AddressExpression, index)


    override fun traceRead(addressExpression: AddressExpression64, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression32, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression16, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression8, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression80, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression128, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression256, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression512, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression28Bytes, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression108Bytes, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: AddressExpression512Bytes, index: Int)  = traceRead(addressExpression as AddressExpression, index)
    override fun traceRead(addressExpression: VectorAddressExpression, index: Int) {}

    override fun traceRead(immediate: Byte, index: Int, size: BitSize) = traceRead(immediate.toLong(), index, size)
    override fun traceRead(immediate: Short, index: Int, size: BitSize) = traceRead(immediate.toLong(), index, size)
    override fun traceRead(immediate: Int, index: Int, size: BitSize) = traceRead(immediate.toLong(), index, size)



    override fun traceWrite(rflagsField: RflagsField, always: Boolean) = traceWrite(rflagsField as StatusOrControlField)
    override fun traceWrite(mxcsrField: MxcsrField, always: Boolean) = traceWrite(mxcsrField as StatusOrControlField)
    override fun traceWrite(x87TagField: X87TagField, always: Boolean) = traceWrite(x87TagField as StatusOrControlField)
    override fun traceWrite(x87StatusField: X87StatusField, always: Boolean) = traceWrite(x87StatusField as StatusOrControlField)
    override fun traceWrite(x87ControlField: X87ControlField, always: Boolean) = traceWrite(x87ControlField as StatusOrControlField)

    override fun traceRead(rflagsField: RflagsField) = traceRead(rflagsField as StatusOrControlField)
    override fun traceRead(mxcsrField: MxcsrField) = traceRead(mxcsrField as StatusOrControlField)
    override fun traceRead(x87TagField: X87TagField) =  traceRead(x87TagField as StatusOrControlField)
    override fun traceRead(x87StatusField: X87StatusField) =  traceRead(x87StatusField as StatusOrControlField)
    override fun traceRead(x87ControlField: X87ControlField) = traceRead(x87ControlField as StatusOrControlField)


}

interface InstructionTracer {
    fun beginTracing() {}
    fun endTracing() {}

    fun traceWrite(register: GpRegister8, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: GpRegister16, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: GpRegister32, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: GpRegister64, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: XmmRegister, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: YmmRegister, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: MmRegister, index: Int, range: BitRange, always: Boolean) {}
    fun traceWrite(register: X87Register, index: Int, range: BitRange, always: Boolean) {}

    fun traceRead(register: GpRegister8, index: Int, range: BitRange) {}
    fun traceRead(register: GpRegister16, index: Int, range: BitRange) {}
    fun traceRead(register: GpRegister32, index: Int, range: BitRange) {}
    fun traceRead(register: GpRegister64, index: Int, range: BitRange) {}
    fun traceRead(register: XmmRegister, index: Int, range: BitRange) {}
    fun traceRead(register: YmmRegister, index: Int, range: BitRange) {}
    fun traceRead(register: MmRegister, index: Int, range: BitRange) {}
    fun traceRead(register: X87Register, index: Int, range: BitRange) {}

    fun traceImplicitWrite(register: GpRegister8, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: GpRegister16, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: GpRegister32, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: GpRegister64, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: XmmRegister, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: YmmRegister, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: MmRegister, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: X87Register, range: BitRange, always: Boolean) {}
    fun traceImplicitWrite(register: IpRegister, range: BitRange, always: Boolean) {}

    fun traceImplicitRead(register: GpRegister8, range: BitRange) {}
    fun traceImplicitRead(register: GpRegister16,range: BitRange) {}
    fun traceImplicitRead(register: GpRegister32, range: BitRange) {}
    fun traceImplicitRead(register: GpRegister64, range: BitRange) {}
    fun traceImplicitRead(register: XmmRegister, range: BitRange) {}
    fun traceImplicitRead(register: YmmRegister, range: BitRange) {}
    fun traceImplicitRead(register: MmRegister, range: BitRange) {}
    fun traceImplicitRead(register: X87Register, range: BitRange) {}
    fun traceImplicitRead(register: IpRegister, range: BitRange) {}

    fun traceImplicitRead(immediate: Int) {}
    fun traceImplicitRead(addressExpression: AddressExpression8) {}
    fun traceImplicitRead(addressExpression: AddressExpression16) {}
    fun traceImplicitRead(addressExpression: AddressExpression32) {}
    fun traceImplicitRead(addressExpression: AddressExpression64) {}

    fun traceImplicitWrite(addressExpression: AddressExpression8) {}
    fun traceImplicitWrite(addressExpression: AddressExpression16) {}
    fun traceImplicitWrite(addressExpression: AddressExpression32) {}
    fun traceImplicitWrite(addressExpression: AddressExpression64) {}

    fun traceWrite(addressExpression: AddressExpression80, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression64, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression32, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression16, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression8, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression128, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression256, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression512, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression28Bytes, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression108Bytes, index: Int) {}
    fun traceWrite(addressExpression: AddressExpression512Bytes, index: Int) {}

    fun traceRead(addressExpression: AddressExpression64, index: Int) {}
    fun traceRead(addressExpression: AddressExpression32, index: Int) {}
    fun traceRead(addressExpression: AddressExpression16, index: Int) {}
    fun traceRead(addressExpression: AddressExpression8, index: Int) {}
    fun traceRead(addressExpression: AddressExpression80, index: Int) {}
    fun traceRead(addressExpression: AddressExpression128, index: Int) {}
    fun traceRead(addressExpression: AddressExpression256, index: Int) {}
    fun traceRead(addressExpression: AddressExpression512, index: Int) {}
    fun traceRead(addressExpression: AddressExpression28Bytes, index: Int) {}
    fun traceRead(addressExpression: AddressExpression108Bytes, index: Int) {}
    fun traceRead(addressExpression: AddressExpression512Bytes, index: Int) {}
    fun traceRead(addressExpression: VectorAddressExpression, index: Int) {}

    fun traceRead(immediate: Byte, index: Int, size: BitSize) {}
    fun traceRead(immediate: Short, index: Int, size: BitSize) {}
    fun traceRead(immediate: Int, index: Int, size: BitSize) {}
    fun traceRead(immediate: Long, index: Int, size: BitSize) {}

    fun traceRead(rflagsField: RflagsField) {}
    fun traceWrite(rflagsField: RflagsField, always: Boolean) {}
    fun traceRead(mxcsrField: MxcsrField) {}
    fun traceWrite(mxcsrField: MxcsrField, always: Boolean) {}

    fun traceRead(x87TagField: X87TagField) {}
    fun traceWrite(x87TagField: X87TagField, always: Boolean) {}

    fun traceRead(x87StatusField: X87StatusField) {}
    fun traceWrite(x87StatusField: X87StatusField, always: Boolean) {}
    fun traceRead(x87ControlField: X87ControlField) {}
    fun traceWrite(x87ControlField: X87ControlField, always: Boolean) {}

    fun traceFeature(feature: CpuFeature) {}
}

interface InstructionParameters {
    fun getGpRegister8(index: Int, isRead: Boolean, isWritten: Boolean): GpRegister8 = throw NotImplementedError()
    fun getGpRegister16(index: Int, isRead: Boolean, isWritten: Boolean): GpRegister16 = throw NotImplementedError()
    fun getGpRegister32(index: Int, isRead: Boolean, isWritten: Boolean): GpRegister32 = throw NotImplementedError()
    fun getGpRegister64(index: Int, isRead: Boolean, isWritten: Boolean): GpRegister64 = throw NotImplementedError()
    fun getMmRegister(index: Int, isRead: Boolean, isWritten: Boolean): MmRegister = throw NotImplementedError()
    fun getXmmRegister(index: Int, isRead: Boolean, isWritten: Boolean): XmmRegister = throw NotImplementedError()
    fun getYmmRegister(index: Int, isRead: Boolean, isWritten: Boolean): YmmRegister = throw NotImplementedError()
    fun getZmmRegister(index: Int, isRead: Boolean, isWritten: Boolean): ZmmRegister = throw NotImplementedError()
    fun getX87Register(index: Int, isRead: Boolean, isWritten: Boolean): X87Register = throw NotImplementedError()

    fun getAddressExpression8(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression8 = throw NotImplementedError()
    fun getAddressExpression16(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression16 = throw NotImplementedError()
    fun getAddressExpression32(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression32 = throw NotImplementedError()
    fun getAddressExpression64(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression64 = throw NotImplementedError()
    fun getAddressExpression80(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression80 = throw NotImplementedError()
    fun getAddressExpression128(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression128 = throw NotImplementedError()
    fun getAddressExpression256(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression256 = throw NotImplementedError()
    fun getAddressExpression512(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression512 = throw NotImplementedError()

    fun getAddressExpression28Bytes(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression28Bytes = throw NotImplementedError()
    fun getAddressExpression108Bytes(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression108Bytes = throw NotImplementedError()
    fun getAddressExpression512Bytes(index: Int, isRead: Boolean, isWritten: Boolean): AddressExpression512Bytes = throw NotImplementedError()

    fun getVectorAddress(index: Int, isRead: Boolean, isWritten: Boolean): VectorAddressExpression = throw NotImplementedError()

    fun useSibd(): Boolean = throw NotImplementedError()

    fun getByteImmediate(index: Int): Byte = throw NotImplementedError()
    fun getShortImmediate(index: Int): Short = throw NotImplementedError()
    fun getIntImmediate(index: Int): Int = throw NotImplementedError()
    fun getLongImmediate(index: Int): Long = throw NotImplementedError()
}

data class EncodingOptions(
        var forceRex: Boolean = false,
        var rexR: Int = 0,
        var rexX: Int = 0,
        var rexB: Int = 0,
        var rexW: Int = 0,
        var legacyPrefixOrder: LegacyPrefixOrder = LegacyPrefixOrder.DEFAULT,
        var legacyPrefix1: LegacyPrefix.Group1? = null,
        var legacyPrefix2: LegacyPrefix.Group2? = null,
        var legacyPrefix3: LegacyPrefix.Group3? = null,
        var legacyPrefix4: LegacyPrefix.Group4? = null,
        var lock: Boolean = false,
        var addressSize: AddressSize = AddressSize.BITS_64,
        var forceSib: Boolean = false,
        var displacementSize: DisplacementSize = DisplacementSize.AUTO,
        var forceLongVex: Boolean = false,
        var vexL: Int = 0,
        var vexV: Int = 0,
        var modrmReg: Int = 0,
        val sibScale: Int = 0,
        val sibIndex: Int = 0,
        val sibBase: Int = 0) {

    val encodedLegacyPrefix4: LegacyPrefix.Group4?
        get() {
            return if (addressSize == AddressSize.BITS_32) {
                LegacyPrefix.Group4.Pref67
            } else {
                legacyPrefix4
            }
        }

    data class LegacyPrefixOrder(val firstGroup: LegacyPrefixGroup,
                                 val secondGroup: LegacyPrefixGroup,
                                 val thirdGroup: LegacyPrefixGroup,
                                 val fourthGroup: LegacyPrefixGroup) {
        companion object {
            val DEFAULT = LegacyPrefixOrder(LegacyPrefixGroup.GROUP_1,
                                            LegacyPrefixGroup.GROUP_2,
                                            LegacyPrefixGroup.GROUP_3,
                                            LegacyPrefixGroup.GROUP_4)

            val REVERSE = LegacyPrefixOrder(LegacyPrefixGroup.GROUP_4,
                                            LegacyPrefixGroup.GROUP_3,
                                            LegacyPrefixGroup.GROUP_2,
                                            LegacyPrefixGroup.GROUP_1)

        }
    }

    companion object {
        val DEFAULT = EncodingOptions()
    }
}

object Encoding {

    fun encodeLegacyPrefixes(buffer: ByteBuffer,
                             legacyPrefixOrder: EncodingOptions.LegacyPrefixOrder,
                             legacyPrefix1: LegacyPrefix.Group1?,
                             legacyPrefix2: LegacyPrefix.Group2?,
                             legacyPrefix3: LegacyPrefix.Group3?,
                             legacyPrefix4: LegacyPrefix.Group4?) {

        encodeLegacyPrefixes(buffer,
                             legacyPrefixOrder.firstGroup,
                             legacyPrefix1,
                             legacyPrefix2,
                             legacyPrefix3,
                             legacyPrefix4);
        encodeLegacyPrefixes(buffer,
                             legacyPrefixOrder.secondGroup,
                             legacyPrefix1,
                             legacyPrefix2,
                             legacyPrefix3,
                             legacyPrefix4);
        encodeLegacyPrefixes(buffer,
                             legacyPrefixOrder.thirdGroup,
                             legacyPrefix1,
                             legacyPrefix2,
                             legacyPrefix3,
                             legacyPrefix4);
        encodeLegacyPrefixes(buffer,
                             legacyPrefixOrder.fourthGroup,
                             legacyPrefix1,
                             legacyPrefix2,
                             legacyPrefix3,
                             legacyPrefix4);
    }

    private fun encodeLegacyPrefixes(buffer: ByteBuffer,
                                     legacyGroup: LegacyPrefixGroup,
                                     legacyPrefix1: LegacyPrefix.Group1?,
                                     legacyPrefix2: LegacyPrefix.Group2?,
                                     legacyPrefix3: LegacyPrefix.Group3?,
                                     legacyPrefix4: LegacyPrefix.Group4?) {
        val legacyPrefix = when (legacyGroup) {
            LegacyPrefixGroup.GROUP_1 -> legacyPrefix1
            LegacyPrefixGroup.GROUP_2 -> legacyPrefix2
            LegacyPrefixGroup.GROUP_3 -> legacyPrefix3
            LegacyPrefixGroup.GROUP_4 -> legacyPrefix4
        }

        if (legacyPrefix != null) {
            legacyPrefix.encode(buffer)
        }
    }

    fun encodeOpcode(buffer: ByteBuffer, byte0: Int) {
        buffer.put(byte0.toByte())
    }

    fun encodeOpcodeO(buffer: ByteBuffer, byte0: Int, register: Register) {
        buffer.put((byte0 + register.unextendedCode).toByte())
    }

    fun encodeOpcodeO(buffer: ByteBuffer, byte0: Int, byte1: Int, register: Register) {
        buffer.put(byte0.toByte())
        buffer.put((byte1 + register.unextendedCode).toByte())
    }

    fun encodeOpcode(buffer: ByteBuffer, byte0: Int, byte1: Int) {
        buffer.put(byte0.toByte())
        buffer.put(byte1.toByte())
    }

    fun encodeOpcode(buffer: ByteBuffer, byte0: Int, byte1: Int, byte2: Int) {
        buffer.put(byte0.toByte())
        buffer.put(byte1.toByte())
        buffer.put(byte2.toByte())
    }

    fun encodeImmediate8(buffer: ByteBuffer, immediate: Byte) {
        buffer.put(immediate)
    }

    fun encodeImmediate16(buffer: ByteBuffer, immediate: Short) {
        buffer.putShort(immediate)
    }

    fun encodeImmediate32(buffer: ByteBuffer, immediate: Int) {
        buffer.putInt(immediate)
    }

    fun encodeImmediate64(buffer: ByteBuffer, immediate: Long) {
        buffer.putLong(immediate)
    }

    fun encodeRegisterImmediate(buffer: ByteBuffer, register: VectorRegister) {
        /* FIXME: can we set the trailing 4 bits to arbitrary value ? If so, add encoding option */
        buffer.put(register.code.shl(4).toByte())
    }

}


object ModRmSib {

    fun encode(buffer: ByteBuffer, options: EncodingOptions, reg: Int, register: Register) {
        val mod = 0b11
        val rm = register.unextendedCode

        putModRm(buffer, mod, reg, rm)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register) {
        val mod = 0b11
        val reg = options.modrmReg
        val rm = register.unextendedCode

        putModRm(buffer, mod, reg, rm)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, register0: Register, register1: Register) {
        val mod = 0b11
        val reg = register0.unextendedCode
        val rm = register1.unextendedCode

        putModRm(buffer, mod, reg, rm)
    }

    private fun putModRm(buffer: ByteBuffer, mod: Int, reg: Int, rm: Int) {
        val byte = rm.or(reg.shl(3)).or(mod.shl(6)).toByte()
        buffer.put(byte)
    }

    private fun putSib(buffer: ByteBuffer, scale: Int, index: Int, base: Int) {
        val byte = base.or(index.shl(3)).or(scale.shl(6)).toByte()
        buffer.put(byte)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, reg: Int, addressExpression: AddressExpression) {
        if (addressExpression.base == IpRegister.RIP) {
            encodeRip(buffer, options, reg, addressExpression)
        } else {
            if (addressExpression.index == null) {
                if (addressExpression.base == null) {
                    encodeDisplacementOnly(buffer, options, reg, addressExpression.displacement)
                } else {
                    encodeBaseOnly(buffer, options, reg, addressExpression.base!!, addressExpression.displacement)
                }
            } else {
                if (addressExpression.base == null) {
                    encodeIndexOnly(buffer,
                                    options,
                                    reg,
                                    addressExpression.index!!,
                                    addressExpression.scale,
                                    addressExpression.displacement)
                } else {
                    encodeBaseIndexScale(buffer,
                                         options,
                                         reg,
                                         addressExpression.base!!,
                                         addressExpression.index!!,
                                         addressExpression.scale,
                                         addressExpression.displacement)
                }
            }
        }
    }

    private fun encodeRip(buffer: ByteBuffer, options: EncodingOptions, reg: Int, addressExpression: AddressExpression) {
        if (addressExpression.index != null || addressExpression.scale != Scale.X1) throw EncodingException("RIP base cannot have index or scale")
        encodeBaseOnly(buffer, options, reg, IpRegister.RIP, addressExpression.displacement)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, addressExpression: AddressExpression) {
        val reg = options.modrmReg
        encode(buffer, options, reg, addressExpression)
    }

    private fun encodeBaseIndexScale(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     reg: Int,
                                     base: AddressRegister,
                                     index: Register,
                                     scale: Scale,
                                     displacement: Int) {
        checkIfIndexEncodable(index)
        putModrmSibDisplacement(buffer, options, reg, base, index, scale, displacement)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register, addressExpression: AddressExpression) {
        encode(buffer, options, register.unextendedCode, addressExpression)
    }

    fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register, vectorAddressExpression: VectorAddressExpression) {
        val reg = register.unextendedCode

        if (vectorAddressExpression.base == null) {
            encodeIndexOnlyWithoutIndexCheck(buffer,
                                             options,
                                             reg,
                                             vectorAddressExpression.index,
                                             vectorAddressExpression.scale,
                                             vectorAddressExpression.displacement)
        } else {
            encodeBaseIndexScale(buffer,
                                 options,
                                 reg,
                                 vectorAddressExpression.base!!,
                                 vectorAddressExpression.index,
                                 vectorAddressExpression.scale,
                                 vectorAddressExpression.displacement)
        }
    }

    private fun encodeDisplacementOnly(buffer: ByteBuffer, options: EncodingOptions, reg: Int, displacement: Int) {

        val mod = 0b00
        val rm = 0b100

        putModRm(buffer, mod, reg, rm)

        val scale = options.sibScale
        val index = 0b100 //options.sibIndex
        val base = 0b101

        putSib(buffer, scale, index, base)


        putDisplacement(buffer, displacement)
    }

    private fun checkIfIndexEncodable(index: Register) {
        if (GpRegister.isSp(index)) throw IllegalIndexException(index)
    }

    private fun encodeIndexOnly(buffer: ByteBuffer,
                                options: EncodingOptions,
                                reg: Int,
                                indexRegister: Register,
                                scale: Scale,
                                displacement: Int) {
        checkIfIndexEncodable(indexRegister)

        encodeIndexOnlyWithoutIndexCheck(buffer, options, reg, indexRegister, scale, displacement)
    }

    private fun encodeIndexOnlyWithoutIndexCheck(buffer: ByteBuffer,
                                                 options: EncodingOptions,
                                                 reg: Int,
                                                 indexRegister: Register,
                                                 scale: Scale,
                                                 displacement: Int) {
        val mod = 0b00
        val rm = 0b100

        putModRm(buffer, mod, reg, rm)

        val scaleCode = scale.code
        val index = indexRegister.unextendedCode
        val base = 0b101

        putSib(buffer, scaleCode, index, base)
        putDisplacement(buffer, displacement)
    }

    private fun putDisplacement(buffer: ByteBuffer, displacement: Int) {
        buffer.putInt(displacement)
    }

    private fun putModrmSibDisplacement(buffer: ByteBuffer,
                                        options: EncodingOptions,
                                        reg: Int,
                                        baseRegister: AddressRegister,
                                        indexRegister: Register,
                                        scale: Scale,
                                        displacement: Int) {
        putModrmSibDisplacement(buffer, options, reg, GpRegister64.RSP, baseRegister, displacement) {
            val scaleCode = scale.code
            val index = indexRegister.unextendedCode
            val base = baseRegister.unextendedCode
            putSib(buffer, scaleCode, index, base)
        }
    }

    private fun putModrmSibDisplacement(buffer: ByteBuffer,
                                        options: EncodingOptions,
                                        reg: Int,
                                        baseRegister: AddressRegister,
                                        displacement: Int) {
        putModrmSibDisplacement(buffer, options, reg, GpRegister64.RSP, baseRegister, displacement) {
            val scaleCode = options.sibScale
            val index = GpRegister64.RSP.unextendedCode
            val base = baseRegister.unextendedCode
            putSib(buffer, scaleCode, index, base)
        }
    }

    private fun putModrmDisplacement(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     reg: Int,
                                     baseRegister: AddressRegister,
                                     displacement: Int) {
        putModrmSibDisplacement(buffer, options, reg, baseRegister, null, displacement) {}
    }

    private inline fun putModrmSibDisplacement(buffer: ByteBuffer,
                                               options: EncodingOptions,
                                               reg: Int,
                                               rmRegister: Register,
                                               baseRegister: AddressRegister?,
                                               displacement: Int,
                                               sibAction: () -> Unit) {
        val rm = rmRegister.unextendedCode

        val displacementSize = options.displacementSize
        val canEncodeDisplacementWithMod00 = displacement == 0 && displacementSize == DisplacementSize.AUTO

        // ModRM cannot encode BP and R13 (use for RIP addressing). Use mod01 and put base-only SIB
        val canEncodeRmWithMod00 = !GpRegister.isBp(rmRegister) && !GpRegister.isR13(rmRegister)

        // SIB cannot encode BP and R13 with mod00. Use mod01 and put a dummy zero displacement
        val canEncodeBaseWithMod00 = baseRegister == null || (!GpRegister.isBp(baseRegister) && !GpRegister.isR13(baseRegister))

        if (canEncodeDisplacementWithMod00 && canEncodeRmWithMod00 && canEncodeBaseWithMod00) {
            val mod = 0b00
            putModRm(buffer, mod, reg, rm)
            sibAction()
        } else if (displacementSize != DisplacementSize._32 && displacement >= Byte.MIN_VALUE && displacement <= Byte.MAX_VALUE) {
            val mod = 0b01
            putModRm(buffer, mod, reg, rm)
            sibAction()
            buffer.put(displacement.toByte())
        } else {
            if(displacementSize == DisplacementSize._8) {
                throw OversizedDisplacementException(displacement, displacementSize)
            }
            val mod = 0b10
            putModRm(buffer, mod, reg, rm)
            sibAction()
            buffer.putInt(displacement)
        }
    }

    private fun encodeBaseOnly(buffer: ByteBuffer,
                               options: EncodingOptions,
                               reg: Int,
                               baseRegister: AddressRegister,
                               displacement: Int) {
        if (baseRegister == IpRegister.RIP) {
            val mod = 0b00
            val rm = 0b101
            putModRm(buffer, mod, reg, rm)
            putDisplacement(buffer, displacement)
        } else {
            val needSib = GpRegister.isSp(baseRegister) || GpRegister.isR12(
                    baseRegister) || options.forceSib
            if (needSib) {
                putModrmSibDisplacement(buffer, options, reg, baseRegister, displacement)
            } else {
                putModrmDisplacement(buffer, options, reg, baseRegister, displacement)
            }

        }
    }
}

open class EncodingException(message: String) : Exception(message) {

}

class IllegalIndexException(val index: Register) : EncodingException("$index cannot be encoded as index") {

}

class OversizedDisplacementException(var displacement: Int,
                                     var displacementSize: DisplacementSize) : EncodingException("$displacement cannot be encoded as ${displacementSize.bitSize}-bit displacement")


sealed class VexPrefix {

    companion object {

        protected fun threeByteVexNeeded(options: EncodingOptions,
                                         vexW: Int,
                                         vexX: Int,
                                         vexB: Int,
                                         vexM: Int): Boolean {
            return vexM != 0x01 || vexX != 0 || vexB != 0 || vexW != 0 || options.forceLongVex
        }

        protected fun putVex(buffer: ByteBuffer,
                             options: EncodingOptions,
                             vexW: Int,
                             vexR: Int,
                             vexX: Int,
                             vexB: Int,
                             vexM: Int,
                             vexV: Int,
                             vexL: Int,
                             vexP: Int) {
            if (threeByteVexNeeded(options, vexW, vexX, vexB, vexM)) {
                putThreeByteVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
            } else {
                putTwoByteVex(buffer, vexR, vexV, vexL, vexP)
            }
        }

        private fun Int.maskedInv(mask: Int): Int {
            return this.inv().and(mask)
        }

        private fun putTwoByteVex(buffer: ByteBuffer, vexR: Int, vexV: Int, vexL: Int, vexP: Int) {
            buffer.put(0xC5.toByte())
            val byte = vexP.or(vexL.shl(2)).or(vexV.maskedInv(0b1111).shl(3)).or(vexR.maskedInv(0b1).shl(7)).toByte()
            buffer.put(byte)
        }

        private fun putThreeByteVex(buffer: ByteBuffer,
                                    options: EncodingOptions,
                                    vexW: Int,
                                    vexR: Int,
                                    vexX: Int,
                                    vexB: Int,
                                    vexM: Int,
                                    vexV: Int,
                                    vexL: Int,
                                    vexP: Int) {
            buffer.put(0xC4.toByte())

            val secondByte = vexM.or(vexB.maskedInv(0b1).shl(5)).or(vexX.maskedInv(0b1).shl(6)).or(vexR.maskedInv(0b1).shl(
                    7)).toByte()
            val thirdByte = vexP.or(vexL.shl(2)).or(vexV.maskedInv(0b1111).shl(3)).or(vexW.shl(7)).toByte()

            buffer.put(secondByte)
            buffer.put(thirdByte)
        }
    }

    object Np : VexPrefix() {

        fun encode(buffer: ByteBuffer, options: EncodingOptions, vexW: Int, vexM: Int, vexL: Int, vexP: Int) {
            putVex(buffer, options, vexW, options.rexR, options.rexX, options.rexB,
                   vexM, options.vexV, vexL, vexP)
        }
    }

    object RegRm : VexPrefix() {

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register: Register,
                   addressExpression: AddressExpression) {

            val vexR = register.rexBit
            val vexX = addressExpression.index?.rexBit ?: options.rexX
            val vexB = addressExpression.base?.rexBit ?: options.rexB

            /* FIXME: does it have to be zero ? */
            val vexV = 0

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register0: Register,
                   register1: Register) {
            val vexR = register0.rexBit
            val vexX = options.rexX
            val vexB = register1.rexBit

            /* FIXME: does it have to be zero ? */
            val vexV = 0

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }

    }

    object RmVex : VexPrefix() {

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   addressExpression: AddressExpression,
                   register: Register) {

            val vexR = options.rexR
            val vexX = addressExpression.index?.rexBit ?: options.rexX
            val vexB = addressExpression.base?.rexBit ?: options.rexB
            val vexV = register.code

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register0: Register,
                   register1: Register) {
            val vexR = register0.rexBit
            val vexX = options.rexX
            val vexB = options.rexB
            val vexV = register1.code

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }
    }

    object Rm : VexPrefix() {

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   addressExpression: AddressExpression) {
            val vexR = options.rexR
            val vexX = addressExpression.index?.rexBit ?: options.rexX
            val vexB = addressExpression.base?.rexBit ?: options.rexB
            val vexV = options.vexV

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }
    }

    object RegRmVex : VexPrefix() {

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register0: Register,
                   addressExpression: AddressExpression,
                   register1: Register) {

            val vexR = register0.rexBit
            val vexX = addressExpression.index?.rexBit ?: options.rexX
            val vexB = addressExpression.base?.rexBit ?: options.rexB
            val vexV = register1.code

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register0: Register,
                   vectorAddressExpression: VectorAddressExpression,
                   register1: Register) {

            val vexR = register0.rexBit
            val vexX = vectorAddressExpression.index.rexBit
            val vexB = vectorAddressExpression.base?.rexBit ?: options.rexB
            val vexV = register1.code

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }

        fun encode(buffer: ByteBuffer,
                   options: EncodingOptions,
                   vexW: Int,
                   vexM: Int,
                   vexL: Int,
                   vexP: Int,
                   register0: Register,
                   register1: Register,
                   register2: Register) {
            val vexR = register0.rexBit
            val vexX = options.rexX
            val vexB = register1.rexBit
            val vexV = register2.code

            putVex(buffer, options, vexW, vexR, vexX, vexB, vexM, vexV, vexL, vexP)
        }
    }
}


sealed class RexPrefix {

    companion object {
        protected fun putRex(buffer: ByteBuffer, rexW: Int, rexR: Int, rexX: Int, rexB: Int) {
            val byte = rexB.shl(0).or(rexX.shl(1)).or(rexR.shl(2)).or(rexW.shl(3)).or(0b0100.shl(4)).toByte()
            buffer.put(byte)
        }

        protected fun throwNotEncodable() {
            throw IllegalArgumentException("cannot encode REX")
        }
    }

    object RegRm : RexPrefix() {

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register, addressExpression: AddressExpression) {
            if (options.forceRex || register.rexBit == 1 || addressExpression.needsRex) {
                putRex(buffer, options, options.rexW, register, addressExpression)
            }
        }

        internal fun encodeMandatory(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     rexW: Int,
                                     register: Register,
                                     addressExpression: AddressExpression) {
            putRex(buffer, options, rexW, register, addressExpression)
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register0: Register, register1: Register) {
            if (options.forceRex || register0.rexBit == 1 || register1.rexBit == 1) {
                putRex(buffer, options, options.rexW, register0, register1)
            }
        }

        internal fun encodeMandatory(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     rexW: Int,
                                     register0: Register,
                                     register1: Register) {
            putRex(buffer, options, rexW, register0, register1)
        }

        internal fun putRex(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, register: Register, addressExpression: AddressExpression) {
            val rexR = register.rexBit
            val rexX = addressExpression.index?.rexBit ?: options.rexX
            val rexB = addressExpression.base?.rexBit ?: options.rexB

            putRex(buffer, rexW, rexR, rexX, rexB)
        }

        internal fun putRex(buffer: ByteBuffer,
                            options: EncodingOptions,
                            rexW: Int,
                            register0: Register,
                            register1: Register) {
            val rexR = register0.rexBit
            val rexX = options.rexX
            val rexB = register1.rexBit

            putRex(buffer, rexW, rexR, rexX, rexB)
        }
    }

    object RegRm8 : RexPrefix() {

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register0: GpRegister8, register1: GpRegister8) {
            if (options.forceRex || register0.rexBit == 1 || register1.rexBit == 1 || register0.needsRex || register1.needsRex) {
                if (register0.forbidsRex || register1.forbidsRex) throwNotEncodable()
                RegRm.putRex(buffer, options, options.rexW, register0, register1)
            }
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register0: GpRegister, register1: GpRegister8) {
            if (options.forceRex || register0.rexBit == 1 || register1.rexBit == 1 || register1.needsRex) {
                if (register1.forbidsRex) throwNotEncodable()
                RegRm.putRex(buffer, options, options.rexW, register0, register1)
            }
        }

        internal fun encodeMandatory(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     rexW: Int,
                                     register0: GpRegister,
                                     register1: GpRegister8) {
            RegRm.putRex(buffer, options, rexW, register0, register1)
        }


        internal fun encodeMandatory(buffer: ByteBuffer,
                                     options: EncodingOptions,
                                     rexW: Int,
                                     register: GpRegister,
                                     addressExpression: AddressExpression) {
            RegRm.encodeMandatory(buffer, options, rexW, register, addressExpression)
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: GpRegister, addressExpression: AddressExpression) {
            RegRm.encode(buffer, options, register, addressExpression)
        }

    }

    object Np : RexPrefix() {

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int) {
            putRex(buffer, options, rexW)
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions) {
            if (options.forceRex) {
                putRex(buffer, options, options.rexW)
            }
        }

        private fun putRex(buffer: ByteBuffer, options: EncodingOptions, rexW: Int) {
            val rexR = options.rexR
            val rexX = options.rexX
            val rexB = options.rexB

            putRex(buffer, rexW, rexR, rexX, rexB)
        }
    }

    object Reg8 : RexPrefix() {

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: GpRegister8) {
            if (options.forceRex || register.rexBit == 1 || register.needsRex) {
                if (register.forbidsRex) throwNotEncodable()
                Reg.putRex(buffer, options, options.rexW, register)
            }
        }
    }

    object Rm8 : RexPrefix() {
        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, addressExpression: AddressExpression) {
            if (options.forceRex || addressExpression.needsRex) {
                Rm.encode(buffer, options, addressExpression)
            }
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: GpRegister8) {
            if (options.forceRex || register.rexBit == 1 || register.needsRex) {
                if (register.forbidsRex) throwNotEncodable()
                Reg8.encode(buffer, options, register)
            }
        }

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, addressExpression: AddressExpression) {
            Rm.putRex(buffer, options, rexW, addressExpression)
        }

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, register: GpRegister8) {
            Reg.putRex(buffer, options, rexW, register)
        }

    }

    object Reg : RexPrefix() {

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register) {
            if (options.forceRex || register.rexBit == 1) {
                putRex(buffer, options, options.rexW, register)
            }
        }

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, register: Register) {
            putRex(buffer, options, rexW, register)
        }

        internal fun putRex(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, register: Register) {
            val rexR = options.rexR
            val rexX = options.rexX
            val rexB = register.rexBit

            putRex(buffer, rexW, rexR, rexX, rexB)
        }
    }

    object Rm : RexPrefix() {

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, addressExpression: AddressExpression) {
            putRex(buffer, options, rexW, addressExpression)
        }

        internal fun encodeMandatory(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, register: Register) {
            Reg.putRex(buffer, options, rexW, register)
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, addressExpression: AddressExpression) {
            if (options.forceRex || addressExpression.needsRex) {
                putRex(buffer, options, options.rexW, addressExpression)
            }
        }

        internal fun encode(buffer: ByteBuffer, options: EncodingOptions, register: Register) {
            if (options.forceRex || register.rexBit == 1) {
                Reg.putRex(buffer, options, options.rexW, register)
            }
        }

        fun putRex(buffer: ByteBuffer, options: EncodingOptions, rexW: Int, addressExpression: AddressExpression) {
            val rexR = options.rexR
            val rexX = addressExpression.index?.rexBit ?: options.rexX
            val rexB = addressExpression.base?.rexBit ?: options.rexB

            putRex(buffer, rexW, rexR, rexX, rexB)
        }

    }
}

