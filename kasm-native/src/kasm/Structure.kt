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
                dimensionSizes[0] = elementSize
                for (i in 1 until dimensions.size) {
                    dimensionSizes[i] = dimensionSizes[i - 1] * dimensions[i - 1]
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

        protected abstract fun get(offset: Int): T
        protected abstract fun set(offset: Int, value: T)
        protected val buffer get() = structure.buffer

        fun address(): Long {
            return buffer.getAddress() + offset
        }

        fun address(vararg dimensions: Int): Long {
            return buffer.getAddress() + elementOffset(dimensions)
        }

        fun get(): T {
            return get(offset)
        }

        fun set(value: T) {
            set(offset, value)
        }

        private fun elementOffset(dimensions: IntArray): Int {
            if (dimensions.size != this.dimensions.size) {
                throw IllegalArgumentException("field is of dimension ${this.dimensions.size} but only ${dimensions.size} indexes given")
            }

            var relativeElementOffset = 0
            for (dimensionIndex in dimensions.indices) {
                relativeElementOffset += dimensions[dimensionIndex] * dimensionSizes[dimensionIndex]
            }

            return offset + relativeElementOffset
        }

        operator fun get(vararg dimensions: Int): T {
            return get(elementOffset(dimensions))
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return get()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            set(value)
        }
    }

    class ByteField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Byte>() {
        override fun set(offset: Int, value: Byte) {
            setByte(offset, value)
        }

        private fun setByte(offset: Int, value: Byte) {
            buffer.putByte(offset, value)
        }

        override val elementSize = 1

        override fun get(offset: Int): Byte {
            return getByte(offset)
        }

        protected fun getByte(offset: Int): Byte {
            return buffer.getByte(offset)
        }
    }

    class ShortField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Short>() {
        override val elementSize = 2

        override fun get(offset: Int): Short {
            return getShort(offset)
        }

        private fun getShort(offset: Int): Short {
            return buffer.getShort(offset)
        }

        override fun set(offset: Int, value: Short) {
            setShort(offset, value)
        }

        protected fun setShort(offset: Int, value: Short) {
            buffer.putShort(offset, value)
        }
    }

    class IntField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Int>() {
        override val elementSize = 4

        override fun get(offset: Int): Int {
            return getInt(offset)
        }

        private fun getInt(offset: Int): Int {
            return buffer.getInt(offset)
        }

        override fun set(offset: Int, value: Int) {
            setInt(offset, value)
        }

        protected fun setInt(offset: Int, value: Int) {
            buffer.putInt(offset, value)
        }
    }

    class LongField(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Long>() {
        override val elementSize = 8

        override fun get(offset: Int): Long {
            return getLong(offset)
        }

        private fun getLong(offset: Int): Long {
            return buffer.getLong(offset)
        }

        override fun set(offset: Int, value: Long) {
            setLong(offset, value)
        }

        protected fun setLong(offset: Int, value: Long) {
            buffer.putLong(offset, value)
        }
    }


    class Vector64Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector64>() {
        override val elementSize = VectorSize._64.byteSize

        override fun get(offset: Int): Vector64 {
            return getVector64(offset)
        }

        fun getVector64(offset: Int): Vector64 {
            return buffer.getVector64(offset)
        }

        override fun set(offset: Int, value: Vector64) {
            setVector64(offset, value)
        }

        protected fun setVector64(offset: Int, value: Vector64) {
            buffer.putVector64(offset, value)
        }
    }

    class Vector128Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector128>() {
        override val elementSize = VectorSize._128.byteSize

        override fun get(offset: Int): Vector128 {
            return getVector128(offset)
        }

        fun getVector128(offset: Int): Vector128 {
            return buffer.getVector128(offset)
        }

        override fun set(offset: Int, value: Vector128) {
            setVector128(offset, value)
        }

        protected fun setVector128(offset: Int, value: Vector128) {
            buffer.putVector128(offset, value)
        }
    }

    class Vector256Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector256>() {
        override val elementSize = VectorSize._256.byteSize

        override fun get(offset: Int): Vector256 {
            return getVector256(offset)
        }

        fun getVector256(offset: Int): Vector256 {
            return buffer.getVector256(offset)
        }

        override fun set(offset: Int, value: Vector256) {
            setVector256(offset, value)
        }

        protected fun setVector256(offset: Int, value: Vector256) {
            buffer.putVector256(offset, value)
        }
    }

    class Vector512Field(override val structure: Structure, override val dimensions: IntArray, override val offset: Int) : Field<Vector512>() {
        override val elementSize = VectorSize._512.byteSize

        override fun get(offset: Int): Vector512 {
            return buffer.getVector512(offset)
        }

        fun getVector512(offset: Int): Vector512 {
            return buffer.getVector512(offset)
        }

        override fun set(offset: Int, value: Vector512) {
            setVector512(offset, value)
        }

        protected fun setVector512(offset: Int, value: Vector512) {
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