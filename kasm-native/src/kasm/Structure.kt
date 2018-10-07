package kasm

import java.nio.ByteBuffer
import kotlin.reflect.KProperty

@ExperimentalUnsignedTypes
open class Structure() {

    abstract class Field<T>(val structure: Structure,
                            val index : Int,
                            val dimensions: IntArray,
                            val alignment: Int,
                            val alias: Field<*>?,
                            val aliasOffset: Int
                            ) {

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

        val address get() = structure.address + offset.toULong()
        val offset get() = structure.getFieldOffset(index)

        fun getAddress(vararg indices: Int): Address {
            return address + getElementOffset(*indices).toULong()
        }

        internal fun getElementOffset(vararg indices: Int): Int {
            return offset + getRelativeElementOffset(*indices)
        }

        internal fun getRelativeElementOffset(vararg indices: Int): Int {
            if (indices.size != this.dimensions.size) {
                throw IllegalArgumentException("field is of dimension ${this.dimensions.size} but only ${indices.size} indices given")
            }

            var relativeElementOffset = 0
            for (dimensionIndex in indices.indices) {
                relativeElementOffset += indices[dimensionIndex] * dimensionSizes[dimensionIndex]
            }

            return relativeElementOffset
        }

        internal fun getElementOffset(index: Int) : Int {
            check(dimensions.size == 1)
            check(index < dimensions.first())
            return offset + index * elementSize
        }

    }

