package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BillingDetailsPage extends BaseTest {
    public BillingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_company")
    WebElement companyName;

    @FindBy(css = "select#billing_country")
    WebElement selectBillingCountry;

    @FindBy(id = "billing_address_1")
    WebElement billingAddress1;

    @FindBy(id = "billing_postcode")
    WebElement billingPostcode;

    @FindBy(id = "billing_city")
    WebElement billingCity;

    @FindBy(id = "billing_phone")
    WebElement billingPhone;

    @FindBy(id = "billing_email")
    WebElement billingEmail;

    @FindBy(id = "place_order")
    WebElement placeOrderBtn;

    public BillingDetailsPage fillOutForm(User user) {
        sendKeys(user.getFristName(), firstName);
        sendKeys(user.getLastName(), lastName);
        sendKeys(user.getCompanyName(), companyName);
        sendKeys(user.getBillingAddress1(), billingAddress1);
        sendKeys("96338", billingPostcode);
        sendKeys(user.getBillingCity(), billingCity);
        sendKeys(user.getBillingPhone(), billingPhone);
        sendKeys(user.getBillingEmail(), billingEmail);

        Select select = new Select(selectBillingCountry);
        select.selectByVisibleText("Poland");

        return new BillingDetailsPage(driver);
    }

    public OrdersDetailsPage clickPlaceOrderBtn() {
        try {
            WebElement date = driver.findElement(By.id("place_order"));
            date.click();
        } catch (StaleElementReferenceException ex) {
            WebElement date = driver.findElement(By.id("place_order"));
            date.click();
        }
        return new OrdersDetailsPage(driver);
    }



}
