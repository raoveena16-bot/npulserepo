package nexusPulse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	//Declares WebDriver at class level so child test classes can use it	
	protected WebDriver driver;

	//Declares a Properties object to store key‑value configuration.
	protected Properties prop;

	//Variables to store environment (qa/stage/prod) and browser type (chrome/edge).
	String environment, browserType;


@BeforeTest

public void loadProperties() throws IOException {
	
	//Reads the global.properties file using AppLibrary.readConfig() method.
	prop= AppLibrary.readConfig("global.properties");
	
	//Extracts values from the global properties file and store them in variables
	environment = prop.getProperty("environment");
	browserType = prop.getProperty("browserType");
	
	}

@BeforeClass


public void instantiateDriver() throws IOException {
    
	//Calls DriverFactory to initialize the driver based on browser type.
	DriverFactory.initDriver(browserType);   
    
	//Retrieves the initialized WebDriver instance from DriverFactory.
	driver = DriverFactory.getDriver(); 
	
	if (environment.equals("qa"))
	{ prop = AppLibrary.readConfig("qa.properties");
	
	}
	else if (environment.equals("stage"))
	{ prop= AppLibrary.readConfig("stage.properties");
	
	}
	else
	{
		prop= AppLibrary.readConfig("prod.properties");
	}
	}
	
	

	public void launchBrowser(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		
	}

}
