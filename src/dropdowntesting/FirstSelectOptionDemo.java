package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSelectOptionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		driver.manage().window().maximize();
		
		WebElement countryDropdown=driver.findElement(By.id("Form_getForm_Country"));
		Select s1=new Select(countryDropdown);
		System.out.println(s1.getFirstSelectedOption().getText());
		
		
		WebElement noOfEmpDropdown=driver.findElement(By.id("Form_getForm_NoOfEmployees"));
		Select s2=new Select(noOfEmpDropdown);
		System.out.println(s2.getFirstSelectedOption().getText());
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
