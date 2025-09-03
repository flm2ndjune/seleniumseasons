package miscellenousactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick2 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void rightClickTest()
	{
		Actions action=new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']")))
				 .pause(3000)
				 .keyDown(Keys.DOWN)
				 .pause(2000)
				 .keyDown(Keys.DOWN)
				 .pause(2000)
				 .keyDown(Keys.DOWN)
				 .pause(2000)
				 .keyDown(Keys.ENTER)
				 .pause(2000)
				 .build()
				 .perform();
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
