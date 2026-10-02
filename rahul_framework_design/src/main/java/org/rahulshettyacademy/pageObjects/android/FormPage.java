package org.rahulshettyacademy.pageObjects.android;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;

public class FormPage  extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("subir sarkar");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private WebElement maleOption;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
				));
	}
	
	/*driver.findElement(By.id("android:id/text1")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();*/
	public void setCountrySelection(String countryName)
	{
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	/*public void submitForm()
	{
		shopButton.click();
	}*/
	
	//by this way we don't need to create seperate object of productCatalog page in test class
	public ProductCatalog submitForm()
	{
		shopButton.click();
		return new ProductCatalog(driver);
	}
	
	
	
	
	
	

}
