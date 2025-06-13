package tests;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReader;
@Listeners(utils.TestListener.class)

public class LoginTests extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;

	
	@DataProvider(name = "ValidLogin")
    public Object[][] getDataValidLoginData() {
        return ExcelReader.readExcelData("ValidLogin");
    }
	
	@DataProvider(name = "InValidLogin")
    public Object[][] InValidLogin() {
        return ExcelReader.readExcelData("InValidLogin"); 
    }
	
	@Test(dataProvider = "ValidLogin", groups = {"Login","smoke"},description="Login with valid details")
    public void testLoginWithValidCredentials(String Username, String Password) {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	loginPage=new LoginPage(driver);
    	loginPage.login(Username, Password);
    	homePage.verifyTheLoginPerson();
    	homePage.clickOnLogout();
    }
    @Test(dataProvider = "InValidLogin",groups={"Login","smoke"},
    	    description = "Login test with Invalid credentials")
    public void testLoginWithInvalidPassword(String Username, String Password) {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	loginPage=new LoginPage(driver);
    	loginPage.login(Username, Password);
    	String expectedMessage="Your email or password is incorrect!";
    	AssertJUnit.assertEquals(loginPage.getEmptyEmailErroeMessage(), expectedMessage);
    }

    @Test(groups={"Login","smoke"}, description = "Verify the logo is displayed")
    public void verifyLogoIsDisplayed() {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	loginPage=new LoginPage(driver);
    	boolean isDisplayed= loginPage.isLogoDisplayed();
        AssertJUnit.assertTrue(isDisplayed);
    }
    

    @Test(groups={"Login","smoke"},
    	    description = "Verify the menu links are displayed")
    public void allTheMenuLinksAreDisplayed() {
    	homePage=new HomePage(driver);
    	homePage.clickOnSignUpLoginButton();
    	loginPage=new LoginPage(driver);
    	boolean isDisplayed= loginPage.AreAllMenuLinksDisplayed();
        AssertJUnit.assertTrue(isDisplayed);
    }

}


