package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods2 {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();

	}

}
