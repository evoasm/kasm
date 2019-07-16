package kasm

import kasm.x64.VectorRegisterType
import java.nio.ByteBuffer


enum class VectorSize {
    BITS_64,
    BITS_128,
    BITS_256,
    BITS_512,
}

@ExperimentalUnsignedTypes
open class Structure( var codeModel: CodeModel? = null) {


    fun getFieldOffset(fieldIndex: Int) : Int {
        allocateIfNeeded()
        return fieldOffsets!![fieldIndex]
    }

    private val _fields = mutableListOf<StructureField>()
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

    fun zero() {
        val capacity = buffer.capacity()
        for(i in 0 until capacity) {
            buffer.put(i, 0)
        }
    }

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

    private fun <T : StructureField> addField(field: T): T {
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

    fun byteField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): ByteStructureField {
        return addField(ByteStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun shortField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): ShortStructureField {
        return addField(ShortStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun intField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): IntStructureField {
        return addField(IntStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun longField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): LongStructureField {
        return addField(LongStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun floatField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): FloatStructureField {
        return addField(FloatStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun doubleField(vararg dimensions: Int, alignment: Int = 1, alias: StructureField? = null, aliasOffset: Int = 0): DoubleStructureField {
        return addField(DoubleStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset))
    }

    fun vectorField(dimensions: IntArray,
                    vectorRegisterType: VectorRegisterType,
                    alignment: Int = vectorRegisterType.alignment,
                    alias: StructureField? = null,
                    aliasOffset: Int = 0): VectorStructureField {
        return addField(VectorStructureField(this, _fields.size, dimensions, alignment, alias, aliasOffset, vectorRegisterType.byteSize))
    }

    fun vector64Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.MM.alignment, alias: StructureField? = null, aliasOffset: Int = 0): VectorStructureField {
        return vectorField(dimensions, VectorRegisterType.MM, alignment, alias, aliasOffset)
    }

    fun vector128Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.YMM.alignment, alias: StructureField? = null, aliasOffset: Int = 0): VectorStructureField {
        return vectorField(dimensions, VectorRegisterType.XMM, alignment, alias, aliasOffset)
    }

    fun vector256Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.ZMM.alignment, alias: StructureField? = null, aliasOffset: Int = 0): VectorStructureField {
        return vectorField(dimensions, VectorRegisterType.YMM, alignment, alias, aliasOffset)
    }

    fun vector512Field(vararg dimensions: Int, alignment: Int = VectorRegisterType.ZMM.alignment, alias: StructureField? = null, aliasOffset: Int = 0): VectorStructureField {
        return vectorField(dimensions, VectorRegisterType.ZMM, alignment, alias, aliasOffset)
    }

}