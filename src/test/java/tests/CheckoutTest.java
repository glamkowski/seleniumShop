package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test (invocationCount = 5)
    public void shouldPurchaseRandomProduct() {

        homePage.goToShop()
                .selectRandomProduct()
                .clickAddToCartBtn()
                .clickViewCartBtn()
                .clickCheckoutBtn()
                .fillOutForm(new User())
                .clickPlaceOrderBtn();

        Assert.assertEquals(orders.getOrderRecivedAlert(), "Thank you. Your order has been received.");
    }

}
