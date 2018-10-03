package kasm

import kasm.ext.alignUp
import java.nio.ByteBuffer
import kotlin.math.max
import kotlin.reflect.KProperty

open class Structure() {

    abstract class Field<T> {
        abstract val structure: Structure
        abstract val dimensions: IntArray
        abstract val offset: Int
        abstract val elementSize: Int

        private val dimensionSizes: IntArray by lazy(LazyThreadSafetyMode.NONE) {
            IntArray(dimensions.size).also { dimensionSizes ->
                dimensionSizes[dimensionSizes.lastIndex] = elementSize
                for (i in dimensionSizes.lastIndex - 1 downTo 0) {
                    dimensionSizes[i] = dimensionSizes[i + 1] * dimensions[i + 1]
                }
            }
        }

//        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
//        }
//
//        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//            println("$value has been assigned to '${property.name}' in $thisRef.")
//        }


        private var _size: Int = 0
        val size: Int
            get() {
                if (_size != 0) return _size
                _size = if (dimensions.isEmpty()) {
                    elementSize
                } else {
                    elementSize * dimensions.reduce { acc, dimension -> acc * dimension }
                }
                return _size
            }

        protected val buffer get() = structure.buffer

        val address : Long get() = ExecutableBuffer.getAddress(buffer) + offset

        fun getAddress(vararg indices: Int): Long {
            return ExecutableBuffer.getAddress(buffer) + getElementOffset(*indices)
        }

        fun getElementOffset(vararg indices: Int): Int {
            if (indices.size != this.dimensions.size) {
                throw IllegalArgumentException("field is of dimension ${this.dimensions.size} but only ${indices.size} indices given")
            }

            var relativeElementOffset = 0
            for (dimensionIndex in indices.indices) {
                relativeElementOffset += indices[dimensionIndex] * dimensionSizes[dimensionIndex]
            }

            return offset + relativeElementOffset
        }

        fun getElementOffset(index: Int) : Int {
            check(dimensions.size == 1)
            check(index < dimensions.first())
            return offset + index * elementSize
        }

    }

    abstract class ValueField<T> : Field<T>() {
        protected abstract fun read(offset: Int): T
        protected abstract fun write(offset: Int, value: T)

        fun get(): T {
            return read(offset)
        }

        fun set(value: T) {
            write(offset, value)
        }

        operator fun get(index: Int): T {
            return read(getElementOffset(index))
        }

        operator fun get(vararg indices: Int): T {
            return read(getElementOffset(*indices))
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return get()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            set(value)
        }
    }

    class ByteField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : ValueField<Byte>() {
        override fun write(offset: Int, value: Byte) {
            writeByte(offset, value)
        }

        private fun writeByte(offset: Int, value: Byte) {
            buffer.put(offset, value)
        }

        override val elementSize = 1

        override fun read(offset: Int): Byte {
            return readByte(offset)
        }

        protected fun readByte(offset: Int): Byte {
            return buffer.get(offset)
        }
    }

    class ShortField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : ValueField<Short>() {
        override val elementSize = 2

        override fun read(offset: Int): Short {
            return readShort(offset)
        }

        private fun readShort(offset: Int): Short {
            return buffer.getShort(offset)
        }

        override fun write(offset: Int, value: Short) {
            writeShort(offset, value)
        }

        protected fun writeShort(offset: Int, value: Short) {
            buffer.putShort(offset, value)
        }
    }

    class IntField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : ValueField<Int>() {
        override val elementSize = 4

        override fun read(offset: Int): Int {
            return readInt(offset)
        }

        private fun readInt(offset: Int): Int {
            return buffer.getInt(offset)
        }

        override fun write(offset: Int, value: Int) {
            writeInt(offset, value)
        }

        protected fun writeInt(offset: Int, value: Int) {
            buffer.putInt(offset, value)
        }
    }

    class LongField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : ValueField<Long>() {
        override val elementSize = 8

        override fun read(offset: Int): Long {
            return readLong(offset)
        }

