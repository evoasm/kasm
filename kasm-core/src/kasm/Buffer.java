package kasm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Buffer {
    protected final ByteBuffer byteBuffer;

    protected Buffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Buffer(int capacity) {
        this(ByteBuffer.allocate(capacity));
    }

    public byte[] toArray() {
        byte[] array = byteBuffer.array();
        return Arrays.copyOf(array, array.length);
    }

    public void putByte(byte value) {
        byteBuffer.put(value);
    }

    public void putShort(short value) {
        byteBuffer.putShort(value);
    }

    public void putInt(int value) {
        byteBuffer.putInt(value);
    }

    public void putLong(long value) {
        byteBuffer.putLong(value);
    }

    public void putByte(int offset, byte value) {
        byteBuffer.put(offset, value);
    }

    public void putShort(int offset, short value) {
        byteBuffer.putShort(offset, value);
    }

    public void putInt(int offset, int value) {
        byteBuffer.putInt(offset, value);
    }

    public void putLong(int offset, long value) {
        byteBuffer.putLong(offset, value);
    }

    private void putVector(int offset, Vector vector) {
        putBytesAt(vector.array(), offset);
    }

    public void putVector64(int offset, Vector64 vector) {
        putVector(offset, vector);
    }

    public void putVector128(int offset, Vector128 vector) {
        putVector(offset, vector);
    }

    public void putVector256(int offset, Vector256 vector) {
        putVector(offset, vector);
    }

    public void putVector512(int offset, Vector512 vector) {
        putVector(offset, vector);
    }

    private void putBytesAt(byte[] array, int offset) {
        byteBuffer.position(offset);
        byteBuffer.put(array);
    }

    public void putBytes(byte[] array, int offset, int length) {
        byteBuffer.put(array, offset, length);
    }

    public void putBytes(byte[] array) {
        byteBuffer.put(array);
    }

    public long capacity() {
        return byteBuffer.capacity();
    }

    public void clear() {
        byteBuffer.clear();
    }

    public byte getByte(int offset) {
        return byteBuffer.get(offset);
    }

    public short getShort(int offset) {
        return byteBuffer.getShort(offset);
    }

    public int getInt(int offset) {
        return byteBuffer.getInt(offset);
    }

    public long getLong(int offset) {
        return byteBuffer.getLong(offset);
    }

    public float getFloat(int offset) {
        return byteBuffer.getFloat(offset);
    }

    public double getDouble(int offset) {
        return byteBuffer.getDouble(offset);
    }

    private byte[] get(int offset, VectorSize vectorSize) {
        return get(offset, vectorSize.getByteSize());
    }

    private byte[] get(int offset, int length) {
        byteBuffer.position(offset);
        byte[] dst = new byte[length];
        byteBuffer.get(dst);
        return dst;
    }

    public String toByteString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < capacity(); i++) {
            builder.append(String.format("%02X", getByte(i)));
            builder.append(" ");
        }
        return builder.toString();
    }

    public Vector64 getVector64(int offset) {
        return new Vector64(get(offset, VectorSize._64));
    }

    public Vector128 getVector128(int offset) {
        return new Vector128(get(offset, VectorSize._128));
    }

    public Vector256 getVector256(int offset) {
        return new Vector256(get(offset, VectorSize._256));
    }

    public Vector512 getVector512(int offset) {
        return new Vector512(get(offset, VectorSize._512));
    }

    public int position() {
        return byteBuffer.position();
    }
}
