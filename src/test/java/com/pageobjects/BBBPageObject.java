package com.pageobjects;

import org.openqa.selenium.WebDriver;

import com.uistore.BBBUI;

public class BBBPageObject {

	public static void BBB(WebDriver driver) {
		driver.findElement(BBBUI.BBB).click();
		
	}
}
