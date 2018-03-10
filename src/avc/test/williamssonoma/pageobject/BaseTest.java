package avc.test.williamssonoma.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeTest
	public void startUp(){
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void endTest() {
		//driver.quit();
	}
	
}
