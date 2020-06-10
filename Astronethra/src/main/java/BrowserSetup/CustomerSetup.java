package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerSetup {
	public WebDriver driver1;
	public WebDriver getBrowser1() {
//		System.setProperty("Webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
//		driver1 = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://qa1.jobztop.com/astronethra/#/");
		return driver1;
	}

}
