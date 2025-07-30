package browserlaunching;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch {

	public static void main(String[] args) {
		
		//approach 1
		//seleneium 3.141.59
		System.setProperty("webdriver.chrome.driver", "D:\\FLM2ndJune\\jars\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		new ChromeDriver();
		

	}

}
