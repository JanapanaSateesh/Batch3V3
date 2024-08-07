package com.orangehrm.testcases;

import org.openqa.selenium.WebDriver;

import com.orangehrm.objects.Web_Objects;

public class EcommerceLoginAndLogOut {

	public static void Login(WebDriver driver, String username, String password) {
		driver.findElement(Web_Objects.username).sendKeys(username);
		driver.findElement(Web_Objects.password).sendKeys(password);
		driver.findElement(Web_Objects.loginbutton).click();
	}
	
	public static void Logout(WebDriver driver) {
		driver.quit();
	}
}
