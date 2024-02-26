import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ChromeTest {
    final double SUM_PAYMENT = 100;
    final String PHONE_NUMBER = "297777777";
    WebDriver driver;
    WebDriverWait webDriverWait;

    static Stream<Arguments> getCardPaymentFields() {
        return Stream.of(Arguments.of(Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)")));
    }

    static Stream<Arguments> getPaymentFormFields() {
        return Stream.of(Arguments.of("Услуги связи", Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека")), Arguments.of("Домашний интернет", Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека")), Arguments.of("Рассрочка", Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека")), Arguments.of("Задолженность", Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека")));
    }

    public void getPaymentPage() {
        driver.findElement(By.id("connection-phone")).sendKeys(PHONE_NUMBER);
        driver.findElement(By.id("connection-sum")).sendKeys(Double.toString(SUM_PAYMENT));
        driver.findElement(By.xpath("//form[@id='pay-connection']/button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bepaid-app']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header__payment']")));
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("---disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @ParameterizedTest(name = "Проверка надписей в полях реквизитов карты при оплате за Услуги связи")
    @MethodSource("getCardPaymentFields")
    void testPhonePaymentFields(List<String> cardPaymentFields) {
        getPaymentPage();
        List<WebElement> elementList = driver.findElements(By.xpath("//label[contains(@class,'ng-tns')]"));
        List<String> elementListText = elementList.stream().map(WebElement::getText).collect(Collectors.toList());
        for (int i = 0; i < cardPaymentFields.size(); i++) {
            assertEquals(cardPaymentFields.get(i), elementListText.get(i));
        }
    }

    @Test
    @DisplayName("Проверка корректности отображения номера телефона и суммы при оплате за Услуги связи")
    void testPhoneNumberAndSum() {
        getPaymentPage();
        String removeLetters = "[^0-9.]";
        String phoneNumberInput = driver.findElement(By.xpath("//p[@class='header__payment-info']")).getText().replaceAll(removeLetters, "");

        String sumHeader = driver.findElement(By.xpath("//div[@class='header__payment-amount']")).getText().replaceAll(removeLetters, "");
        String sumButton = driver.findElement(By.xpath("//button[contains(.,'Оплатить')]")).getText().replaceAll(removeLetters, "");
        String sumInput = String.format("%.2f", SUM_PAYMENT).replaceAll(",", ".");

        assertAll(() -> assertEquals(phoneNumberInput, "375" + PHONE_NUMBER), () -> assertTrue(sumInput.equals(sumButton) && sumButton.equals(sumHeader)));
    }

    @ParameterizedTest(name = "Проверка наличия иконки платежной системы {0} при оплате за Услуги связи")
    @ValueSource(strings = {"mastercard", "visa", "belkart", "mir", "maestro"})
    void testLogoPaymentSystems(String paymentSystem) {
        getPaymentPage();
        WebElement logoPresent = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'" + paymentSystem + "-system')]")));
        assertTrue(logoPresent.isDisplayed(), "Отсутствует логотип " + paymentSystem);
    }

    @ParameterizedTest(name = "Проверка полей для варианта оплаты {0}")
    @MethodSource("getPaymentFormFields")
    void testPaymentFormFields(String nameForm, List<String> cardPaymentFields) {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath(String.format("//li/p[contains(., '%s')]", nameForm))).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//form[@class='pay-form opened']/div/input"));
        List<String> elementListText = elementList.stream().map(o -> o.getAttribute("placeholder")).collect(Collectors.toList());
        assertAll(() -> assertEquals(elementListText.get(0), cardPaymentFields.get(0)), () -> assertEquals(elementListText.get(1), cardPaymentFields.get(1)), () -> assertEquals(elementListText.get(2), cardPaymentFields.get(2)));
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }
}
