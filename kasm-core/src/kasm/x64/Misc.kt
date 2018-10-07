package kasm.x64

import java.nio.ByteBuffer

enum class DisplacementSize {
    AUTO {
        override val bitSize: Int get() = throw UnsupportedOperationException()
    },
    _8 {
        override val bitSize get() = 8
    },
    _32 {
        override val bitSize get() = 32
    };
    abstract val bitSize: Int
}

enum class AddressSize {
    _32,
    _64
}

enum class Scale(val code: Int) {
    _1(0),
    _2(1),
    _4(2),
    _8(3);
}

enum class LegacyPrefixGroup {
    _1,
    _2,
    _3,
    _4;

    val prefixes: List<LegacyPrefix>
        get() {
            return LegacyPrefix::class.nestedClasses.flatMap {
                it.nestedClasses
            }.mapNotNull {
                val prefix = it.objectInstance as LegacyPrefix
                if (prefix.prefixGroup == this) {
                    return@mapNotNull prefix
                } else {
                    return@mapNotNull null
                }
            }
        }
}

sealed class LegacyPrefix(val prefixGroup: LegacyPrefixGroup, byte: Int) {

    val byte : Byte = byte.toByte()

    fun encode(buffer: ByteBuffer) {
        buffer.put(byte)
    }

    sealed class Group1(byte: Int) : LegacyPrefix(LegacyPrefixGroup._1, byte) {
        object Lock : Group1(0xF0)
        object Rep : Group1(0xF3)
        object Repne : Group1(0xF2)
    }

    sealed class Group2(byte: Int) : LegacyPrefix(LegacyPrefixGroup._2, byte) {
        object Cs : Group2(0x2E) {
        }

        object Ss : Group2(0x36) {
        }

        object Ds : Group2(0x3E) {
        }

        object Es : Group2(0x26) {
        }

        object Fs : Group2(0x64) {
        }

        object Gs : Group2(0x65) {
        }

        object BranchTaken : Group2(0x3E) {
        }

        object BranchNotTaken : Group2(0x2E) {
        }
    }

    sealed class Group3(byte: Int) : LegacyPrefix(LegacyPrefixGroup._3, byte) {
        object _66 : Group3(0x66) {
        }
    }

    sealed class Group4(byte: Int) : LegacyPrefix(LegacyPrefixGroup._3, byte) {
        object _67 : Group4(0x67) {
        }
    }
}

abstract class AddressExpression(val base: AddressRegister?, val index: AddressRegister?, val scale : Scale, val displacement: Int) {
    val needsRex = base?.rexBit == 1 || index?.rexBit == 1
}

class AddressExpression8(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression16(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression32(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression64(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression128(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression256(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

class AddressExpression512(base: AddressRegister?, index: AddressRegister?, scale: Scale = Scale._1, displacement: Int = 0) : AddressExpression(base, index, scale, displacement) {
    constructor(displacement: Int) : this(null, null, Scale._1, displacement)
    constructor(base: AddressRegister, displacement: Int = 0) : this(base, null, Scale._1, displacement)
}

data class VectorAddressExpression(val base: AddressRegister?, val index: VectorRegister, val scale: Scale = Scale._1, val displacement: Int = 0) {

}
