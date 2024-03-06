import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String numberId = "com.google.android.calculator:id/digit_";
    private static final String operationId = "com.google.android.calculator:id/";
    private static final Map<String, String> operationsIdsMap = Map.of(
            "+", "op_add",
            "-", "op_sub",
            "*", "op_mul",
            "/", "op_div");
    static AndroidDriver<AndroidElement> driver = null;

    @BeforeAll
    public static void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }

    public BaseTest clickNumber(String numbers) {
        char[] numbersList = numbers.toCharArray();
        for (char num : numbersList) {
            driver.findElementById(numberId + num).click();
        }
        return this;
    }

    public BaseTest clickOperation(String operationSymbol) {
        driver.findElementById(operationId + operationsIdsMap.get(operationSymbol)).click();
        return this;
    }

    public String getResult() {
        driver.findElementById(operationId + "eq").click();
        return driver.findElementById(operationId + "result_final").getText();
    }
}
