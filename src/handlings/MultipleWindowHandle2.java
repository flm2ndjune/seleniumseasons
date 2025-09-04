package handlings;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle2 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void multipeWindowHandleTest() throws InterruptedException
	{
		
		String homeWindowId=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		Thread.sleep(3000);
		
		Set<String>  allWindowIds=driver.getWindowHandles();
		
		//logic to switch to desired window/tab
		
		for(String windowId: allWindowIds)
		{
			
			driver.switchTo().window(windowId);
			
			//condition check -> whether i'm switched to desired window
			if(driver.getTitle().equals("Not Found"))
			{
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		Thread.sleep(3000);
		
		
		//switching to home window 
		driver.switchTo().window(homeWindowId);
		
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		
		Thread.sleep(3000);
		
		allWindowIds=driver.getWindowHandles();
		
		//logic to switch to desired window/tab
		
				for(String windowId: allWindowIds)
				{
					
					driver.switchTo().window(windowId);
					
					Thread.sleep(2000);
					
					//condition check -> whether i'm switched to desired window
					if(driver.getTitle().equals("TestFlight - Apple"))
					{
						break;
					}
					
				}
				
				driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();
				
				Thread.sleep(3000);
				
				allWindowIds=driver.getWindowHandles();
				
				//logic to switch to desired window/tab
				
						for(String windowId: allWindowIds)
						{
							
							driver.switchTo().window(windowId);
							
							Thread.sleep(2000);
							
							//condition check -> whether i'm switched to desired window
							if(driver.getTitle().equals("Legal - Apple Media Services - Apple"))
							{
								break;
							}
							
						}
						Thread.sleep(3000);
						
						driver.findElement(By.xpath("//a[text()='Choose your country/region']")).click();
						
						Thread.sleep(3000);
						
						driver.switchTo().window(homeWindowId);
		
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
