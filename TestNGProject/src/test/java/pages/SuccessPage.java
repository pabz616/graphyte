package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class SuccessPage {
	//LOCATORS
	By productNotice = By.xpath("//p[@class='productsNotifications']");
	By thankYou_msg = By.tagName("//h3");
	By continueCTA = By.id("tdb5");
	
	WebDriver driver = null;
	
	public SuccessPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//ACTIONS
	public void verifySuccessPageUI(WebDriver driver){
		String productPurchased = driver.findElement(productNotice).getText();
		String productName = "Matrox G200 MMS";
		
		Assert.assertNotNull(productNotice);
		Assert.assertNotNull(thankYou_msg);
		
		Assert.assertEquals(productPurchased, productName);
	}
	
	public void completeOrder(WebDriver driver) {
		driver.findElement(continueCTA).click();
	}
	
}
