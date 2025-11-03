package horilla.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Recruitment {

    WebDriver driver;
    WebDriverWait wait;
    public  Recruitment(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//a[@data-id='recruitmentGenericNav']")
    WebElement recruitmentTab;
    @FindBy(xpath = "//a[@href=\"/recruitment/pipeline/?closed=false\"]")
    WebElement recruitment;
    @FindBy(css = "button[id='createNewRecruitment']")
    WebElement AddRecruitment;
    @FindBy(css = "input[id=\"id_title\"]")
    WebElement title;
    @FindBy(css = "div[role=\"textbox\"]")
    WebElement description;
    @FindBy(xpath = "//div[@id=\"openPositionUpdateContainer\"]//span[@dir=\"ltr\"]")
    WebElement jobDropdown;
    @FindBy(xpath = "//li[contains(text(),'Odoo Dev - (S/W Dept)')]")
    WebElement dropSelect;
    @FindBy(xpath = "//div[@id=\"selectContainerid_recruitment_managers\"]")
    WebElement managerDropdown;
    @FindBy(xpath = "//li[contains(text(),'Amelia Cooper (PEP25)')]")
    WebElement managerSelect;
    @FindBy(xpath = "//input[@id=\"id_vacancy\"]")
    WebElement vacancyInt;

    @FindBy(id = "id_publish_in_linkedin")
    WebElement publishInLinkedInCheckbox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;


    String titlevalue= "New Title up";
    String descriptionValue="New Description";

    public String recruitmentAdd(){
        recruitmentTab.click();
        recruitment.click();
        AddRecruitment.click();
        wait.until(ExpectedConditions.elementToBeClickable(title));
        title.sendKeys(titlevalue);
        description.sendKeys(descriptionValue);
        jobDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(dropSelect));
        dropSelect.click();
        managerDropdown.click();

        managerSelect.click();
        vacancyInt.sendKeys("2");

        if(publishInLinkedInCheckbox.isSelected()){
            publishInLinkedInCheckbox.click();
        }
        saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Recruitment added')]")
        ));

        System.out.println(toast.getText());
        String toastMessage =toast.getText();

        return toastMessage;
// Print the text of the toast messa



    }


















}
