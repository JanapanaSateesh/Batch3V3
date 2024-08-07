package com.orangehrm.commands;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Commands {

	public WebDriver driver;
	public final static Logger logger = LogManager.getLogger("rootLogger");
	
	public Commands(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Click(By locator) {
		try {
			ExplicitWait(locator);
			driver.findElement(locator).click();
			logger.info("Click is passed on: "+" "+ locator);
		}catch(Exception e) {
			// TODO: handle exception
			logger.error("Click is failed : "+" "+locator);
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}
	
	public void Type(By locator, String text) {
		try {
			ExplicitWait(locator);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			logger.info("Entered the value "+text+" "+"in "+locator);
		}catch(Exception e) {
			// TODO: handle exception
			logger.error("Entering "+text+"is failed "+" "+"in "+" "+locator);
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}
	
	public void ExplicitWait(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public String GetText(By locator) {
		String name="";
		try {
			 name= driver.findElement(locator).getText();
			 logger.info("Get the text message from the application UI. The value is : "+name);
			
		}catch(Exception e) {
			// TODO: handle exception
			logger.error("Get Text command is failed");
			logger.error(e.getMessage());
			Assert.fail();
			
		}
		return name;
	}
	
	public void StringValidation(String expected, String actual) {
		try {
			if(expected.equals(actual)) {
				logger.info("Validation is successful between respective strings"+actual+",,"+expected);
			}else {
				logger.error("VALIDATION IS FAILED BETWEEN"+actual+",,"+expected);
				Assert.fail();
			}
			
		}catch(AssertionError  e) {
			
			logger.error(e.getMessage());
		}
		
	}
}
