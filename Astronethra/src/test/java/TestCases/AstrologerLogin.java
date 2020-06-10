package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AstronethraPO.AstrologerLoginPO;
import AstronethraPO.GetOtpFromDB;
import BrowserSetup.AstrologerSetup;

public class AstrologerLogin {
	WebDriver driver;
	AstrologerSetup browser;
	AstrologerLoginPO loginPO;
	GetOtpFromDB GetOtpFromdb;
	
	@BeforeClass
	public void setup() {
		browser = new AstrologerSetup();
		driver=browser.getBrowser();
		loginPO = new AstrologerLoginPO(driver);
		GetOtpFromdb = new GetOtpFromDB();
	}
	
	@Test(priority=1,
			description="Success Login for astrologer")
	public void successLogin() throws Exception {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		loginPO.login("91", "8310378098");
		String Otp = GetOtpFromdb.sendGet("8310378098", "91");
		loginPO.otp(Otp);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
