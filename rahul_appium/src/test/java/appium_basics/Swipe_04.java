package appium_basics;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe_04 extends BaseTest {
	//public static AppiumDriver driver;

	@Test
	public void swipe() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("	\r\n"
				+ "//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		WebElement firstImage=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		
		//swipe code
		
		/*((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement)firstImage).getId(),
				"direction","left",
				"percent",0.75
				));*/
		
		//OR
		
		swipeAction(firstImage,"left");
		
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Gallery)[1]")).getAttribute("focusable"),"false");
		
		
		
	}

}
