package BrowserLaunch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AstronethraPO.AppointmentsPO;
import AstronethraPO.AstrologerLoginPO;
import AstronethraPO.CalendarPO;
import AstronethraPO.CustomerLoginPO;
import AstronethraPO.GetOtpFromDB;
import BrowserSetup.AstrologerSetup;
import BrowserSetup.CustomerSetup;

public class SchedulingForIncomplete {
	WebDriver driver;
	AstrologerLoginPO loginPO;
	AstrologerSetup browser;
	GetOtpFromDB GetOtpFromdb;
	CalendarPO calendar;
	
	//Customer
	
	WebDriver driver1;
	CustomerLoginPO cusloginPO;
	CustomerSetup browser1;
	GetOtpFromDB GetOtpFromdb1;
	AppointmentsPO appointmets;
	
	@BeforeClass
	public void setup() {
		browser = new AstrologerSetup();
		driver=browser.getBrowser();
		loginPO = new AstrologerLoginPO(driver);
		GetOtpFromdb = new GetOtpFromDB();
		calendar = new CalendarPO(driver);
		
		//customer
		
		browser1 = new CustomerSetup();
		driver1=browser1.getBrowser1();
		cusloginPO = new CustomerLoginPO(driver1);
		GetOtpFromdb1 = new GetOtpFromDB();
		appointmets = new AppointmentsPO(driver1);
	}
	
	@Test(priority=1,
			description="Success Login for astrologer")
	public void successAstrologerBrowserLaunch() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			loginPO.login("91", "8310378098");
			String Otp = GetOtpFromdb.sendGet("8310378098", "91");
			loginPO.otp(Otp);
		} catch(Exception e) {
			System.out.println("Unable to complete the success login for astrologer");
		}
	}
	
	@Test(priority=2,
			description="Success Login for customer")
	public void successCustomerBrowserLaunch() {
		try {
			driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			cusloginPO.login("91", "9986067657");
			String Otp = GetOtpFromdb1.sendGet("9986067657", "91"); //9986067657
			cusloginPO.cusotpvalidation(Otp);
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test(priority=3,
			description="Rescheduling with Invalid Data for Incomplete call")
	public void SchedulingWithInvalidDataForIncomplete() throws Exception {
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		calendar.schedulingForIncomplete("1996", "1200");
	}
	
	@Test(priority=4,
			description="Filtering Incomplete status using schedules filter")
	public void FilterUsingIncomplete() throws Exception {
		driver1.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		appointmets.FilterForIncomplte();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver1.quit();
	}

}
