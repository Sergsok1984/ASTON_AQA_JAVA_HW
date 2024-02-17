import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @DisplayName("Проверка валидных значений")
    @ParameterizedTest
    @CsvSource({"1, 0", "1, 1", "120, 5"})
    public void checkFactorialValidNum(long expectedValue, long value) {
        assertEquals(expectedValue, Factorial.getFactorial(value));
    }

    @DisplayName("Проверка исключения")
    @Test
    public void checkFactorialException() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> Factorial.getFactorial(-1));
        assertEquals("Число не может быть отрицательным", thrown.getMessage());
    }
}
