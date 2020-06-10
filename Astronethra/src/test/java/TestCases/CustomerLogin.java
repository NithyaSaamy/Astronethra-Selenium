package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AstronethraPO.AstrologerLoginPO;
import AstronethraPO.CalendarPO;
import AstronethraPO.CustomerLoginPO;
import AstronethraPO.GetOtpFromDB;
import BrowserSetup.AstrologerSetup;
import BrowserSetup.CustomerSetup;

public class CustomerLogin {
	WebDriver driver1;
	CustomerLoginPO cusloginPO;
	CustomerSetup browser1;
	GetOtpFromDB GetOtpFromdb1;
	
	@BeforeClass
	public void setup() {
		browser1 = new CustomerSetup();
		driver1=browser1.getBrowser1();
		cusloginPO = new CustomerLoginPO(driver1);
		GetOtpFromdb1 = new GetOtpFromDB();
	}
	
	@Test(priority=2,
			description="Success Login for customer")
	public void successCustomerBrowserLaunch() {
		try {
	
			driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			cusloginPO.login("91", "8310378098");
			String Otp = GetOtpFromdb1.sendGet("8310378098", "91"); //9092797998
			cusloginPO.cusotpvalidation(Otp);
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	@AfterClass
	public void tearDown() {
		driver1.quit();
	}
	

}
