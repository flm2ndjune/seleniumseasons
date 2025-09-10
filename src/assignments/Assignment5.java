package assignments;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment5 {

	WebDriver driver;
	@BeforeMethod
	public void browserLaunch() {
		driver=new ChromeDriver(setChromeOptions());
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
	}
	
		public ChromeOptions setChromeOptions() {
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("profile.password_manager_leak_detection", false);

	        ChromeOptions co = new ChromeOptions();
	        co.setExperimentalOption("prefs", prefs);
	        co.addArguments("--disable-notifications");
	        return co;
	}
	
	@Test
	 public void Mousehover() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_field")));

        driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
        driver.findElement(By.id("password_field")).sendKeys("admin123");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Login to Account']")).click();

 

        Actions mouseHover = new Actions(driver); 
        Thread.sleep(2000);
        mouseHover.moveToElement(driver.findElement(By.xpath("//button[normalize-space()='Intractions']"))).pause(3000).build().perform();
        
        mouseHover.moveToElement(driver.findElement(By.xpath("//a[text()='Double Click']"))).click().build().perform();
        
        
     Thread.sleep(2000);
      mouseHover.moveToElement(driver.findElement(By.xpath("//button[normalize-space()='Intractions']"))).pause(3000).build().perform();
       
       mouseHover.moveToElement(driver.findElement(By.xpath("//a[text()='Double Click']"))).click().build().perform();
        

        int count = 0;
        while (count < 5) {
        	mouseHover.doubleClick(driver.findElement(By.xpath("//button[normalize-space()='Double Click']"))).build().perform();
            System.out.println("Current Count: " + count);
            count++;
        }
		
	}
	
	@AfterMethod
	public void driverQuit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
