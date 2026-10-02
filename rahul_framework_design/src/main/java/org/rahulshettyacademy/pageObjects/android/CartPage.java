package org.rahulshettyacademy.pageObjects.android;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;

	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]\r\n"
	//+ "")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
	private WebElement cartButton;
	
	//By.id("	\r\n"
	//+ "com.androidsample.generalstore:id/productPrice")
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	//By.id("com.androidsample.generalstore:id/totalAmountLbl"
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	
	public void getCartButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(cartButton,"text","Cart"));
	}
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductSum()
	{
		int count=productList.size();
		double totalSum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=productList.get(i).getText();
			Double price=getFormattedAmount(amountString);
			totalSum=totalSum+price;
		}
		return totalSum;
	}
	
	public double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions()
	{
		longPress(terms);
		acceptButton.click();
	}
	
	public static Double getFormattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void SubmitOrder()
	{
		checkBox.click();
		proceed.click();
	}
	
	
	
	
	
	
	
	
	

}
