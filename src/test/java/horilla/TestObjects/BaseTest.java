package horilla.TestObjects;

import horilla.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\alame\\IdeaProjects\\untitled3\\src\\main\\java\\horilla\\resources\\GlobalDataProperties");
        properties.load(fis);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();

        }


        return driver;

    }
    @BeforeMethod(alwaysRun = true)
    public LoginPage launchHorilla() throws IOException {

    driver=initializeDriver();
    loginPage = new LoginPage(driver);
    loginPage.goTo();
    return loginPage ;

    }

    @AfterMethod(alwaysRun = true)
    public void endRun(){
        driver.quit();
    }

}