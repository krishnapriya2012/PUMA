package org.puma.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.puma.generics.BasePage;

public class HomePage extends BasePage{
	@FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]")
	private WebElement SecondProduct;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void navigationtoMenu(String menu,String category,String options )
	{ 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText(menu.toUpperCase()))).perform();
		String dynamicXp="//a[text()='"+category+"' and contains(@href,'"+menu+"')]/../../following-sibling::li/a[text()='"+options+"']";
		WebElement option=driver.findElement(By.xpath(dynamicXp));
		verifyElement(driver,option);
		option.click();
	}
   
	public void verifytheTitle(WebDriver driver)
	{
		verifyTitle( driver,"Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com");
	}
	public void ScrolltoElementandClick()
	{  
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",SecondProduct);
		verifyElement(driver,SecondProduct);
		SecondProduct.click();
		ArrayList<String> lstWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(lstWindows.get(1));
		
	}	
}
