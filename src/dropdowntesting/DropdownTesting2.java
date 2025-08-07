package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTesting2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=	new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//using Select class 
		
		//using selectByIndex
		//WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		//Select s1=new Select(drop);
		//s1.selectByIndex(11);
		
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByIndex(11);
		
		
		//selectByValue(String):void
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByValue("search-alias=stripbooks");
		
		//selectByVisibleText(String):void
		new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
		

	}

}
