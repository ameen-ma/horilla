package horilla.tests;

import horilla.TestObjects.BaseTest;
import horilla.pageObjects.Leave;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LeaveWorkflow extends BaseTest {
    @Test
    public void LeaveSubmission() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        leave=new Leave(driver);
        loginPage.loginApplication();
        leave.leaveApplication();

    }


}
