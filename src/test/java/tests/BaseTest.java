package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
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
    public ProductPage productPage;
    public CartPage cartPage;
    public BillingDetailsPage billingDetailsPage;
    public OrdersDetailsPage ordersDetailsPage;
    public static String email;
    public static String password;

    @BeforeMethod
    public void setup() throws IOException {
        email = PropertiesLoader.getProperty("test.data.email");
        password = PropertiesLoader.getProperty("test.data.password");

        driver = DriverFactory.getWebDriver(PropertiesLoader.getProperty("browser.name"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get(PropertiesLoader.getProperty("url"));

        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        loggedUserPage = new LoggedUserPage(driver);
        productListPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        billingDetailsPage = new BillingDetailsPage(driver);
        ordersDetailsPage = new OrdersDetailsPage(driver);
    }

    @AfterMethod
    public void cleaup() {
        driver.quit();
    }

    public void sendKeys(String text, WebElement element) {
        System.out.println("Sending text: " + text + " to: " + element.getTagName());
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        System.out.println("Clicking on the: " + element.getTagName());
        element.click();
    }

}
