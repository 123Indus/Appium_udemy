package appium_basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class Basics_01 extends BaseTest {
	//public static AppiumDriver driver;
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException
	{
		/*********************BaseTest*********************/
		//Appiumcode -> AppiumServer -> Mobile
		
		//for start appium server programmatically.
		/*AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Subir Sarkar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();*/
		
		//1st approach
		/*UiAutomator2Options options=new UiAutomator2Options();
		options.setCapability("appium:deviceName","Motorola Edge_30");
		options.setCapability("appium:setApp","D://Appium_RahulShetty//rahul_appium//src//test//java//utils//ApiDemos-debug.apk");
		options.setCapability("appium:udid","ZD22276NQH");
		options.setCapability("platformName","Android");
		options.setCapability("appium:automationName","uiautomator2");
		options.setCapability("appium:platformVersion","14");
		driver =new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);*/
		//>java 20
		//driver =new AppiumDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(),options);
		//driver.quit();
		//service.stop();
		
		//2nd approach
		//from selenium 4, need to use appium:deviceName
		/*DesiredCapabilities ds=new DesiredCapabilities();
		ds.setCapability("appium:deviceName","Motorola Edge_30");
		ds.setCapability("appium:udid","ZD22276NQH");
		ds.setCapability("platformName","Android");
		ds.setCapability("appium:automationName","uiautomator2");
		ds.setCapability("appium:app","D:\\Appium_RahulShetty\\rahul_appium\\src\\test\\java\\utils\\ApiDemos-debug.apk");
		ds.setCapability("appium:platformVersion","14");
		
		//driver =new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),ds);
		URL url=URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		AndroidDriver driver=new AndroidDriver(url,ds);
		System.out.println("Application started");*/
		//driver.quit();
		
		/*************************End*************************/
		
		
		
		//Locators
		//xpath,id,accessbilityId,classname,androidUIAutomator
		
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		//or
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("	\r\n"
				+ "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.xpath("	\r\n"
				+ "//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\r\n"
				+ "")).click();
		
		String actualtext=driver.findElement(By.id("android:id/alertTitle")).getText();
		
		String expectedtext="WiFi settings";
		
		Assert.assertEquals(expectedtext, actualtext);
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("subir_wifi");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		
	}

}
