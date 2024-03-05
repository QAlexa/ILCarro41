package tests;

import config.BaseTest;
import helpers.TopMenuItem;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class IlCarroTest extends BaseTest {

    @Test
    @Parameters("browser")

    public void testIlCarro_001(@Optional("firefox")String browser) throws InterruptedException{
        MainPage mainPage= new MainPage(getDriver());
        SignUpPage signUpPage = mainPage.openTopMenu(TopMenuItem.SIGNUP.toString());
        signUpPage.fillNameField("Piter");

    }
}
