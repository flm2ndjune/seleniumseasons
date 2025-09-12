package extratopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/upload");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void fileUploadTest()
	{
		
		WebElement uploadInput=driver.findElement(By.xpath("//input[@id='fileInput']"));
		
		uploadInput.sendKeys("D:\\FLM2ndJune\\Notes and Images\\DB Testing.png");
		
		//driver.findElement(By.xpath("//button[@id='fileSubmit']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='fileSubmit']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container']/h1")).getText(), "File Uploaded!");
		
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
