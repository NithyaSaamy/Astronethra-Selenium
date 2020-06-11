package BrowserLaunch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AstronethraPO.AstrologerLoginPO;
import AstronethraPO.CalendarPO;
import AstronethraPO.CustomerLoginPO;
import AstronethraPO.GetOtpFromDB;
import AstronethraPO.TalkToAstrologerPO;
import BrowserSetup.AstrologerSetup;
import BrowserSetup.CustomerSetup;

public class NotifyTheAstrologer {
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
	TalkToAstrologerPO talktoastrologer;
	
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
		talktoastrologer = new TalkToAstrologerPO(driver1);
	}
	
	@Test(priority=1,
			description="Success Login for astrologer")
	public void successAstrologerBrowserLaunch() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			loginPO.login("91", "8838589864");
			String Otp = GetOtpFromdb.sendGet("8838589864", "91"); //8838589864
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
			cusloginPO.login("91", "9551842434");
			String Otp = GetOtpFromdb1.sendGet("9551842434", "91"); //9551842434
			cusloginPO.cusotpvalidation(Otp);
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test(priority=3,
			description="Notifying the astrologer from customer using search name filter")
	public void NotifyAstrologer() throws Exception {
		driver1.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		talktoastrologer.NotifyingTheAstrologer("Mathan");
	}
	
	@Test(priority=4,
			description="Scheduling with Invalid Data for Notified customer")
	public void SchedulingWithInvalidDataForNotified() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		calendar.schedulingForNotified("1996", "1200");
	}

}
