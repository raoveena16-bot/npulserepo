package org.iitwf.nexuspulse.patient.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
	
	WebDriver driver;
	public EditProfilePage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	public void editFirstName(String fNameValue)
	{
		
		WebElement fName = driver.findElement(By.id("firstName"));
		fName.clear();
		fName.sendKeys(fNameValue);
		
	}
	public String getFirstName()
	{

		String actualFName = driver.findElement(By.id("firstName")).getAttribute("value");
		return actualFName;
	}
	public void editLastName(String LNameValue)
	{
		
		WebElement lName = driver.findElement(By.id("lastName"));
		lName.clear();
		lName.sendKeys(LNameValue);
		
	}
	public String getLastName()
	{

		String actualLName = driver.findElement(By.id("lastName")).getAttribute("value");
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
