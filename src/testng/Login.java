package testng;

import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void validUsernameAndValidPassword()
	{
		System.out.println("Login successful..");
	}
	
	@Test
	public void validUsernameAndInValidPassword()
	{
		System.out.println("Error Message displayed..");
	}
	
	@Test
	public void invalidUsernameAndValidPassword()
	{
		System.out.println("Error Message displayed..");
	}

	
	@Test
	public void invalidUsernameAndInValidPassword()
	{
		System.out.println("Error Message displayed..");
	}

	@Test
	public void emptyUsernameAndEmptyPassword()
	{
		System.out.println("InlineError displayed..");
	}
	
	@Test
	public void onlyPasswordEmpty()
	{
		System.out.println("InlineError displayed..");
	}
	
	@Test
	public void onlyUsernameEmpty()
	{
		System.out.println("InlineError displayed..");
	}
	
	@Test
	public void pendingEmailVerification()
	{
		System.out.println("Email pending verification error displayed..");
	}

}
