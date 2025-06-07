package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentDonePage;
import pages.PaymentPage;
import pages.ProductSearchPage;
import utils.TestUtil;

public class ProductSearchTests extends BaseTest {
	
	ProductSearchPage productSearchPage;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
	PaymentDonePage paymentDonePage;
	

@Test
public void verifyProductCount() {
	
	productSearchPage=new ProductSearchPage(driver);
    int count = productSearchPage.getProductCount();
    System.out.println("Product count: " + count);
}

	@Test
	public void printUIProductData() {
		productSearchPage=new ProductSearchPage(driver);
		Map<String, String> productData = productSearchPage.getProductDataFromUI();
	    System.out.println("----- Product Details from UI -----");
	    for (Map.Entry<String, String> entry : productData.entrySet()) {
	        System.out.println("Product Name: " + entry.getKey() + " | Price: Rs. " + entry.getValue());}
	    }
	    
	 @Test
	 public void AddToCartIsPresernt() {
		productSearchPage=new ProductSearchPage(driver);
		productSearchPage.verifyAddCartButtonIsPresentOnEachProduct();
	 }
	 
	 @Test
	 public void VerifyAllCategory() {
			productSearchPage=new ProductSearchPage(driver);
			List<String> expectedCategory = Arrays.asList("Women", "Men", "Kids");
			List<String> actualCategory=productSearchPage.verifyAllCategory();
			expectedCategory.equals(actualCategory);	
	 }
	 
	 @Test

	 public void verifyAllSubcategories() throws InterruptedException {
			productSearchPage=new ProductSearchPage(driver);
			productSearchPage.clickEachCategoryAndPrintSubcategories();;

	 }
	 
	 @Test
	 public void AddPerticularProductInCart() {
			productSearchPage=new ProductSearchPage(driver);
			cartPage=new CartPage(driver);
			loginPage=new LoginPage(driver);
			checkoutPage=new CheckoutPage(driver);
			paymentDonePage=new PaymentDonePage(driver);
			cartPage.verifyProduct();
			cartPage.clickOnRegisterLogin();
			loginPage.login("rameshamale26@gmail.com", "Test@123");
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
	        paymentDonePage.clickOnContinueButton();
	 }
	 
	 @Test
	 public void productSeacrch() {
			homePage=new HomePage(driver);
			homePage.clickProductsLink();
			productSearchPage=new ProductSearchPage(driver);
			productSearchPage.searchForProduct("dress");
			productSearchPage.verifySearchResultsContainKeyword();	
	 }

}