package extratopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("https://automationexercise.com/");
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test
	public void brokenLinksTest() throws IOException 
	{
		
		List<WebElement>  allLinks=driver.findElements(By.tagName("a"));
		
		URL url=null;
		
		HttpURLConnection connection=null;
		int validLinksCount=0;
		int inValidLinkscount=0;
		
		for(WebElement link:allLinks)
		{
			String path=link.getAttribute("href");
			
			try {
				url=new URL(path);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				
				continue;
			}
			
			
			
			try {
				connection=(HttpURLConnection)url.openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				continue;
				
			}
			
			
			
			int responseCode=connection.getResponseCode();
			
			if(responseCode>=400)
			{
				System.out.println("Broken link "+link.getText()+" Status code is "+responseCode);
				validLinksCount++;
			}
			else
			{
			
				System.out.println("Valid link "+link.getText()+" Status code is "+responseCode);
				inValidLinkscount++;
			}
			
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
