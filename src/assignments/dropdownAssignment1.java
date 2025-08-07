package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownAssignment1 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]")).click();
		new Select(driver.findElement(By.xpath("//select[@id='day']"))).selectByValue("11");
		
		new Select(driver.findElement(By.xpath("(//select[@id='month'])[1]"))).selectByValue("10");
		new Select(driver.findElement(By.id("year"))).selectByValue("2000");
		
		
		Thread.sleep(5000);
		
		driver.quit();

	}


}
