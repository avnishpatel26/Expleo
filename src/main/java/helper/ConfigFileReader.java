package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;
    public static String URL;

    public static void loadConfigs(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(Constants.PROPERTY_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("environment.properties not found at " + Constants.PROPERTY_FILE_PATH);
        }
        URL = properties.getProperty("baseURL");
    }

    public static String getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) 
        	return "chrome";
        else if(browserName.equalsIgnoreCase("firefox")) 
        	return "firefox";
        else 
        	throw new RuntimeException("Browser name key value in environment.properties is not matched : " + browserName);
    }

}
