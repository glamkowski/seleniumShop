package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class Orders extends BaseTest {

    public Orders (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (css = ".woocommerce-order p")
    WebElement orderRecivedAlert;

    public String getOrderRecivedAlert () {
        return orderRecivedAlert.getText();
    }

}
