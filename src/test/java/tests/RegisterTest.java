package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    @Test
    public void shouldRegisterNewRandomUser() {
        homePage.goToMyAccount()
                .registerNewRandomUser();

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));
    }

    @Test
    public void shouldRegisterNewUser() throws IOException {
        homePage.goToMyAccount()
                .setRegEmailInput(email)
                .setRegPasswordInput(password)
                .clickRegBtnForValidData();

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));
    }


}
