package tests;

import org.testng.annotations.*;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductSearchPage;

public class CartTests extends BaseTest {
	CartPage cartPage;
	LoginPage loginPage;
	HomePage homePage;
	

    @Test(groups = "cart")
    public void testAddProductToCart() {
        System.out.println("testAddProductToCart executed.");
    }

    @Test(groups = "cart")
    public void testRemoveProductFromCart() {
    	homePage=new HomePage(driver);
    	homePage.AddPerticularProductInCart();
    	cartPage=new CartPage(driver);
    	cartPage.clickOnCartLink();
    	cartPage.clickOnItemRemoveButton();
    }


    @Test(groups = "cart")
    public void testUpdateCartQuantity() {
        System.out.println("testUpdateCartQuantity executed.");
        
    }

}