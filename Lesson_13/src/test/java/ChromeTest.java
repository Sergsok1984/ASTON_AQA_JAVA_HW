import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ChromeTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
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

    @DisplayName("Проверка названия блока Онлайн пополнение без комиссии")
    @Test
    void testPaymentTitle() {
        String paymentTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().replaceAll("\n", " ");
        assertEquals("Онлайн пополнение без комиссии", paymentTitle);
    }

    @DisplayName("Проверка наличия логотипов платёжных систем")
    @ParameterizedTest
    @ValueSource(strings = {"Visa", "MasterCard", "МИР", "Белкарт"})
    void testLogoPaymentSystems(String paymentSystem) {
        boolean logoPresent = driver.findElement(By.cssSelector("img[alt='" + paymentSystem + "']")).isDisplayed();
        assertTrue(logoPresent, "Отсутствует логотип " + paymentSystem);
    }

    @DisplayName("Проверка работы ссылки Подробнее о сервисе")
    @Test
    void testServiceLink() {
        String expectedURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String expectedTitle = "Порядок оплаты и безопасность интернет платежей";
        driver.findElement(By.xpath("//a[contains(.,'Подробнее о сервисе')]")).click();
        assertAll(() -> assertEquals(expectedURL, driver.getCurrentUrl()), () -> assertEquals(expectedTitle, driver.getTitle()));
    }

    @DisplayName("Проверка работы кнопки Продолжить")
    @ParameterizedTest
    @CsvSource(value = {"297777777, 100"})
    void testContinueButton(int phoneNumber, int sum) {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys(String.valueOf(phoneNumber));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys(String.valueOf(sum));
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
        continueButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bepaid-app']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header__payment']")));
        assertTrue(driver.findElement(By.xpath("//p[@class='header__payment-info']")).getText().contains("Оплата: Услуги связи Номер:375297777777"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
