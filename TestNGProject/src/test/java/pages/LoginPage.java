package pages;
import org.openqa.selenium.*;

public class LoginPage {
	//LOCATORS
	
	By usn_input = By.name("email_address");
	By pwd_input = By.name("password");
	By signInCTA = By.id("tdb5");
	
	WebDriver driver = null;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//ACTIONS
	public void proceedAsCustomer(WebDriver driver) {
		String email_address = "qaTester.testng@mail.com";
		String password = "Password1";
		
		driver.findElement(usn_input).sendKeys(email_address);
		driver.findElement(pwd_input).sendKeys(password);
		driver.findElement(signInCTA).click();
	}
}
