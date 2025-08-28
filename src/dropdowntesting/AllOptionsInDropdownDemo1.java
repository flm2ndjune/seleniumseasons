package dropdowntesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllOptionsInDropdownDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		driver.manage().window().maximize();
		
		WebElement countryDropdown=driver.findElement(By.id("Form_getForm_Country"));
		
		List<WebElement> allItems=countryDropdown.findElements(By.tagName("option"));
		
		System.out.println("No of countries "+(allItems.size()-1));
		
		for(int i=1;i<allItems.size();i++)
		{
			System.out.println(allItems.get(i).getText());
		}
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
