package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdactinHotelApp {
	
	@Test(priority=1)
	public void registrationTest()
	{
		System.out.println("browser started..");
		System.out.println("App launched..");
		System.out.println("registration success..");
		System.out.println("Browser closed...");
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		System.out.println("browser started..");
		System.out.println("App launched..");
		Assert.assertTrue(false);
		System.out.println("Login success..");
		System.out.println("Browser closed...");
	}
	
	@Test(priority = 3)
	public void forgotPasswordTest()
	{
		System.out.println("browser started..");
		System.out.println("App launched..");
		System.out.println("forgot password success..");
		System.out.println("Browser closed...");
	}
	
	@Test(priority = 4,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		System.out.println("browser started..");
		System.out.println("App launched..");
		System.out.println("change password success..");
		System.out.println("Browser closed...");
	}
	

}
