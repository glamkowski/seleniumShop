package pages;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
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

    @FindBy (xpath = "//input[@id='username']")
    WebElement logUsernameInput;

    @FindBy (css = "input[id='password']")
    WebElement logPasswordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginBtn;

    public LoggedUserPage logIn (String email, String password) {
        sendKeys(email, logUsernameInput);
        sendKeys(password, logPasswordInput);
        click(loginBtn);
        return new LoggedUserPage(driver);
    }

    public AccountPage setRegEmailInput(String email) {
        sendKeys(email, regEmailInput);
        return this;
    }

    public AccountPage setRegPasswordInput(String password) {
        sendKeys(password, regPasswordInput);
        return this;
    }

    public LoggedUserPage clickRegBtnForValidData() {
        click(regBtn);
        return new LoggedUserPage(driver);
    }

    public AccountPage clickRegBtnForInvalidData() {
        click(regBtn);
        return this;
    }

    public LoggedUserPage registerNewRandomUser() {
        Random random = new Random();
        String email = random.nextInt(100) + "@oskar.inq";
        String password = random.nextInt(100) + "DD43Y@rT";
        setRegisterForm(email, password);
        return new LoggedUserPage(driver);
    }

    private void setRegisterForm(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        regBtn.click();
    }

    public String getErrorTextAfterLogIn() {
        return errorText.getText().trim();
    }
}
