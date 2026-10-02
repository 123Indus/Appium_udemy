package appium_basics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;

public class Ecomm_testCase_01 extends BaseTest{
	  
	@Test
	public void fillForm() throws InterruptedException
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
		Assert.assertEquals(toastmessage,"Please enter your name");
	}

}
