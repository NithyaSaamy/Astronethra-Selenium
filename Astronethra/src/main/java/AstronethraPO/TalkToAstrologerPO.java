package AstronethraPO;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TalkToAstrologerPO {
	WebDriver driver;
	WebElement ele;
		
	public TalkToAstrologerPO(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public WebElement talkToAstrologerTab() {
		ele = driver.findElement(By.xpath("/html/body/app-root/app-common-file/app-horoscoperesults-list/html/body/div[2]/div/div/ul/li[3]/a"));
		return ele;
	}
	
	public WebElement searchByNameField() throws Exception {
		ele = driver.findElement(By.xpath("//input[@placeholder='Search name']"));
//		Robot robot = new Robot();
//		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		return ele;
	}
	
	public WebElement searchIconForName() { 
		ele = driver.findElement(By.xpath("/html/body/app-root/app-common-file/app-horoscoperesults-list/html/body/div[3]/div/div/div/div/div[1]/div/div[2]/div/div/span"));
		return ele;
	}
	
	public WebElement notifyAstrologer() {
		List<WebElement> NotifiedList=driver.findElements(By.xpath("//div[@class='card card-starts astListCard']"));
		for(int i=0;i<NotifiedList.size();i++) {
			System.out.println("Notified list size: "+NotifiedList.size());
			ele=NotifiedList.get(i).findElement(By.xpath("//a[@class='nameStyle']"));
			String customerName=ele.getText();
			System.out.println("Customer Name: " +customerName);
			if((customerName.equalsIgnoreCase("Mathan"))) {
				//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				NotifiedList.get(i).findElement(By.xpath("//span[@class='chipAlign cursor']")).click();;
				System.out.println("Clicked Notify option");
			}
		}
		return ele;
	}
	
	public void searchByNameFieldValue(String value) throws Exception {
		searchByNameField().click();
		searchByNameField().clear();
		searchByNameField().sendKeys(value);
	}
	
	public void NotifyingTheAstrologer(String name) throws Exception {
		talkToAstrologerTab().click();
		searchByNameFieldValue(name);
		searchIconForName().click();
		notifyAstrologer();
	}

}
