package org.nexuspulse.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	

		WebDriver driver;
		private By userNameLocator = By.name("username");
		private By passwordLocator = By.name("password");
		
		public AdminLoginPage(WebDriver driver)
		{
			this.driver = driver;		
		}
		public void adminLogin(String uName,String pWord) {
			 
			driver.findElement(userNameLocator).sendKeys(uName);
			driver.findElement(passwordLocator).sendKeys(pWord);
			driver.findElement(By.xpath("//button[@class='btn-primary']")).click();
		}
	}


