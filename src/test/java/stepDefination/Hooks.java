package stepDefination;

import cucumber.api.java.After;
import helper.Browser;

public class Hooks {
	
	@After
	public void afterHook()
	{
		try {
		if(Browser.driver!=null)
			Browser.closeDriver();
		}
		catch(Exception e) {}
	}
}
