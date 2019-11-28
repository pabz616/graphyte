package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ProductDetailsPage {
	//LOCATORS

	By productTitle = By.xpath("(//h1)[2]");
	By productPrice = By.xpath("(//h1)[1]");
	By productImage = By.xpath("//img[@alt='Matrox G200 MMS']");
	By productDescr = By.xpath("//div[@class='contentText']");
	By productOptionA = By.name("id[4]");
	By productOptionA_item = By.xpath("(//option[@value='1'])[1]");
	By productOptionB = By.name("id[3]");
	By productOptionB_item = By.xpath("(//option[@value='5'])[1]");
	By productCTA = By.id("tdb4");
	
	
	WebDriver driver = null;
	
	public ProductDetailsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//ACTIONS
	public void verifyProductDetailsPageUI(WebDriver driver) {
		String productPriceShown = driver.findElement(productPrice).getText();
		
		Assert.assertNotNull(productTitle);
		Assert.assertNotNull(productPrice);		
		Assert.assertNotNull(productImage);
		Assert.assertNotNull(productDescr);
		
		Assert.assertEquals("$299.99", productPriceShown, "Product price is incorrect or has changed");
	}
	
	public void addItemToCart(WebDriver driver) {
		driver.findElement(productOptionA).click();
		driver.findElement(productOptionA_item).click();
		driver.findElement(productOptionB).click();
		driver.findElement(productOptionB_item).click();		
		driver.findElement(productCTA).click();
	}

}
