package teststeps;

import java.io.IOException;
import java.text.Normalizer.Form;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Email;
import pageobjects.Home;
import pageobjects.FormFill;

public class FormTest extends TestBase{
	
	Home homepage;
	Email emailpage;
	FormFill formpage;

	public FormTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Home();
		homepage.clickOnWeiterBttn();
	    emailpage = new Email();
	    emailpage.fillEmail(properties.getProperty("emailaddress"));
	    emailpage.clickOnRadioBttn();
	    
	    formpage = new FormFill();
	   
	}
	

	@Test
	public void verifyFormErrorMessage() 
	{
		formpage.clickOnFormBttn();
		boolean errorMsgConfirm = formpage.verifyErrorMessage(properties.getProperty("salutation"), properties.getProperty("firstname"), properties.getProperty("lastname"), properties.getProperty("dob"), properties.getProperty("mobilenumber"));
		Assert.assertTrue(errorMsgConfirm);
		formpage.fillForm(properties.getProperty("firstnameForm"), properties.getProperty("lastnameForm"), properties.getProperty("dobForm"), properties.getProperty("mobileNoForm"));
		
	}
	
	@Test
	public void formPageTitleVerify()
	{
		String title =  formpage.formPageTitleVerify();
		Assert.assertEquals(title, properties.getProperty("formPagetitle"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
