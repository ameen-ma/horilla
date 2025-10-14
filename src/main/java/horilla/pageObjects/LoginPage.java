package horilla.pageObjects;

import horilla.abstracts.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    public void goTo(){
        driver.get("https://demo.horilla.com/login/");

    }

@FindBy(xpath = "//button[@type='submit']")
    WebElement loginClick;


    public void loginApplication(){

        loginClick.click();
    }





}
