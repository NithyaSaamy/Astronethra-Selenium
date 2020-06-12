package com.auto.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener implements ITestListener,ISuiteListener {
Logger log = LogManager.getLogger(Listener.class);
	
	WebDriver driver;	
	Screenshot screenshot;	
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter reporter;
	
	CurrentDate date = new CurrentDate();
	String timeStamp = date.getDateFormat();

	public void onFinish(ITestContext result) {
		log.info("inside Class Test OnFinsish");
		System.out.println("On Finish");
		extent.flush();
		String fileName = (String) result.getAttribute("className");
		int reportInstance = result.getCurrentXmlTest().getIndex() + 1;
		File oldFileName = new File(System.getProperty("user.dir") + "/Reports/"+ timeStamp + "/Report" + reportInstance + ".html");
		File newFileName = new File(System.getProperty("user.dir") + "/Reports/"+ timeStamp + "/" + fileName + ".html");
		if(newFileName.exists()) {
			newFileName = new File(System.getProperty("user.dir") + "/Reports/"+ timeStamp + "/" + fileName + reportInstance + ".html");
		}
		oldFileName.renameTo(newFileName);
	}

	public void onStart(ITestContext result) {
		log.info("inside Class Test onStart");
		int reportInstance = result.getCurrentXmlTest().getIndex() + 1;
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/"+ timeStamp + "/Report" + reportInstance + ".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Astronethra");
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("Java Version", "1.8");
		extent.setSystemInfo("Tester", "Nithya");
		extent.setSystemInfo("Application", "Astronethra");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("inside Class Test onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailure(ITestResult result) {
		log.info("Result - " + result.getThrowable());
		ITestContext context = result.getTestContext();
		driver = (WebDriver) context.getAttribute("webDriver");
		screenshot = new Screenshot(driver);
		String methodName = result.getTestClass().getName() + "-" + result.getName().toString().trim();
		logger.log(Status.FAIL, "Result - Failed");
		logger.log(Status.ERROR, result.getThrowable());
		String ipad_screenshot_path = screenshot.captureScreenshot(methodName, timeStamp);
		logger.log(Status.INFO, "Screenshot path - "+ ipad_screenshot_path);
		try {
			logger.addScreenCaptureFromPath(ipad_screenshot_path);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		log.info("inside Class Test onTestSkipped");
		logger.log(Status.SKIP, "Result - Skipped");
	}

	public void onTestStart(ITestResult result) {
		log.info("Executing method" + result.getMethod());
		log.info("inside Class Test onTestStart");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("ASTRONETHRA REPORT");
		logger = extent.createTest(result.getName());
		logger.log(Status.INFO, "Class Name - " + result.getTestClass().getName());
		logger.log(Status.INFO, "Description - " + result.getMethod().getDescription());
		logger.log(Status.INFO, "Method Name - " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("inside Class Test onTestSuccess");
		logger.log(Status.PASS, "Result - Passed");
	}

	public void onFinish(ISuite result) {
		log.info("Stopping Appium server");	
		//service.stopServer();		
	}

	public void onStart(ISuite result) {
		log.info("Starting Appium Server");
		//service = new AppiumServices();
		//service.startServer();
	}

}
