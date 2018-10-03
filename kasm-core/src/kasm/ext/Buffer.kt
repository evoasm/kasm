package kasm.ext

import kasm.ByteBuffers
import java.nio.ByteBuffer

fun ByteBuffer.toArray() : ByteArray {
    return ByteBuffers.toArray(this)
}

fun ByteBuffer.toByteString(): String {
    return ByteBuffers.toByteString(this)
}
