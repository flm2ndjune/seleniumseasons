package miscellenousactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void mouseHoverTest()
	{
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Add-ons']")))
				  .pause(3000)
				 .click(driver.findElement(By.xpath("(//div[text()='Excess Baggage'])[1]")))
				 .build()
				 .perform();
		
		//driver.findElement(By.xpath("//div[text()='Excess Baggage' and contains(@class,'css-76zvg2 r-c20mna')]")).click();
		
		
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
