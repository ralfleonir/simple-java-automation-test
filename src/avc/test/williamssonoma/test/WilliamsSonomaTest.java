package avc.test.williamssonoma.test;

import org.testng.annotations.Test;

import avc.test.williamssonoma.mainpage.WSMainPage;
import avc.test.williamssonoma.pageobject.BaseTest;

public class WilliamsSonomaTest extends BaseTest {
	
	
	@Test
	public void shouldPutProductInCart() throws Exception{
		
		WSMainPage chooseAproduct = new WSMainPage(driver);
		
		String 
		product = "All-Clad d5 Stainless-Steel 10-Piece Cookware Set",
		search = "fry pan",
		resPageTitle = "Search Results for:",
		productName = "Calphalon Elite Nonstick Fry Pan Set",
		productPrice = "89.95";
		
		chooseAproduct
		
		//Add a product to cart
		.accessWSMainPage()
		.hoverMenuCategory()
		.clickSubcategory()
		.chooseAproduct(product)
		.addProductToCart()
		.startCheckout()
		.checkShoppingCartPageLoad()
		.checkProductOnShoppingCartPage(product)
		
		//See a Product on Quick Look Overlay
		.fillSearchInput(search)
		.searchIten()
		.hoverProductImage(resPageTitle, productName, productPrice)
		.clickQuickLookButton()
		.productOverlay(productName, productPrice);
		
		
		
	}
	
}
