package com.orangehrm.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.extentmanager.ExtentManagerCls;
import com.orangehrm.utilities.ReadConfig;

public class Base  {
	
	public WebDriver driver;
	public String url;
	public String username;
	public String password;
	public ExtentManagerCls reportclass;
	
	@BeforeSuite(alwaysRun = true)
	public void StartReport() {
		reportclass=new ExtentManagerCls();
		reportclass.StartReport();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		ReadConfig credentials = new ReadConfig();
		url=credentials.getUrl();
		username=credentials.getusername();
		password=credentials.getPassword();

		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		//After Conflicts

		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		EcommerceLoginAndLogOut.Login(driver, username, password);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Test is passed");
		}
		if(result.getStatus()==ITestResult.FAILURE) {
			reportclass.addScreenshotOnTestFailure(driver);
			
		}
		
		EcommerceLoginAndLogOut.Logout(driver);
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void EndReport() {
		reportclass.EndReport();
	}
}
