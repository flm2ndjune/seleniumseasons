package handlings;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle4 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");

		driver.manage().window().maximize();

	}

	@Test
	public void multipeWindowHandleTest() throws InterruptedException {

		String homeWindowId = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();

		Thread.sleep(3000);

		switchToWindow("Not Found");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");

		driver.findElement(By.xpath("//input[@value='Search']")).click();

		Thread.sleep(3000);

		// switching to home window
		driver.switchTo().window(homeWindowId);

		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();

		Thread.sleep(3000);

		switchToWindow("TestFlight - Apple");

		driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();

		Thread.sleep(3000);

		switchToWindow("Legal - Apple Media Services - Apple");
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Choose your country/region']")).click();

		Thread.sleep(3000);

		driver.switchTo().window(homeWindowId);

	}

	public void switchToWindow(String expTitle) {

		Set<String> allWindowIds = driver.getWindowHandles();

		// logic to switch to desired window/tab

		Iterator<String> it=allWindowIds.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			
			// condition check -> whether i'm switched to desired window
						if (driver.getTitle().equals(expTitle)) {
							break;
						}
			
		}
		
	}

	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

}
