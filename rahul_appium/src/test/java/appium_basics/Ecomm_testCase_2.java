package appium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;

public class Ecomm_testCase_2 extends BaseTest{
	  
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
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		System.out.println(productCount);
		Thread.sleep(2000);
		for(int i=0;i<productCount;i++)
		{
			System.out.println("yes");
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				System.out.println("no");
				//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]\r\n"
						+ "")).click();
				break;
			}
		}
		driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]\r\n"
				+ "")).click();
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]\r\n"
				+ ""));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(cart,"text","Cart"));
		String lastPageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct,"Jordan Lift Off");
		
	}

}
