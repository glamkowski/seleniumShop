package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.netty.resolver.HostsFileEntries;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        homePage.clickNavBtn("Cart")
                .clickNavBtn("My account")
                .clickNavBtn("Shop");
    }

    @Test
    public void clickToNavBtn (String navBtnName) {

    }


}
