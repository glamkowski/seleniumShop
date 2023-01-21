package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

import java.util.List;
import java.util.stream.Stream;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='nav__title' and text()='Cart']")
    List<WebElement> navBtns;

    public HomePage clickNavBtn(String textInsideNavBtn) {
        navBtns.stream()
                .filter(x -> x.isDisplayed())
                .filter(x -> x.getText().equals(textInsideNavBtn))
                .findFirst().ifPresent(x -> x.click());
        return this;
    }


}
