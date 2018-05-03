package org.puma.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.puma.generics.BasePage;
import org.testng.Assert;

public class ProductDescPage extends BasePage{
	@FindBy(xpath="//div[@class='product-size-click-btn']")
	private WebElement selectSizeMenu;
	@FindBy(xpath="//a[@name='7']/span[contains(.,'7')]")
	private WebElement selectSize;
	@FindBy(xpath="//button[@title='Add to Cart']")
	private WebElement addToCartbtn;
	@FindBy(xpath="//div[@class='product-name']/span")
	private  WebElement productName;
	@FindBy(xpath="//table[@id='shopping-cart-table']//a[contains(text(),'IGNITE evoKNIT Lo 2 Men')]")
	private WebElement prodNameOnCart;
	
	String ActualProdName=null;
	
	public ProductDescPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnAddToCartbtn() 
	{
        selectSizeMenu.click();
	    selectSize.click();
	    ActualProdName=productName.getText();
		try {
			Thread.sleep(3000);
		    }
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		verifyElement(driver,addToCartbtn);
		addToCartbtn.click();
	}
	
	public void verifytheProduct()
	{
		verifyElement(driver,prodNameOnCart);
		String expectedProdName=prodNameOnCart.getText();
		Assert.assertEquals(ActualProdName.toLowerCase(),expectedProdName.toLowerCase());
	}

}
