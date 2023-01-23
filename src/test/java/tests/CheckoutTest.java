package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void should () {
        homePage.goToShop()
                .selectRandomProduct()
                .clickAddToCartBtn()
                .clickViewCartBtn()
                .clickCheckoutBtn();
    }

}
