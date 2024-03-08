import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Тестирование приложения Google Calculator на Pixel 2 в эмуляторе Android Studio")
public class CalculatorTest extends BaseTest{

    @DisplayName("Проверка операций: Сложение, Вычитание, Умножение, Деление")
    @Severity(CRITICAL)
    @Owner("Сергей Соколов")
    @ParameterizedTest
    @CsvSource({
            "12, +, 8, 20",
            "20, -, 19, 1",
            "11, *, 11, 121",
            "9, /, 3, 3"})
    public void calculationTest(String firstNumber, String operation, String secondNumber, String expectedResult) {
        String actualResult = new BaseTest()
                .clickNumber(firstNumber)
                .clickOperation(operation)
                .clickNumber(secondNumber)
                .getResult();
        assertEquals(expectedResult, actualResult);
    }
}
