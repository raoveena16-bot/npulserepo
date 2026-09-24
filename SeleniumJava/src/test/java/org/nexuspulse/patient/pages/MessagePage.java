package org.nexuspulse.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import nexusPulse.AppLibrary;

public class MessagePage {
WebDriver driver;
	
	public MessagePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String  sendMessage(String message)
	{
		
		driver.findElement(By.xpath("//textarea[@placeholder='Type your message here...']")).sendKeys(message);
		driver.findElement(By.xpath("//button[text()='Send']")).click();
		return message;
	}
	
	public  String checkMessage(String expectedMessage)
	{
		
		
		String displayedMessage = driver.findElement(By.xpath("//table[@class='table-styled']/tbody/tr/td[text()='" + expectedMessage + "']")).getText();
		

		return displayedMessage;
		
}
}