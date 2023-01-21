package tests;

import com.beust.ah.A;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.netty.resolver.HostsFileEntries;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void test() {
        homePage.goToMyAccount().registerNewUser();
        Assert.assertTrue(loggedUserPage.getLoggedTitle().equals("My account"));
    }

    @Test
    public void clickToNavBtn (String navBtnName) {

    }


}
