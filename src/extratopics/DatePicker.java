package extratopics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker {
	

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test
	public void datePickerTest() throws IOException, InterruptedException 
	{
		
		driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
		
		
		String targetDay="10";
		String targetMonth="April";
		String targetYear="2026";
		int firstIndex=1;
		int secondIndex=2;
		while(true)
		{
			
		WebElement monthYearElement1=driver.findElement(By.xpath("(//div[contains(@data-testid,'undefined-month-')])["+firstIndex+"]/descendant::div[2]"));
		String displayedMonthYear1=monthYearElement1.getText();
		
		WebElement monthYearElement2=driver.findElement(By.xpath("(//div[contains(@data-testid,'undefined-month-')])["+secondIndex+"]/descendant::div[2]"));
		String displayedMonthYear2=monthYearElement2.getText();
		
		if((displayedMonthYear1.contains(targetYear) && displayedMonthYear1.contains(targetMonth)) ||
				(displayedMonthYear2.contains(targetYear) && displayedMonthYear2.contains(targetMonth)))
		{
			break;
		}
		else
		{
			driver.findElement(By.xpath("(//*[name()='svg'])[18]")).click();
			Thread.sleep(2000);
			firstIndex=firstIndex+2;
			secondIndex=secondIndex+2;
		}
			
		}
		
		String part1="//div[@data-testid='undefined-month-";
		String part2="']/descendant::div[text()='";
		String part3="']";

		driver.findElement(By.xpath(part1+targetMonth+"-"+targetYear+part2+targetDay+"']")).click();
		
	
		
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
