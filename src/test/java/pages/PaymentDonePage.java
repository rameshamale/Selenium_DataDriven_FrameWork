package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDonePage {
	
	WebDriver driver;
	
	@FindBy (css="h2[class='title text-center']")
	WebElement orderPlaced;
	

	@FindBy (css="a[data-qa='continue-button']")
	WebElement continueButton;
	
	@FindBy (linkText="Download Invoice")
	WebElement downLoadButton;
		
	public PaymentDonePage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);	}

	public String confirmOrderPalcedMessage() {
	
		return orderPlaced.getText();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public void clickOnDownLoadButton() {
		downLoadButton.click();
	}

}
