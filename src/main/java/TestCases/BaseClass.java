package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadProperty;
import Utilities.XLUtils;

public class BaseClass {
	XLUtils xl=new XLUtils();
	ReadProperty rp=new ReadProperty();
	public String baseURLBS=rp.getUrl();
	public  String UsernameBS=rp.getUser();
	public String passwordBS=rp.getPass();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Aotoit1\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger=logger.getLogger("guruBanking");
		PropertyConfigurator.configure("log4j.properties");		
	}
	@AfterClass
	public void tearUp()
	{
		driver.quit();
	}
	
}
