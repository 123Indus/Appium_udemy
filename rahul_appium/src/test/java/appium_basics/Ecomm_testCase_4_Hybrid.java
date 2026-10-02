package appium_basics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecomm_testCase_4_Hybrid extends BaseTest{
	  
	@Test
	public void fillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("subir sarkar");
		driver.hideKeyboard();  //to close the keyboard
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();   //1st element, because it become added to cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();   //2nd element
		driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]\r\n"
				+ "")).click();
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]\r\n"
				+ ""));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(cart,"text","Cart"));
		List<WebElement> productPrices = driver.findElements(By.id("	\r\n"
				+ "com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double totalsum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=productPrices.get(i).getText();
			Double price=Double.parseDouble(amountString.substring(1));
			totalsum=totalsum+price;
		}
		
		Thread.sleep(1000);
		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedsum=getFormattedAmount(displaySum);
		//Assert.assertEquals(totalsum, displayFormattedsum);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPress(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		//context change
		Set<String> contexts=driver.getContextHandles();
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("subir sarkar");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.context("NATIVE_APP");
		
	}

}
