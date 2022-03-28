package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.UtilHelper;

public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase() throws IOException
	{
	     properties = new Properties();
	     FileInputStream inp = new FileInputStream("C:\\Config\\configuration.properties");
	     properties.load(inp);
	}

	public static void initialization() 
	{
		String browser = properties.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Config\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		driver.get(properties.getProperty("url"));
	 	driver.manage().timeouts().pageLoadTimeout(UtilHelper.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 	driver.manage().timeouts().implicitlyWait(UtilHelper.IMPLICIT_WAIT, TimeUnit.SECONDS);	 	
	 	
	}	

}
