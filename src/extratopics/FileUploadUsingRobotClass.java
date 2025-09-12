package extratopics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class FileUploadUsingRobotClass {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://imgur.com/meme-generator");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void fileUploadTest() throws InterruptedException, AWTException
	{
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Picsart']")));
		
		driver.findElement(By.xpath("//button//*[name()='svg']")).click();
		
		Thread.sleep(3000);
		
		WebElement uploadInput=driver.findElement(By.xpath("(//input[@type='file'])[3]/parent::label//*[name()='svg']"));
		uploadInput.click();
		
		//uploadInput.sendKeys("D:\\FLM2ndJune\\Notes and Images\\DB Testing.png");
		
		// this is just to copy something to clipboard
		StringSelection filePath=new StringSelection("D:\\FLM5thDecWS\\SeleniumSeasons\\Xpath Axes.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		
		Thread.sleep(5000);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.delay(3000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
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
