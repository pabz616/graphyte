package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class firstTestNGClass {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "../drivers/chromedriver78";
    public WebDriver driver ; 
  
  @BeforeTest
  public void beforeTest() {
    System.out.println("launching chrome browser");
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.get(baseUrl);
  }
  
  @Test(priority=1)
  public void verifyHomepageTitle() {
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  

  @AfterTest
  public void afterTest() {
      driver.close();
  }
}
