package kasm

import java.nio.ByteBuffer
import kotlin.reflect.KProperty

@ExperimentalUnsignedTypes
open class Structure( var codeModel: CodeModel? = null) {

    abstract class Field(val structure: Structure,
                            val index : Int,
                            val dimensions: IntArray,
                            val alignment: Int,
                            val alias: Field?,
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
            return address + getAbsoluteElementOffset(*indices).toULong()
        }

        fun getAddress(index: Int): Address {
            return address + getAbsoluteElementOffset(index).toULong()
        }

        internal fun getAbsoluteElementOffset(vararg indices: Int): Int {
            return offset + getRelativeElementOffset(*indices)
        }

        internal fun getAbsoluteElementOffset(index0: Int, index1: Int): Int {
            return offset + getRelativeElementOffset(index0, index1)
        }

        internal fun getRelativeElementOffset(index0: Int, index1: Int): Int {
            assert(dimensions.size == 2)
            val dimension0 = dimensions[0]
            val dimension1 = dimensions[1]
            assert(index0 < dimension0)
            assert(index1 < dimension1)
            return (index0 * dimension1 + index1) * elementSize
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

        internal fun getAbsoluteElementOffset(index: Int) : Int {
            assert(dimensions.size == 1)
            assert(index < dimensions.first())
            return offset + index * elementSize
        }

    }

    abstract class ValueField<T>(structure: Structure,
                                 index: Int,
                                 dimensions: IntArray,
                                 alignment: Int,
                                 alias: Field?,
                                 aliasOffset: Int) : Field(structure,
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
            return read(getAbsoluteElementOffset(index))
        }

        operator fun get(index0: Int, index1: Int): T {
            return read(getAbsoluteElementOffset(index0, index1))
        }

        operator fun get(vararg indices: Int): T {
            return read(getAbsoluteElementOffset(*indices))
        }

        fun set(index: Int, value: T) {
            write(getAbsoluteElementOffset(index), value)
        }

