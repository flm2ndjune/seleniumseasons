package radioandcheck;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://echoecho.com/htmlforms09.htm");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test(description="To validate default check box selection in app",enabled = false)
	public void checkboxTest1()
	{
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		
	}
	
	@Test(description="To validate all check box selected ", enabled=false)
	public void checkboxTest2() throws InterruptedException
	{
		
		List<WebElement> allChecks=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		
		for(WebElement check:allChecks)
		{
			if(!check.isSelected())
			{
				check.click();
				Thread.sleep(3000);
			}
		}
		
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		for(WebElement check:allChecks)
		{
			Assert.assertTrue(check.isSelected());
		}
	}

	
	@Test(description="To validate all check boxes when unselected ", enabled=true)
	public void checkboxTest3() throws InterruptedException
	{
		
		List<WebElement> allChecks=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		
		for(WebElement check:allChecks)
		{
			if(check.isSelected())
			{
				check.click();
				Thread.sleep(3000);
			}
		}
		
		//Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		//Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		//Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		for(WebElement check:allChecks)
		{
			Assert.assertFalse(check.isSelected());
		}
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