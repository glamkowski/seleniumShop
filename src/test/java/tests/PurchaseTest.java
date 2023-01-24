package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test(invocationCount = 2)
    public void shouldPurchaseRandomProduct() {

        homePage.goToShop()
                .selectRandomProduct()
                .clickAddToCartBtn()
                .clickViewCartBtn()
                .clickCheckoutBtn()
                .fillOutForm(new User())
                .clickPlaceOrderBtn();

        Assert.assertEquals(ordersDetailsPage.getOrderRecivedAlert(), "Thank you. Your order has been received.");
    }

}
