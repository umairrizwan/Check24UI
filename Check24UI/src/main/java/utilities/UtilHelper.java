package utilities;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilHelper {
	
public UtilHelper() throws IOException {
		
	}

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 10;

	
	  public static WebElement waitForWebElementToBeVisible(WebDriver driver, WebElement webelement,int seconds)
	    {
	       WebDriverWait wait = new WebDriverWait(driver,seconds);
	       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
	       return  element;
	    }
	  
	  public static void clickElementByJS(WebElement element, WebDriver driver)
	  {
		  JavascriptExecutor js = ((JavascriptExecutor)driver);
		  js.executeScript("arguments[0].click();", element);
	  }
}
