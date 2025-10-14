package horilla.abstracts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponents(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
@FindBy(css = "button[hx-get=\"/attendance/clock-in\"]")
    WebElement checkIn;
@FindBy(xpath = "//div[@id=\"attendance-activity-container\"]")
    WebElement log;

    public String attendanceCheckIn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"attendance-activity-container\"]")));

        wait.until(ExpectedConditions.elementToBeClickable(checkIn)).click();
        //checkIn.click();
        String attendenceText=log.getText();
        return attendenceText;
    }



}
