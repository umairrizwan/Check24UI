package teststeps;

import java.io.IOException;
import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Home;

public class HomeTest extends TestBase{
	
	public HomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Home homepage;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Home();
		
	}
	
	@Test
	public void openUrl() throws InterruptedException
	{
		boolean cookieCheck = homepage.checkCookie(properties.getProperty("cookie"));
	
		Assert.assertTrue(cookieCheck);
		homepage.clickOnWeiterBttn();
	}
	
	@Test
	public void verifyHomePageTitle()
	{
		String title = homepage.homePageTitleVerify();
		Assert.assertEquals(title, properties.getProperty("homePagetitle"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
