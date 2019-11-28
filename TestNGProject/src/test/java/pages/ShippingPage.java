package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ShippingPage {
	//LOCATORS
	By pageTitle = By.tagName("//h1");
	By shippingAddress_hdr = By.xpath("(//h2)[1]");
	By shippingAddressInfo_company = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[1]");
	By shippingAddressInfo_name = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[2]");
	By shippingAddressInfo_address = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[3]");
	By shippingAddressInfo_city = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[4]");
	By shippingAddressInfo_state = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[5]");
	By shippingAddressInfo_country = By.xpath("//*[@id='bodyContent']/form/div/div[1]/div/div[2]/text()[6]");
	
	By shippingMethod_hdr = By.xpath("(//h2)[2]");
	By shippingMethod = By.xpath("//tr[@id='defaultSelected']");
	
	By comments_hdr = By.xpath("(//h2)[3]");
	By comments = By.name("comments");
	
	By continueCTA = By.id("tdb6");
	
	WebDriver driver = null;
	
	public ShippingPage (WebDriver driver) {
		this.driver = driver;
	}
	//ACTIONS
	public void verifyShippingDetails(WebDriver driver) {
		Assert.assertNotNull(pageTitle);
		Assert.assertNotNull(shippingAddress_hdr);
		Assert.assertNotNull("shippingAddressInfo_company");
		Assert.assertNotNull("shippingAddressInfo_name");
		Assert.assertNotNull("shippingAddressInfo_address");
		Assert.assertNotNull("shippingAddressInfo_city");
		Assert.assertNotNull("shippingAddressInfo_state");
		Assert.assertNotNull("shippingAddressInfo_country");
		
		Assert.assertNotNull("shippingMethod_hdr");
		Assert.assertNotNull("shippingMethod");
		
		Assert.assertNotNull("comments_hdr");
		Assert.assertNotNull("comments");
		
	}
	
	public void addShippingNotes(WebDriver driver) {
		driver.findElement(comments).sendKeys("TestNG E2E Checkout Demo");
		driver.findElement(continueCTA).click();
	}

}
