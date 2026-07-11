package org.iitwf.nexuspulse.admin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientApprovalPage {

	WebDriver driver;
	public PatientApprovalPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	public void approvePatient(String patientName) {

		List<WebElement> pageList = driver.findElements(By.xpath("//div[@class='pagination-controls']/a"));
		for( int i=1;i<pageList.size()-1;i++)
		{
		 
			try {
				WebElement approvePatientWE = driver.findElement(By.xpath("//td[text()='"+patientName+"']/following-sibling::td[4]/form/button[contains(text(),'Approve')]"));
				boolean approveButtonExists= approvePatientWE.isEnabled();                    
					if(approveButtonExists)
					{
						approvePatientWE.click();
						pageList = driver.findElements(By.xpath("//div[@class='pagination-controls']/a"));
						pageList.get(i-2).click();
						break;
					}
					else
					{
						System.out.println("Approve Button Doesnt Exists");
					}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			pageList = driver.findElements(By.xpath("//div[@class='pagination-controls']/a"));
			pageList.get(i).click();

			//index - pageno 
			//    0 - prev
			//    1 - page1
			//    2 - page2
		}



	}
	public String fetchApprovedStatusMessage(String patientName)
	{
		List<WebElement> trList = driver.findElements(By.xpath("//table[@class='patients-table']/tbody/tr[td[text()='"+patientName+"']]"));
		String acutalData = trList.get(0).getText();
		return acutalData;
	}
	 
}















