package AstronethraPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentsPO {
	WebDriver driver;
	WebElement ele;
		
	public AppointmentsPO(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public WebElement appointmentsTab() {
		ele = driver.findElement(By.xpath("/html/body/app-root/app-common-file/app-horoscoperesults-list/html/body/div[2]/div/div/ul/li[4]/a"));
		return ele;
	}
	
	public WebElement schedulesFilterForIncomplte() {
		ele = driver.findElement(By.xpath("//select[@name='schedule']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("INCOMPLETE");
		return ele;
	}
	
	public WebElement schedulesFilterForLapsed() {
		ele = driver.findElement(By.xpath("//select[@name='schedule']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("LAPSED");
		return ele;
	}
	
	public WebElement schedulesFilterForNotified() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-common-file/app-horoscoperesults-list/html/body/div[3]/div/div/div/div/div[7]/div[1]/div[1]/select")));
		//ele = driver.findElement(By.xpath("//select[@name='schedule']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("NOTIFIED");
		return ele;
	}
	
	public void FilterForIncomplte() {
		appointmentsTab().click();
		schedulesFilterForIncomplte().click();
	}
	
	public void FilterForLapsed() {
		appointmentsTab().click();
		schedulesFilterForLapsed().click();
	}
	
	public void FilterForNotified() {
		appointmentsTab().click();
		schedulesFilterForNotified().click();
	}

}
