package horilla.pageObjects;

import horilla.abstracts.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Leave extends AbstractComponents {
    WebDriver driver;
    WebDriverWait wait;
    public Leave(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy (xpath = "//img[@src=\"/static/images/ui/leave.svg\"]")
    WebElement leaveTab;
    @FindBy(xpath = "//a[@href=\"/leave/request-view/\"]")
    WebElement leaveRequest;
    @FindBy(xpath = "//button[@id=\"requestCreateButton\"]")
    WebElement leaveButton;
    @FindBy(xpath = "//span[@id=\"select2-id_leave_type_id-container\"]")
    WebElement leaveType;

    @FindBy(xpath = "//span[@id=\"select2-id_employee_id-container\"]")
    WebElement employee;
    @FindBy(xpath="//li[contains(text(), '(PEP00)')]")
    WebElement employeeSelect;
    @FindBy(xpath="//li[contains(text(), 'Maternity Leave')]")
    WebElement maternityLeave;

    @FindBy(xpath = "//*[@name=\"description\"]")
    WebElement description;
    @FindBy(xpath = "//*[@id=\"buttonID\"]")
    WebElement saveButton;
    // Popup title
    @FindBy(css = "h2#swal2-title")
    List<WebElement> popupTitle;  // use List to safely check existence

    // Confirm button
    @FindBy(xpath = "//div[@class='swal2-actions']/button[contains(text(),'Confirm')]")
    WebElement confirmButton;

    public void leaveApplication()  {
        wait.until(ExpectedConditions.elementToBeClickable(leaveTab));
        leaveTab.click();
        leaveRequest.click();
        leaveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(employee));
        employee.click();
        employeeSelect.click();
        leaveType.click();
        maternityLeave.click();
        description.sendKeys("Maternity leave");
        saveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

        if(!popupTitle.isEmpty()){
            try{

                confirmButton.click();
                //wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
            }catch (Exception ignored){

            }
        }


    }





    






}
