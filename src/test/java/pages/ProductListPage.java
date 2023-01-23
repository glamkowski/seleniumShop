package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ProductListPage extends BaseTest {

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (css = ".woocommerce-products-header > h1")
    WebElement pageTitle;

    @FindBy (css = ".woocommerce-loop-product__title")
    List<WebElement> productsFound;

    public ProductPage selectRandomProduct () {
        Random random = new Random();
        Integer numberOfProducts = getQuantityProducts();
        productsFound.get(random.nextInt(numberOfProducts)).click();
        return new ProductPage(driver);
    }

    public List<String> getListProductNames() {
        return productsFound.stream().map(x -> x.getText()).collect(Collectors.toList());
    }

    public Integer getQuantityProducts () {
        return productsFound.size();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

}
