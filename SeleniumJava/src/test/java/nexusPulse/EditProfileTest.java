package nexusPulse;

import java.time.Duration;

import org.nexuspulse.patient.pages.EditProfilePage;
import org.nexuspulse.patient.pages.HomePage;
import org.nexuspulse.patient.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTest extends BaseClass {

	 
	LoginPage lPage;
	HomePage hPage;
	EditProfilePage profilePage;
	@BeforeClass
	public void setUp()
	{
	
		launchBrowser(prop.getProperty("url"));
		lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("puname"),prop.getProperty("ppword"));
		hPage = new HomePage(driver);
		profilePage = new EditProfilePage(driver);
		 
	}
	@Test
	public void validateEditFName()
	{
		hPage.navigateToAModule("Profile");
		String expectedFName = AppLibrary.randomString("FName");
		profilePage.editFirstName(expectedFName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualFName = profilePage.getFirstName();
		Assert.assertEquals(actualFName, expectedFName);
	}
	@Test
	public void validateEditLName()
	{
		 
		hPage.navigateToAModule("Profile");
		String expectedLName = AppLibrary.randomString("LName");
		profilePage.editLastName(expectedLName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualLName = profilePage.getLastName();
		Assert.assertEquals(actualLName, expectedLName);
	}
	@Test
	public void validateEditAllFields()
	{
		 
		hPage.navigateToAModule("Profile");
		String expectedLName = AppLibrary.randomString("LName");
		String expectedFName = AppLibrary.randomString("FName");
		profilePage.editFirstName(expectedFName);
		profilePage.editLastName(expectedLName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualFName = profilePage.getFirstName();
		String actualLName = profilePage.getLastName();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualLName, expectedLName);
		sa.assertEquals(actualFName, expectedFName);
		sa.assertAll();
	
	}
}

