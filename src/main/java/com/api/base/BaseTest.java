package com.api.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.api.config.Configuration;
import com.api.config.ConfigurationManager;
import com.api.utilities.Event;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseTest {
	
	public static ExtentTest test;
 	public static ExtentReports report;
 	public static ExtentTest node;
 	public static WebDriver driver;
 	public static ExtentSparkReporter spark;
	public static Event event= new Event();
	public static Configuration config= ConfigurationManager.getConfiguration();
	
 	@BeforeSuite(alwaysRun = true)
	public void StartService() {
 		report = new ExtentReports();
 		spark = new ExtentSparkReporter("target/Spark.html");
		report.attachReporter(spark);
//		System.out.println(ctx.getCurrentXmlTest().getSuite().getName());

	}
	
	 
	
 	@BeforeMethod(alwaysRun = true)
	public void launchApp(Method testmethod) {

		test = report.createTest(testmethod.getName());
 
	}
	
	
	 
	
	
 	@AfterMethod()
	public void closeApp() {
		
		
		if (report != null) {
			System.out.println("[EVENT] Ending Test...");
			System.out.println("[EVENT] Flushing...");
			report.flush();
		}
		
		
	}
 	
 	@AfterSuite
	public void stopServer() {
 		report.flush();
	}


}
