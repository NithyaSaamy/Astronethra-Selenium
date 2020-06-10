package AstronethraPO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPO {
	WebDriver driver1;
	WebElement ele1;
		
	public CustomerLoginPO(WebDriver webdriver) {
		this.driver1 = webdriver;
	}
	
	public WebElement countryCode() {
		ele1 = driver1.findElement(By.xpath("//input[@placeholder='Code']"));
		return ele1;
	}
	
	public WebElement mobileNumber() {
		ele1 = driver1.findElement(By.xpath("//input[@placeholder='Mobile']"));
		return ele1;
	}
	
	public WebElement signin() {
		ele1 = driver1.findElement(By.xpath("//button[@class='ast_btn'][1]"));
		return ele1;
	}
	
	public WebElement otpBox() {
		ele1 = driver1.findElement(By.xpath("//input[@formcontrolname='otpvalue']"));
		return ele1;
	}
	
	public WebElement confirmOtp() {
		try {
			Thread.sleep(1000);
			ele1 = driver1.findElement(By.xpath("//button[@class=\"btn btn-success cursor\"]"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		return ele1;
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
		driver1.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		countrycodeValue(countrycode);
		mobilenumbervalue(mobilenumber);
		signin().click();
	}
	
	public void cusotpvalidation(String otp) throws InterruptedException {
		driver1.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		otpBoxvalue(otp);
		Thread.sleep(10000);
		confirmOtp().click();	
	}

}
