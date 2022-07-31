package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uistore.RegistrationUI;
import com.uistore.SearchUI;

public class SearchPageObject {

	public static void Search(WebDriver driver) {
		driver.findElement(SearchUI.Searchbox).click();
		driver.findElement(SearchUI.Searchbox).sendKeys("hygienic");
		driver.findElement(SearchUI.Searchbox).sendKeys(Keys.ENTER);
		driver.findElement(SearchUI.Popup).click();
		try {
			driver.findElement(SearchUI.hygenic).click();
	    } catch (org.openqa.selenium.StaleElementReferenceException e) {
	        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(RegistrationUI.SignUp)));
	        driver.findElement(SearchUI.hygenic).click();
	    }
		
	}
	public static void Findreatailers(WebDriver driver) {
		driver.findElement(SearchUI.Findretailers).click();
	}
	public static void Buy(WebDriver driver) {
		  driver.findElement(SearchUI.Buy).click();
		
	}
	public static void Addcart(WebDriver driver) {
		driver.findElement(SearchUI.Addcart).click();
	}
}
