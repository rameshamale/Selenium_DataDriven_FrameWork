package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignUpPage;
import utils.SignUpHelper;
import utils.TestUtil;
@Listeners(utils.TestListener.class)

public class SignUPTest extends BaseTest {

	RegistrationPage registrationPage;
	HomePage homePage;
	SignUpPage signUpPage;
	AccountCreatedPage accountCreatedPage;
	SignUpHelper signUpHelper;
	String[] UserRegistrationData=TestUtil.genrateSignUpData();	
	
	@BeforeMethod
	public void testRegistrationWithValidDetails() {
    	homePage=new HomePage(driver);
    	accountCreatedPage=new AccountCreatedPage(driver);
    	homePage.clickOnSignUpLoginButton();
    	registrationPage=new RegistrationPage(driver);
    	String[] UserRegistrationData=TestUtil.genrateUserRegistrationData();
    	registrationPage.register(UserRegistrationData[0],UserRegistrationData[1]);
    }
	
    @Test
    public void signUpWithValidDetails() {
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpForm(UserRegistrationData);
    	signUpHelper.submitForm();
        String actAccountCreatedPageMessage=accountCreatedPage.verifyTheAccountCreatesSuccessMessage();
        String EexpcAccountCreatedPageMessage="Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(EexpcAccountCreatedPageMessage, actAccountCreatedPageMessage, "Account is not created");
        accountCreatedPage.clickOnContinueButton();
        homePage.clickOnLogout();
    }

    @Test
    public void testSignUpWithEmptyPassword() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"password","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getPasswordValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);        
    }
    
    @Test
    public void testSignUpWithEmptyFirstName() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"firstName","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getFristNameValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
    @Test
    public void testSignUpWithEmptyLastName() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"lastName","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getLastNameValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
    @Test
    public void testSignUpWithEmptyAddress() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"address","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getAdressValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
    @Test
    
    public void testSignUpWithEmptyState() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"state","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getStateValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
    @Test
    public void testSignUpWithEmptyZipCode() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"pinCode","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getZipCodeValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
    @Test
    
    public void testSignUpWithEmptyMobileNumber() {
    	signUpPage=new SignUpPage(driver);
    	signUpHelper=new SignUpHelper(driver);
    	signUpHelper.fillSignUpFormWithOverrides(UserRegistrationData,"mobile","");
    	signUpHelper.submitForm();
        String ActErrorMessage=signUpPage.getMobileNumberValidationMessage();
        System.out.println(ActErrorMessage);
        String ExpErrorMessage="Please fill out this field.";
        Assert.assertEquals(ActErrorMessage,ExpErrorMessage);
    }
}