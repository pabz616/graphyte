package test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import pages.RegistrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;

public class CreateAccount {
    private static WebDriver driver = null;
    
    public RegistrationPage onNewAccountForm = new RegistrationPage(driver);
    
    public static void main(String [] args) {}
    public String baseUrl = "http://5elementslearning.com/demosite/create_account.php";

	@BeforeTest
	@Parameters({"chrome_browser", "pathToExecutable"})
    public void setUp(@Optional("webdriver.chrome.driver") String chrome_browser, @Optional("drivers/chromedriver78") String pathToExecutable) {
		
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
