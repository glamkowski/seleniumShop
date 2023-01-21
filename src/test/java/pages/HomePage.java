package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.List;
import java.util.stream.Stream;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//span[text()='My account']")
    List<WebElement> myAccountNavLink;

    public AccountPage goToMyAccount() {
        myAccountNavLink.stream()
                .filter(x -> x.isDisplayed())
                .findFirst()
                .ifPresent(x -> x.click());
        return new AccountPage(driver);
    }


}
