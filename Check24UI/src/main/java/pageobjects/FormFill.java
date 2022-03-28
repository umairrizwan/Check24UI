package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utilities.UtilHelper;

public class FormFill extends TestBase{

	public FormFill() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//body/div[@id='c24-page-and-ads']/div[@id='c24-page-container-content']/div[@id='c24-page-content']/div[@id='c24-content']/div[@id='c24']/div[@id='application-form']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement weiterBttn;
	
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[1]/div[2]/div[1]/div[2]/label[1]")
	WebElement salutationMsg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[2]/div[1]/div[1]/div[2]/label[1]")
	WebElement firstNameMsg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[2]/div[1]/div[1]/div[3]/label[1]")
	WebElement lastNameMsg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[3]/div[1]/div[1]/div[2]/label[1]")
	WebElement dateOfBirthMsg;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[4]/div[1]/div[1]/div[2]/label[1]")
	WebElement mobileNumberMsg;
	
	//Text boxes
	//************************************
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	WebElement salutataionTxtBox;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstnameTxtBox;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement lastnameTxtBox;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement dobtxtBox;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/section[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement mobileTxtBox;	
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]/font[1]/font[1]")
	WebElement secondFormMessage;
	
	
	
	public void clickOnFormBttn()
	{		
		UtilHelper.waitForWebElementToBeVisible(driver, weiterBttn, 5);
		UtilHelper.clickElementByJS(weiterBttn, driver);		
	}
	
	public boolean verifyErrorMessage(String salutationmsg, String firstName, String lastName, String dobmsg, String mobilenumbermsg)
	{
		boolean value = false;
		
		String salut = salutationMsg.getText();
		String fn = firstNameMsg.getText();
		String ln = lastNameMsg.getText();
		String dob = dateOfBirthMsg.getText();
		String mob = mobileNumberMsg.getText();
				
		
		if(salut.equals(salutationmsg) && fn.equals(firstName) && ln.equals(lastName) && dob.equals(dobmsg) && mob.equals(mobilenumbermsg))
	
		{
			value=true;			
		}
		
		return value;
	}
	
	public void fillForm(String firstName, String lastName, String dobmsg, String mobilenumbermsg) 
	{
		UtilHelper.waitForWebElementToBeVisible(driver, salutataionTxtBox, 5);
		salutataionTxtBox.click();
		firstnameTxtBox.sendKeys(firstName);
		lastnameTxtBox.sendKeys(lastName);
		dobtxtBox.sendKeys(dobmsg);
		mobileTxtBox.sendKeys(mobilenumbermsg);
		
		UtilHelper.waitForWebElementToBeVisible(driver, weiterBttn, 5);
		UtilHelper.clickElementByJS(weiterBttn, driver);		
		
	}
	
	public String formPageTitleVerify()
	{
		 String title = driver.getTitle();
		 return title;
	}

	
}
