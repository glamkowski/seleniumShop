package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class AddressPage extends BaseTest {
    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//button[text()='Place order']")
    WebElement placeOrderBtn;

    public AddressDetailsPage clickPlaceOrderBtn () {
        click(placeOrderBtn);
        return new AddressDetailsPage(driver);
    }

}
