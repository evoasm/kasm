package kasm;

public class Capstone {
    static {
        System.loadLibrary("kasm_capstone");
    }
    public static native String[][] disassembleX64(byte[] code);
}
