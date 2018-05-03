package org.puma.tests;

import org.puma.generics.BaseTest;
import org.puma.pages.HomePage;
import org.puma.pages.ProductDescPage;
import org.testng.annotations.Test;

public class VerifyShoeTest extends BaseTest {
	
	@Test
	public void testShoeOnCart() 
	{
		//navigating to url:https://in.puma.com from BaseTest class
		
		HomePage hp=new HomePage(driver);
		ProductDescPage pdp=new ProductDescPage(driver);
		//Assert the page Title
		hp.verifytheTitle(driver);
		//click on Men/shoes/Running
		hp.navigationtoMenu("men", "Shoes", "Running");
		//click on second product from product detail page
		hp.ScrolltoElementandClick();
		//Add the shoe to cart from product detail page (for any size or quantity)
		pdp.clickOnAddToCartbtn();
		//Assert that the cart has the correct shoe selected in previous step (Based on name of product/quantity/price)
		pdp.verifytheProduct();
	}

}
