package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

public class GenericFunctions {

    public static void click(WebDriver driver, WebElement element, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
            element.click();
        }
        catch(Exception e)
        {
        	Reporter.addStepLog("Unable to click at element : " + elementName + " " + e.getMessage());
        }
    }

    public static void enterText(WebDriver driver, WebElement element, String text, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
        	element.clear();
            element.sendKeys(text);
        }
        catch(Exception e)
        {
        	Reporter.addStepLog("Unable to enter text in : " + elementName + " " + e.getMessage());
        }
    }
    
    public static void enterTextInAutoCompleteTextBox(WebDriver driver, WebElement element, String text, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
        	element.clear();
            element.sendKeys(text + Keys.ENTER);
        }
        catch(Exception e)
        {
        	Reporter.addStepLog("Unable to enter text in : " + elementName + " " + e.getMessage());
        }
    }
    
    public static void waitForPageLoaded(WebDriver driver) 
	{
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
        	Reporter.addStepLog("Timeout while waiting for Page Load Request to complete.");
        }
    }
    
    public static void moveToElement(WebDriver driver, WebElement element, String elementName)
    {
    	try
    	{
    		Actions act = new Actions(driver);
    		act.moveToElement(element).perform();
    	}
    	catch(Exception e)
    	{
    		Reporter.addStepLog("Unable to move to Element: " + elementName + " " + e.getMessage());
    	}
    }
    
    public static String getText(WebDriver driver, WebElement element, String elementName)
    {
    	waitForPageLoaded(driver);
    	moveToElement(driver, element, elementName);
    	return element.getText();
    }
    
}
