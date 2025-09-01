package xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelativeXpath2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		//driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void loginTest()
	{
		//dynamic id is present
		//driver.findElement(By.xpath("//a[@id='u_0_0_Yf']")).click();
		driver.findElement(By.xpath("//a[starts-with(@id,'u_0_0_')]")).click();
		
		//driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	
	    //driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("harry potter");
	}
	
	
	
	

}
