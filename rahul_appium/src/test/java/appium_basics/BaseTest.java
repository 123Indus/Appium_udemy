package appium_basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

public class BaseTest {
	public static AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		//2nd approach
		//from selenium 4, need to use appium:deviceName
		DesiredCapabilities ds=new DesiredCapabilities();
		//ds.setCapability("appium:deviceName","Motorola Edge_30");
		//ds.setCapability("appium:chromedriverAutodownload", true);
		ds.setCapability("appium:deviceName","Redmi Note 7 Pro");
		//ds.setCapability("appium:udid","ZD22276NQH");
		ds.setCapability("appium:udid","218b444e");
		ds.setCapability("platformName","Android");
		ds.setCapability("appium:automationName","uiautomator2");
		//ds.setCapability("appium:app","D:\\Appium_RahulShetty\\rahul_appium\\src\\test\\java\\utils\\ApiDemos-debug.apk");
		ds.setCapability("appium:app","D:\\Appium_RahulShetty\\rahul_appium\\src\\test\\java\\utils\\General-Store.apk");
		ds.setCapability("appium:platformVersion","14");
		ds.setCapability("appium:chromedriverExecutable","C:/Users/Subir Sarkar/OneDrive/Desktop/chromeDriver_143/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		
		//for ecommetce test case 4 hybrid
		/*UiAutomator2Options options=new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\Subir Sarkar\\OneDrive\\Desktop\\chromeDriver_143\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");*/

		//driver =new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),ds);
		URL url=URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver=new AndroidDriver(url,ds);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Application started");
	}

	//code for longpress
	public static void longPress(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}

	//code for scrolling
	public static void scrolltoEndAction()
	{
		//particular element
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
//OR
		//scroll depend on height and width
		boolean canscrollMore;
		do {
			canscrollMore=(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left",100,"top",100,"width",200,"height",200,
					"direction","down",
					"percent",3.0));
		}
		while(canscrollMore);

	}
	
	//For swipe
	
	public static void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement)ele).getId(),
				"direction",direction,
				"percent",0.75
				));
	}
	
	//for formatted amount
	public static Double getFormattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}

	/*@AfterClass
	public void teardown()
	{
		driver.quit();
	}*/

}
