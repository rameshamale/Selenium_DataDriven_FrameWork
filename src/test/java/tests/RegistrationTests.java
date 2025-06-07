package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.HomePage;
import pages.RegistrationPage;
import utils.TestUtil;
@Listeners(utils.TestListener.class)
public class RegistrationTests extends BaseTest {
	RegistrationPage registrationPage;
	HomePage homePage;

    @Test
    public void testRegistrationWithValidDetails() {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	registrationPage=new RegistrationPage(driver);
    	String[] UserRegistrationData=TestUtil.genrateUserRegistrationData();
    	registrationPage.register(UserRegistrationData[0],UserRegistrationData[1]);
    }

    @Test
    public void testRegistrationWithExistingEmail() {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	registrationPage=new RegistrationPage(driver);
    	registrationPage.register("Ramesh","rameshamale26@gmail.com");
    	String actualErrormessage=registrationPage.getErrorMessageText();
    	String expectedErrorMessage="Email Address already exist!";
    	Assert.assertEquals(actualErrormessage, expectedErrorMessage, "Error message did not match!");
    }
    
    @Test
    public void testSignUpWithEmptyName() {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	registrationPage=new RegistrationPage(driver);
    	registrationPage.register("","rameshamale26@gmail.com");
    	String actualErrormessage=registrationPage.getsignUpUserNameValidationMessage();
    	String expectedErrorMessage="Please fill out this field.";
    	Assert.assertEquals(actualErrormessage, expectedErrorMessage, "Error message did not match!");
    }

}