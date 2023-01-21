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
    public void shouldCreateNewUser() {
        homePage.goToMyAccount()
                .registerNewUserValidData();

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));
    }

    @Test
    public void shouldNotCreateNewUser() {
        homePage.goToMyAccount()
                .registerNewUserInvalidData("test@test.com");

        Assert.assertFalse(accountPage.getErrorText().equals("An account is already registered with your email address. Please log in."));

    }

    @Test
    public void clickToNavBtn (String navBtnName) {

    }


}
