package pageobjects;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Home extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Akzeptieren')]")
	WebElement popupBttn;
	
	@FindBy(xpath="//body/div[@id='c24-page-and-ads']/div[@id='c24-page-container-content']/div[@id='c24-page-content']/div[@id='c24-content']/div[@id='c24']/main[@id='result']/div[2]/div[1]/div[4]/div[4]/div[5]/div[3]/div[3]/a[1]")
	WebElement weiterBttn;
	
	public Home() throws IOException
	{
		PageFactory.initElements(driver, this);			
		popupBttn.click();		
	}
	
	
	public void clickOnWeiterBttn()
	{
		weiterBttn.click();
	}
	
	public boolean checkCookie(String cookie)
	
	{		
		
		boolean result = false;
		Cookie cookiee = driver.manage().getCookieNamed("ppset");		
		
		if(cookie.equals(cookiee.toString()))
		{
			result = true;
		}
		return result;
		
	}
	
	public String homePageTitleVerify()
	{
		 String title = driver.getTitle();
		 return title;
	}
	

}
