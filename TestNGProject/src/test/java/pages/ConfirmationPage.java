package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ConfirmationPage {
	//LOCATORS
	
	By pageTitle = By.tagName("//h1");
	By shippingInfo_hdr = By.xpath("(//h2)[1]");
	By billingInfo_hdr = By.xpath("(//h2)[2]");
	By orderCommentsInfo_hdr = By.xpath("(//h2)[3]");
	By orderSubTotal = By.xpath("//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]");
	By orderShippingMethod = By.xpath("//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]");
	By orderTotal = By.xpath("//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]");
	By orderConfirmationCTA = By.id("tdb5");
	
	WebDriver driver = null;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
		
	//ACTIONS
	public void verifyOrderConfirmationDetails(WebDriver driver) {
		Assert.assertNotNull(pageTitle);
		
		//SHIPPING INFO
		Assert.assertNotNull(shippingInfo_hdr);
		
		//BILLING INFO
		Assert.assertNotNull(billingInfo_hdr);
		
		//ORDER INFO
		Assert.assertNotNull(orderCommentsInfo_hdr);
		Assert.assertNotNull(orderSubTotal);
		Assert.assertNotNull(orderShippingMethod);
		Assert.assertNotNull(orderTotal);
		
		driver.findElement(orderConfirmationCTA).click();
	}

}
