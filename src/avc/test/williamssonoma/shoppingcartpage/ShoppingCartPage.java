package avc.test.williamssonoma.shoppingcartpage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import avc.test.williamssonoma.pageobject.AbstractPage;
import avc.test.williamssonoma.searchresultpage.SearchResultPage;

public class ShoppingCartPage extends AbstractPage {

	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	private WebElement shoopingCartPageTitle;
	@FindBy(id = "title-lineid-1")
	private WebElement productName;
	@FindBy(id = "search-field")
	private WebElement searchInput;
	@FindBy(id = "btnSearch")
	private WebElement goSearch;
	
	public ShoppingCartPage(WebDriver driver){
		super(driver);
	}
	
	
	public ShoppingCartPage checkShoppingCartPageLoad(){
		
		wait.until(ExpectedConditions.visibilityOf(shoopingCartPageTitle));
		
		//assert if When click on "Checkout" button then shopping cart page is shown
		String pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
		assertEquals("Shopping Cart page should have appear.","Shopping Cart", pageTitle);
		
		return this;
	}
	
	public ShoppingCartPage checkProductOnShoppingCartPage(String product){
		
		wait.until(ExpectedConditions.visibilityOf(productName));
		
		//assert if The product added to cart is on shopping cart page
		String nameProduct = driver.findElement(By.id("title-lineid-1")).getText();
		assertEquals("Should apper the product i've chosen.", ""+product+"", nameProduct);
		
		return this;
	}
	
	public ShoppingCartPage fillSearchInput(String search){
		
		searchInput.sendKeys(search);
		
		return this;
	}
	
	public SearchResultPage searchIten(){
		
		goSearch.click();
		
		//jse.executeScript("arguments[0].click();", driver.findElement(By.id("btnSearch")));
		
		return PageFactory.initElements(driver, SearchResultPage.class);
	}
	
	
	
	
	
	
}
