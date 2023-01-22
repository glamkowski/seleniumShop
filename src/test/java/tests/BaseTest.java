package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.ProductListPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public AccountPage accountPage;
    public LoggedUserPage loggedUserPage;
    public ProductListPage productListPage;

    @BeforeMethod
    public void setup() throws IOException {

        driver = DriverFactory.getWebDriver(PropertiesLoader.getProperty("browser.name"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get(PropertiesLoader.getProperty("url"));

        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        loggedUserPage = new LoggedUserPage(driver);
        productListPage = new ProductListPage(driver);


    }

    @AfterMethod
    public void cleaup() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void sendKeys(String text, WebElement element) {
        System.out.println("Sending text: " + text + " to: " + element.getTagName());
        element.sendKeys(text);
    }

    public void click (WebElement element) {
        System.out.println("Clicking on the: " + element.getTagName());
        element.click();
    }

}
