package avc.test.williamssonoma.productpage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import avc.test.williamssonoma.pageobject.AbstractPage;
import avc.test.williamssonoma.shoppingcartpage.ShoppingCartPage;

public class ProductPage extends AbstractPage{

	@FindBy(xpath = "//fieldset[1]/button/span[contains(text(),'Add to Cart')]")
	private WebElement addToCartButton;
	@FindBy(id = "anchor-btn-checkout")
	private WebElement checkoutButton;
	@FindBy(id = "racOverlay")
	private WebElement addToCartOverlay;
	
	
	public ProductPage(WebDriver driver){
		super(driver);
	}
	
	public ProductPage addProductToCart(){
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		
		//assert if Product page shows "Add to cart button"
		String addButton = driver.findElement(By.xpath("//fieldset[1]/button/span[contains(text(),'Add to Cart')]")).getText();
		assertEquals("Should have a add to cart button.","Add to Cart", addButton);
				
		addToCartButton.click();
		
		return this;
	}
	
	public ShoppingCartPage startCheckout() throws Exception{
		
		//assert if When click on "Add to cart button", add to cart overlay appears
		try{
			wait.until(ExpectedConditions.visibilityOf(addToCartOverlay));	
		}catch(Exception e){
			throw new Exception("add to cart overlay should appear", e);
		}
					
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		
		//assert if Checkout button is on the add to cart overlay
		String overlayCheckoutButton = driver.findElement(By.id("anchor-btn-checkout")).getText();
		assertEquals("Should have a Checkout button on overlay.","Checkout", overlayCheckoutButton);
		
		checkoutButton.click();
		
		return PageFactory.initElements(driver, ShoppingCartPage.class);
	}
	
}
