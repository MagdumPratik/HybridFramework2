package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPageObject;

public class TC_01_LoginTest extends BaseClass{

	@Test
	public void loginTest()
	{
		driver.get(baseURLBS);
		logger.info("Url opened");
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setUsername(UsernameBS);
		logger.info("USername is set");
		lp.setPAssword(passwordBS);
		logger.info("Password is set");
		lp.clickOnLogin();
		logger.info("loginButton clicked");
		System.out.println("2***"+driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case PAssed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
	}
}
