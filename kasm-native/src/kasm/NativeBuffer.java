package kasm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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
    private static native long execute(ByteBuffer byteBuffer) throws SignalException;
    private static native long executeUnsafe(ByteBuffer byteBuffer);
    private static native void release(ByteBuffer byteBuffer, boolean mmap);
    private static native long address(ByteBuffer byteBuffer);

    @Override
    protected void finalize() throws Throwable {
        release(byteBuffer, mmap);
        super.finalize();
    }

    public synchronized void execute() throws Exception {
        protect(byteBuffer, true);
        execute(byteBuffer);
        protect(byteBuffer, false);
    }

    public synchronized void executeUnsafe() {
        protect(byteBuffer, true);
        executeUnsafe(byteBuffer);
        protect(byteBuffer, false);
    }

    public long address() {
        return address(byteBuffer);
    }
}
