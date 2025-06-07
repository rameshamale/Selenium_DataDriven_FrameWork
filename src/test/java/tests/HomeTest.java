package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest {
	
	HomePage homepage;
	
	@Test
	public void verifyThreeSliderArePresent() {
		homepage=new HomePage(driver);
		homepage.verifySlidersPresent();
	}
	
	@Test
	public void verifyCategoryHeadingIsPresent() {
		homepage=new HomePage(driver);
		homepage.verifyTheCategoryHeading();
	}
	
	@Test
	public void verifyBrandsHeadingIsPresent() {
		homepage=new HomePage(driver);
		homepage.verifyTheBrandsHeading();
	}

	@Test
	public void verifyCategoryName() {
		homepage=new HomePage(driver);
		homepage.verifyTheCategoryName();
	}
	
	@Test
	public void verifyBrandsName() {
		homepage=new HomePage(driver);
		homepage.verifyTheBrandName();
	}
	
	@Test
	public void LogOut() {
		homepage=new HomePage(driver);
		homepage.LogOut();
	}
	
	@Test
	public void addProductToCart() {
		homepage=new HomePage(driver);
		homepage.AddPerticularProductInCart();
	}
}
