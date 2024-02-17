import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @DataProvider(name = "numbers")
    public static Integer[][] numbers() {
        return new Integer[][]{{0, 1}, {1, 1}, {5, 120}};
    }

    @Test(dataProvider = "numbers")
    public void checkFactorialValidNum(long value, long expectedValue) {
        assertEquals(expectedValue, Factorial.getFactorial(value));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = "Число не может быть отрицательным")
    public void checkFactorialException() {
        Factorial.getFactorial(-1);
    }
}
