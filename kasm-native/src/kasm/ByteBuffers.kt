package kasm

import kasm.ext.alignUp
import java.nio.ByteBuffer
import java.nio.ByteOrder

object ByteBuffers {

    fun allocateLittleEndianDirect(capacity: Int): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(capacity)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)

//        val address = ExecutableBuffer.getAddress(byteBuffer)
//        val alignedAddress = address.alignUp(alignment)
//        val skip = (alignedAddress - address).toInt()
//        byteBuffer.position(skip)

        return byteBuffer
    }

    fun allocateLittleEndian(capacity: Int): ByteBuffer {
        val byteBuffer = ByteBuffer.allocate(capacity)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
        return byteBuffer
    }

    fun toByteString(byteBuffer: ByteBuffer): String {
        val builder = StringBuilder()
        for (i in 0 until byteBuffer.limit()) {
            builder.append(String.format("%02X", byteBuffer.get(i)))
            builder.append(" ")
        }
        return builder.toString()
    }

    fun toArray(byteBuffer: ByteBuffer): ByteArray {
        val array = ByteArray(byteBuffer.limit())
        val currentPosition = byteBuffer.position()
        byteBuffer.position(0)
        byteBuffer.get(array)
        byteBuffer.position(currentPosition)
        return array
    }
}

fun ByteBuffer.toArray() : ByteArray {
    return ByteBuffers.toArray(this)
}

fun ByteBuffer.toByteString(): String {
    return ByteBuffers.toByteString(this)
}
