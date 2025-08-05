package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods3 {

	public static void main(String[] args) {
		
		WebDriver driver=	new ChromeDriver();
		driver.get("https://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table"
				+ "/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[2]")).getAttribute("checked"));
		
		driver.quit();

	}

}
