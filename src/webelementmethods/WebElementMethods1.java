package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods1 {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver=	new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	driver.findElement(By.id("username")).sendKeys("reyaz0806");
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys("reyaz123");
	Thread.sleep(3000);
	driver.findElement(By.id("login")).click();
	Thread.sleep(3000);
	System.out.println(driver.getTitle());
	
	driver.findElement(By.id("datepick_in")).clear();
	Thread.sleep(3000);
	driver.findElement(By.id("datepick_in")).sendKeys("03/08/2025");
	Thread.sleep(3000);
	
	driver.quit();

	}

}
