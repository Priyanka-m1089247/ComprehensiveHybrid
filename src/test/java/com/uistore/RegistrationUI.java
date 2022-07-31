package com.uistore;

import org.openqa.selenium.By;

public class RegistrationUI {

	public static By Registration=By.cssSelector("span[class='login-register']");
	public static By SignUp=By.xpath("//a[@class='event_internal_link']");
	public static By Firstname=By.xpath("//input[@placeholder='First name']");
	public static By Email=By.xpath("//input[@placeholder='Email address']");
	public static By Password=By.xpath("//input[@placeholder='Password']");
	public static By CreateAccount=By.xpath("//*[@value='CREATE ACCOUNT']");
	
	public static By Login=By.xpath("//button[text()='Log in']");
	public static By LoginEmail=By.id("login-email");
	public static By LoginPassword=By.id("login-password");
	public static By EndLogin=By.cssSelector("input[value='LOG IN']");
	
}
