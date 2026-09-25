package nexusPulse;

import org.nexuspulse.patient.pages.HomePage;
import org.nexuspulse.patient.pages.LoginPage;
import org.nexuspulse.patient.pages.MessagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMessages extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	MessagePage messagePage;
	
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
		messagePage = new MessagePage(driver);
		String randomMessage = AppLibrary.randomString("Msg");
		messagePage.sendMessage(randomMessage);
		
		String displayedMessage = messagePage.checkMessage(randomMessage);
		Assert.assertEquals(displayedMessage, randomMessage);
	}
	
	
	

}
