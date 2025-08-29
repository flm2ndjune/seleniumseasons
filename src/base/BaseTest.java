package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("browser started..");
		System.out.println("App launched..");
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("Browser closed...");
	}

}