        fun set(vararg indices: Int, value: T) {
            write(getAbsoluteElementOffset(*indices), value)
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
                    alias: Field?,
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
                     alias: Field?,
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
                   alias: Field?,
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
                    alias: Field?,
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

    class FloatField(structure: Structure,
                   index: Int,
                   dimensions: IntArray,
                   alignment: Int,
                   alias: Field?,
                   aliasOffset: Int) : ValueField<Float>(structure, index, dimensions, alignment, alias, aliasOffset) {
        override val elementSize = 4

        override fun read(offset: Int): Float {
            return readFloat(offset)
        }

        private fun readFloat(offset: Int): Float {
            return buffer.getFloat(offset)
        }

        override fun write(offset: Int, value: Float) {
            writeFloat(offset, value)
        }

        protected fun writeFloat(offset: Int, value: Float) {
            buffer.putFloat(offset, value)
        }
    }

    class DoubleField(structure: Structure,
                    index: Int,
                    dimensions: IntArray,
                    alignment: Int,
                    alias: Field?,
                    aliasOffset: Int) : ValueField<Double>(structure, index, dimensions, alignment, alias, aliasOffset) {
        override val elementSize = 8

        override fun read(offset: Int): Double {
            return readDouble(offset)
        }

        private fun readDouble(offset: Int): Double {
            return buffer.getDouble(offset)
        }

        override fun write(offset: Int, value: Double) {
            writeDouble(offset, value)
        }

        protected fun writeDouble(offset: Int, value: Double) {
            buffer.putDouble(offset, value)
        }
    }

    class VectorField(structure: Structure,
                      index: Int,
                      dimensions: IntArray,
                      alignment: Int,
                      alias: Field?,
                      aliasOffset: Int,
                      override val elementSize: Int) : Field(structure,
                                                            index,
                                                            dimensions,
                                                            alignment,
                                                            alias,
                                                            aliasOffset) {


        companion object {
            const val DOUBLE_SIZE_BYTES = 8
            const val FLOAT_SIZE_BYTES = 4
        }

        private fun readByte(offset: Int, vectorElementIndex: Int) : Byte {
            return buffer.get(offset + vectorElementIndex * Byte.SIZE_BYTES)
        }

        private fun readShort(offset: Int, vectorElementIndex: Int) : Short {
            return buffer.getShort(offset + vectorElementIndex * Short.SIZE_BYTES)
        }

        private fun readInt(offset: Int, vectorElementIndex: Int) : Int {
            return buffer.getInt(offset + vectorElementIndex * Int.SIZE_BYTES)
        }
        
        private fun readLong(offset: Int, vectorElementIndex: Int) : Long {
            return buffer.getLong(offset + vectorElementIndex * Long.SIZE_BYTES)
        }
        
        private fun readFloat(offset: Int, vectorElementIndex: Int) : Float {
            return buffer.getFloat(offset + vectorElementIndex * FLOAT_SIZE_BYTES)
        }

        private fun readDouble(offset: Int, vectorElementIndex: Int) : Double {
            return buffer.getDouble(offset + vectorElementIndex * DOUBLE_SIZE_BYTES)
        }

        private fun writeByte(offset: Int, vectorElementIndex: Int, value: Byte) {
            buffer.put(offset + vectorElementIndex * Byte.SIZE_BYTES, value)
        }

        private fun writeShort(offset: Int, vectorElementIndex: Int, value: Short) {
            buffer.putShort(offset + vectorElementIndex * Short.SIZE_BYTES, value)
        }

        private fun writeInt(offset: Int, vectorElementIndex: Int, value : Int)  {
            buffer.putInt(offset + vectorElementIndex * Int.SIZE_BYTES, value)
        }

        private fun writeLong(offset: Int, vectorElementIndex: Int, value: Long) {
            buffer.putLong(offset + vectorElementIndex * Long.SIZE_BYTES, value)
        }

        private fun writeFloat(offset: Int, vectorElementIndex: Int, value: Float)  {
            buffer.putFloat(offset + vectorElementIndex * FLOAT_SIZE_BYTES, value)
        }

        private fun writeDouble(offset: Int, vectorElementIndex: Int, value: Double)  {
            buffer.putDouble(offset + vectorElementIndex * DOUBLE_SIZE_BYTES, value)
        }

        private fun readByteArray(offset: Int, array: ByteArray) {
            for (i in 0 until elementSize / Byte.SIZE_BYTES) {
                array[i] = buffer.get(offset + i * Byte.SIZE_BYTES)
            }
        }

        private fun readShortArray(offset: Int, array: ShortArray) {
            for (i in 0 until elementSize / Short.SIZE_BYTES) {
                array[i] = buffer.getShort(offset + i * Short.SIZE_BYTES)
            }
        }

        private fun readIntArray(offset: Int, array: IntArray) {
            for (i in 0 until elementSize / Int.SIZE_BYTES) {
                array[i] = buffer.getInt(offset + i * Int.SIZE_BYTES)
            }
        }

        private fun readLongArray(offset: Int, array: LongArray) {
            for (i in 0 until elementSize / Long.SIZE_BYTES) {
                array[i] = buffer.getLong(offset + i * Long.SIZE_BYTES)
            }
        }

        private fun readFloatArray(offset: Int, array: FloatArray) {
            for (i in 0 until elementSize / FLOAT_SIZE_BYTES) {
                array[i] = buffer.getFloat(offset + i * FLOAT_SIZE_BYTES)
            }
        }

        private fun readDoubleArray(offset: Int, array: DoubleArray) {
            for (i in 0 until elementSize / DOUBLE_SIZE_BYTES) {
                array[i] = buffer.getDouble(offset + i * DOUBLE_SIZE_BYTES)
            }
        }

        private fun writeByteArray(offset: Int, array: ByteArray) {
            for (i in 0 until elementSize / Byte.SIZE_BYTES) {
               buffer.put(offset + i * Byte.SIZE_BYTES, array[i])
            }
        }

        private fun writeShortArray(offset: Int, array: ShortArray) {
            for (i in 0 until elementSize / Short.SIZE_BYTES) {
                buffer.putShort(offset + i * Short.SIZE_BYTES, array[i])
            }
        }

        private fun writeIntArray(offset: Int, array: IntArray) {
            for (i in 0 until elementSize / Int.SIZE_BYTES) {
                buffer.putInt(offset + i * Int.SIZE_BYTES, array[i])
            }
        }

        private fun writeLongArray(offset: Int, array: LongArray) {
            for (i in 0 until elementSize / Long.SIZE_BYTES) {
                buffer.putLong(offset + i * Long.SIZE_BYTES, array[i])
            }
        }

        private fun writeFloatArray(offset: Int, array: FloatArray) {
            for (i in 0 until elementSize / FLOAT_SIZE_BYTES) {
                buffer.putFloat(offset + i * FLOAT_SIZE_BYTES, array[i])
            }
        }

        private fun writeDoubleArray(offset: Int, array: DoubleArray) {
            for (i in 0 until elementSize / DOUBLE_SIZE_BYTES) {
                buffer.putDouble(offset + i * DOUBLE_SIZE_BYTES, array[i])
            }
        }


        fun getByte(vararg indices: Int, vectorElementIndex: Int) : Byte {
            return readByte(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getShort(vararg indices: Int, vectorElementIndex: Int) : Short {
            return readShort(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getInt(vararg indices: Int, vectorElementIndex: Int) : Int {
            return readInt(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getLong(vararg indices: Int, vectorElementIndex: Int) : Long {
            return readLong(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getFloat(vararg indices: Int, vectorElementIndex: Int) : Float {
            return readFloat(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getDouble(vararg indices: Int, vectorElementIndex: Int) : Double {
            return readDouble(getAbsoluteElementOffset(*indices), vectorElementIndex)
        }

        fun getByte(index: Int, vectorElementIndex: Int) : Byte {
            return readByte(getAbsoluteElementOffset(index), vectorElementIndex)
        }

        fun getShort(index: Int, vectorElementIndex: Int) : Short {
            return readShort(getAbsoluteElementOffset(index), vectorElementIndex)
        }

        fun getInt(index: Int, vectorElementIndex: Int) : Int {
            return readInt(getAbsoluteElementOffset(index), vectorElementIndex)
        }

        fun getLong(index: Int, vectorElementIndex: Int) : Long {
            return readLong(getAbsoluteElementOffset(index), vectorElementIndex)
        }

        fun getFloat(index: Int, vectorElementIndex: Int) : Float {
            return readFloat(getAbsoluteElementOffset(index), vectorElementIndex)
        }

        fun getDouble(index: Int, vectorElementIndex: Int) : Double {
            return readDouble(getAbsoluteElementOffset(index), vectorElementIndex)
        }



        fun setByte(vararg indices: Int, vectorElementIndex: Int, value: Byte) {
            writeByte(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setShort(vararg indices: Int, vectorElementIndex: Int, value: Short) {
            writeShort(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setInt(vararg indices: Int, vectorElementIndex: Int, value: Int) {
            writeInt(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setLong(vararg indices: Int, vectorElementIndex: Int, value: Long)  {
            writeLong(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setFloat(vararg indices: Int, vectorElementIndex: Int, value: Float) {
            writeFloat(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setDouble(vararg indices: Int, vectorElementIndex: Int, value: Double)  {
            writeDouble(getAbsoluteElementOffset(*indices), vectorElementIndex, value)
        }

        fun setByte(index: Int, vectorElementIndex: Int, value: Byte) {
            writeByte(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }

        fun setShort(index: Int, vectorElementIndex: Int, value: Short) {
            writeShort(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }

        fun setInt(index: Int, vectorElementIndex: Int, value: Int) {
            writeInt(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }

        fun setLong(index: Int, vectorElementIndex: Int, value: Long)  {
            writeLong(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }

        fun setFloat(index: Int, vectorElementIndex: Int, value: Float) {
            writeFloat(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }

        fun setDouble(index: Int, vectorElementIndex: Int, value: Double)  {
            writeDouble(getAbsoluteElementOffset(index), vectorElementIndex, value)
        }



        fun getByteArray(vararg indices: Int, array: ByteArray? = null) : ByteArray {
            val actualArray = if(array != null) array else ByteArray(elementSize)
            readByteArray(getAbsoluteElementOffset(*indices), actualArray)
            return actualArray
        }

        fun getShortArray(vararg indices: Int, array: ShortArray? = null) : ShortArray {
            val actualArray = if(array != null) array else ShortArray(elementSize / 2)
            readShortArray(getAbsoluteElementOffset(*indices), actualArray)
            return actualArray
        }

        fun getIntArray(vararg indices: Int, array: IntArray? = null): IntArray {
            val actualArray = if(array != null) array else IntArray(elementSize / 4)
            readIntArray(getAbsoluteElementOffset(*indices), actualArray)
            return actualArray
        }

        fun getLongArray(vararg indices: Int, array: LongArray? = null): LongArray {
            val actualArray = if(array != null) array else LongArray(elementSize / 8)
            readLongArray(getAbsoluteElementOffset(*indices), actualArray)
            return actualArray
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
            writeByteArray(getAbsoluteElementOffset(*indices), array)
        }

        fun setShortArray(array: ShortArray, vararg indices: Int) {
            writeShortArray(getAbsoluteElementOffset(*indices), array)
        }

        fun setIntArray(array: IntArray, vararg indices: Int) {
            writeIntArray(getAbsoluteElementOffset(*indices), array)
        }

        fun setLongArray(array: LongArray, vararg indices: Int) {
            writeLongArray(getAbsoluteElementOffset(*indices), array)
        }
    }

    fun getFieldOffset(fieldIndex: Int) : Int {
        allocateIfNeeded()
        return fieldOffsets!![fieldIndex]
    }

    private val _fields = mutableListOf<Field>()
    val fields get() = _fields.toList()
    private var _buffer: ByteBuffer? = null
    private var nativeBuffer: NativeBuffer? = null

    private var fieldOffsets : IntArray? = null

    var size : Int = -1
       private set

    val address: Address get() {
        allocateIfNeeded()
        return Address(NativeBuffer.getAddress(_buffer).toULong())
    }

    fun allocate() = allocateIfNeeded()


    private fun allocateIfNeeded() {
        if(_buffer != null) return;

        size = 0
        _fields.forEach {
            size += it.size + it.alignment - 1
        }

        _buffer = if(codeModel == null) {
            ByteBuffers.allocateLittleEndianDirect(size)
        } else {
            nativeBuffer = NativeBuffer(size.toLong(), codeModel)
            nativeBuffer!!.byteBuffer
        }

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
            allocateIfNeeded()
            return _buffer!!
        }

    private fun <T : Field> addField(field: T): T {
        require(_buffer == null){"Cannot add fields to allocated structure"}
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

    fun byteField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): ByteField {
        return addField(ByteField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun shortField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): ShortField {
        return addField(ShortField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun intField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): IntField {
        return addField(IntField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun longField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): LongField {
        return addField(LongField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun floatField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): FloatField {
        return addField(FloatField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun doubleField(vararg dimensions: Int, alignment: Int = 1, alias: Field? = null, aliasOffset: Int = 0): DoubleField {
        return addField(DoubleField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    internal fun vectorField(dimensions: IntArray,
                             alignment: Int,
                             alias: Field?,
                             aliasOffset: Int,
                             elementSize: Int): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, elementSize))
    }

    fun vector64Field(vararg dimensions: Int, alignment: Int = 8, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, alignment, alias, aliasOffset, 8)
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = 16, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, alignment, alias, aliasOffset, 16)
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = 32, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, alignment, alias, aliasOffset, 32)
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = 32, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, alignment, alias, aliasOffset, 64)
    }

}