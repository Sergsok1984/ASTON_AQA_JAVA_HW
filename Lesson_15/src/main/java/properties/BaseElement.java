package properties;

import org.openqa.selenium.WebDriver;

public class BaseElement {
    protected WebDriver driver;
    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }
}
