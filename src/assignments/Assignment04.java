package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment04 {

	WebDriver driver;
	@BeforeMethod
	public void browserLaunch() {
		driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void assignment04() {

		Actions action=new Actions(driver);
		WebElement loanAmount= driver.findElement(By.xpath("//div[@id='loanamountslider']/span"));
		action.dragAndDropBy(loanAmount, 80, 0).pause(5000).build().perform();
		
		WebElement loadIntrestRate= driver.findElement(By.xpath("//div[@id='loaninterestslider']/span"));
		action.dragAndDropBy(loadIntrestRate, 150, 0).pause(3000).build().perform();
		
		WebElement loadTenure= driver.findElement(By.xpath("//div[@id='loantermslider']/span"));
		action.dragAndDropBy(loadTenure, -110, 0).pause(3000).build().perform();
	}
	
	@AfterMethod
	public void driverQuit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
