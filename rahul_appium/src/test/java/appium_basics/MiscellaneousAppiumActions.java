package appium_basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class MiscellaneousAppiumActions extends BaseTest {
	//public static AppiumDriver driver;
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException
	{
		//Locators
		//xpath,id,accessbilityId,classname,androidUIAutomator
		
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		//or
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("	\r\n"
				+ "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.xpath("	\r\n"
				+ "//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
		
		//to rotate to landscape mode
		DeviceRotation landScape=new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\r\n"
				+ "")).click();
		
		String actualtext=driver.findElement(By.id("android:id/alertTitle")).getText();
		
		String expectedtext="WiFi settings";
		
		Assert.assertEquals(expectedtext, actualtext);
		
		//copy to clipboard -> paste it clipboard
		driver.setClipboardText("subir_wifi");
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("amdroid.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("subir_wifi");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
	}

}
