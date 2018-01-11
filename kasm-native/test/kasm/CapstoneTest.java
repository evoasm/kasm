package kasm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapstoneTest {

    @Test
    void disassembleX64() {
        byte[] code = new byte[]{0x55, 0x48, (byte) 0x8b, 0x05, (byte) 0xb8, 0x13, 0x00, 0x00};
        String[][] disassembly = new String[][]{
                {"push", "rbp"},
                {"mov", "rax, qword ptr [rip + 0x13b8]"}
        };

        assertArrayEquals(disassembly, Capstone.disassembleX64(code));
    }
}