        private fun readLong(offset: Int): Long {
            return buffer.getLong(offset)
        }

        override fun write(offset: Int, value: Long) {
            writeLong(offset, value)
        }

        protected fun writeLong(offset: Int, value: Long) {
            buffer.putLong(offset, value)
        }
    }


    class VectorField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int, override val elementSize: Int) : Field<ByteBuffer>() {

        private val byteBuffer = buffer
        private val shortBuffer = buffer.asShortBuffer()
        private val intBuffer = buffer.asIntBuffer()
        private val longBuffer = buffer.asLongBuffer()

        fun read(offset: Int, array: ByteArray) {
            byteBuffer.get(array, offset, elementSize)
        }

        fun read(offset: Int, array: ShortArray) {
            shortBuffer.get(array, offset, elementSize / 2)
        }

        fun read(offset: Int, array: IntArray) {
            intBuffer.get(array, offset, elementSize / 4)
        }

        fun read(offset: Int, array: LongArray) {
            longBuffer.get(array, offset, elementSize / 8)
        }

        fun get(array: ByteArray, vararg indices: Int) {
            read(getElementOffset(*indices), array)
        }

        fun get(array: ShortArray, vararg indices: Int) {
            read(getElementOffset(*indices), array)
        }

        fun get(array: IntArray, vararg indices: Int) {
            read(getElementOffset(*indices), array)
        }

        fun get(array: LongArray, vararg indices: Int) {
            read(getElementOffset(*indices), array)
        }




        fun write(offset: Int, array: ByteArray) {
            byteBuffer.put(array, offset, elementSize)
        }

        fun write(offset: Int, array: ShortArray) {
            shortBuffer.put(array, offset, elementSize / 2)
        }

        fun write(offset: Int, array: IntArray) {
            intBuffer.put(array, offset, elementSize / 4)
        }

        fun write(offset: Int, array: LongArray) {
            longBuffer.put(array, offset, elementSize / 8)
        }

        fun set(array: ByteArray, vararg indices: Int) {
            write(getElementOffset(*indices), array)
        }

        fun set(array: ShortArray, vararg indices: Int) {
            write(getElementOffset(*indices), array)
        }

        fun set(array: IntArray, vararg indices: Int) {
            write(getElementOffset(*indices), array)
        }

        fun set(array: LongArray, vararg indices: Int) {
            write(getElementOffset(*indices), array)
        }



    }


    private var offset = 0
    private var _fields = mutableListOf<Field<*>>()
    val fields = _fields.toList()
    private var _buffer: ByteBuffer? = null

    val buffer: ByteBuffer
        get() {
            _buffer?.let { return it }
            return ByteBuffers.allocateLittleEndianDirect(offset).also {
                _buffer = it
            }

//        if(_buffer != null) {
//            _buffer = ByteBuffers(offset.toLong(), false)
//        }
//        return _buffer!!
        }

    private inline fun <T : Field<*>> addField(alignment: Int, alias: Field<*>? = null, aliasOffset: Int, action: (Int) -> T): T {
        val fieldOffset = if (alias != null) {
            alias.offset + aliasOffset
        } else {
            offset.alignUp(alignment)
        }

        return action(fieldOffset).also {
            _fields.add(it)
            offset = max(offset, fieldOffset + it.size)
        }
    }

    fun byteField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): ByteField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            ByteField(this, dimensions, fieldOffset)
        }
    }

    fun shortField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): ShortField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            ShortField(this, dimensions, fieldOffset)
        }
    }

    fun intField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): IntField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            IntField(this, dimensions, fieldOffset)
        }
    }

    fun longField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): LongField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            LongField(this, dimensions, fieldOffset)
        }
    }

    fun vector64Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            VectorField(this, dimensions, fieldOffset, 8)
        }
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            VectorField(this, dimensions, fieldOffset, 16)
        }
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            VectorField(this, dimensions, fieldOffset, 32)
        }
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            VectorField(this, dimensions, fieldOffset, 64)
        }
    }

}