package org.puma.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements Constants {

	public WebDriver driver;
	
	@BeforeMethod
	public void preCondition()
	{
		System.setProperty(chrome_key,chrome_value);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterMethod
	public void postCondition()
	{
		
		driver.quit();
	}
}
