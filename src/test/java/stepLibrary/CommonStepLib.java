package stepLibrary;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import helper.Browser;
import helper.ConfigFileReader;
import po.HomePage;


public class CommonStepLib {
	
	public static WebDriver driver;
	public static String amount, fromCurrency, toCurrency;
	public static HomePage homePO;
	
	public CommonStepLib() 
	{
		ConfigFileReader.loadConfigs();
	}
	
	public void navigateToHomePage()
	{
		driver = Browser.createDriver();
		driver.navigate().to(ConfigFileReader.URL);
		Assert.assertEquals("Xe Currency Converter | Foreign Exchange Rates Calculator", driver.getTitle());
	}
	
	public void enterAmountAndCurrencies(String amt, String fromCCY, String toCCY)
	{
		amount = amt;
		fromCurrency = fromCCY;
		toCurrency = toCCY;
		homePO = new HomePage(driver);
		homePO.acceptCookies();
		homePO.fillDetails(amt, fromCCY, toCCY);
	}
	
	public void clickOnConvertButton()
	{
		homePO = new HomePage(driver);
		homePO.clickOnConvertBtn();
	}
	
	public void verifyCurrencyConversion()
	{
		homePO = new HomePage(driver);
		String rate = homePO.getConversionRate(fromCurrency);
		BigDecimal conversionRate = new BigDecimal(rate.split("=")[1].trim().split(" ")[0]);
		Reporter.addStepLog("Amount : " + amount + " " + fromCurrency);
		Reporter.addStepLog("Conversion Rate: " + rate);
		BigDecimal actualConvertedAmount = new BigDecimal(homePO.getConvertedAmount().replace(",","").trim().split(" ")[0]).setScale(2, RoundingMode.FLOOR);
		Reporter.addStepLog("Actual Converted Amount : " + actualConvertedAmount + " " + toCurrency);
		//BigDecimal expectedConvertedAmount = new BigDecimal(amount).multiply(new BigDecimal(conversionRate)).round(m);
		BigDecimal expectedConvertedAmount = new BigDecimal(amount).multiply(conversionRate).setScale(2, RoundingMode.FLOOR);
		Reporter.addStepLog("Expected Converted Amount : " + expectedConvertedAmount + " " + toCurrency);
		Assert.assertEquals(expectedConvertedAmount, actualConvertedAmount);
	}
	
	public void closeBrowser()
	{
		Browser.closeDriver();
	}
}
