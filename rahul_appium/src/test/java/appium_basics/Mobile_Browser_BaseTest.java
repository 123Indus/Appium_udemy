package appium_basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Mobile_Browser_BaseTest {
	public static AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{

		DesiredCapabilities ds=new DesiredCapabilities();
		ds.setCapability("appium:browserName","chrome");
		ds.setCapability("appium:chromedriverExecutable","C:/Users/Subir Sarkar/OneDrive/Desktop/chromeDriver_143/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		URL url=URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver=new AndroidDriver(url,ds);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Application started");
	}


	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
