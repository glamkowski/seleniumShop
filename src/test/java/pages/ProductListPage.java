package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.List;

public class ProductListPage extends BaseTest {

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (css = ".woocommerce-products-header > h1")
    WebElement pageTitle;

    @FindBy (css = ".woocommerce-loop-product__title")
    List<WebElement> productsFound;

    public Integer getQuantityProducts () {
        return productsFound.size();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

}
