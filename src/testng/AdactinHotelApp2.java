package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class AdactinHotelApp2 extends BaseTest {
	
	
	@Test(priority=1)
	public void registrationTest()
	{
		
		System.out.println("registration success..");
		
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		String expTitle="Adactin.com - Search Hotel";
		String actTitle="Adactin.com - Search Hotel";
		Assert.assertTrue(expTitle.equals(actTitle));
		System.out.println("Login success..");
		
	}
	
	@Test(priority = 3)
	public void forgotPasswordTest()
	{
		
		System.out.println("forgot password success..");
		
	}
	
	@Test(priority = 4,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		
		System.out.println("change password success..");
		
	}
	


	
}
