package com.orangehrm.utilities;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public String TakeSnapShotOfWebApplication(WebDriver driver) {
		byte[] screenshotInBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		String screenshot=Base64.getEncoder().encodeToString(screenshotInBytes);
		return screenshot;
	}
}
