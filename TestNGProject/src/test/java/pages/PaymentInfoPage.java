package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class PaymentInfoPage {
	//LOCATORS
	By pageTitle = By.tagName("//h1");
	By billingAddress_hdr = By.xpath("(//h2)[1]");
	By paymentMethod_hdr = By.xpath("(//h2)[2]");
	By paymentMethod_cod = By.xpath("//input[@value='cod']");
	By paymentMethod_paypal = By.xpath("//input[@value='paypal_express']");
	
	By paymentComments_hdr = By.xpath("(//h2)[3]");
	By paymentComments = By.name("comments");
	By paymentCTA = By.id("tdb6");
	
	WebDriver driver = null;
	
	public PaymentInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	//ACTIONS
	
	public void verifyPaymentMethodPageUI(WebDriver driver) {
		Assert.assertNotNull("pageTitle");
		Assert.assertNotNull("billingAddress_hdr");
		Assert.assertNotNull("paymentMethod_hdr");
		Assert.assertNotNull("paymentMethod_cod");
		Assert.assertNotNull("paymentMethod_paypal");
		Assert.assertNotNull("paymentComments_hdr");
		Assert.assertNotNull("paymentComments");		
	}
	
	public void selectPaymentMethod(WebDriver driver) {
		driver.findElement(paymentMethod_cod).click();
		driver.findElement(paymentComments).sendKeys("This is the payment page comment of my Test");
		driver.findElement(paymentCTA).click();
	}
}
