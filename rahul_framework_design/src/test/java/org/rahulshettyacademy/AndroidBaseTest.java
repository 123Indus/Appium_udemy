package org.rahulshettyacademy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AndroidBaseTest {
	public static AndroidDriver driver;

	@BeforeClass(alwaysRun = true)
	public void configureAppium() throws IOException {
//this is the code for properties file coming from data.properties file
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream("D:\\Appium_RahulShetty\\rahul_framework_design\\src\\main\\java\\com\\rahulshettyacademy\\properties\\data.properties");
		prop.load(fileInputStream);

		//if you want to pass value during maven run from command prompt
		//example
		/*String ipAddress=System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		String port=System.getProperty("port")!=null ? System.getProperty("port") : prop.getProperty("port");
		System.out.println("ipAddress: "+ipAddress);
		System.out.println("port: "+port);*/

		//2nd approach
		//from selenium 4, need to use appium:deviceName
		DesiredCapabilities ds=new DesiredCapabilities();
		//ds.setCapability("appium:deviceName","Motorola Edge_30");
		//ds.setCapability("appium:chromedriverAutodownload", true);
		ds.setCapability("appium:deviceName",prop.getProperty("AndroiDeviceName"));
		//ds.setCapability("appium:udid","ZD22276NQH");
		ds.setCapability("appium:udid","218b444e");
		ds.setCapability("platformName","Android");
		ds.setCapability("appium:automationName","uiautomator2");
		//ds.setCapability("appium:app","D:\\Appium_RahulShetty\\rahul_appium\\src\\test\\java\\utils\\ApiDemos-debug.apk");
		ds.setCapability("appium:app","D:\\Appium_RahulShetty\\rahul_framework_design\\src\\test\\java\\org\\rahulshettyacademy\\utils\\General-Store.apk");
		ds.setCapability("appium:platformVersion","14");
		//ds.setCapability("appium:chromedriverExecutable","C:/Users/Subir Sarkar/OneDrive/Desktop/chromeDriver_143/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		ds.setCapability("appium:chromedriverAutodownload", true);
		
		//for ecommetce test case 4 hybrid
		/*UiAutomator2Options options=new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\Subir Sarkar\\OneDrive\\Desktop\\chromeDriver_143\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");*/

		//driver =new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),ds);
		URL url=URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver=new AndroidDriver(url,ds);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Application started");
	}

	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException
	{
		//convert json file content to json string
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}


	
	@AfterClass(alwaysRun = true)
	public void teardown()
	{

		driver.quit();

	}

}
