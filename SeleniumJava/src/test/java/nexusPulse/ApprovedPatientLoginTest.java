package nexusPulse;

import org.nexuspulse.patient.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApprovedPatientLoginTest extends BaseClass {

    LoginPage patientLogin;

    @Test
    public void approvedPatientLogin() {
        launchBrowser(prop.getProperty("url"));
        patientLogin = new LoginPage(driver);
        patientLogin.login("NexusUName108Nv", prop.getProperty("ppword"));

       
        //Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Appointments']")).isDisplayed());
    }
}

