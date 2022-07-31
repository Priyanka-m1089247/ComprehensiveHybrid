package com.utilities;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Windowhandle {
	public static WebDriver driver;
	public Windowhandle(WebDriver driver) {
		Windowhandle.driver=driver;
	}
	public static  void Window(WebDriver driver) {
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		
		
	}
	
}
