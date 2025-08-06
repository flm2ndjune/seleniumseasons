package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleEnable {
	
	public static void main(String[] args) {
		
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
				driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
				System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
				System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
				System.out.println(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).isEnabled());
				
				driver.quit();

	}

}
