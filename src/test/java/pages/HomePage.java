package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;
import utils.SeleniumHelper;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='My account']")
    List<WebElement> myAccountLink;

    @FindBy(xpath = "//a/span[@class='nav__title' and text()='Shop']")
    List<WebElement> shopLink;

    //CONTACT FORM

    @FindBy(xpath = "//input[@id='nimble_name1623128272']")
    WebElement formFirstInput;

    @FindBy(css = "#nimble_email1623128272")
    WebElement formSecondInput;

    @FindBy(css = "#nimble_message1623128272")
    WebElement formThirdInput;

    @FindBy (id = "nimble_submit1623128272")
    WebElement sendContactFormBtn;

    public ProductListPage goToShop() {
        shopLink.stream()
                .filter(x -> x.isDisplayed())
                .findFirst()
                .ifPresent(x -> x.click());
        return new ProductListPage(driver);
    }

    public AccountPage goToMyAccount() {
        myAccountLink.stream()
                .filter(x -> x.isDisplayed())
                .findFirst()
                .ifPresent(x -> x.click());
        return new AccountPage(driver);
    }

    public HomePage fillUpContactForm (String firstInput, String secondInput, String thirdInput) {
        sendKeys(firstInput, formFirstInput);
        sendKeys(secondInput, formSecondInput);
        sendKeys(thirdInput, formThirdInput);
        sendContactFormBtn.click();
        return new HomePage(driver);
    }

    public String getFormMessage () {
        By locator = By.cssSelector(".sek-form-message");
        SeleniumHelper.waitForExsistElement(driver, locator);
        return driver.findElement(locator).getText();
    }

}
