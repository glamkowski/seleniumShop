package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class ProductPage extends BaseTest {

    public ProductPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (css = ".summary > h1")
    WebElement productTitle;

    public String getProductTitle () {
        return productTitle.getText();
    }

}
