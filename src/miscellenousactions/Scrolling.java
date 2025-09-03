package miscellenousactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scrolling {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void scrollTest()
	{
		Actions action=new Actions(driver);
		
		action.sendKeys(Keys.PAGE_DOWN)
		          .pause(3000)
		          .sendKeys(Keys.PAGE_UP)
		          .pause(3000)
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
