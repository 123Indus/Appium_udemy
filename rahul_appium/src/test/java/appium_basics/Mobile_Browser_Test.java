package appium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

public class Mobile_Browser_Test extends Mobile_Browser_BaseTest {
	
	
	
	@Test
	public void browserTest() throws InterruptedException
	{
		
		/*driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("subir sarkar");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);*/
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		String text=driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Assert.assertEquals(text,"Devops");
		Thread.sleep(2000);
		
	}

}
