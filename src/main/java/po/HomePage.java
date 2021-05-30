package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ConfigFileReader;
import helper.GenericFunctions;

public class HomePage extends GenericFunctions {

	WebDriver driver;
	
	@FindBy(id = "amount")
	private WebElement amountTxtbox;
	
	@FindBy(id="midmarketFromCurrency")
	private WebElement fromCurrencyTxtbox;
	
	@FindBy(id="midmarketToCurrency")
	private WebElement toCurrencyTxtbox;
	
	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	private WebElement acceptCookiesOKBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Convert')]")
	private WebElement convertBtn;
	
	@FindBy(xpath = "//p[contains(@class,'result__BigRate')]")
	private WebElement convertedAmountLbl;
	
	String conversionRate_startXpath = "//div[contains(@class,'unit-rates')]/p[contains(text(),'1 ";
	String conversionRate_endXpath = "')]";
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToLoginPage() {
		driver.get(ConfigFileReader.URL);
	}
	
	public void acceptCookies(){
		GenericFunctions.click(driver, acceptCookiesOKBtn, "Accept Cookies OK");
	}
	
	public void fillDetails(String amount, String fromCCY, String toCCY) {
		GenericFunctions.enterText(driver, amountTxtbox, amount, "Amount");
		GenericFunctions.enterTextInAutoCompleteTextBox(driver, fromCurrencyTxtbox, fromCCY, "From Currency");
		GenericFunctions.enterTextInAutoCompleteTextBox(driver, toCurrencyTxtbox, toCCY, "To Currency");
	}
	
	public void clickOnConvertBtn()
	{
		GenericFunctions.click(driver, convertBtn, "Convert");
	}
	
	public String getConversionRate(String fromCCY)
	{
		String xpath = conversionRate_startXpath + fromCCY + conversionRate_endXpath;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return GenericFunctions.getText(driver, driver.findElement(By.xpath(xpath)), "Conversion Rate");
	}
	
	public String getConvertedAmount()
	{
		return GenericFunctions.getText(driver, convertedAmountLbl, "Converted Amount");
	}

}
