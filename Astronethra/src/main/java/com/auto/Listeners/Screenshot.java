package com.auto.Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	WebDriver driver=null;
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public String captureScreenshot(String screenshotName, String timeStamp) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "/Reports/"+ timeStamp + "/Screenshots/" + screenshotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(src,destination);
			return dest;
			
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot - " + e.getMessage());
			return e.getMessage();
		}	
	}

}
