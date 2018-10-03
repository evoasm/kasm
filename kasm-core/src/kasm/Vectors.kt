package kasm

import java.nio.*

fun ByteBuffer.getVector64(offset: Int) : ByteArray {
    val array = ByteArray(8)
    this.get(array, offset, array.size)
    return array
}

fun ShortBuffer.getVector64(offset: Int) : ShortArray {
    val array = ShortArray(4)
    this.get(array, offset, array.size)
    return array
}

fun IntBuffer.getVector64(offset: Int) : IntArray {
    val array = IntArray(2)
    this.get(array, offset, array.size)
    return array
}

fun LongBuffer.getVector64(offset: Int) : LongArray {
    val array = LongArray(1)
    this.get(array, offset, array.size)
    return array
}

fun FloatBuffer.getVector64(offset: Int) : FloatArray {
    val array = FloatArray(2)
    this.get(array, offset, array.size)
    return array
}

fun DoubleBuffer.getVector64(offset: Int) : DoubleArray {
    val array = DoubleArray(1)
    this.get(array, offset, array.size)
    return array
}



fun ByteBuffer.getVector128(offset: Int) : ByteArray {
    val array = ByteArray(16)
    this.get(array, offset, array.size)
    return array
}

fun ShortBuffer.getVector128(offset: Int) : ShortArray {
    val array = ShortArray(8)
    this.get(array, offset, array.size)
    return array
}

fun IntBuffer.getVector128(offset: Int) : IntArray {
    val array = IntArray(4)
    this.get(array, offset, array.size)
    return array
}

fun LongBuffer.getVector128(offset: Int) : LongArray {
    val array = LongArray(2)
    this.get(array, offset, array.size)
    return array
}

fun FloatBuffer.getVector128(offset: Int) : FloatArray {
    val array = FloatArray(4)
    this.get(array, offset, array.size)
    return array
}

fun DoubleBuffer.getVector128(offset: Int) : DoubleArray {
    val array = DoubleArray(2)
    this.get(array, offset, array.size)
    return array
}




fun ByteBuffer.getVector256(offset: Int) : ByteArray {
    val array = ByteArray(32)
    this.get(array, offset, array.size)
    return array
}

fun ShortBuffer.getVector256(offset: Int) : ShortArray {
    val array = ShortArray(16)
    this.get(array, offset, array.size)
    return array
}

fun IntBuffer.getVector256(offset: Int) : IntArray {
    val array = IntArray(8)
    this.get(array, offset, array.size)
    return array
}

fun LongBuffer.getVector256(offset: Int) : LongArray {
    val array = LongArray(4)
    this.get(array, offset, array.size)
    return array
}

fun FloatBuffer.getVector256(offset: Int) : FloatArray {
    val array = FloatArray(8)
    this.get(array, offset, array.size)
    return array
}

fun DoubleBuffer.getVector256(offset: Int) : DoubleArray {
    val array = DoubleArray(4)
    this.get(array, offset, array.size)
    return array
}

fun ByteBuffer.getVector512(offset: Int) : ByteArray {
    val array = ByteArray(64)
    this.get(array, offset, array.size)
    return array
}

fun ShortBuffer.getVector512(offset: Int) : ShortArray {
    val array = ShortArray(32)
    this.get(array, offset, array.size)
    return array
}

fun IntBuffer.getVector512(offset: Int) : IntArray {
    val array = IntArray(16)
    this.get(array, offset, array.size)
    return array
}

fun LongBuffer.getVector512(offset: Int) : LongArray {
    val array = LongArray(8)
    this.get(array, offset, array.size)
    return array
}

fun FloatBuffer.getVector512(offset: Int) : FloatArray {
    val array = FloatArray(16)
    this.get(array, offset, array.size)
    return array
}

fun DoubleBuffer.getVector512(offset: Int) : DoubleArray {
    val array = DoubleArray(8)
    this.get(array, offset, array.size)
    return array
}



enum class VectorSize(val bitSize: Int) {
    _64(64),
    _128(128),
    _256(256),
    _512(512);
    val byteSize = bitSize / 8
    val longSize = bitSize / 64

    companion object {
        fun get(byteSize: Int) : VectorSize {
            return when(byteSize) {
                8 -> _64
                16 -> _128
                32 -> _256
                64 -> _512
                else -> throw IllegalArgumentException("invalid vector size $byteSize")
            }
        }
    }
}

abstract class Vector {
    private var buffer : ByteBuffer
    private val size: VectorSize

    constructor(size: VectorSize, bytes: ByteArray) {
        if(VectorSize.get(bytes.size) != size) {
            throw IllegalArgumentException()
        }

        this.size = size
        buffer = ByteBuffer.wrap(bytes)
    }

    constructor(size: VectorSize) {
        this.size = size
        this.buffer = ByteBuffer.allocate(size.byteSize)
    }

    fun getByte(index: Int) = buffer.get(index)
    fun getShort(index: Int) = buffer.getShort(index * 2)
    fun getInt(index: Int) = buffer.getInt(index * 4)
    fun getLong(index: Int) = buffer.getLong(index * 8)

    operator fun get(index: Int) = getByte(index)

    operator fun set(index: Int, value: Byte) = buffer.put(index, value)
    operator fun set(index: Int, value: Short) = buffer.putShort(index * 2, value)
    operator fun set(index: Int, value: Int) = buffer.putInt(index * 4, value)
    operator fun set(index: Int, value: Long) = buffer.putLong(index * 8, value)
    operator fun set(index: Int, value: Float) = buffer.putFloat(index * 4, value)
    operator fun set(index: Int, value: Double) = buffer.putDouble(index * 8, value)

    fun array() : ByteArray = buffer.array()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector

        if (size != other.size) return false
        for (index in 0 until size.longSize) {
            if(getLong(index) != other.getLong(index)) {
                return false
            }
        }
        return true
    }

    override fun hashCode(): Int {
        var result = size.bitSize
        for (index in 0 until size.longSize) {
            result *= 31 * getLong(index).toInt()
        }
        return result
    }
}

class Vector64 : Vector {
    constructor(bytes: ByteArray): super(VectorSize._64, bytes)
    constructor(): super(VectorSize._64)
}

class Vector128 : Vector {
    constructor(bytes: ByteArray): super(VectorSize._128, bytes)
    constructor(): super(VectorSize._128)
}

class Vector256 : Vector {
    constructor(bytes: ByteArray): super(VectorSize._256, bytes)
    constructor(): super(VectorSize._256)
}

class Vector512 : Vector {
    constructor(bytes: ByteArray): super(VectorSize._512, bytes)
    constructor(): super(VectorSize._512)
}

