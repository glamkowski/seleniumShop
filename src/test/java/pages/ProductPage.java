package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class ProductPage extends BaseTest {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".summary > h1")
    WebElement productTitle;

    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@tabindex='1' and text()='View cart']")
    WebElement viewCartBtn;

    public CartPage clickViewCartBtn() {
        click(viewCartBtn);
        return new CartPage(driver);
    }

    public ProductPage clickAddToCartBtn() {
        click(addToCartBtn);
        return this;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

}
