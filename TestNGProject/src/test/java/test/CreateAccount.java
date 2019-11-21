package test;
import java.util.concurrent.TimeUnit;
import pages.RegistrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;

public class CreateAccount {
    private static WebDriver driver = null;
    
    public RegistrationPage onNewAccountForm = new RegistrationPage(driver);
    
    public static void main(String [] args) {}
    
    public String chrome_browser = "webdriver.chrome.driver";
    public String baseUrl = "http://5elementslearning.com/demosite/create_account.php";
    public String pathToExecutable = "drivers/chromedriver78";

    @BeforeTest
    public void setUp() {
        System.setProperty(chrome_browser, pathToExecutable);
    	driver = new ChromeDriver();    	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    
    @Test
    public void registrationFormUI() {
    	onNewAccountForm.verifyRegistrationFormUI(driver);

    }
    
    @Test
    public void registrationFormSubmission() {
    	onNewAccountForm.submitPersonalInformation(driver);
    	onNewAccountForm.submitEmploymentInformation(driver);
    	onNewAccountForm.submitAddressInformation(driver);
    	onNewAccountForm.submitContactInformation(driver);
    	onNewAccountForm.submitAccountCredentials(driver);
    }
    
    @AfterTest
    public void tearDown() {
    	driver.close();
    }
}
