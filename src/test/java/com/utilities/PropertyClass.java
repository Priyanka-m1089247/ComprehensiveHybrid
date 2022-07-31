package com.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;


public class PropertyClass {
	public static WebDriver driver;
	public static Properties prop;
	public  PropertyClass() throws IOException {
		File confi=new File("./propertiesData/dataDriven.properties");
		FileInputStream fis=new FileInputStream(confi);
		prop=new Properties();
		
		prop.load(fis);
		
	}
	
	public String geturl() {
		return prop.getProperty("url");
	}
	
}
