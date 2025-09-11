package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

		driver.manage().window().maximize();
		
		

	}

	@Test
	public void waitsTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='2']")).click();
		driver.findElement(By.xpath("//span[text()='+']")).click();
		driver.findElement(By.xpath("//span[text()='3']")).click();
		driver.findElement(By.xpath("//span[text()='=']")).click();
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(30));
		myWait.pollingEvery(Duration.ofMillis(200));
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spinner1']")));
		myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='spinner1']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='screen']")).getText(), "5");
		
		
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