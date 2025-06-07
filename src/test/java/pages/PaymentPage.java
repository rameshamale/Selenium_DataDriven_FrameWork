package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Name on Card
    @FindBy(name = "name_on_card")
    private WebElement nameOnCardInput;

    // Card Number
    @FindBy(name = "card_number")
    private WebElement cardNumberInput;

    // CVC
    @FindBy(name = "cvc")
    private WebElement cvcInput;

    // Expiry Month
    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInput;

    // Expiry Year
    @FindBy(name = "expiry_year")
    private WebElement expiryYearInput;

    // Pay and Confirm Order button
    @FindBy(id = "submit")
    private WebElement payAndConfirmButton;

    // Success message (optional)
    @FindBy(id = "success_message")
    private WebElement successMessage;


    public void enterCardDetails(Map<String, String> cardData) {
        nameOnCardInput.sendKeys(cardData.get("name_on_card"));
        cardNumberInput.sendKeys(cardData.get("card_number"));
        cvcInput.sendKeys(cardData.get("cvc"));
        expiryMonthInput.sendKeys(cardData.get("expiry_month"));
        expiryYearInput.sendKeys(cardData.get("expiry_year"));
    }

    public void enterNameOnCard(String name) {
        nameOnCardInput.sendKeys(name);
    }

    public void enterCardNumber(String cardNum) {
        cardNumberInput.sendKeys(cardNum);
    }

    public void enterCVC(String cvc) {
        cvcInput.sendKeys(cvc);
    }

    public void enterExpiryMonth(String month) {
        expiryMonthInput.sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        expiryYearInput.sendKeys(year);
    }

    public void clickPayAndConfirm() {
        payAndConfirmButton.click();
    }

    public boolean isOrderSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
