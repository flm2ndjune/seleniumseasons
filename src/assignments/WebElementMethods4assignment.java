package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods4assignment {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(3000);
		driver.findElement(By.tagName("i")).click();
		Thread.sleep(3000);
		
		WebElement div = driver.findElement(By.id("flash"));

        // Get full text of div
        String fullText = div.getText();
        System.out.println("fullText"+fullText);

        // Get text of the <a> tag
        String linkText = div.findElement(By.tagName("a")).getText();
        System.out.println("linkText"+linkText);

        // Remove the <a> text from the full text
        String result = fullText.replace(linkText, "").trim();

        System.out.println("Text without <a>: " + result);

		System.out.println(driver.findElement(By.id("flash")).getCssValue("border-color"));
		//driver.findElement(By.tagName("a")).click();
		
		//driver.findElement(By.className("icon-2x icon-signout")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("flash")).getText());
		driver.quit();

	}

}