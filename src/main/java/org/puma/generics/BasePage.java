package org.puma.generics;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
	
	public WebDriver driver;
	
	public void verifyTitle(WebDriver driver,String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		try
		{
		wait.until(ExpectedConditions.titleIs(eTitle));
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching:Actual title is "+driver.getTitle());
		}
	}
	
	public void verifyElement(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		catch (Exception e) {
			Reporter.log("Element is not visible", true);
		}
	}

}
