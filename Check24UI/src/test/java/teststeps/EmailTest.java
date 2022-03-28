package teststeps;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Email;
import pageobjects.Home;

public class EmailTest extends TestBase{

	public EmailTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Home homepage;
	Email emailpage;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Home();
	    emailpage = new Email();
	//	homepage.clickOnpopUpBttn();
		homepage.clickOnWeiterBttn();
		
	}
	
	@Test
	public void fillEmail() throws InterruptedException
	{
		emailpage.fillEmail(properties.getProperty("emailaddress"));
		emailpage.clickOnRadioBttn();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
