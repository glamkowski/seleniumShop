package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']//p[1]")
    WebElement loggedText;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    WebElement errorText;

    public String getLoggedTitle () {
        return loggedText.getText();
    }

    public String getErrorText () {
        return errorText.getText().trim();
    }


}
