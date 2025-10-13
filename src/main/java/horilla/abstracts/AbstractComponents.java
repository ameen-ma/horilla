package horilla.abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);

    }
@FindBy(css = "button[hx-get=\"/attendance/clock-in\"]")
    WebElement checkIn;
@FindBy(xpath = "//div[@id=\"attendance-activity-container\"]")
    WebElement log;

    public void attendanceCheckIn(){
        checkIn.click();
        log.getText();
    }



}
