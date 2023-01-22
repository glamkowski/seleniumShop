package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.IOException;

public class RegLogTest extends BaseTest {

    public final String email = PropertiesLoader.getProperty("test.data.email");
    public final String password = PropertiesLoader.getProperty("test.data.password");

    public RegLogTest() throws IOException {
    }

    @Test
    public void shouldCreateNewRandomUser() {
        homePage.goToMyAccount()
                .registerNewRandomUser();

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));
    }

    @Test
    public void shouldCreateNewUser () throws IOException {
        homePage.goToMyAccount()
                .setRegEmailInput(email)
                .setRegPasswordInput(password)
                .clickRegBtnForValidData();

        Assert.assertTrue(loggedUserPage.getLoggedTitle().contains("Hello"));
    }

    @Test
    public void shouldLogin() throws IOException {
        homePage.goToMyAccount()
                .logIn(email, password);
    }


}
