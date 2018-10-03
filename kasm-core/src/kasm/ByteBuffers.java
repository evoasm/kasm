package kasm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBuffers {

    public static ByteBuffer allocateLittleEndianDirect(int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer;
    }

    public static ByteBuffer allocateLittleEndian(int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer;
    }

    public static String toByteString(ByteBuffer byteBuffer) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            builder.append(String.format("%02X", byteBuffer.get(i)));
            builder.append(" ");
        }
        return builder.toString();
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        byte[] array = new byte[byteBuffer.limit()];
        int currentPosition = byteBuffer.position();
        byteBuffer.position(0);
        byteBuffer.get(array);
        byteBuffer.position(currentPosition);
        return array;
    }
}
