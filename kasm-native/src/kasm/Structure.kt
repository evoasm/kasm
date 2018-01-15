package kasm

import kasm.ext.alignUp
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

        protected abstract fun read(offset: Int): T
        protected abstract fun write(offset: Int, value: T)
        protected val buffer get() = structure.buffer

        val address : Long get() = buffer.getAddress() + offset

        fun getAddress(vararg indices: Int): Long {
            return buffer.getAddress() + getElementOffset(*indices)
        }

        fun get(): T {
            return read(offset)
        }

        fun set(value: T) {
            write(offset, value)
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
            return dimensions[0] * elementSize
        }

        operator fun get(index: Int): T {
          return read(getElementOffset(index))
        }

        operator fun get(vararg dimensions: Int): T {
            return read(getElementOffset(*dimensions))
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return get()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            set(value)
        }
    }

    class ByteField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Byte>() {
        override fun write(offset: Int, value: Byte) {
            writeByte(offset, value)
        }

        private fun writeByte(offset: Int, value: Byte) {
            buffer.putByte(offset, value)
        }

        override val elementSize = 1

        override fun read(offset: Int): Byte {
            return readByte(offset)
        }

        protected fun readByte(offset: Int): Byte {
            return buffer.getByte(offset)
        }
    }

    class ShortField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Short>() {
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

    class IntField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Int>() {
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

    class LongField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Long>() {
        override val elementSize = 8

        override fun read(offset: Int): Long {
            return readLong(offset)
        }

        fun getLong(index: Int) : Long {
            return readLong(getElementOffset(index))
        }

        fun setLong(index: Int, value: Long) {
            writeLong(getElementOffset(index), value)
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


    class Vector64Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector64>() {
        override val elementSize = VectorSize._64.byteSize

        override fun read(offset: Int): Vector64 {
            return readVector64(offset)
        }

        private fun readVector64(offset: Int): Vector64 {
            return buffer.getVector64(offset)
        }

        override fun write(offset: Int, value: Vector64) {
            writeVector64(offset, value)
        }

        protected fun writeVector64(offset: Int, value: Vector64) {
            buffer.putVector64(offset, value)
        }
    }

    class Vector128Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector128>() {
        override val elementSize = VectorSize._128.byteSize

        override fun read(offset: Int): Vector128 {
            return readVector128(offset)
        }

        private fun readVector128(offset: Int): Vector128 {
            return buffer.getVector128(offset)
        }

        override fun write(offset: Int, value: Vector128) {
            writeVector128(offset, value)
        }

        protected fun writeVector128(offset: Int, value: Vector128) {
            buffer.putVector128(offset, value)
        }
    }

    class Vector256Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector256>() {
        override val elementSize = VectorSize._256.byteSize

        override fun read(offset: Int): Vector256 {
            return readVector256(offset)
        }

        private fun readVector256(offset: Int): Vector256 {
            return buffer.getVector256(offset)
        }

        override fun write(offset: Int, value: Vector256) {
            writeVector256(offset, value)
        }

        protected fun writeVector256(offset: Int, value: Vector256) {
            buffer.putVector256(offset, value)
        }
    }

    class Vector512Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector512>() {
        override val elementSize = VectorSize._512.byteSize

        override fun read(offset: Int): Vector512 {
            return readVector512(offset)
        }

        private fun readVector512(offset: Int): Vector512 {
            return buffer.getVector512(offset)
        }

        override fun write(offset: Int, value: Vector512) {
            writeVector512(offset, value)
        }

        protected fun writeVector512(offset: Int, value: Vector512) {
            buffer.putVector512(offset, value)
        }
    }


    private var offset = 0
    private var _fields = mutableListOf<Field<*>>()
    val fields = _fields.toList()
    private var _buffer: NativeBuffer? = null

    val buffer: NativeBuffer
        get() {
            _buffer?.let { return it }
            return NativeBuffer(offset.toLong(), false).also {
                _buffer = it
            }

//        if(_buffer != null) {
//            _buffer = Buffer(offset.toLong(), false)
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

    fun vector64Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): Vector64Field {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            Vector64Field(this, dimensions, fieldOffset)
        }
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): Vector128Field {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            Vector128Field(this, dimensions, fieldOffset)
        }
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): Vector256Field {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            Vector256Field(this, dimensions, fieldOffset)
        }
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): Vector512Field {
        return addField(alignment, alias, aliasOffset) { fieldOffset ->
            Vector512Field(this, dimensions, fieldOffset)
        }
    }

}