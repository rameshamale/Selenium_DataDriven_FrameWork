package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	@FindBy (css="a[href='/view_cart']")
	private WebElement Cartlink;
	
	@FindBy(xpath = "//tr[starts-with(@id,'product-')]")
	private List<WebElement> productRows;

    @FindBy(css = ".cart_description h4 a")
    private WebElement productName;

    @FindBy(css = ".cart_description p")
    private WebElement productCategory;

    @FindBy(css = ".cart_price p")
    private WebElement productPrice;

    @FindBy(css = ".cart_quantity button")
    private WebElement productQuantity;

    @FindBy(css = ".cart_total_price")
    private WebElement productTotal;
    
    @FindBy(linkText="Proceed To Checkout")
    WebElement checkOutButton;
    
    @FindBy(css="div.modal-body a[href='/login']")
    WebElement RegisterLoginLink;
    
    @FindBy(xpath="//a[@class='cart_quantity_delete']")
    WebElement removeItemFromCart;
	
	 public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); 
	    }
	 
	 public void verifyProduct() {
		 
		 for (WebElement row : productRows)
		 {	 
		        String name = row.findElement(By.cssSelector(".cart_description h4 a")).getText();
		        String category = row.findElement(By.cssSelector(".cart_description p")).getText();
		        String price = row.findElement(By.cssSelector(".cart_price p")).getText();
		        String quantity = row.findElement(By.cssSelector(".cart_quantity button")).getText();
		        String total = row.findElement(By.cssSelector(".cart_total_price")).getText();
		        
		    }
	 }
	 
	 public void clickOnCheckOutButton() {
		 checkOutButton.click();
	 }
	 
	 public void clickOnRegisterLogin() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", RegisterLoginLink);
	 }
	 
	 public void clickOnCartLink() {
		 Cartlink.click();
	 }
	 
	 public void clickOnItemRemoveButton() {
		 removeItemFromCart.click();
	 }
	    
}
