package AstronethraPO;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPO {
	WebDriver driver;
	WebElement ele;
		
	public CalendarPO(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public WebElement calendarTab() {
		ele = driver.findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[1]/div/div/div[2]/div/div/ul/li[2]/a"));
		return ele;
	}
	
	public WebElement schedulesFilterForNotified() {
		ele = driver.findElement(By.xpath("//select[@style='font-size: 14px;border-radius: 20px;']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("NOTIFIED");
		return ele;
	}
	
	public WebElement schedulesFilterForIncomplete() {
		ele = driver.findElement(By.xpath("//select[@style='font-size: 14px;border-radius: 20px;']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("INCOMPLETE");
		return ele;
	}
	
	public WebElement schedulesFilterForLapsed() {
		ele = driver.findElement(By.xpath("//select[@style='font-size: 14px;border-radius: 20px;']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("LAPSED");
		return ele;
	}
	
	public WebElement searchnameFilter() throws Exception {
		ele = driver.findElement(By.xpath("//input[@placeholder='Search Name']"));
		//ele.sendKeys(Keys.ENTER);
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ENTER);
		//act.sendKeys(Keys.ENTER).build().perform();
//		act.keyUp(Keys.ENTER);
//		String selectkeys= Keys.chord(Keys.ENTER);
		//String selectkeys= ele.Keys.chord(Keys.ENTER);
		
		Robot robot = new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		return ele;
	}
	
	public WebElement scheduleForNotified() {
		ele = driver.findElement(By.xpath("//button[@style='border-radius: 20px;min-width:fit-content;']"));
		return ele;
	}
	
	public WebElement scheduleDay() {
		ele = driver.findElement(By.xpath("//select[@name='scheduleDay']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("05");
		return ele;
	}
	
	public WebElement scheduleMonth() {
		ele = driver.findElement(By.xpath("//select[@name='scheduleMonth']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Jun");
		return ele;
	}
	
	public WebElement scheduleYear() {
		ele = driver.findElement(By.xpath("//input[@name='scheduleYear']"));
		return ele;
	}

	public WebElement scheduleTime() {
		ele = driver.findElement(By.xpath("//input[@name='scheduleTime']"));
		return ele;
	}
	
	public WebElement scheduleBtn() {
		ele = driver.findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[2]/div[8]/div/div/div[3]/button"));
		return ele;
	}
	
	public WebElement scheduleBtn1() {
		try {
			ele = driver.findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[2]/div[8]/div/div/div[3]/button"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ele;
	}
	
	public WebElement closePopup() {
		ele = driver.findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[2]/div[8]/div/div/div[1]/button/span"));
		return ele;
	}
	
	public WebElement refresh() {
		ele = driver.findElement(By.xpath("//i[@class='fa fa-refresh']"));
		return ele;
	}
	
	public WebElement incompleteReschedule() {
//		driver.findElement(By.xpath("//span[text()='Reschedule']")).click();;
//		WebDriverWait wait = new WebDriverWait(driver,90);
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[2]/p[3]/span/p/span[1]")));	
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[2]/p[3]/span/p/span[1]"))).click();	
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", ele);
		List<WebElement> incompleteList=driver.findElements(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div"));
		for(int i=0;i<incompleteList.size();i++) {
			System.out.println("Incomplete list size: "+incompleteList.size());
			ele=incompleteList.get(i).findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/p[1]/b"));
			String customerName=ele.getText();
			System.out.println("Customer Name: " +customerName);
			if((customerName.equalsIgnoreCase("Payaswini Hegde"))) {
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				//incompleteList.get(i).findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[2]/p[3]/span/p/span[1]")).click();;
				Actions act = new Actions(driver);
				act.moveToElement(incompleteList.get(i).findElement(By.xpath("//span[@class=\"redColor cursor\"][1]"))).click().build().perform();;
				
				//				WebElement ele1=incompleteList.get(i).findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[2]/p[3]/span/p/span[1]"));
//				((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", ele1);
//				ele1.click();
//				WebDriverWait wait = new WebDriverWait(driver,200);
//				wait.until(ExpectedConditions.invisibilityOf(incompleteList.get(i).findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[2]/p[3]/span/p/span[1]"))));	
				System.out.println("Clicked reschedule");			
			}
		}
		return ele;
	}
	
	public WebElement lapsedReschedule() {
		List<WebElement> lapsedList=driver.findElements(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div[1]/div"));
		for(int i=0;i<lapsedList.size();i++) {
			System.out.println("Lapsed list size: "+lapsedList.size());
			ele=lapsedList.get(i).findElement(By.xpath("/html/body/app-root/app-astrologer/app-result-page/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/p[1]/b"));
			String customerName=ele.getText();
			System.out.println("Customer Name: " +customerName);
			if((customerName.equalsIgnoreCase("MS Aniruddha Jegannath"))) {
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				lapsedList.get(i).findElement(By.xpath("//a[@style=\"color: orange;text-align: center;\"]")).click();;
				System.out.println("Clicked change option");
			}
		}
		return ele;
	}
	
	public void searchnameFilterValue(String value) throws Exception {
		searchnameFilter().click();
		searchnameFilter().clear();
		searchnameFilter().sendKeys(value);
	}
	
	public void schduleYearValue(String value) {
		scheduleYear().click();
		scheduleYear().clear();
		scheduleYear().sendKeys(value);
	}
	
	public void schduleTimeValue(String value) {
		scheduleTime().click();
		scheduleTime().clear();
		scheduleTime().sendKeys(value);
	}
	
	public void schedulesFilterForNotifiedclick() {
		calendarTab().click();
		schedulesFilterForNotified().click();
	}
	
	public void searchNameFilterclick(String name) throws Exception {
		calendarTab().click();
		searchnameFilterValue(name);
	}
	
	public void schedulingForNotified(String year, String time) throws InterruptedException {
		calendarTab().click();
		scheduleForNotified().click();
		scheduleDay();
		scheduleMonth();
		schduleYearValue(year);
		schduleTimeValue(time);
		scheduleBtn().click();
		Thread.sleep(1000);
		closePopup().click();
	}
	
	//public void schedulingForIncomplete(String name, String year, String time) throws Exception {
	public void schedulingForIncomplete(String year, String time) throws Exception {
		calendarTab().click();
		schedulesFilterForIncomplete().click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		incompleteReschedule();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		scheduleDay();
		scheduleMonth();
		schduleYearValue(year);
		schduleTimeValue(time);
		scheduleBtn().click();
		//Thread.sleep(1000);
		closePopup().click();
	}
	
	public void schedulingForLapsed(String year, String time) throws Exception {
		Thread.sleep(5000);
		calendarTab().click();
		schedulesFilterForLapsed().click();
		//searchnameFilterValue(name);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lapsedReschedule();
		scheduleDay();
		scheduleMonth();
		schduleYearValue(year);
		schduleTimeValue(time);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		scheduleBtn1();
		closePopup().click();
	}

}
