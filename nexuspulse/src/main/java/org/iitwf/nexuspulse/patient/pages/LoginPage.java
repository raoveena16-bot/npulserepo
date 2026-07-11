package org.iitwf.nexuspulse.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


	private By userNameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By submitButtonLocator = By.xpath("//button[@class='btn-primary']");
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void login(String uName,String pWord)
	{
		driver.findElement(userNameLocator).sendKeys(uName);
		driver.findElement(passwordLocator).sendKeys(pWord);
		driver.findElement(submitButtonLocator).click();
	}
	public RegisterPage register()
	{
		driver.findElement(By.xpath("//a[text()='New user? Register']")).click();
		return new RegisterPage(driver);
	}
}
