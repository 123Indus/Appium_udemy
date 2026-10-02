package org.rahulshettyacademy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;

public class Ecomm_testCase_01Android extends AndroidBaseTest {
	
	
	/*@BeforeMethod
	public void preSetup()
	{
		//screen to home page
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
				));

		driver.launchApp();
	}*/

	@Test
	public void fillForm_ErrorValidation() throws InterruptedException
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("subir sarkar");
		driver.hideKeyboard();  //to close the keyboard
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		String toastmessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastmessage);
		//Assert.assertEquals(toastmessage,"Please enter your name");
		Assert.assertEquals(toastmessage,"Please your name");
	}

	@Test
	public void fillForm_positiveFlow() throws InterruptedException
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("subir sarkar");
		driver.hideKeyboard();  //to close the keyboard
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		/*String toastmessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastmessage);
		Assert.assertEquals(toastmessage,"Please enter your name");*/
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
	}

}
