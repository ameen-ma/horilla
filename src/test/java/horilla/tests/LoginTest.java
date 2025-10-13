package horilla.tests;

import horilla.TestObjects.BaseTest;
import horilla.pageObjects.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    L

@Test
    public void loginHorilla(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   loginPage.loginApplication();



}
}
