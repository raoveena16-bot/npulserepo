package nexusPulse;


import org.nexuspulse.patient.pages.LoginPage;
import org.nexuspulse.patient.pages.PatientAprrovalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientErrorMessageTest extends BaseClass {

    LoginPage patientLogin;

    @Test
    public void validateErrorMessage() {
        launchBrowser(prop.getProperty("url"));
        patientLogin = new LoginPage(driver);
        patientLogin.login("NexusUName108Nv", prop.getProperty("ppword"));

        PatientAprrovalPage approvalPage = new PatientAprrovalPage(driver);
        String actual = approvalPage.getErrorMessage();

        Assert.assertEquals(actual, "Invalid username or password");
    }
}
