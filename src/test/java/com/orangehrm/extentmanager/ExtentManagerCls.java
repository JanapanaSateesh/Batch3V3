package com.orangehrm.extentmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.utilities.CaptureScreenshot;

public class ExtentManagerCls {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static CaptureScreenshot capturescreenshotobject;

	
	public void StartReport() {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH-mm-ss");
		LocalDateTime time=LocalDateTime.now();
		String date=dtf.format(time).toString();
		
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("./Reports/"+date+"_OrangeHRMSummaryReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Summary Report");
		
		extent.attachReporter(spark);
	}
	
	public void EndReport() {
		extent.flush();
		
	}
	
	public void CreateTestCaseNameOnTheReport(String testcasename) {
		test=extent.createTest(testcasename);
		
	}
	
	public void AddTestcaseSteps(String step) {
		test.info(step);
		
	}
	
	public void addScreenshotOnTestFailure(WebDriver driver) {
		capturescreenshotobject = new CaptureScreenshot();
		 String image=capturescreenshotobject.TakeSnapShotOfWebApplication(driver);
		 test.fail("Failed");
		test.addScreenCaptureFromBase64String(image);
		
	}
	

	
}
