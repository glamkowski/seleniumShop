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

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    WebElement errorText;

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

    public LoggedUserPage registerNewUserValidData() {
        Random random = new Random();
        setRegisterForm("EMAIL" + random.nextInt(100) + "@ds.pl", "00123@DDY");
        return new LoggedUserPage(driver);
    }

    public AccountPage registerNewUserInvalidData(String email) {
        setRegisterForm(email, "9384@@Dw");
        return this;
    }

    private void setRegisterForm(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        regBtn.click();
    }

    public String getErrorText() {
        return errorText.getText().trim();
    }
}
