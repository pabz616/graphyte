package pages;
import org.openqa.selenium.*;
import org.testng.Assert;


public class RegistrationPage {

	WebDriver driver = null;
	
	//LOCATORS
	
	By header = By.xpath("//h1[contains(.,'My Account Information')]");
	By select_male = By.xpath(("//h1[contains(.,'My Account Information')]"));
	By fname_input = By.name("firstname");
	By lname_input = By.name("lastname");
	By dob_datePicker = By.name("dob");
	By email_input = By.name("email_address");
	By company_input = By.name("company");
	By street_addr_input = By.name("street_address");
	By suburb_input = By.name("suburb");
	By zipcode_input = By.name("postcode");
	By city_input = By.name("city");
	By state_input = By.name("state");
	By country_ddl = By.name("country");
	By option_usa = By.xpath("//option[@value='223']");
	By telephone_input = By.name("telephone");
	By new_password_input = By.name("password");
	By confirm_password_input = By.name("confirmation");
	
	
	public RegistrationPage (WebDriver driver) {
		this.driver = driver;
	}
		
	//ACTIONS
 	public void verifyRegistrationFormUI(WebDriver driver) {
 		WebElement page_header = driver.findElement(header);
 		
    	String expected_text = "My Account Information";
    	String actual_text = page_header.getText();
    	
    	Assert.assertNotNull(page_header, "Page header is not shown");
    	Assert.assertEquals(actual_text, expected_text);
 	}
 	
	public void submitPersonalInformation(WebDriver driver) {
		driver.findElement(select_male).click();
		driver.findElement(fname_input).sendKeys("Awesome");
		driver.findElement(lname_input).sendKeys("Is My Name");
		driver.findElement(dob_datePicker).sendKeys("06/16/1975");
		driver.findElement(email_input).sendKeys("awesomeness@mail.com");
	}

	public void submitEmploymentInformation(WebDriver driver) {
		driver.findElement(company_input).sendKeys("QA Testers, Inc.");
	}
	
	public void submitAddressInformation(WebDriver driver) {
		driver.findElement(street_addr_input).sendKeys("2600 Netherland Avenue - Apt. 1607");
		driver.findElement(suburb_input).sendKeys("Bronx");
		driver.findElement(zipcode_input).sendKeys("10463");
		driver.findElement(city_input).sendKeys("Riverdale");
		driver.findElement(state_input).sendKeys("New York");
		driver.findElement(country_ddl).click();
		driver.findElement(option_usa).click();
	}
	
	public void submitContactInformation(WebDriver driver) {
		driver.findElement(telephone_input).sendKeys("212-333-4455");
	}
	
	public void submitAccountCredentials(WebDriver driver) {
		driver.findElement(new_password_input).sendKeys("Password1");
		driver.findElement(confirm_password_input).sendKeys("Password1");
	}

}
