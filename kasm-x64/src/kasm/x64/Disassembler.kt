package kasm.x64

import kasm.Capstone

class Disassembler {
    companion object {
        fun disassemble(code: ByteArray): Array<out Array<String>> {
            return Capstone.disassembleX64(code)
        }
    }
}