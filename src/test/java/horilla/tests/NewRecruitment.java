package horilla.tests;

import horilla.TestObjects.BaseTest;
import horilla.pageObjects.Recruitment;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewRecruitment extends BaseTest {




@Test
    public void Recruitments(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    recruitment =new Recruitment(driver);
    loginPage.loginApplication();
    String toastMessage= recruitment.recruitmentAdd();

    Assert.assertEquals(toastMessage,"Recruitment added.");

}
@Test
    public void checkIned() throws InterruptedException {

   // loginPage.loginApplication();
    String attendenceText=abstractComponents.attendanceCheckIn();
    Assert.assertEquals(attendenceText,"You cannot mark attendance from this network");

}




}
