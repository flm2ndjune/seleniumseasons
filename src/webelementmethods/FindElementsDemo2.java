package webelementmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsDemo2 {

	public static void main(String[] args) {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		WebElement block=driver.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
		//List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(int i=0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
		}
		
		driver.quit();

	}

}
