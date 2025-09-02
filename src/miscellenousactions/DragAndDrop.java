package miscellenousactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void mouseHoverTest()
	{
		driver.switchTo().frame(0);
		
		Actions action=new Actions(driver);
		
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), 
				                         driver.findElement(By.xpath("//div[@id='droppable']")))
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
