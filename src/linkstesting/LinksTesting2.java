package linkstesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting2 {

	public static void main(String[] args) {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
		WebElement newUserRegiterLink= driver.findElement(By.linkText("New User Register Here"));
		
		System.out.println(newUserRegiterLink.getAttribute("href"));
		
		newUserRegiterLink.click();
		
		System.out.println(driver.getCurrentUrl());
		
		
		driver.quit();
		
		

	}

}
