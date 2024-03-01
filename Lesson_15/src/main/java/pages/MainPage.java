package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {
    private List<String> selectedProducts;
    private List<String> selectedPrices;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage addToBasket(int count) {
        List<WebElement> cardProductNames = driver.findElements(ProductCard.productNameLocator);
        selectedProducts = cardProductNames.stream()
                .limit(count)
                .map(p -> p.getAttribute(Attribute.innerText.toString()).split("/")[1].trim())
                .collect(Collectors.toList());

        List<WebElement> cardLowerPrices = driver.findElements(ProductCard.lowerPriceLocator);
        selectedPrices = cardLowerPrices.stream()
                .limit(count)
                .map(p -> p.getText().split("₽")[0].replaceAll("\\s", ""))
                .collect(Collectors.toList());

        driver.findElements(ProductCard.btnAddToBasketLocator)
                .stream()
                .limit(count)
                .forEach(this::checkForPopup);
        return this;
    }

    private void checkForPopup(WebElement element) {
        element.click();
        try {
            driver.findElement(Popup.btnLocator).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    public String getSelectedProductName(int index) {
        return selectedProducts.get(index);
    }

    public Double getSelectedProductPrice(int index) {
        return Double.parseDouble(selectedPrices.get(index));
    }

    public int getCountOfSelected() {
        return selectedProducts.size();
    }

    public double getSumOfSelected() {
        return selectedPrices.stream().mapToDouble(Double::parseDouble).sum();
    }

    private static class ProductCard {
        private static final By productNameLocator = By.xpath("//span[@class='product-card__name']");
        private static final By lowerPriceLocator = By.xpath("//article/.//ins");
        private static final By btnAddToBasketLocator = By.xpath("//article/.//a[@href='/lk/basket']");
    }

    private static class Popup {
        private static final By btnLocator = By.xpath("//div[@class='popup__content']/ul/li");
    }

    public enum Attribute {
        innerText,
    }
}
