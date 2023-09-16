package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject {

	WebDriver ldriver;
	
	public LoginPageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	
	@FindBy(name="password")
	WebElement PAssword;
	
	public void setPAssword(String pass)
	{
		PAssword.sendKeys(pass);
	}
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logout;
	
	public void clickOnLogout()
	{
		logout.click();
	}
}
