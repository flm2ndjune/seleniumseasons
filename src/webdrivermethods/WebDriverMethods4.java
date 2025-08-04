package webdrivermethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods4 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getWindowHandle());
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		System.out.println(driver.getWindowHandle());
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		
		System.out.println(driver.getWindowHandle());
		
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		
		System.out.println(driver.getWindowHandle());
		
		//driver.navigate().to("https://www.facebook.com/");
		
		URL fbURL=new URL("https://www.facebook.com/");
		
		driver.navigate().to(fbURL);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getWindowHandle());
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
