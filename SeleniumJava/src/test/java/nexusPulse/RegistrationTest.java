package nexusPulse;

import org.nexuspulse.patient.pages.LoginPage;
import org.nexuspulse.patient.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseClass {

   
	@Test
	public void validateEditFName()
	{
		launchBrowser(prop.getProperty("url"));
		LoginPage lPage = new LoginPage(driver);
		RegistrationPage rPage = lPage.register();
		String actual = rPage.registerPatient();
		System.out.println("Actual::: " + actual);
	}
}

