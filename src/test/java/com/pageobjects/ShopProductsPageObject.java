package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uistore.ShopProductsUI;

public class ShopProductsPageObject {
	 
	public static void Shopfunctionality(WebDriver driver) {
		Actions a=new Actions(driver);
		WebElement ele=driver.findElement(ShopProductsUI.shopproducts);
		a.moveToElement(ele).perform();
		driver.findElement(ShopProductsUI.powder).click();
		
	}
	
	
	public static void Shopnavigation(WebDriver driver) {
		driver.findElement(ShopProductsUI.shopproducts).click();
		
	}
	
}
