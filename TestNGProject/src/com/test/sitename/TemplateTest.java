package com.test.sitename;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class TemplateTest {


    public WebDriver driver;
    public String chrome_browser = "webdriver.chrome.driver";
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public String pathToExecutable = "src/drivers/chromedriver78";
    
    @BeforeSuite    
	public void setUp() {
        System.setProperty(chrome_browser, pathToExecutable);
    	driver = new ChromeDriver();    	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void beforeTest() {
	    driver.get(baseUrl);	
	}
	 
	@Test
	@Parameters({"comment"})
	public void f(String comment) {
		System.out.println(comment);
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

}
