package pages;
import org.openqa.selenium.*;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class CartPage {
	//LOCATORS
	
	By productTitle = By.xpath("//td/a/strong");
	By productPrice = By.xpath("//td/strong");
	By productImage = By.xpath("//img[@alt='Matrox G200 MMS']");
	By productOptionA = By.xpath("(//td/small/i)[1]");
	By productOptionB = By.xpath("(//td/small/i)[2]");
	By updateQTY_input = By.xpath("//input[contains(@name,'cart_quantity')]");
	By updateQTY_cta = By.id("tdb4");
	By productSubTotal = By.xpath("//p/strong");
	By CTA = By.id("tdb5");
	
	WebDriver driver = null;
	
	public CartPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//ACTIONS
	public void verifyCartDetails(WebDriver driver) {
		Assert.assertNotNull(productTitle);
		Assert.assertNotNull(productPrice);
		Assert.assertNotNull(productImage);
		Assert.assertNotNull(productOptionA);
		Assert.assertNotNull(productOptionB);
		Assert.assertNotNull(CTA);
	}
	
	public void updateItemQuantityInCart(WebDriver driver) throws Exception {
		//String initial_price = driver.findElement(productPrice).getText();
		double price = 299.99; //Integer.valueOf(initial_price);
		int qty = 2;
		
		//Update the item in the cart
		driver.findElement(updateQTY_input).clear();
		driver.findElement(updateQTY_input).sendKeys("2");
		driver.findElement(updateQTY_cta).click();
		
		//calculate new price
		double cost = price * qty;
		
		TimeUnit.SECONDS.sleep(2);
		String updated_price = driver.findElement(productSubTotal).getText();
	    Assert.assertEquals(updated_price, "Sub-Total: $"+cost, "The updated price does not match $"+cost);
	}
	
	public void proceedToCheckout(WebDriver driver) {
		driver.findElement(CTA).click();
	}
}

