import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketTest extends BaseTest {

    @Test(description = "Проверка названия товаров")
    public void productNameTest() {
        for (int i = 0; i < COUNT; i++) {
            assertEquals(basketPage.getProductName(COUNT - i - 1), mainPage.getSelectedProductName(i), "Наименование товаров отличается");
        }
    }

    @Test(description = "Проверка количества товаров")
    public void countProductTest() {
        assertEquals(basketPage.getCount(), mainPage.getCountOfSelected(), "Количество товаров отличается");
    }

    @Test(description = "Проверка стоимости товаров")
    public void priceProductTest() {
        assertEquals(basketPage.getSum(), basketPage.getSumOfSelectedPrices(), "Общая стоимость товаров в корзине и сумма цен на товары различаются");
    }
}
