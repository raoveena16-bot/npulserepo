package org.iitwf.nexuspulse;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;


public class BaseClass {

	protected WebDriver driver;
	protected Properties prop;
	String environment,browserType;
	
	

	@BeforeTest
	public void loadProperties() throws IOException
	{
		prop = AppLibrary.readConfig("global.properties");
		environment = prop.getProperty("environment");
		browserType = prop.getProperty("browserType");
		if(environment.equals("qa"))
		{
			prop =  AppLibrary.readConfig("qa.properties");
		}
		else if(environment.equals("stage"))
		{
			prop =  AppLibrary.readConfig("stage.properties");
		}
		else
		{
			prop =  AppLibrary.readConfig("prod.properties");
		}
	}
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		DriverFactory.initDriver(browserType);
		driver= DriverFactory.getDriver();
		 
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public void captureAlertScreenshot(String fileName) {
	    try {
	        Robot robot = new Robot();
	        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	        ImageIO.write(screenFullImage, "png", new File(fileName));
	        System.out.println("Alert screenshot saved: " + fileName);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	


}
