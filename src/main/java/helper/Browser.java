package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser{

    public static WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null) driver = createDriver();
        return driver;
    }

    public static WebDriver createDriver() {
        switch (ConfigFileReader.getBrowser()) {
            case "firefox" :
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ Constants.FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}
