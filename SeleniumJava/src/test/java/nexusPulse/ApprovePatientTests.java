package nexusPulse;

import java.util.List;

import org.nexuspulse.admin.pages.AdminLoginPage;
import org.nexuspulse.patient.pages.HomePage;
import org.nexuspulse.patient.pages.LoginPage;
import org.nexuspulse.patient.pages.PatientAprrovalPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApprovePatientTests extends BaseClass{


	AdminLoginPage lPage;
	HomePage hPage;
	PatientAprrovalPage pApprovalPage;
	@BeforeClass
	public void setUp()
	{

		launchBrowser(prop.getProperty("adminurl"));
		lPage = new AdminLoginPage(driver);
		lPage.adminLogin(prop.getProperty("adminuname"),prop.getProperty("adminpword"));
		pApprovalPage = new PatientAprrovalPage(driver);
		hPage = new HomePage(driver);
		
	}
	@Test
	public void validateApprovePatientTests()
	{
		hPage.navigateToAModule("Patients");
		pApprovalPage.approvePatient("NexusUName108Nv");
		String actualData = pApprovalPage.fetchApprovedStatusMessage("NexusUName108Nv");
		Assert.assertTrue(actualData.contains("Approved"));

	}
}