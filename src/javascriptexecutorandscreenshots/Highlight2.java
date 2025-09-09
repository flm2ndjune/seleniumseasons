package javascriptexecutorandscreenshots;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Highlight2 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void loginTest() throws InterruptedException
	{
		
		Thread.sleep(2000);
		WebElement usernameTextbox=driver.findElement(By.xpath("//input[@name='username']"));
		highlightElement(usernameTextbox);
		usernameTextbox.sendKeys("reyaz0806");
		Thread.sleep(2000);
		
		
		WebElement passwordTextboxd=driver.findElement(By.xpath("//input[@name='password']"));
		highlightElement(passwordTextboxd);
		passwordTextboxd.sendKeys("reyaz123");
		Thread.sleep(2000);
		
		
		WebElement loginButton=driver.findElement(By.xpath("//input[@name='login']"));
		highlightElement(loginButton);
		loginButton.click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
		Thread.sleep(2000);
		
		WebElement logoutButton=driver.findElement(By.xpath("//a[text()='Logout']"));
		highlightElement(logoutButton);
		logoutButton.click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Logout");
		Thread.sleep(2000);
		
		WebElement loginAgainLink=driver.findElement(By.xpath("//a[text()='Click here to login again']"));
		highlightElement(loginAgainLink);
		loginAgainLink.click();
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
		
	}
	
	private void highlightElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].style.border=''", element);
		
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