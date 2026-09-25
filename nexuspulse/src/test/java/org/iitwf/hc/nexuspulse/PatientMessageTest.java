package org.iitwf.hc.nexuspulse;

import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.iitwf.nexuspulse.patient.pages.LoginPage;
import org.iitwf.nexuspulse.patient.pages.PatientMessagesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientMessageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	PatientMessagesPage messagePage;
	
	@BeforeClass
	public void setup()
	{
		launchBrowser(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("puname"),prop.getProperty("ppword"));
		homePage = new HomePage(driver);
		homePage.navigateToAModule("Messages");
	}
	
	@Test
	public void testSendMessage() {
		messagePage = new PatientMessagesPage(driver);
		String randomMessage = AppLibrary.randomString("Msg");
		messagePage.sendMessage(randomMessage);
		
		String displayedMessage = messagePage.checkMessage(randomMessage);
		Assert.assertEquals(displayedMessage, randomMessage);
	}
	
	
	

}



