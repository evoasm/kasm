package kasm

import kasm.x64.VectorRegisterType
import java.lang.RuntimeException
import java.nio.ByteBuffer
import kotlin.reflect.KProperty


enum class VectorSize {
    BITS_64,
    BITS_128,
    BITS_256,
    BITS_512,
}

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
            return address + getElementOffset(*indices).toULong()
        }

        fun getAddress(index: Int): Address {
            return address + getElementOffset(index).toULong()
        }

        internal fun getElementOffset(index: Int) : Int {
            assert(dimensions.size == 1)
            assert(index < dimensions.first())
            return offset + index * elementSize
        }

        internal fun getElementOffset(index0: Int, index1: Int): Int {
            return offset + getRelativeElementOffset(index0, index1)
        }

        internal fun getElementOffset(vararg indices: Int): Int {
            return offset + getRelativeElementOffset(*indices)
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
            return read(getElementOffset(index))
        }

        operator fun get(index0: Int, index1: Int): T {
            return read(getElementOffset(index0, index1))
        }

        operator fun get(vararg indices: Int): T {
            return read(getElementOffset(*indices))
        }

        fun set(index: Int, value: T) {
            write(getElementOffset(index), value)
        }

        fun set(index0: Int, index1: Int, value: T) {
            write(getElementOffset(index0, index1), value)
        }

        fun set(vararg indices: Int, value: T) {
            write(getElementOffset(*indices), value)
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

        private fun readByte(offset: Int, vectorElementIndex: Int) = buffer.get(offset + vectorElementIndex * Byte.SIZE_BYTES)
        private fun readShort(offset: Int, vectorElementIndex: Int) = buffer.getShort(offset + vectorElementIndex * Short.SIZE_BYTES)
        private fun readInt(offset: Int, vectorElementIndex: Int) = buffer.getInt(offset + vectorElementIndex * Int.SIZE_BYTES)
        private fun readLong(offset: Int, vectorElementIndex: Int) = buffer.getLong(offset + vectorElementIndex * Long.SIZE_BYTES)
        private fun readFloat(offset: Int, vectorElementIndex: Int) = buffer.getFloat(offset + vectorElementIndex * FLOAT_SIZE_BYTES)
        private fun readDouble(offset: Int, vectorElementIndex: Int) = buffer.getDouble(offset + vectorElementIndex * DOUBLE_SIZE_BYTES)

        private inline fun <reified T: Number> read(offset: Int, vectorElementIndex: Int, dummy: T) : T {
            when(dummy) {
                is Byte -> return readByte(offset, vectorElementIndex) as T
                is Short -> return readShort(offset, vectorElementIndex) as T
                is Int -> return readInt(offset, vectorElementIndex) as T
                is Long -> return readLong(offset, vectorElementIndex) as T
                is Float -> return readFloat(offset, vectorElementIndex) as T
                is Double -> return readDouble(offset, vectorElementIndex) as T
                else -> throw RuntimeException()
            }
        }

        private fun writeByte(offset: Int, vectorElementIndex: Int, value: Byte) = buffer.put(offset + vectorElementIndex * Byte.SIZE_BYTES, value)
        private fun writeShort(offset: Int, vectorElementIndex: Int, value: Short) = buffer.putShort(offset + vectorElementIndex * Short.SIZE_BYTES, value)
        private fun writeInt(offset: Int, vectorElementIndex: Int, value : Int) = buffer.putInt(offset + vectorElementIndex * Int.SIZE_BYTES, value)
        private fun writeLong(offset: Int, vectorElementIndex: Int, value: Long) = buffer.putLong(offset + vectorElementIndex * Long.SIZE_BYTES, value)
        private fun writeFloat(offset: Int, vectorElementIndex: Int, value: Float) = buffer.putFloat(offset + vectorElementIndex * FLOAT_SIZE_BYTES, value)
        private fun writeDouble(offset: Int, vectorElementIndex: Int, value: Double) = buffer.putDouble(offset + vectorElementIndex * DOUBLE_SIZE_BYTES, value)

        private inline fun <reified T> write(offset: Int, vectorElementIndex: Int, value: T) {
            when(value) {
                is Byte -> writeByte(offset, vectorElementIndex, value)
                is Short -> writeShort(offset, vectorElementIndex, value)
                is Int -> writeInt(offset, vectorElementIndex, value)
                is Long -> writeLong(offset, vectorElementIndex, value)
                is Float -> writeFloat(offset, vectorElementIndex, value)
                is Double -> writeDouble(offset, vectorElementIndex, value)
                else -> throw RuntimeException()
            }
        }


        fun getByte(vararg indices: Int, vectorElementIndex: Int) : Byte = readByte(getElementOffset(*indices), vectorElementIndex)
        fun getShort(vararg indices: Int, vectorElementIndex: Int) : Short = readShort(getElementOffset(*indices), vectorElementIndex)
        fun getInt(vararg indices: Int, vectorElementIndex: Int) : Int = readInt(getElementOffset(*indices), vectorElementIndex)
        fun getLong(vararg indices: Int, vectorElementIndex: Int) : Long = readLong(getElementOffset(*indices), vectorElementIndex)
        fun getFloat(vararg indices: Int, vectorElementIndex: Int) : Float = readFloat(getElementOffset(*indices), vectorElementIndex)
        fun getDouble(vararg indices: Int, vectorElementIndex: Int) : Double = readDouble(getElementOffset(*indices), vectorElementIndex)

        fun getByte(index: Int, vectorElementIndex: Int) : Byte = readByte(getElementOffset(index), vectorElementIndex)
        fun getShort(index: Int, vectorElementIndex: Int) : Short = readShort(getElementOffset(index), vectorElementIndex)
        fun getInt(index: Int, vectorElementIndex: Int) : Int = readInt(getElementOffset(index), vectorElementIndex)
        fun getLong(index: Int, vectorElementIndex: Int) : Long = readLong(getElementOffset(index), vectorElementIndex)
        fun getFloat(index: Int, vectorElementIndex: Int) : Float = readFloat(getElementOffset(index), vectorElementIndex)
        fun getDouble(index: Int, vectorElementIndex: Int) : Double = readDouble(getElementOffset(index), vectorElementIndex)

        fun getByte(index0: Int, index1: Int, vectorElementIndex: Int) : Byte = readByte(getElementOffset(index0, index1), vectorElementIndex)
        fun getShort(index0: Int, index1: Int, vectorElementIndex: Int) : Short = readShort(getElementOffset(index0, index1), vectorElementIndex)
        fun getInt(index0: Int, index1: Int, vectorElementIndex: Int) : Int = readInt(getElementOffset(index0, index1), vectorElementIndex)
        fun getLong(index0: Int, index1: Int, vectorElementIndex: Int) : Long = readLong(getElementOffset(index0, index1), vectorElementIndex)
        fun getFloat(index0: Int, index1: Int, vectorElementIndex: Int) : Float = readFloat(getElementOffset(index0, index1), vectorElementIndex)
        fun getDouble(index0: Int, index1: Int, vectorElementIndex: Int) : Double = readDouble(getElementOffset(index0, index1), vectorElementIndex)

        fun setByte(vararg indices: Int, vectorElementIndex: Int, value: Byte) = writeByte(getElementOffset(*indices), vectorElementIndex, value)
        fun setShort(vararg indices: Int, vectorElementIndex: Int, value: Short) = writeShort(getElementOffset(*indices), vectorElementIndex, value)
        fun setInt(vararg indices: Int, vectorElementIndex: Int, value: Int) = writeInt(getElementOffset(*indices), vectorElementIndex, value)
        fun setLong(vararg indices: Int, vectorElementIndex: Int, value: Long) = writeLong(getElementOffset(*indices), vectorElementIndex, value)
        fun setFloat(vararg indices: Int, vectorElementIndex: Int, value: Float) = writeFloat(getElementOffset(*indices), vectorElementIndex, value)
        fun setDouble(vararg indices: Int, vectorElementIndex: Int, value: Double) = writeDouble(getElementOffset(*indices), vectorElementIndex, value)

        fun setByte(index: Int, vectorElementIndex: Int, value: Byte) = writeByte(getElementOffset(index), vectorElementIndex, value)
        fun setShort(index: Int, vectorElementIndex: Int, value: Short) = writeShort(getElementOffset(index), vectorElementIndex, value)
        fun setInt(index: Int, vectorElementIndex: Int, value: Int) = writeInt(getElementOffset(index), vectorElementIndex, value)
        fun setLong(index: Int, vectorElementIndex: Int, value: Long) = writeLong(getElementOffset(index), vectorElementIndex, value)
        fun setFloat(index: Int, vectorElementIndex: Int, value: Float) = writeFloat(getElementOffset(index), vectorElementIndex, value)
        fun setDouble(index: Int, vectorElementIndex: Int, value: Double) = writeDouble(getElementOffset(index), vectorElementIndex, value)

        fun setByte(index0: Int, index1: Int, vectorElementIndex: Int, value: Byte) = writeByte(getElementOffset(index0, index1), vectorElementIndex, value)
        fun setShort(index0: Int, index1: Int, vectorElementIndex: Int, value: Short) = writeShort(getElementOffset(index0, index1), vectorElementIndex, value)
        fun setInt(index0: Int, index1: Int, vectorElementIndex: Int, value: Int) = writeInt(getElementOffset(index0, index1), vectorElementIndex, value)
        fun setLong(index0: Int, index1: Int, vectorElementIndex: Int, value: Long) = writeLong(getElementOffset(index0, index1), vectorElementIndex, value)
        fun setFloat(index0: Int, index1: Int, vectorElementIndex: Int, value: Float) = writeFloat(getElementOffset(index0, index1), vectorElementIndex, value)
        fun setDouble(index0: Int, index1: Int, vectorElementIndex: Int, value: Double) = writeDouble(getElementOffset(index0, index1), vectorElementIndex, value)

        private inline fun <reified T: Number> getArraySize(dummy: T) : Int {
            return elementSize / when(dummy) {
                is Byte -> Byte.SIZE_BYTES
                is Short -> Short.SIZE_BYTES
                is Int -> Int.SIZE_BYTES
                is Long -> Long.SIZE_BYTES
                is Float -> FLOAT_SIZE_BYTES
                is Double -> DOUBLE_SIZE_BYTES
                else -> throw RuntimeException()
            }
        }

        private inline fun <reified T : Number> readArray(offset: Int, array: Array<T>? = null, dummy: T): Array<T> {
            val actualArray : Array<T> = array ?: Array<T>(getArraySize<T>(dummy), {0 as T})
            for (i in 0 until actualArray.size) {
                actualArray[i] = read<T>(offset, i, dummy)
            }
            return actualArray
        }

        fun getByteArray(vararg indices: Int, array: Array<Byte>? = null) = readArray(getElementOffset(*indices), array, 0)
        fun getShortArray(vararg indices: Int, array: Array<Short>? = null) = readArray(getElementOffset(*indices), array, 0)
        fun getIntArray(vararg indices: Int, array: Array<Int>? = null) = readArray(getElementOffset(*indices), array, 0)
        fun getLongArray(vararg indices: Int, array: Array<Long>? = null) = readArray(getElementOffset(*indices), array, 0)
        fun getFloatArray(vararg indices: Int, array: Array<Float>? = null) = readArray(getElementOffset(*indices), array, 0f)
        fun getDoubleArray(vararg indices: Int, array: Array<Double>? = null) = readArray(getElementOffset(*indices), array, 0.0)


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

    fun vectorField(dimensions: IntArray,
                    vectorRegisterType: VectorRegisterType,
                    alignment: Int = vectorRegisterType.alignment,
                    alias: Field? = null,
                    aliasOffset: Int = 0): VectorField {
        return addField(VectorField(this, _fields.size, dimensions, alignment, alias, aliasOffset, vectorRegisterType.byteSize))
    }

    fun vector64Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.MM.alignment, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, VectorRegisterType.MM, alignment, alias, aliasOffset)
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.YMM.alignment, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, VectorRegisterType.XMM, alignment, alias, aliasOffset)
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.ZMM.alignment, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, VectorRegisterType.YMM, alignment, alias, aliasOffset)
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.ZMM.alignment, alias: Field? = null, aliasOffset: Int = 0): VectorField {
        return vectorField(dimensions, VectorRegisterType.ZMM, alignment, alias, aliasOffset)
    }

}