package com.runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.pageobjects.BBBPageObject;
import com.pageobjects.BouncePageObject;

import com.pageobjects.PandGPageObject;
import com.pageobjects.RegistrationPageObject;
import com.pageobjects.SearchPageObject;
import com.pageobjects.ShopProductsPageObject;
import com.pageobjects.WhatsnewPageObject;
import com.utilities.PropertyClass;
import com.utilities.Screenshot;
import com.utilities.Windowhandle;
import com.utilities.baseClass;



public class Runner extends baseClass{
	PropertyClass property;
	public baseClass baseObj=new baseClass();
	public Screenshot ScreObj=new Screenshot();
	
	Logger log=LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void Extent() {
		baseObj.ExtentReport();
	}
	
	@BeforeMethod
public void navigateToLandingPage() throws IOException {
		property=new PropertyClass();
		driver=InitializeDriver();
		log.info("initialized driver");
		driver.get(property.geturl());
		log.info("HomePage is opened");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@Test
	public void ValidSignup() throws IOException {
		extentTest=extent.createTest("Signup");
		
		RegistrationPageObject.SignUp(driver);
		log.info("Clicked on sign now");
		Windowhandle.Window(driver);
		log.info("Window is switched to child");
		RegistrationPageObject.ValidSignUpInput(driver);
		log.info("Entered the ValidSignUpInput");
		RegistrationPageObject.CreateAccount(driver);
		log.info("Clicked on Create an Account button");
	}
	@Test
	public void InValidSignup() throws IOException {
		extentTest=extent.createTest("InvalidSignup");
		RegistrationPageObject.SignUp(driver);
		log.info("Clicked on sign now");
		Windowhandle.Window(driver);
		log.info("Window is switched to child");
		RegistrationPageObject.InValidSignUpInput(driver);
		log.info("Entered the InValidSignUpInput");
		Assert.assertTrue(RegistrationPageObject.InvalidCreateAccount(driver));
		log.info("Checked the assert condition for Invalid signup");
		
		
	}
	@Test
	public void ValidLogin() throws IOException {
		extentTest=extent.createTest("ValidLogin");
		RegistrationPageObject.SignUp(driver);
		log.info("Clicked on sign now");
		Windowhandle.Window(driver);
		log.info("Window is switched to child");
		RegistrationPageObject.Login(driver);
		log.info("Clicked on Login");
		RegistrationPageObject.ValidLoginInput(driver);
		log.info("Entered the ValidLoginInput");
		RegistrationPageObject.EndLogin(driver);
		log.info("Clicked on EndLogin button");
		
	}
	@Test
	public void InValidLogin() throws IOException {
		
		extentTest=extent.createTest("InValidLogin");
		
		RegistrationPageObject.SignUp(driver);
		Windowhandle.Window(driver);
		RegistrationPageObject.Login(driver);
		RegistrationPageObject.InValidLoginInput(driver);
		log.info("Entered the InValidLoginInput");
		Assert.assertTrue(RegistrationPageObject.InvalidEndLogin(driver));
		log.info("Checked the assert condition for Invalid Login");
		
	}
	@Test
	public void Search() throws IOException {		
		extentTest=extent.createTest("Search");
		SearchPageObject.Search(driver);
		log.info("Clicked and Searched the product");
		boolean searchresult=driver.getPageSource().contains("Innovative liquid detergent technology gets between the fibers to clean invisible stains.");
		Assert.assertTrue(searchresult);
		log.info("verified the text in Search Result");
	}
	@Test
	public void ShopProductsFunctionality() {
		extentTest=extent.createTest("ShopProductsFunctionality");
		ShopProductsPageObject.Shopfunctionality(driver);
		log.info("Mouse hoverd on ShopProducts and clicked the powder");
		boolean powderText=driver.getPageSource().contains("Related articles");
		Assert.assertTrue(powderText);
		log.info("Text is validated in powder page");
		driver.navigate().back();
		log.info("navigated back");
		ShopProductsPageObject.Shopnavigation(driver);
		log.info("clicked ShopProducts");
		boolean ShopText=driver.getPageSource().contains("Tide Products");
		Assert.assertTrue(ShopText);
		log.info("Text is validated in ShopProducts page");
	}
	@Test
	public void WhatsnewFunctionality() {
		extentTest=extent.createTest("WhatsnewFunctionality");
		
		WhatsnewPageObject.Whatsnew(driver);
		log.info("Clicked on Whatsnew");
		boolean Text=driver.getPageSource().contains("Tide Hygienic Clean Heavy Duty 10X Free Power PODS®");
		Assert.assertTrue(Text);
		log.info("Text is validated in Whatsnew page");
	}
	
	@Test
	public void PandG(){
		extentTest=extent.createTest("PandG");
		PandGPageObject.Fragrance(driver);
		log.info("Clicked on P&G and clicked on fragrance");
		boolean fragranceText=driver.getPageSource().contains("More about the fragrance ingredients we use");
		Assert.assertTrue(fragranceText);
		log.info("Text is validated in PandG page");
	}
	@Test
	public void Bounce(){
		extentTest=extent.createTest("Bounce");
		BouncePageObject.bounce(driver);
		log.info("Clicked on Bounce");
		BouncePageObject.Product(driver);
		log.info("Clicked on Product");
		boolean productText=driver.getPageSource().contains("Bounce® Rapid Touch Up 3-in-1 Clothing Spray");
		Assert.assertTrue(productText);
		log.info("Text is validated in Bounce page");
		
	}
	@Test
	public void BBB(){
		extentTest=extent.createTest("BBB Page");
		BBBPageObject.BBB(driver);
		log.info("Clicked on BBB");
		boolean pageText=driver.getPageSource().contains("BBB");
		Assert.assertTrue(pageText);
		log.info("Text is validated in BBB page");
	}
	
	@AfterMethod
	public void Teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "The Test case Failed is"+result.getName());
			
			String temp=Screenshot.getScreenshot(driver);
			extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "The Test case skiped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "The Test case passed is"+result.getName());
		}
		driver.quit();
	}
	@AfterTest
	public void endreport() {
		extent.flush();
		
		
	}
	

}
