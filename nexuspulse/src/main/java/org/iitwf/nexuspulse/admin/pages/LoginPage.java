package org.iitwf.nexuspulse.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	public void adminLogin(String uName,String pWord) {
		 
		driver.findElement(By.name("username")).sendKeys(uName);
		driver.findElement(By.name("password")).sendKeys(pWord);
		driver.findElement(By.xpath("//button[@class='btn-primary']")).click();
	}
}
