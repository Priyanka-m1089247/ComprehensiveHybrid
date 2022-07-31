package com.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uistore.RegistrationUI;
import com.utilities.ExcelData;

public class RegistrationPageObject {
	public static ExcelData Excel=new ExcelData();
	public static void SignUp(WebDriver driver) {
		driver.findElement(RegistrationUI.Registration).click();
	
		 try {
		         driver.findElement(RegistrationUI.SignUp).click();
		    } catch (org.openqa.selenium.StaleElementReferenceException e) {
		        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(RegistrationUI.SignUp)));
		        driver.findElement(RegistrationUI.SignUp).click();
		    }
		
	}
	public static void ValidSignUpInput(WebDriver driver) {
		String Firstname=Excel.getStingData("sheet1", 1, 0);
		String Email=Excel.getStingData("sheet1", 1, 1);
		String password=Excel.getStingData("sheet1", 1, 2);
		driver.findElement(RegistrationUI.Firstname).sendKeys(Firstname);
		driver.findElement(RegistrationUI.Email).sendKeys(Email);
		driver.findElement(RegistrationUI.Password).sendKeys(password);
	}
	public static void InValidSignUpInput(WebDriver driver) {
		String Firstname=Excel.getStingData("sheet1", 2, 0);
		String Email=Excel.getStingData("sheet1", 2, 1);
		String password=Excel.getStingData("sheet1", 2, 2);
		driver.findElement(RegistrationUI.Firstname).sendKeys(Firstname);
		driver.findElement(RegistrationUI.Email).sendKeys(Email);
		driver.findElement(RegistrationUI.Password).sendKeys(password);
	}
	public static void CreateAccount(WebDriver driver) {
		
	
			driver.findElement(RegistrationUI.CreateAccount).click();

		
		
	}
	public static boolean InvalidCreateAccount(WebDriver driver) {
		
		return driver.findElement(RegistrationUI.CreateAccount).isDisplayed();
		
		
	}
	public static void Login(WebDriver driver) {
		
			driver.findElement(RegistrationUI.Login).click();
		
		
		}
		
	public static void ValidLoginInput(WebDriver driver) {
		String Email=Excel.getStingData("sheet1", 3, 1);
		String password=Excel.getStingData("sheet1", 3, 2);
		driver.findElement(RegistrationUI.LoginEmail).sendKeys(Email);
		driver.findElement(RegistrationUI.LoginPassword).sendKeys(password);
	}
	public static void InValidLoginInput(WebDriver driver) {
		String Email=Excel.getStingData("sheet1", 4, 1);
		String password=Excel.getStingData("sheet1", 4, 2);
		driver.findElement(RegistrationUI.LoginEmail).sendKeys(Email);
		driver.findElement(RegistrationUI.LoginPassword).sendKeys(password);
	}
	public static void EndLogin(WebDriver driver) {
		
		driver.findElement(RegistrationUI.EndLogin).click();
		
	}
	public static boolean InvalidEndLogin(WebDriver driver) {
		return driver.findElement(RegistrationUI.EndLogin).isDisplayed();
		
		
	}

}
