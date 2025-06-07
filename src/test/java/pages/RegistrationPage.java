package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestUtil;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(linkText = "Signup / Login")
    WebElement signupLoginButton;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signUpUserName;

    @FindBy(xpath = "//input[@data-qa='signup-email']") 
    WebElement signUpEmail;

    @FindBy(xpath = "//button[text()='Signup']") 
    WebElement signUpButton;
    
    @FindBy(xpath="//p[text()='Email Address already exist!']")
    WebElement errormessage;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void register(String user, String email) {
        signUpUserName.sendKeys(user);
        signUpEmail.sendKeys(email);
        signUpButton.click();
    }
    
    public String getErrorMessageText() {
    	TestUtil.waitForElementVisible(driver, errormessage, 10);
    	return errormessage.getText();
    }
    
    public String getsignUpUserNameValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",signUpUserName);
    }
}
