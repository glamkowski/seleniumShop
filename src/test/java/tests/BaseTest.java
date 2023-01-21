package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.PropertiesLoader;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getWebDriver(PropertiesLoader.getProperty("browser.name"));
        driver.get(PropertiesLoader.getProperty("url"));
    }

    @AfterMethod
    public void cleaup () {
        driver.quit();
    }

}
