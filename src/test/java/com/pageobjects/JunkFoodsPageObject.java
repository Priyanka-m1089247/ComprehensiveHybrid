package com.pageobjects;

import org.openqa.selenium.WebDriver;

import com.uistore.JunkFoodsUI;

public class JunkFoodsPageObject {

	public static void Junkfood(WebDriver driver) {
		driver.findElement(JunkFoodsUI.junkfood).click();
		//driver.findElement(JunkFoodsUI.bag).click();
		//driver.findElement(JunkFoodsUI.viewbag).click();
	}
}
