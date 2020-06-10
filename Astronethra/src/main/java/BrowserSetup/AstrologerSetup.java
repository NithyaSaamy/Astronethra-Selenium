package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AstrologerSetup {
	public WebDriver driver;
	public WebDriver getBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.jobztop.com/astronethra/#/AstrologerHome");
		return driver;
	}

}
