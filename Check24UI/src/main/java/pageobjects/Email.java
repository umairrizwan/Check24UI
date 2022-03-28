package pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utilities.UtilHelper;

public class Email extends TestBase{
	
	
	@FindBy(xpath = "//input[@id='cl_login']")
	WebElement emailTxtField;
	
	@FindBy(xpath =  "//button[@id='c24-uli-login-btn']")
	WebElement weiterBttn;
	
	@FindBy(xpath = "//div[contains(text(),'Ich möchte als Gast fortfahren')]")
	WebElement radioBttn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/unified-login[1]/div[1]/div[1]/div[2]/div[5]/form[1]/div[3]/button[1]")
	WebElement weiterBttn2;
	
	public void fillEmail(String email) throws InterruptedException
	{
		UtilHelper.waitForWebElementToBeVisible(driver, emailTxtField, 5).sendKeys(email);;
		
		UtilHelper.waitForWebElementToBeVisible(driver, weiterBttn, 5);
		
		UtilHelper.clickElementByJS(weiterBttn, driver);
		
	}
	
	public void clickOnRadioBttn()
	{
		UtilHelper.waitForWebElementToBeVisible(driver, radioBttn, 5);
		UtilHelper.clickElementByJS(radioBttn, driver);
		
		UtilHelper.waitForWebElementToBeVisible(driver, weiterBttn2, 5);
		UtilHelper.clickElementByJS(weiterBttn2, driver);
		
	}
	
	public Email() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	

}
