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
import io.appium.java_client.android.Activity;

public class DragAndDrop_05 extends BaseTest {
	//public static AppiumDriver driver;

	@Test
	public void swipe() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		//App package and App activity(if we use this , it will navigate directly to this page)
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.view.DragAndDropDemo");
		//driver.startActivity(activity); --deprecated
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.view.DragAndDropDemo"
				));
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		//drag and drop
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement)source).getId(),
				"endX",619,
				"endY",560
				));
		
		Thread.sleep(2000);
		String droppedText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(droppedText, "Dropped!");
		
		
		
	}

}
