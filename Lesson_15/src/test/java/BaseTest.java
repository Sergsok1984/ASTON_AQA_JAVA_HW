import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.BasketPage;
import pages.MainPage;
import properties.CommonActions;
import properties.Header;

public class BaseTest {
    final int COUNT = 3;
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    protected MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    protected BasketPage basketPage = PageFactory.initElements(driver, BasketPage.class);
    protected Header header = PageFactory.initElements(driver, Header.class);

    @BeforeSuite(alwaysRun = true)
    public void open() {
        basePage.open("https://www.wildberries.ru/");
        mainPage.addToBasket(COUNT);
        header.clickBasketButton();
        basketPage.wait(5000).readProducts();
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
