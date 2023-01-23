package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class CartPage extends BaseTest {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".summary > h1")
    WebElement h1CartTitle;

    @FindBy(xpath = "//a[contains(text(), 'checkout')]")
    WebElement checkoutBtn;

    public String getH1CartTitle() {
        return h1CartTitle.getText();
    }

    public AddressPage clickCheckoutBtn() {
        click(checkoutBtn);
        return new AddressPage(driver);
    }


}
