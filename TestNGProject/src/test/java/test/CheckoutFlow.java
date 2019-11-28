package test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


import pages.HomePage;

public class CheckoutFlow {
    private static WebDriver driver = null;
    
    public HomePage onDemoSiteHomePage = new HomePage(driver);
    public ProductDetailsPage onDemoSiteProductDetailsPage = new ProductDetailsPage(driver);
    public CartPage onDemoSiteCartPage = new CartPage(driver);
    public LoginPage onDemoSiteLoginPage = new LoginPage(driver);
    public ShippingPage onDemoSiteShippingDetailsPage = new ShippingPage(driver);
    public PaymentInfoPage onDemoSitePaymentInfoPage = new PaymentInfoPage(driver);
    public ConfirmationPage onDemoSiteOrderConfirmationPage = new ConfirmationPage(driver);
    public SuccessPage onDemoSiteSuccessPage = new SuccessPage(driver);
    
    public static void main(String [] args) {}
    
	@BeforeTest()
	@Parameters({"chrome_browser", "pathToExecutable", "baseUrl"})
    public void setUp(@Optional("http://5elementslearning.com/demosite") String baseUrl, @Optional("webdriver.chrome.driver") String chrome_browser, @Optional("drivers/chromedriver78") String pathToExecutable) {
		
        System.setProperty(chrome_browser, pathToExecutable);
    	driver = new ChromeDriver();    	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
     }
    
    @Test
	public void itemPurchaseTest() throws Exception {
    	//LAUNCH SITE
    	onDemoSiteHomePage.verifyLandingPageUI(driver);
    	onDemoSiteHomePage.selectItem(driver);
    	
    	//SELECT PRODUCT
    	onDemoSiteProductDetailsPage.verifyProductDetailsPageUI(driver);
    	onDemoSiteProductDetailsPage.addItemToCart(driver);
    	
    	//ADD TO CART
    	onDemoSiteCartPage.verifyCartDetails(driver);
    	onDemoSiteCartPage.updateItemQuantityInCart(driver);
    	onDemoSiteCartPage.proceedToCheckout(driver);
    	
    	//PROCEED AS RETURN CUSTOMER
    	onDemoSiteLoginPage.proceedAsCustomer(driver);
    	
    	//SELECT SHIPPING METHOD
    	onDemoSiteShippingDetailsPage.verifyShippingDetails(driver);
    	onDemoSiteShippingDetailsPage.addShippingNotes(driver);
    	
    	//SELECT PAYMENT METHOD
    	onDemoSitePaymentInfoPage.verifyPaymentMethodPageUI(driver);
    	onDemoSitePaymentInfoPage.selectPaymentMethod(driver);
    	
    	//CONFIRM ORDER DETAILS
    	onDemoSiteOrderConfirmationPage.verifyOrderConfirmationDetails(driver);
    	
    	//ACKNOWLEDGE SUCCESS PAGE
    	onDemoSiteSuccessPage.verifySuccessPageUI(driver);
    	onDemoSiteSuccessPage.completeOrder(driver);
    	
    	//CLOSE THE TRANSACTION
    	onDemoSiteHomePage.logOff(driver);
    }
    
    @AfterTest
    public void tearDown() {
    	driver.close();
    }

}
