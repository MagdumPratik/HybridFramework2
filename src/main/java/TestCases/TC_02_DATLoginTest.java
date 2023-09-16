package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPageObject;

public class TC_02_DATLoginTest extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pass)
	{
		driver.get(baseURLBS);
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setUsername(user);
		lp.setPAssword(pass);
		lp.clickOnLogin();

		if(alertIsPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test Case PAssed");
			lp.clickOnLogout();
			driver.switchTo().alert().accept();
			driver.navigate().refresh();
			
		}
	}
	
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getLoginData() throws IOException
	{
		String excelFilePath=".\\DATTestDATa\\LoginData1.xlsx";
		int rowcount=xl.getRowCount(excelFilePath, "Sheet1");
		int cellCount=xl.getCellCount(excelFilePath, "Sheet1", 1);
		
		String[][] loginData=new String[rowcount][cellCount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int c=0;c<cellCount;c++)
			{
				loginData[i-1][c]=xl.getCellData(excelFilePath, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}
