package handlings;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandling {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void alertHandlingTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@name='proceed']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		String actUsernameAlertText=alert.getText();
		
		//validation of alert text
		Assert.assertEquals(actUsernameAlertText, "Please enter a valid user name");
				
		Thread.sleep(3000);
		
		//click ok on alert
		
		alert.accept();
		
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@name='proceed']")).click();
		
		alert=driver.switchTo().alert();
		
		String actPasswordAlertText=alert.getText();
		
		//validation of alert text
		Assert.assertEquals(actPasswordAlertText, "Please enter your password");
				
		Thread.sleep(3000);
		
		alert.accept();
		
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