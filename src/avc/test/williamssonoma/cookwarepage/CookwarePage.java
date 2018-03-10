package avc.test.williamssonoma.cookwarepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import avc.test.williamssonoma.pageobject.AbstractPage;
import avc.test.williamssonoma.productpage.ProductPage;

public class CookwarePage extends AbstractPage{

	@FindBy(xpath = "//*[@id='subCatListContainer']/ul/li[1]/a/span")
	private WebElement product;
	
	
	public CookwarePage(WebDriver driver){
		super(driver);
	}
	
	public ProductPage chooseAproduct(String product){
		
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//ul/li[1]/a/span[contains(text(),'"+product+"')]"))).click();
				
		//this.product.click();
		
		return PageFactory.initElements(driver, ProductPage.class);
	}
	
	
}
