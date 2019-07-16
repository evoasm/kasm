package kasm;

import java.lang.ref.Cleaner;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NativeBuffer {
    private static final Cleaner cleaner;

    static {
        System.loadLibrary("kasm_buffer");

        register();
        /*FIXME: not sure about keeping this in a static context */
        cleaner = Cleaner.create();
    }

    private final ByteBuffer byteBuffer;
    private final CodeModel codeModel;

    private static class Deallocator implements Runnable {
        private final int capacity;
        private final long address;

        public Deallocator(long address, int capacity) {
            this.address = address;
            this.capacity = capacity;
        }

        public void run() {
            release(address, capacity);
        }
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    public String toByteString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            builder.append(String.format("%02X", byteBuffer.get(i)));
            builder.append(" ");
        }
        return builder.toString();
    }


    public NativeBuffer(long capacity) {
        this(capacity, CodeModel.LARGE);
    }

    public NativeBuffer(long capacity, CodeModel codeModel) {
        this.byteBuffer = allocate(capacity, codeModel == CodeModel.SMALL);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.codeModel = codeModel;
        cleaner.register(byteBuffer, new Deallocator(getAddress(byteBuffer), byteBuffer.capacity()));
    }

    public byte[] toArray() {
        return toArray(byteBuffer);
    }

    public CodeModel getCodeModel() {
        return codeModel;
    }

    private static native ByteBuffer allocate(long capacity, boolean smallCodeModel);
    public static native byte[] toArray(ByteBuffer byteBuffer);
    private static native void protect(ByteBuffer byteBuffer, boolean executable);
    private static native long execute0(ByteBuffer byteBuffer) throws SignalException;
    private static native long execute1(ByteBuffer byteBuffer, long arg1) throws SignalException;
    private static native long execute2(ByteBuffer byteBuffer, long arg1, long arg2) throws SignalException;
    private static native long execute6(ByteBuffer byteBuffer, long arg1, long arg2, long arg3, long arg4, long arg5, long arg6) throws SignalException;

    private static native long executeUnsafe0(ByteBuffer byteBuffer);
    private static native long executeUnsafe1(ByteBuffer byteBuffer, long arg);

    private static native void register();
    private static native void release(long address, int capacity);
    protected static native long getAddress(ByteBuffer byteBuffer);

    public long execute() throws Exception {
        long result;
        result = execute0(byteBuffer);
        return result;
    }

    public long execute(long arg1) throws Exception {
        long result;
        result = execute1(byteBuffer, arg1);
        return result;
    }

    public long execute(long arg1, long arg2) throws Exception {
        long result;
        result = execute2(byteBuffer, arg1, arg2);
        return result;
    }

    public long execute(long arg1, long arg2, long arg3, long arg4, long arg5, long arg6) throws Exception {
        long result;
        result = execute6(byteBuffer, arg1, arg2, arg3, arg4, arg5, arg6);
        return result;
    }

    public void setExecutable(boolean executable) {
        protect(byteBuffer, executable);
    }

    public void executeUnsafe() {
        executeUnsafe0(byteBuffer);
    }

    public void executeUnsafe(long arg1) {
        executeUnsafe1(byteBuffer, arg1);
    }
}
