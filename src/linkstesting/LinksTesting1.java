package linkstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting1 {

	public static void main(String[] args) {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
		WebElement forgotPasswordLink=driver.findElement(By.linkText("Forgot Password?"));
		
		//isDisplayed
		
		System.out.println(forgotPasswordLink.isDisplayed()); //true
		System.out.println(forgotPasswordLink.getText()); // Forgot Password?
		
		//click 
		forgotPasswordLink.click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//back to home page 
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		
		driver.quit();
		
		

	}

}
