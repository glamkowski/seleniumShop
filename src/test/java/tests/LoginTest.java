package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLogin() throws IOException {
        homePage.goToMyAccount()
                .logIn(email, password);

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));

    }
}
