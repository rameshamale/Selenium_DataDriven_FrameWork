package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import utils.ExcelReader;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;
    
    @FindBy(xpath="//p[text()='Your email or password is incorrect!']")
    WebElement ErrorMessage;
    
    @FindBy(css = "div.logo.pull-left img")
    WebElement websiteLogo;
    
    @FindBy(css="div.shop-menu.pull-right ul.nav.navbar-nav li a")
    List<WebElement> menuLinks;

    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        return ExcelReader.readExcelData("LoginData"); // Sheet name
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 // Method to verify logo is displayed
    public boolean isLogoDisplayed() {
        return websiteLogo.isDisplayed();
    }
    
    
    public void login(String user, String pass) {
    	loginEmail.sendKeys(user);
    	password.sendKeys(pass);
    	loginButton.click();
    }
   
    public String getEmptyEmailErroeMessage() {
    	return ErrorMessage.getText();
    }
    
    public String getEmptyPasswordErroeMessage() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",password);    }
    
    public String getEmptyEmailErroeMessage1() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",loginEmail);    }
    
    public String getEmptyEmailPasswordErroeMessage() {
    	return ErrorMessage.getText();
    }

    public boolean AreAllMenuLinksDisplayed() {
    	for (WebElement link: menuLinks) {
    		if(!link.isDisplayed()) {
                System.out.println("Missing or hidden link: " + link.getText());
                return false;}
    	}
    	return true;
    }
    
}