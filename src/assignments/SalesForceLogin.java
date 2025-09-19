package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class SalesForceLogin  {

	WebDriver driver;
    @BeforeTest
    public void setup() {
    	driver=new ChromeDriver();
		
		driver.get("https://www.salesforce.com/in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
    }

    @AfterTest
    public void closeBrowser() {
        
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();

    }

    @Test
    public void clickLogin() throws InterruptedException {
        SearchContext shadowRoot1 = driver
                .findElement(By
                        .cssSelector("hgf-c360nav"))
                .getShadowRoot();


        SearchContext shadowRoot2 = shadowRoot1
                .findElement(By
                        .cssSelector("hgf-c360login[aria-haspopup]")).getShadowRoot();


        SearchContext shadowRoot3 = shadowRoot2
                .findElement(By
                        .cssSelector("hgf-button[aria-controls='login-unauth-content']"))
                .getShadowRoot();


        WebElement login = shadowRoot3.findElement(By.cssSelector("button"));

            new Actions(driver)
                .moveToElement(login)
                .pause(Duration.ofSeconds(2))
                .moveToElement(shadowRoot2.findElement(By.cssSelector("a[data-tracking-stable='salesforceLogin'")))
                .pause(Duration.ofSeconds(2))
                .click()
                .build()
                .perform();

        Thread.sleep(5000);

    }
}
