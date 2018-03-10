package avc.test.williamssonoma.searchresultpage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import avc.test.williamssonoma.pageobject.AbstractPage;

public class SearchResultPage extends AbstractPage{

	@FindBy(xpath = "//*[@id='content']/div[2]/ul/li[2]/div[1]/a[1]/span/img")
	private WebElement image;
	@FindBy(xpath = "//*[@id='content']/div[2]/ul/li[2]/div[1]/a[2]/span")
	private WebElement quickLookButton;
	@FindBy(xpath = "//*[@id='results-summary']/h3")
	private WebElement resultPageTitle;
	@FindBy(xpath = "//*[@id='quicklookOverlay']")
	private WebElement productOverlay;
	@FindBy(xpath = "//*[@id='content']/div[2]/ul/li[2]/a/span")
	private WebElement productName;
	@FindBy(xpath = "//*[@id='content']/div[2]/ul/li[2]/span/span[2]/span[2]/span[2]")
	private WebElement productPrice;
	
	@FindBy(xpath = "//*[@id='purchasing-container']/div[2]/div/h1")
	private WebElement overlayProductName;
	@FindBy(xpath = "//*[@id='itemselection']/div/section/section/div/div/div/div[2]/span/span[2]/span[2]/span[2]")
	private WebElement overlayProductPrice;
	
	
	public SearchResultPage (WebDriver driver){
		super(driver);
	}
	
	public SearchResultPage hoverProductImage(String resPageTitle, String productName, String productPrice) throws Exception{
		
		//assert if Search field takes to the results page
		wait.until(ExpectedConditions.visibilityOf(resultPageTitle));
		String resultPagTitle = driver.findElement(By.xpath("//*[@id='results-summary']/h3")).getText();
		assertEquals("Should be on result page.",""+resPageTitle+"", resultPagTitle);

		//checking the product name on search result page
		wait.until(ExpectedConditions.visibilityOf(this.productName));
		String prodName = driver.findElement(By.xpath("//*[@id='content']/div[2]/ul/li[2]/a/span")).getText();
		assertEquals("Incorrect product name, should be "+productName+" .",""+productName+"", prodName);
		
		//checking the product price on search result page
		wait.until(ExpectedConditions.visibilityOf(this.productPrice));
		String prodPrice = driver.findElement(By.xpath("//*[@id='content']/div[2]/ul/li[2]/span/span[2]/span[2]/span[2]")).getText();
		assertEquals("Incorrect product price, should be $"+productPrice+" .",""+productPrice+"", prodPrice);
		
		wait.until(ExpectedConditions.visibilityOf(image));
		action.moveToElement(image).build().perform();
		
		//assert if Hover the product's image display the quick look button
		try{
			wait.until(ExpectedConditions.elementToBeClickable(quickLookButton));

//			String quickLButton = driver.findElement(By.xpath("//*[@id='content']/div[2]/ul/li[2]/div[1]/a[2]/span")).getText();
//			assertEquals("Quick look button should appear.","Quicklook", quickLButton);
			
		}catch(Exception e){
			throw new Exception("Quick look button should have appear", e);
		}
		
		return this;
	}
	
	public SearchResultPage clickQuickLookButton(){

		wait.until(ExpectedConditions.elementToBeClickable(quickLookButton));
		quickLookButton.click();
		
		//jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='content']/div[2]/ul/li[1]/div[1]/a[2]/span")));
		
		return this;
	}
	
	public SearchResultPage productOverlay(String productName, String productPrice) throws Exception{
		
		//assert if Click the quick look button show the product overlay
		try{
			wait.until(ExpectedConditions.visibilityOf(productOverlay));
		}catch(Exception e){
			throw new Exception("The product overlay shoul have appear.", e);
		}
		
		//assert if The product clicked should have the same name and price as the product in the overlay
		wait.until(ExpectedConditions.visibilityOf(overlayProductName));
		String overlayProdName = driver.findElement(By.xpath("//*[@id='purchasing-container']/div[2]/div/h1")).getText();
		assertEquals("The product name on overlay is not the same as in result page, should be "+productName+"", productName, overlayProdName);
		
		wait.until(ExpectedConditions.visibilityOf(overlayProductPrice));
		String overlayProdPrice = driver.findElement(By.xpath("//*[@id='itemselection']/div/section/section/div/div/div/div[2]/span/span[2]/span[2]/span[2]")).getText();
		assertEquals("The product price on overlay is not the same as in result page, should be $"+productPrice+"", productPrice, overlayProdPrice);
		
		//end of QA test
		
		return this;
	}
	
	
	
}
