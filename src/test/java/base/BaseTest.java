package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import utils.ConfigReader;
import utils.ExtentReportManager;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    ConfigReader configReader;

    @BeforeSuite
    public void setupExtentReport() {
        ExtentReportManager.setupReport();
    }
    
   
    @BeforeClass
    public void setUp() {
        System.out.println("Before class method is running");

        // Set up Chrome download preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.autofill", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("download.default_directory","D:\\selenium-data-driven-framework\\Downloads" );
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-autofill-keyboard-accessory-view");

        driver = new ChromeDriver(options);

        configReader = new ConfigReader();
        String url = configReader.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
    
    @AfterSuite
    public void tearDownExtentReport() {
        ExtentReportManager.flushReport();
    }
    
}