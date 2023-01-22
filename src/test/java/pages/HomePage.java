package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//span[text()='My account']")
    List<WebElement> myAccountNavLink;

    @FindBy (xpath = "//a/span[@class='nav__title' and text()='Shop']")
    List<WebElement> shopNavLink;

    public ProductListPage goToShop () {
        shopNavLink.stream()
                .filter(x -> x.isDisplayed())
                .findFirst()
                .ifPresent(x -> x.click());
        return new ProductListPage(driver);
    }

    public AccountPage goToMyAccount() {
        myAccountNavLink.stream()
                .filter(x -> x.isDisplayed())
                .findFirst()
                .ifPresent(x -> x.click());
        return new AccountPage(driver);
    }


}
