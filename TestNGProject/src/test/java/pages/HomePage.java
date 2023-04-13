package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class HomePage {
	WebDriver driver = null;
	
	//LOCATORS
	String welcomeTitle = "Welcome to Tattvamassi";
	
	By header = By.xpath("//h1[contains(.,'Welcome')]");
	By byline = By.xpath("//h2[contains(.,'New Products')]");
	By productImage = By.xpath("//img[@title='Matrox G200 MMS']");
	By productTitle = By.xpath("(//a[contains(.,'Matrox G200 MMS')])[1]");
	By productPrice = By.xpath("//td[contains(.,'$299.99')]");
	By logOutCTA = By.id("tdb4");
	
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	//ACTIONS
	public void verifyLandingPageUI(WebDriver driver) {
		String landingPageTitle = driver.findElement(header).getText();
		
		Assert.assertEquals(landingPageTitle, welcomeTitle, "Strings are not matching");
		Assert.assertNotNull(productImage);
		Assert.assertNotNull(productTitle);
		Assert.assertNotNull(productPrice);		
	}
	
	public void selectItem(WebDriver driver) {
		driver.findElement(productTitle).click();
	}
	
	public void logOff(WebDriver driver) {
		driver.findElement(logOutCTA).click();
	}

}
