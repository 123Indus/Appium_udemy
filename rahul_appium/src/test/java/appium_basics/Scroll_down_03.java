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

public class Scroll_down_03 extends BaseTest {
	//public static AppiumDriver driver;

	@Test
	public void longPress() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//By using androidUIAutomator
		//used when u exactly know where to scroll
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		//scroll depend on height and width
		/*boolean canscrollMore;
		do {
		canscrollMore=(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left",100,"top",100,"width",200,"height",200,
				"direction","down",
				"percent",3.0));
		}
		while(canscrollMore);*/
		
		scrolltoEndAction(); //method calling from BaseTest
		
		Thread.sleep(2000);
		
	}

}
