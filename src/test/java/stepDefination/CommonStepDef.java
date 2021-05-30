package stepDefination;

import cucumber.api.java.en.When;
import helper.Browser;
import stepLibrary.CommonStepLib;


public class CommonStepDef extends Browser{

    CommonStepLib commonStepLibs = new CommonStepLib();

    @When("^user navigates to Xe currency convertor Home Page$")
    public void user_navigates_to_Xe_currency_convertor_Home_Page() {
    	commonStepLibs.navigateToHomePage();
    }
    
    @When("^user enters amount as '(.+)', from currency as '(.+)' and to currency as '(.+)'$")
    public void user_enters_amount_as_Amount_from_currency_as_EUR_and_to_currency_as_GBP(String amount, String fromCCY, String toCCY){
    	commonStepLibs.enterAmountAndCurrencies(amount, fromCCY, toCCY);
    }
    
    @When("^user clicks on convert button$")
    public void user_clicks_on_convert_button() {
    	commonStepLibs.clickOnConvertButton();
    }
    
    @When("^user verifies converted currency amount$")
    public void user_verifies_converted_currency_amount() {
    	commonStepLibs.verifyCurrencyConversion();
    }
    
    @When("^user closes the web browser$")
    public void user_close_the_web_browser() {
    	commonStepLibs.closeBrowser();
    }

}
