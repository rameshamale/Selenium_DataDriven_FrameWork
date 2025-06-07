package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	WebDriver driver;
	
	@FindBy(xpath = "//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement successMessage;
	
	@FindBy (xpath="//a[text()='Continue']")
	WebElement continueButton;
	
	@FindBy (css="h2[data-qa=\"account-created\"]")
	WebElement AccountCreated;
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTheAccountCreatesSuccessMessage() {
	 String AccountCreatesSuccessMessage=successMessage.getText();
		return AccountCreatesSuccessMessage;
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}

}
