package org.rahulshettyacademy.pageObjects.android;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//GrandParent(AppiumUtils) -> AndroidActions -> ProductCatalog 
//currently i am not using AppiumUtils.
public class ProductCatalog extends AndroidActions {

	AndroidDriver driver;

	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); 
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;

	//driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]\r\n"
	//+ "")).click();

	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")
	private WebElement cart;


	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}

	public void goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		
	}
	
	//or
	/*public void goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		new CartPage(driver);
		
	}*/





}
