package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	
	@FindBy (linkText="Place Order")
	WebElement Place_Order;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlaceOrderButton() {
		Place_Order.click();
	}

}
