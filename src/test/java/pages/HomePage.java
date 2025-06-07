package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WebDriverWait wait;
    
	@FindBy (xpath="//a[text()=' Logout']")
	WebElement Logout;
    By signUpButton = By.linkText("Signup / Login");
    
	@FindBy (xpath="//div[@class='productinfo text-center']//p")
	List<WebElement> Productinfo;

	@FindBy (xpath="//u[text()='View Cart']")
	WebElement viewCartLink;
	
	@FindBy (id="cartModal")
	WebElement cartModel;
	
	@FindBy (xpath="//p[text()='Your product has been added to cart.']")
	WebElement prodcutAddedMessage;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//a[contains(text(),'Add to cart')]")
	WebElement SingleAddToKartBUtton;
    
    @FindBy (xpath="//a[contains(text(),'Logged in as')]/b")
    WebElement LoggedInElement;
    
    @FindBy (css="#slider-carousel .carousel-inner .item")
    List<WebElement> sliders;
    
    @FindBy (xpath="//h2[text()='Category']")
    WebElement category;
    
    @FindBy (xpath="//h2[text()='Brands']")
    WebElement BrandsHeading;

    @FindBy (xpath="//div[@class='panel panel-default']")
    List<WebElement> Categories; 
    
    @FindBy (xpath="//div[@class='brands_products']//ul/li/a")
    List<WebElement> Brands; 
    
    @FindBy(xpath = "//li/a[@href='/products' and contains(text(),'Products')]")
    private WebElement productsLink;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignUpLoginButton() {
    	
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }
    
    public void clickOnLogout() {
    	Logout.click();
    }
    
    public String verifyTheLoginPerson() {
    	return LoggedInElement.getText();
    }
    
    public void verifySlidersPresent() {
        if (sliders.size() > 0) {
            System.out.println("Sliders are present. Total sliders found: " + sliders.size());
        } else {
            System.out.println("No sliders found!");
        }
    }
    
    public String verifyTheCategoryHeading() {
    	return category.getText();
    }
    
    public String verifyTheBrandsHeading() {
    	return BrandsHeading.getText();
    }
    
    public void verifyTheCategoryName() {
    	for(WebElement category:Categories) {
    		System.out.println(category.getText());
    	}
    	 
    }
    
    public void verifyTheBrandName() {
    	for(WebElement Brand:Brands) {
    		System.out.println(Brand.getText().replaceAll("\\(.*\\)", "").trim());
    	}
}
    public void clickProductsLink() {
        productsLink.click();
    }

	public void LogOut() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		homePage.clickOnSignUpLoginButton();
		loginPage.login("rameshamale26@gmail.com", "Test@123");
		homePage.clickOnLogout();
	}
	
    public void AddPerticularProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	for (WebElement product:Productinfo) {
    		String NameofProduct=product.getText();
    		
    	    if (NameofProduct.equalsIgnoreCase("Blue Top")) {
    	        Actions actions = new Actions(driver);
    	        actions.moveToElement(product).perform();
    	        SingleAddToKartBUtton.click();
    	        wait.until(ExpectedConditions.visibilityOf(cartModel));
    	        if(prodcutAddedMessage.isDisplayed()) {
    	            System.out.println("Success message is displayed: " + prodcutAddedMessage.getText());
    	        }
    	        else {
    	            System.out.println("Success message not found!");
    	        }
    	        
    	        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
    	        viewCartLink.click();
    	        break;
    	    }
    	    wait.until(ExpectedConditions.urlContains("/view_cart"));
    	    
    	}
    	
    }
}
