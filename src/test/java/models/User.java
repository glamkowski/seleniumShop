package models;

import com.github.javafaker.Faker;

public class User {
    private String fristName;
    private String lastName;
    private String companyName;
    private String billingCountry;
    private String billingAddress1;
    private String billingPostCode;
    private String billingCity;
    private String billingPhone;
    private String billingEmail;

    public User() {
        Faker faker = new Faker();
        this.fristName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.billingCity = "Poland";
        this.companyName = faker.company().name();
        this.billingCountry = faker.address().country();
        this.billingAddress1 = faker.address().fullAddress();
        this.billingPostCode = faker.address().zipCode();
        this.billingPhone = faker.phoneNumber().cellPhone();
        this.billingEmail = faker.internet().emailAddress();
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingPostCode() {
        return billingPostCode;
    }

    public void setBillingPostCode(String billingPostCode) {
        this.billingPostCode = billingPostCode;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }
}
