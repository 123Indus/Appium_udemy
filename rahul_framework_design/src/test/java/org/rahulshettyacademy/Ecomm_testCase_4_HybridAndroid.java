package org.rahulshettyacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.rahulshettyacademy.pageObjects.android.CartPage;
import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.rahulshettyacademy.pageObjects.android.ProductCatalog;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecomm_testCase_4_HybridAndroid extends AndroidBaseTest {
	
	/*@BeforeMethod
	public void preSetup()
	{
		FormPage formpage=new FormPage(driver); 
		formpage.setActivity();
	}*/
	  
	
	
	//For multiple dataset
	@Test(dataProvider="getData" , groups = {"smoke"})
	public void fillForm(HashMap<String,String> input) throws InterruptedException  //for multiple dataset
	//public void fillForm(String name,String gender,String country) throws InterruptedException  //for single dataset
	{
		FormPage formpage=new FormPage(driver);  //object creation
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("subir sarkar");
		//driver.hideKeyboard();  //to close the keyboard
		
		//formpage.setNameField("subir sarkar");
		
		//by using dataprovider
		//formpage.setNameField(name);
		formpage.setNameField(input.get("name"));
		
		
		//driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		//formpage.setGender("female");
		
		//by using dataprovider
		//formpage.setGender(gender);
		formpage.setGender(input.get("gender"));
		
		/*driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();*/
		//formpage.setCountrySelection("Argentina");
		
		//by using dataprovider
		//formpage.setCountrySelection(country);
		formpage.setCountrySelection(input.get("country"));
		
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//formpage.submitForm();
		//or
		//this is another way(Note: few changes in FormPage also)
		ProductCatalog prdctlog=formpage.submitForm();
		
		Thread.sleep(2000);
		
		//ProductCatalog prdctlog=new ProductCatalog(driver);  //this steps not required because of above step.
		
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();   //1st element, because it become added to cart
		prdctlog.addItemToCartByIndex(0);
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();   //2nd element
		prdctlog.addItemToCartByIndex(0);
		//driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]\r\n"
				//+ "")).click();
		prdctlog.goToCartPage();
		
		Thread.sleep(2000);
		CartPage cart=new CartPage(driver);
		/*WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]\r\n"
				+ ""));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(cart,"text","Cart"));*/
		
        cart.getCartButton();
        
		/*List<WebElement> productPrices = driver.findElements(By.id("	\r\n"
				+ "com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double totalsum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=productPrices.get(i).getText();
			Double price=Double.parseDouble(amountString.substring(1));
			totalsum=totalsum+price;
		}*/
        double totalSum=cart.getProductSum();
		//AndroidActions anact=new AndroidActions(driver);
		Thread.sleep(1000);
		/*String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		Double displayFormattedsum=AndroidActions.getFormattedAmount(displaySum);*/  //calling androidactions
		double displaySum=cart.getTotalAmountDisplayed();
		
		//Assert.assertEquals(totalsum, displayFormattedsum);
		/*WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		
		AndroidActions.longPress(ele);
		
		driver.findElement(By.id("android:id/button1")).click();*/
		
		cart.acceptTermsConditions();
		
		/*driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();*/
		cart.SubmitOrder();
		
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
	
	@DataProvider(name="getData")
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"/src/test/java/org/rahulshettyacademy/testData/eCommerce.json");
		//for single dataset
		//return new Object[][] {{"subir sarkar","female","Argentina"},{"subir kumar","male","Argentina"}};
		
		//for multiple dataset
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}


}
