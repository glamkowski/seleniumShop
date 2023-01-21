package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.Random;

public class AccountPage extends BaseTest {

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[@class='entry-title']")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@id='reg_email']")
    WebElement regEmailInput;

    @FindBy(xpath = "//input[@id='reg_password']")
    WebElement regPasswordInput;

    @FindBy(css = "button[name='register']")
    WebElement regBtn;

    public AccountPage setRegEmailInput(String email) {
        regEmailInput.sendKeys(email);
        return this;
    }

    public AccountPage setRegPasswordInput(String password) {
        regPasswordInput.sendKeys(password);
        return this;
    }

    public void clickRegBtn() {
        regBtn.click();
    }

    public LoggedUserPage registerNewUser() {
        Random random = new Random();
        regEmailInput.sendKeys(random.nextInt(1000) + "0012D@llli.pl");
        regPasswordInput.sendKeys(random.nextInt(1000) + "0012D@llli.pl");
        regBtn.click();
        return new LoggedUserPage(driver);
    }
}
