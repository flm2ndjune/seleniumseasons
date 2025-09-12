package webtables;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicTable {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.timeanddate.com/worldclock/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void webTableTest()
	{
		
		WebElement  table=driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']/child::tbody"));
		
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		for(WebElement row:rows)
		{
			List<WebElement>  cols=row.findElements(By.tagName("td"));
			for(WebElement col:cols)
			{
			System.out.print(col.getText()+"\t");	
			}
			System.out.println();
		}
		
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}