package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uistore.BounceUI;

public class BouncePageObject {

	public static void bounce(WebDriver driver) {
		driver.findElement(BounceUI.bounce).click();
		driver.findElement(BounceUI.search).click();
		driver.findElement(BounceUI.searchbox).sendKeys("spray");
		
		
	}
	public static void Product(WebDriver driver) {
		driver.findElement(BounceUI.producttext).click();
		
	}
}
