package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void showRandomProduct () {
        homePage.goToShop()
                .selectRandomProduct();

        List<String> productList = new ArrayList<>(
                Arrays.asList("BDD Cucumber", "GIT basics", "Java Selenium WebDriver")
        );

        Assert.assertTrue(productList.stream()
                .filter(x -> x.equals(productPage.getProductTitle()))
                .findFirst()
                .isPresent()
        );
    }

    @Test
    public void showProductsList () {
        homePage.goToShop();
        Assert.assertTrue(productListPage.getH1Title().equals("Shop"));
        Assert.assertTrue(productListPage.getQuantityProducts().equals(3));
    }

}
