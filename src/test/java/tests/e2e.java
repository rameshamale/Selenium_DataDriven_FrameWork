package tests;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentDonePage;
import pages.PaymentPage;
import pages.ProductSearchPage;
import pages.RegistrationPage;
import pages.SignUpPage;
import utils.AddProductToCartHelper;
import utils.SignUpHelper;
import utils.TestUtil;

public class e2e extends BaseTest {
	
	HomePage homePage;
	LoginPage loginPage;
	SignUpHelper signUpHelper;
	CartPage cartPage;
	ProductSearchPage productSearchPage;
	AccountCreatedPage accountCreatedPage;
	RegistrationPage registrationPage;
	CheckoutPage checkoutPage;
	PaymentDonePage paymentDonePage;
	AddProductToCartHelper addProductToCartHelper;
	PaymentPage paymentPage; 
	String[] UserRegistrationData=TestUtil.genrateSignUpData();
	
	@Test
	public void verifyInvoiceDownload() {
		homePage=new HomePage(driver);
		cartPage=new CartPage(driver);
		paymentPage=new PaymentPage(driver);
		loginPage=new LoginPage(driver);
		checkoutPage=new CheckoutPage(driver);
		paymentDonePage=new PaymentDonePage(driver);
		homePage.AddPerticularProductInCart();
		cartPage.clickOnCheckOutButton();
		cartPage.clickOnRegisterLogin();
		loginPage.login("rameshamale26@gmail.com", "Amale@123");
		cartPage.clickOnCartLink();
		cartPage.clickOnCheckOutButton();
		checkoutPage.clickOnPlaceOrderButton();
		paymentPage = new PaymentPage(driver);
        Map<String, String> cardData = TestUtil.generateFakePaymentData();
        paymentPage.enterCardDetails(cardData);
        paymentPage.clickPayAndConfirm();
        String actMessage=paymentDonePage.confirmOrderPalcedMessage();
        String expOrderPlacedMessage="ORDER PLACED!";
        Assert.assertEquals(actMessage, expOrderPlacedMessage);
        paymentDonePage.clickOnDownLoadButton();
	}

}
