package assignments;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6WindowHandling {
	WebDriver driver;
	@BeforeMethod
	
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void alertHandling() throws InterruptedException {
	  Thread.sleep(3000);
	  String homeHandle=driver.getWindowHandle();
	  driver.switchTo().frame("a077aa5e");
	 driver.findElement(By.xpath("//img[contains(@src,'Jmeter720.png')]")).click();
	 Thread.sleep(2000);
	 driver.switchTo().defaultContent(); //shifts frame to page
	 
	 Set<String> allWindowHandles= driver.getWindowHandles();
	 //switching to second page
	 for(String windowHandle:allWindowHandles)
	 {
		 driver.switchTo().window(windowHandle);
		 
		 if(driver.getTitle().equals("Selenium Live Project for Practice"))
		 {
			 break;
		 }
	 } 
	 
	Thread.sleep(3000);
	

	List<WebElement> a= driver.findElements(By.xpath("//p[text()='Top Tutorials']/ancestor::div[contains(@class,'wp-block-kadence-column')][1]/descendant::span[@class='kt-blocks-info-box-title']"));
	
	for(WebElement s:a) {
		
		System.out.println(s.getText());
	}
	
	Thread.sleep(1000);
	
	  driver.switchTo().window(homeHandle);
	  Thread.sleep(1000);
	  
	}
	
	

	@AfterMethod
	
	public void tearDown() {
	try {
		
		Thread.sleep(5000);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
		
	}
	driver.quit();
	}

}
