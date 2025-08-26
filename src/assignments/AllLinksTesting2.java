package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksTesting2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		for(int i=1;i<=10;i++)
		{
			
			Thread.sleep(2000);
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		
		driver.manage().window().maximize();
		}
		
	
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
