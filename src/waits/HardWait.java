package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardWait {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

	}

	@Test
	public void waitsTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz");
		
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