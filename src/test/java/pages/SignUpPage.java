package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage{



    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//label[@class='checkbox-label terms-label']")
    WebElement checkboxLabel;

    @FindBy(xpath = "////button[contains(text(),\"Y’alla!\")]")
    WebElement YallaButton;

    public SignUpPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);

    }

    public SignUpPage fillNameField(String name){
        nameField.sendKeys(name);
        return this;
    }

    public BasePage clickSignUpButton(){
        signUpElement.click();
        Alert alert = getAlertIfPresent();
        if (alert != null) {
            alert.accept();
            return new SignUpPage(driver);
        } else {
            return new SearchPage(driver);
        }
    }
    private Alert getAlertIfPresent(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            return wait.until(ExpectedConditions.alertIsPresent());
        }catch(TimeoutException e){
            System.out.println("Alert issue "+e);
            return null;
        }

    }

}
