package assignments.ramesh;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment5 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		
		  Map<String, Object> prefs = new HashMap<>();
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);
		  prefs.put("profile.password_manager_leak_detection", false);
		 
        ChromeOptions co = new ChromeOptions();
        co.setExperimentalOption("prefs", prefs);
        co.addArguments("--disable-notifications");
		
		driver=new ChromeDriver(co);
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void doubleClickTest() throws InterruptedException 
	{
		
		driver.findElement(By.xpath("//input[@id='email_field']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_field']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		
		Thread.sleep(3000);
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='dropdown'])[2]")))
		.pause(2000)
		.click(driver.findElement(By.xpath("//a[text()='Double Click']")))
		.pause(2000)
		.build()
		.perform();

		action.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[2]")))
		.pause(2000)
		.click(driver.findElement(By.xpath("//a[text()='Double Click']")))
		.pause(2000)
		.build()
		.perform();
		
		for(int i=1; i<=5; i++)
		{
			action.doubleClick(driver.findElement(By.xpath("//button[text()='Double Click']")))
			.build()
			.perform();
		}

	}
	
	@AfterMethod
	public void tearDown()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		//driver.quit();
	}

}
