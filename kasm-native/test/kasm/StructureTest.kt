package kasm

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StructureTest {

    class TestStructure : Structure() {
        val a = longField(10, 20, 30)
    }

    @Test
    fun getRelativeElementOffset() {
        val structure = TestStructure()
        assertEquals(8, structure.a.elementSize)
        assertEquals(2 * 20 * 30 * structure.a.elementSize + 3 * 30 * structure.a.elementSize + 4 * structure.a.elementSize,
                     structure.a.getRelativeElementOffset(2, 3, 4))
    }
}