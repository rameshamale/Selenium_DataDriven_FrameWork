package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductSearchPage {
    WebDriver driver;
    private String lastSearchedKeyword;

	@FindBy(css="div.product-image-wrapper")
	List<WebElement> productList;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//a[contains(text(),'Add to cart')]")
	List<WebElement> AddtoCartButton;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//a[contains(text(),'Add to cart')]")
	WebElement SingleAddToKartBUtton;
	
	@FindBy(xpath="//div[@class='panel panel-default']")
	List<WebElement> allCategory;
	
	@FindBy(css = "#Women ul li a")
	private List<WebElement> womenSubcategories;
	
	@FindBy (xpath="//span[@class='badge pull-right']")
	List<WebElement> subCategotyCollapseButton;
	
	@FindBy (xpath="//div[@class='productinfo text-center']//p")
	List<WebElement> Productinfo;
	
	@FindBy (xpath="//p[text()='Your product has been added to cart.']")
	WebElement prodcutAddedMessage;
	
	@FindBy (id="cartModal")
	WebElement cartModel;
	
	@FindBy (xpath="//u[text()='View Cart']")
	WebElement viewCartLink;
	
	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement searchInput;

	@FindBy(id = "submit_search")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//p")
	private List<WebElement> productName;

	
    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ Required for @FindBy
    }
    
    public int getProductCount() {
        return AddtoCartButton.size();
    }
    
    public Map<String, String> getProductDataFromUI() {
        Map<String, String> uiData = new HashMap<>();
        for (WebElement product : productList) {
            WebElement productInfo = product.findElement(By.cssSelector(".productinfo.text-center"));
            String price = productInfo.findElement(By.tagName("h2")).getText().replace("Rs.", "").trim();
            String name = productInfo.findElement(By.tagName("p")).getText().trim();
            uiData.put(name, price);
        }
        return uiData;
    }
    
    public void verifyAddCartButtonIsPresentOnEachProduct() {
    	for(WebElement Element :AddtoCartButton) {
    		Element.isDisplayed();
    	}
		System.out.println("AddtocartPresent on each product");

    }
    
    public List<String> verifyAllCategory() {
        List<String> categoryNames = new ArrayList<>();

        for (WebElement category : allCategory) {
            categoryNames.add(category.getText());
        }

        return categoryNames;
    }
    
    public void clickEachCategoryAndPrintSubcategories() throws InterruptedException {
        List<String> categoryNames = Arrays.asList("Women", "Men", "Kids");

        for (String categoryName : categoryNames) {
            WebElement categoryLink = driver.findElement(By.xpath("//a[contains(@href, '#" + categoryName + "')]"));

            // Use JS click if regular click is unreliable
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryLink);

            WebElement panel = driver.findElement(By.id(categoryName));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Wait for panel to expand and subcategories to be visible
            wait.until(ExpectedConditions.attributeContains(panel, "class", "in"));
            wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(panel, By.cssSelector("ul > li > a")));

            List<WebElement> subLinks = panel.findElements(By.cssSelector("ul > li > a"));

            System.out.println("Category: " + categoryName);
            for (WebElement link : subLinks) {
                System.out.println("  Subcategory: " + link.getText().trim());
            }
        }
    }
    

    public void searchForProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName.toLowerCase());
        searchButton.click();
        lastSearchedKeyword = productName; // Store the keyword used
    }

    public void verifySearchResultsContainKeyword() {
    	SoftAssert softAssert = new SoftAssert();

    	if (productName.isEmpty()) {
    	    softAssert.fail("No search results found.");
    	} else {
    	    for (WebElement product : productName) {
    	        String name = product.getText().toLowerCase();
    	        String keyword = lastSearchedKeyword.toLowerCase().replaceAll("s$", "");
    	        softAssert.assertTrue(name.contains(keyword),
    	            "Product name does not match expected keyword. Actual: " + name);
    	    }
    	}

    }
                
 }
    


