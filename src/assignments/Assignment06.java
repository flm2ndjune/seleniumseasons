package assignments;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment06 {

	WebDriver driver;
	@BeforeMethod
	public void browserLaunch() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void assignment06Test() throws InterruptedException {
		
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
		Thread.sleep(5000);
		
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowId : allWindows) {
			Thread.sleep(5000);
		    driver.switchTo().window(windowId);  // switch to that window
		    if(driver.getTitle().contains("Selenium Live Project")) {
		    	System.out.println(driver.getTitle()); // print its title
		    	break;
		    }
		}
		Thread.sleep(5000);
		List<WebElement> elementsToGetText=driver.findElements(By.xpath("//p[contains(text(),'Top Tutorials')]/ancestor::div[contains(@class,'wp-block-kadence-column')][1]/descendant::div[@class='kt-infobox-textcontent']/span"));
		
		for(WebElement element:elementsToGetText) {
			System.out.println(element.getText());
		}

		Thread.sleep(5000);
		// switch back to main window if you want
		driver.switchTo().window(mainWindow);
	}

	
	@AfterMethod
	public void driverQuit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
