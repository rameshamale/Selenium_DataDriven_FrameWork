package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage{
	
	WebDriver driver;
	
	@FindBy (id="id_gender1")
	WebElement MrGender;
	
	@FindBy (id="id_gender2")
	WebElement MrsGender;
	
	@FindBy (css="#name")
	WebElement name;
	
	@FindBy (css="#password")
	WebElement password;
	
	@FindBy (css="#days")
	WebElement days;
	
	@FindBy (css="#months")
	WebElement months;

	@FindBy (css="#years")
	WebElement years;
	
	@FindBy (css="#newsletter")
	WebElement newsletter;
	
	@FindBy (css="#optin")
	WebElement specialOffer;
	
	@FindBy (css="#first_name")
	WebElement firstName;

	@FindBy (css="#last_name")
	WebElement lastName;
	
	@FindBy (css="#company")
	WebElement CompanyName;
	
	@FindBy (css="#address1")
	WebElement AdreesLine1;

	@FindBy (css="#country")
	WebElement Country;
	
	@FindBy (css="#state")
	WebElement State;
	
	@FindBy (css="#city")
	WebElement City;
	
	@FindBy (css="#mobile_number")
	WebElement MobileNumber;
	
	@FindBy (css="button[data-qa='create-account']")
	WebElement CreateAccounButton;
	
	@FindBy (css="#zipcode")
	WebElement zipCode;
	
	 public SignUpPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	public void selectGender(String gender) {
	    if (gender.equalsIgnoreCase("Mr")) {
	        MrGender.click();
	    } else if (gender.equalsIgnoreCase("Mrs")) {
	        MrsGender.click();
	    }
	}
	public void enterName(String fullName) {
	    name.clear();
	    name.sendKeys(fullName);
	}

	public void enterPassword(String pass) {
	    password.clear();
	    password.sendKeys(pass);
	}
	public void selectDay(String day) {
	    new Select(days).selectByVisibleText(day);
	}

	public void selectMonth(String month) {
	    new Select(months).selectByVisibleText(month);
	}

	public void selectYear(String year) {
	    new Select(years).selectByVisibleText(year);
	}
	public void toggleNewsletter(boolean subscribe) {
	    if (subscribe && !newsletter.isSelected()) {
	        newsletter.click();
	    } else if (!subscribe && newsletter.isSelected()) {
	        newsletter.click();
	    }
	}

	public void toggleSpecialOffer(boolean subscribe) {
	    if (subscribe && !specialOffer.isSelected()) {
	        specialOffer.click();
	    } else if (!subscribe && specialOffer.isSelected()) {
	        specialOffer.click();
	    }
	}
	public void enterFirstName(String fName) {
	    firstName.clear();
	    firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
	    lastName.clear();
	    lastName.sendKeys(lName);
	}

	public void enterCompany(String company) {
	    CompanyName.clear();
	    CompanyName.sendKeys(company);
	}

	public void enterAddress(String addressLine) {
	    AdreesLine1.clear();
	    AdreesLine1.sendKeys(addressLine);
	}
	public void selectCountry(String country) {
	    new Select(Country).selectByVisibleText(country);
	}

	public void enterState(String state) {
	    State.clear();
	    State.sendKeys(state);
	}

	public void enterCity(String city) {
	    City.clear();
	    City.sendKeys(city);
	}
	public void enterMobileNumber(String mobile) {
	    MobileNumber.clear();
	    MobileNumber.sendKeys(mobile);
	}
	
	public void enterPinCode(String pincode) {
		zipCode.clear();
		zipCode.sendKeys(pincode);
	}
	
	public void clickCreateAccountButton() {
	    CreateAccounButton.click();
	}
	
	public String getPasswordValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", password);
    }
	
	public String getFristNameValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", firstName);
    }
	
	public String getLastNameValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",lastName);
    }
	
	public String getAdressValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",AdreesLine1);
    }
	public String getStateValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",State);
    }
	
	public String getZipCodeValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",zipCode);
    }
	
	public String getMobileNumberValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",MobileNumber);
    }
}