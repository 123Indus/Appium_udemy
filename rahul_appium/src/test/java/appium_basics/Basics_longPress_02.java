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

public class Basics_longPress_02 extends BaseTest {
	//public static AppiumDriver driver;

	@Test
	public void longPress() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();


		/*driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]")).click();
		RemoteWebElement longPress = (RemoteWebElement) driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));

		driver.executeScript("gesture: longPress", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 800));*/

		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));

		/*((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));*/
		//OR
		longPress(ele);  //calling from baseTest

		Thread.sleep(2000);

		String menuText=driver.findElement(By.id("android:id/title")).getText();

		Assert.assertEquals(menuText,"Sample menu");

		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

		driver.findElement(By.id("android:id/title")).click();

		Thread.sleep(2000);

	}

}
