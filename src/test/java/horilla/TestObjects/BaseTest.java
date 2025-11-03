package horilla.TestObjects;

import horilla.abstracts.AbstractComponents;
import horilla.pageObjects.LoginPage;
import horilla.pageObjects.Recruitment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public AbstractComponents abstractComponents;
    public Recruitment recruitment;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\ameen.ma\\OneDrive - PITSOLUTIONS\\Ameen_Projects\\Selenium\\horilla\\src\\main\\java\\horilla\\resources\\GlobalDataProperties");
        properties.load(fis);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();

        }


        return driver;

    }
    public String getScreenshot(String testCaseName , WebDriver driver) throws IOException {
        TakesScreenshot ts =(TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testCaseName+".png";

    }







    @BeforeMethod(alwaysRun = true)
    public LoginPage launchHorilla() throws IOException {

    driver=initializeDriver();
    loginPage = new LoginPage(driver);
    abstractComponents = new AbstractComponents(driver);

    loginPage.goTo();
    return loginPage ;

    }

    @AfterMethod(alwaysRun = true)
    public void endRun(){
       // driver.quit();
    }

}