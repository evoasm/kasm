package kasm;

import java.nio.ByteBuffer;

public class NativeBuffer extends Buffer {
    private final boolean mmap;

    static {
        System.loadLibrary("kasm_buffer");
    }

    private boolean writable;

    public NativeBuffer(long capacity, boolean mmap) {
        super(allocate(capacity, mmap));
        this.mmap = mmap;
        this.writable = true;
    }

    @Override
    public byte[] toArray() {
        return toArray(byteBuffer);
    }

    private static native ByteBuffer allocate(long capacity, boolean mmap);
    public static native byte[] toArray(ByteBuffer byteBuffer);
    private static native void protect(ByteBuffer byteBuffer, boolean executable);
    private static native long execute0(ByteBuffer byteBuffer) throws SignalException;
    private static native long execute1(ByteBuffer byteBuffer, long arg1) throws SignalException;
    private static native long execute2(ByteBuffer byteBuffer, long arg1, long arg2) throws SignalException;

    private static native long executeUnsafe(ByteBuffer byteBuffer);
    private static native void release(ByteBuffer byteBuffer, boolean mmap);
    private static native long getAddress(ByteBuffer byteBuffer);

    @Override
    protected void finalize() throws Throwable {
        release(byteBuffer, mmap);
        super.finalize();
    }

    public synchronized long execute() throws Exception {
        long result;

        protect(byteBuffer, true);
        result = execute0(byteBuffer);
        protect(byteBuffer, false);

        return result;
    }

    public synchronized long execute(long arg1) throws Exception {
        long result;

        protect(byteBuffer, true);
        result = execute1(byteBuffer, arg1);
        protect(byteBuffer, false);

        return result;
    }

    public synchronized long execute(long arg1, long arg2) throws Exception {
        long result;

        protect(byteBuffer, true);
        result = execute2(byteBuffer, arg1, arg2);
        protect(byteBuffer, false);

        return result;
    }

    public synchronized void executeUnsafe() {
        protect(byteBuffer, true);
        executeUnsafe(byteBuffer);
        protect(byteBuffer, false);
    }

    public long getAddress() {
        return getAddress(byteBuffer);
    }
}
