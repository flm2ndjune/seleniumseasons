package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FewLinksTesting4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement block=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[5]"));
		
		List<WebElement> allLinksInBlock=block.findElements(By.tagName("a"));
		
		System.out.println("No of links in Module "+allLinksInBlock.size());
		
		for(int i=0;i<allLinksInBlock.size();i++)
		{
			WebElement link= allLinksInBlock.get(i);
			System.out.println(link.getText());
			System.out.println(link.getDomAttribute("href"));
			link.click();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(2000);
			block=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[5]"));
			allLinksInBlock=block.findElements(By.tagName("a"));
		}
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
