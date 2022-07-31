package com.pageobjects;

import org.openqa.selenium.WebDriver;

import com.uistore.WhatsnewUI;

public class WhatsnewPageObject {

	public static void Whatsnew(WebDriver driver) {
		driver.findElement(WhatsnewUI.Whatsnew).click();
		driver.findElement(WhatsnewUI.newproduct).click();
		
	}
}
