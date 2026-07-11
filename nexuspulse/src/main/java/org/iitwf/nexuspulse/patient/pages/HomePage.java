package org.iitwf.nexuspulse.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigateToAModule(String module)
	{
		driver.findElement(By.xpath("//span[text()='"+module+"']")).click();
		
	}
}
