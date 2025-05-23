package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeSuite
    public void BeforeSuite() {
    	System.out.println("Before suit code is running");
   }
    
    @BeforeClass
    public void setUp() {
    	driver= new ChromeDriver();
    	driver.get("https://www.automationexercise.com/");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
    
    @AfterSuite
    public void AfterSuite() {
    	System.out.println("After suit code is running");
   }
    
}