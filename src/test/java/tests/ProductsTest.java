package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void showProductsList () {
        homePage.goToShop();
        Assert.assertTrue(productListPage.getPageTitle().equals("Shop"));
        Assert.assertTrue(productListPage.getQuantityProducts().equals(3));
    }

}
