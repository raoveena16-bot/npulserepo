package org.nexuspulse.patient.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nexusPulse.AppLibrary;

public class RegistrationPage {
	
	WebDriver driver;
	private By userFNameLocator = By.id("firstName");
	private By userLNameLocator = By.id("lastName");
	private By usernameLocator = By.id("username");
	private By userPasswordLocator = By.id("password");
	private By userEmailLocator = By.id("email");
	private By userPhoneLocator = By.id("phone");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String registerPatient()
	{
		driver.findElement(userFNameLocator).sendKeys("NexusFName");
		driver.findElement(userLNameLocator).sendKeys("NexusLName");
		String uname= AppLibrary.randomString("NexusUName");
		System.out.println("unique Username:::" + uname);
		driver.findElement(usernameLocator).sendKeys(uname);
		driver.findElement(userPasswordLocator).sendKeys(uname);
		driver.findElement(userEmailLocator).sendKeys(uname+"@gmail.com");
		driver.findElement(userPhoneLocator).sendKeys("1234567891");
		Select gender = new Select(driver.findElement(By.id("gender")));
		gender.selectByVisibleText("Male");
		WebElement dob = driver.findElement(By.id("dob"));
		dob.sendKeys("1990-01-01");
		driver.findElement(By.xpath("//button[text()='Register']")).submit();
		Alert alrt = driver.switchTo().alert();
		return alrt.getText(); 
	}
}


		


		


