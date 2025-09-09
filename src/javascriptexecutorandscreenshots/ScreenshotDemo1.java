package javascriptexecutorandscreenshots;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenshotDemo1 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		//TakesScreenshot ts=(TakesScreenshot) driver;
		
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destFile=new File("D:\\FLM2ndJuneWS\\adactin1.png");
		
		Files.copy(srcFile, destFile);
		
		
		
		
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