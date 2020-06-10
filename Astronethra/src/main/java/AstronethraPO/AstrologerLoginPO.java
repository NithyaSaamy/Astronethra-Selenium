package AstronethraPO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AstrologerLoginPO {
	WebDriver driver;
	WebElement ele;
		
	public AstrologerLoginPO(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public WebElement countryCode() {
		ele = driver.findElement(By.xpath("//input[@placeholder='Code']"));
		return ele;
	}
	
	public WebElement mobileNumber() {
		ele = driver.findElement(By.xpath("//input[@placeholder='Mobile']"));
		return ele;
	}
	
	public WebElement signin() {
		ele = driver.findElement(By.xpath("//button[@class='ast_btn'][1]"));
		return ele;
	}
	
	public WebElement otpBox() {
		ele = driver.findElement(By.xpath("//input[@placeholder='Enter OTP*']"));
		return ele;
	}
	
	public WebElement confirmOtp() {
		try {
			Thread.sleep(10000);
			ele = driver.findElement(By.xpath("/html/body/app-root/app-home-page/html/body/div[4]/div/div/div[4]/button"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ele;
	}
	
	public void countrycodeValue(String value) {
		countryCode().click();
		countryCode().clear();
		countryCode().sendKeys(value);		
	}
	
	public void mobilenumbervalue(String value) {
		mobileNumber().click();
		mobileNumber().clear();
		mobileNumber().sendKeys(value);
	}
	
	public void otpBoxvalue(String value) {
		otpBox().click();
		otpBox().clear();
		otpBox().sendKeys(value);
	}
	
	public void login(String countrycode, String mobilenumber) {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		countrycodeValue(countrycode);
		mobilenumbervalue(mobilenumber);
		signin().click();
	}
	
	public void otp(String otp) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		otpBoxvalue(otp);
		Thread.sleep(10000);
		confirmOtp().click();		
	}

}
