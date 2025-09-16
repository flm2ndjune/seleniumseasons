package extratopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDOM {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("https://automationexercise.com/");
		
		driver.get("http://watir.com/examples/shadow_dom.html");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test
	public void shadowDOMTest() throws IOException 
	{
		
	
			//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("flm2ndjune");
		
		WebElement shadowHost1=driver.findElement(By.xpath("//div[@id='shadow_host']"));
		SearchContext shadowRoot1=shadowHost1.getShadowRoot();
		//WebElement textbox=shadowRoot1.findElement(By.xpath("//input[@type='text']"));
		WebElement textbox=shadowRoot1.findElement(By.cssSelector("input[type='text']"));
		textbox.sendKeys("flm22ndjune");
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
