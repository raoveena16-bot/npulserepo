package org.nexuspulse.patient.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
	
	WebDriver driver;
	private By FNameLocator = By.id("firstName");
	private By LNameLocator = By.id("lastName");
	
	public EditProfilePage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	public void editFirstName(String fNameValue)
	{
		
		WebElement fName = driver.findElement(FNameLocator);
		fName.clear();
		fName.sendKeys(fNameValue);
		
	}
	public String getFirstName()
	{

		String actualFName = driver.findElement(FNameLocator).getAttribute("value");
		return actualFName;
	}
	public void editLastName(String LNameValue)
	{
		
		WebElement lName = driver.findElement(LNameLocator);
		lName.clear();
		lName.sendKeys(LNameValue);
		
	}
	public String getLastName()
	{

		String actualLName = driver.findElement(LNameLocator).getAttribute("value");
		return actualLName;
	}
	public void submitProfile()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	public void handleAlerts()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}

