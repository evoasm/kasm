package kasm

import kasm.ext.alignDown
import kasm.ext.alignUp

@ExperimentalUnsignedTypes
inline class Address(val value: ULong) {
    override fun toString() : String {
        return value.toString(16)
    }

    fun alignDown(alignment: UInt) : Address {
        return Address(value.alignDown(alignment))
    }

    fun alignUp(alignment: UInt) : Address {
        return Address(value.alignUp(alignment))
    }

    operator fun plus(value: ULong): Address {
        return Address(this.value + value)
    }

    operator fun minus(other: Address): Address {
        return Address(this.value - other.value)
    }
}