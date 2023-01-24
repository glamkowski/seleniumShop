package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {

    @Test
    public void sendContactForm() {

        homePage.fillUpContactForm("contact23@gmai.com", "contacttest@gma.com", "Example");
        Assert.assertEquals(homePage.getFormMessage(), "It is demo page! We are not sending emails!");

    }
}
