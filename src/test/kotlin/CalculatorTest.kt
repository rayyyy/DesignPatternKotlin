import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class CalculatorTest {

    @Test
    @DisplayName("Add Two Numbers")
    fun add() {
        assertEquals(4.0,  Calculator().add(2.0,2.0))
    }
}