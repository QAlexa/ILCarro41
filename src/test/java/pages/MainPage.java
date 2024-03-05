package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    public  MainPage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/");
    }

    public <T extends BasePage> T openTopMenu(String topMenuItem){
        WebElement menuItem = driver.findElement(By.xpath("//a[contains(text(),'"+ topMenuItem + "')]"));
        menuItem.click();

        switch (topMenuItem){
            case "SEARCH":
                return (T) new SearchPage(driver);
            case "LETTHECARWORK":
                return (T) new LetTheCarWorkPage(driver);
            case "TERMSOFUSE":
                return (T) new TermsOfUsePage(driver);
            case " Sign up ":
                return (T) new SearchPage(driver);
            case "LOGIN":
                return (T) new LoginPage(driver);

            default: throw new IllegalArgumentException("Something wrong" + topMenuItem);
        }
    }
}