    abstract class ValueField<T>(structure: Structure,
                                 index: Int,
                                 dimensions: IntArray,
                                 alignment: Int,
                                 alias: Field<*>?,
                                 aliasOffset: Int) : Field<T>(structure,
                                                              index,
                                                              dimensions,
                                                              alignment,
                                                              alias,
                                                              aliasOffset) {
        protected abstract fun read(offset: Int): T
        protected abstract fun write(offset: Int, value: T)

        fun contentEquals(other: ValueField<T>): Boolean {
            return get() == other.get()
        }

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

    class ByteField(structure: Structure,
                    index: Int,
                    dimensions: IntArray,
                    alignment: Int,
                    alias: Field<*>?,
                    aliasOffset: Int) : ValueField<Byte>(structure, index, dimensions, alignment, alias, aliasOffset) {
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

    class ShortField(structure: Structure,
                     index: Int,
                     dimensions: IntArray,
                     alignment: Int,
                     alias: Field<*>?,
                     aliasOffset: Int) : ValueField<Short>(structure,
                                                           index,
                                                           dimensions,
                                                           alignment,
                                                           alias,
                                                           aliasOffset) {
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

    class IntField(structure: Structure,
                   index: Int,
                   dimensions: IntArray,
                   alignment: Int,
                   alias: Field<*>?,
                   aliasOffset: Int) : ValueField<Int>(structure, index, dimensions, alignment, alias, aliasOffset) {
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

    class LongField(structure: Structure,
                    index: Int,
                    dimensions: IntArray,
                    alignment: Int,
                    alias: Field<*>?,
                    aliasOffset: Int) : ValueField<Long>(structure, index, dimensions, alignment, alias, aliasOffset) {
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


    class VectorField(structure: Structure,
                      index: Int,
                      dimensions: IntArray,
                      alignment: Int,
                      alias: Field<*>?,
                      aliasOffset: Int,
                      override val elementSize: Int) : Field<ByteBuffer>(structure,
                                                            index,
                                                            dimensions,
                                                            alignment,
                                                            alias,
                                                            aliasOffset) {


        private val shortBuffer by lazy(LazyThreadSafetyMode.NONE) {  buffer.asShortBuffer() }
        private val intBuffer by lazy(LazyThreadSafetyMode.NONE) { buffer.asIntBuffer() }
        private val longBuffer by lazy(LazyThreadSafetyMode.NONE) {  buffer.asLongBuffer() }

        fun readByteArray(offset: Int, array: ByteArray) {
            buffer.position(offset)
            buffer.get(array, 0, elementSize)
        }

        fun readShortArray(offset: Int, array: ShortArray) {
            shortBuffer.position(offset)
            shortBuffer.get(array, 0, elementSize / 2)
        }

        fun readIntArray(offset: Int, array: IntArray) {
            intBuffer.position(offset)
            intBuffer.get(array, 0, elementSize / 4)
        }

        fun readLongArray(offset: Int, array: LongArray) {
            longBuffer.position(offset)
            longBuffer.get(array, 0, elementSize / 8)
        }

        fun getByteArray(vararg indices: Int, array: ByteArray? = null) : ByteArray {
            val array_ = if(array != null) array else ByteArray(elementSize)
            readByteArray(getElementOffset(*indices), array_)
            return array_
        }

        fun getShortArray(vararg indices: Int, array: ShortArray? = null) : ShortArray {
            val array_ = if(array != null) array else ShortArray(elementSize / 2)
            readShortArray(getElementOffset(*indices), array_)
            return array_
        }

        fun getIntArray(vararg indices: Int, array: IntArray? = null): IntArray {
            val array_ = if(array != null) array else IntArray(elementSize / 4)
            readIntArray(getElementOffset(*indices), array_)
            return array_
        }

        fun getLongArray(vararg indices: Int, array: LongArray? = null): LongArray {
            val array_ = if(array != null) array else LongArray(elementSize / 8)
            readLongArray(getElementOffset(*indices), array_)
            return array_
        }

        fun writeByteArray(offset: Int, array: ByteArray) {
            buffer.position(offset)
            buffer.put(array, 0, elementSize)
        }

        fun writeShortArray(offset: Int, array: ShortArray) {
            shortBuffer.position(offset)
            shortBuffer.put(array, 0, elementSize / 2)
        }

        fun writeIntArray(offset: Int, array: IntArray) {
            intBuffer.position(offset)
            intBuffer.put(array, 0, elementSize / 4)
        }

        fun writeLongArray(offset: Int, array: LongArray) {
            longBuffer.position(offset)
            longBuffer.put(array, 0, elementSize / 8)
        }

        fun contentEquals(other: VectorField) : Boolean {
            if(size != other.size) return false
            for(i in 0 until size) {
                if(getByte(i) != other.getByte(i)) return false
            }
            return true
        }

        protected fun getByte(byteIndex: Int) : Byte {
            require(byteIndex < size)
            return buffer.get(offset + byteIndex)
        }

        fun setByteArray(array: ByteArray, vararg indices: Int) {
            writeByteArray(getElementOffset(*indices), array)
        }

        fun setShortArray(array: ShortArray, vararg indices: Int) {
            writeShortArray(getElementOffset(*indices), array)
        }

        fun setIntArray(array: IntArray, vararg indices: Int) {
            writeIntArray(getElementOffset(*indices), array)
        }

        fun setLongArray(array: LongArray, vararg indices: Int) {
            writeLongArray(getElementOffset(*indices), array)
        }
    }

    fun getFieldOffset(fieldIndex: Int) : Int {
        initializeIfNeeded()
        return fieldOffsets!![fieldIndex]
    }

    private val _fields = mutableListOf<Field<*>>()
    val fields get() = _fields.toList()
    private var _buffer: ByteBuffer? = null


    private var fieldOffsets : IntArray? = null

    var size : Int = -1
       private set

    val address: Address get() {
        initializeIfNeeded()
        return Address(ExecutableBuffer.getAddress(_buffer).toULong())
    }

    private fun initializeIfNeeded() {
        if(_buffer != null) return;

        _fields.forEach {
            size += it.size + it.alignment - 1
        }

        _buffer = ByteBuffers.allocateLittleEndianDirect(size)

        val fieldOffsets = IntArray(_fields.size)
        this.fieldOffsets = fieldOffsets

        val structureAddress = address
        var currentAddress = address

        _fields.forEachIndexed { index, field ->
            if(field.alias != null) {
                fieldOffsets[index] = field.alias.offset + field.aliasOffset
            } else {
                val fieldAddress = currentAddress.alignUp(field.alignment.toUInt())
                fieldOffsets[index] = (fieldAddress.value - structureAddress.value).toInt()
                currentAddress += field.size.toULong()
            }
        }

    }

    val buffer: ByteBuffer
        get() {
            initializeIfNeeded()
            return _buffer!!
        }

    private fun <T : Field<*>> addField(field: T): T {
        require(_buffer == null){"Cannot add fields to initialized structure"}
//        val fieldOffset = if (alias != null) {
//            alias.offset + aliasOffset
//        } else {
//            offset.alignUp(alignment)
//        }
//
//        return action(fieldOffset).also {
//            _fields.add(it)
//            offset = max(offset, fieldOffset + it.size)
//        }
        _fields.add(field)
        return field
    }

    fun byteField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): ByteField {
        return addField(ByteField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun shortField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): ShortField {
        return addField(ShortField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun intField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): IntField {
        return addField(IntField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun longField(vararg dimensions: Int, alignment: Int = 1, alias: Field<*>? = null, aliasOffset: Int = 0): LongField {
        return addField(LongField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun vector64Field(vararg dimensions: Int, alignment: Int = 8, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, 8))
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = 16, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, 16))
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = 32, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, 32))
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = 32, alias: Field<*>? = null, aliasOffset: Int = 0): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, 64))
    }

}