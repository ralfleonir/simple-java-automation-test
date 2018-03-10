package avc.test.williamssonoma.mainpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import avc.test.williamssonoma.cookwarepage.CookwarePage;
import avc.test.williamssonoma.pageobject.AbstractPage;

public class WSMainPage extends AbstractPage {

	@FindBy(xpath = "//*[@id='topnav-container']/ul/li[1]/a")
	private WebElement menuCookware;
	@FindBy(name = "map_1253273676_1429739978753")
	private WebElement image;
	@FindBy(xpath = "//*[@id='topnav-container']/ul/li[1]/div/div[1]/ul[1]/li[1]/a")
	private WebElement subMenu;
	
	
	public WSMainPage(WebDriver driver) {
		super(driver);
	}

	public WSMainPage hoverMenuCategory() throws Exception {
		driver.manage().deleteAllCookies();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@id='topnav-container']/ul/li[1]/a")));
		// Thread.sleep(3000);
		//Actions act = new Actions(driver);
		action.moveToElement(menuCookware).build().perform();
		return this;
	}
	
	public CookwarePage clickSubcategory(){
		
		wait.until(ExpectedConditions.elementToBeClickable(subMenu));
		subMenu.click();
		
		return PageFactory.initElements(driver, CookwarePage.class);
		
		
		
	}
	

}
