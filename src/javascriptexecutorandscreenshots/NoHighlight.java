package javascriptexecutorandscreenshots;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NoHighlight {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void loginTest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Logout");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
		
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