package utils;

import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

public class SignUpHelper {
    private WebDriver driver;
    private SignUpPage signUpPage;


    public SignUpHelper(WebDriver driver) {
        this.driver = driver;
        this.signUpPage = new SignUpPage(driver);
    }


    public void fillSignUpForm(String[] UserRegistrationData) {
    	signUpPage = new SignUpPage(driver);
    	signUpPage.selectGender("Mr");
        signUpPage.enterName(UserRegistrationData[0]);
        signUpPage.enterPassword(UserRegistrationData[1]);
        signUpPage.selectDay("15");
        signUpPage.selectMonth("May");
        signUpPage.selectYear("1995");
        signUpPage.toggleNewsletter(true);
        signUpPage.toggleSpecialOffer(true);
        signUpPage.enterFirstName(UserRegistrationData[2]);
        signUpPage.enterLastName(UserRegistrationData[3]);
        signUpPage.enterCompany(UserRegistrationData[4]);
        signUpPage.enterAddress(UserRegistrationData[5]);
        signUpPage.selectCountry("India");
        signUpPage.enterState("Maharashtra");
        signUpPage.enterCity("Mumbai");
        signUpPage.enterMobileNumber(UserRegistrationData[8]);
        signUpPage.enterPinCode("413253");
    }

    public void fillSignUpFormWithOverrides(String[] data, String fieldToOverride, String overrideValue) {
        fillSignUpForm(data);
        switch (fieldToOverride) {
            case "password": signUpPage.enterPassword(overrideValue); break;
            case "firstName": signUpPage.enterFirstName(overrideValue); break;
            case "lastName": signUpPage.enterLastName(overrideValue); break;
            case "address": signUpPage.enterAddress(overrideValue); break;
            case "state": signUpPage.enterState(overrideValue); break;
            case "pinCode": signUpPage.enterPinCode(overrideValue); break;
            case "mobile": signUpPage.enterMobileNumber(overrideValue); break;
        }
    }

    public void submitForm() {
        signUpPage.clickCreateAccountButton();
    }
}
