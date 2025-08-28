package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=	new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		driver.manage().window().maximize();
		
		WebElement multiSelectDrop=driver.findElement(By.xpath("//*[@id=\"post-291\"]/div/div[2]/select"));
		
		Select s1=new Select(multiSelectDrop);
		
		s1.selectByVisibleText("James's flamingo");
		
		Thread.sleep(3000);
		
		s1.selectByVisibleText("Andean flamingo");
		
		Thread.sleep(3000);
		
		s1.selectByVisibleText("Lesser flamingo");
		
		Thread.sleep(3000);
		
		s1.deselectAll();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
