package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabled {
	
	public static void main(String[] args) {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-08/08/2025&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.id("search-button")).isEnabled());
		
		driver.quit();
		
		
	}

}
