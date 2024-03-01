package properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseElement {
    public Header(WebDriver driver) {
        super(driver);
    }

    public static class Basket {
        private static final By btnLocator = By
                .xpath("//div[@id='basketContent']/.//a[@href='/lk/basket']");
    }

    public Header clickBasketButton() {
        driver.findElement(Basket.btnLocator).click();
        return this;
    }
}
