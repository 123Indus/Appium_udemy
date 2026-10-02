package com.rahulshettyacademy.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;

public class AndroidActions{

	static AndroidDriver driver;

	public AndroidActions(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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

	//code for scrolling to text
	public static void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
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
	//copied to AppiumUtils class
	public static  Double getFormattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}

	//for screenshot
	public static String getScreenshotPath(String testCaseName,AndroidDriver driver)
	{
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		try {
			FileUtils.copyFile(source, new File(destinationFile));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return destinationFile;
	}




}
