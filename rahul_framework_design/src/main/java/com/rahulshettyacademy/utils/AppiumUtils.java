package com.rahulshettyacademy.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AppiumUtils {
	
	AppiumDriver driver;  //it is the superior of androidDriver and IOSDriver
	public AppiumDriverLocalService service;
	
	public AppiumUtils(AppiumDriver driver)
	{
		this.driver=driver;
	}
	
	
	//for formatted amount
	public static  Double getFormattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
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
	
	/*public AppiumDriverLocalService StartAppiumServer()
	{
		service=new AppiumDriverLocalService(null, null, 0, null, null, null).withAppiumJS(new File("//"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		return service;
	}*/
	
	

	
	public void waitForElementToAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(ele,"text","Cart"));
	}
}
