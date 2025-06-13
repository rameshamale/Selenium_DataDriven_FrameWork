package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LogOutTest extends BaseTest {
	HomePage homePage;
	LoginPage loginPage;
	LogoutPage logOutPage;
	
	@BeforeMethod
	public void login() {
		homePage=new HomePage(driver);
		homePage.clickOnSignUpLoginButton();
		loginPage=new LoginPage(driver);
		loginPage.login("rameshamale26@gmail.com", "Amale@123");}
	
	@Test
	public void Logout() {
		logOutPage=new LogoutPage(driver);
		logOutPage.clicklOnLogoutButton();
	}
	
}
