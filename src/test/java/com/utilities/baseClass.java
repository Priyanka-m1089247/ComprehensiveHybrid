package com.utilities;

import java.io.File;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseClass {

	public static WebDriver driver;
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public WebDriver InitializeDriver() throws IOException {
		
		
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver=new EdgeDriver();
		
			driver.manage().window().maximize();
		
		
		return driver;
	}
	
	
	
	public  void ExtentReport() {
		 htmlReporter = new ExtentHtmlReporter(new File("./report/Extent.html"));
		 htmlReporter.config().setEncoding("utf-8");
		 htmlReporter.config().setDocumentTitle("HTML Report");
		 htmlReporter.config().setReportName("TestResult");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 extent=new ExtentReports();
		 extent.setSystemInfo("mindtree", "automation");
		 extent.setSystemInfo("browser", "chrome");
		 extent.attachReporter(htmlReporter);
	}
	
	
}
