package avc.test.williamssonoma.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import avc.test.williamssonoma.mainpage.WSMainPage;

public class AbstractPage {

	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	protected JavascriptExecutor jse;
	
	public AbstractPage (WebDriver driver){
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver,15);
		this.action = new Actions(driver);
		this.jse = (JavascriptExecutor)driver;
	}
	
	public WSMainPage accessWSMainPage(){
		
		driver.get("http://www.williams-sonoma.com");		
		
		return PageFactory.initElements(driver, WSMainPage.class);
	}
	
}
