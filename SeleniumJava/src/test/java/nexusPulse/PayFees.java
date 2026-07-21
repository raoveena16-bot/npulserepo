package nexusPulse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayFees {
	
	
	WebDriver driver;
	
	@Test 
	public void payFees() {
		
		driver = new ChromeDriver();
		driver.get("http://82.197.92.72:8080/patient/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("patient1");
		driver.findElement(By.name("password")).sendKeys("Mmp@2025!Patient#93");
		driver.findElement(By.xpath("//button[@class='btn-primary']")).click();
		driver.findElement(By.xpath("//span[text()='Fees']")).click();
		String actualText = driver.findElement(By.xpath("//h2[text()='My Fees']")).getText();
		String expectedText = "My Fees";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Fees page is displayed successfully");
		
	}
   
	
}
