package junit.login;

import constants.UserMenuOptions;
import junit.base.BaseTests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;
import uimappers.pages.LoginPage;
import uimappers.pages.SumarContPage;
import uimappers.pages.UserPage;

import static constants.TimeOutConstants.PAGE_LOADING_TIMEOUT;
import static properties.PropertiesKeys.ALTEX_EMAIL;
import static properties.PropertiesKeys.ALTEX_PASSWORD;

public class LoginTests extends BaseTests {
    private HomePage homePage;
    private String emailAddress = PropertiesConfig.getProperty(ALTEX_EMAIL);
    private String password = PropertiesConfig.getProperty(ALTEX_PASSWORD);

    @Before
    public void setUp() {
        driver.get("https://altex.ro/");
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        driver.manage().window().maximize();
        homePage = new HomePage();
    }

    @Test
    public void altexLoginInTest() {
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.clickAutentificare("Autentificare");
        loginPage.setLoginEmailInputField(emailAddress);
        loginPage.setLoginPasswordInputField("password",password);

        UserPage userPage = loginPage.clickAutentificare("Autentificare");
        SumarContPage sumarContPage = userPage.openUserMenu("Sumar cont");

//        String actualMessage = sumarContPage.getUsernameMessage("Salut Cosmin Test");
//        Assert.assertTrue(actualMessage.contains("Cosmin Test"));

        String actualMessage2 = sumarContPage.assertionTextFromSumarContPage("Salut Cosmin Test");
        Assert.assertTrue(actualMessage2.contains("Cosmin Test"));

    }

    @After
    public void tearDown() {
//        homePage.logout(UserMenuOptions.LOG_OUT);
        driver.quit();
    }
}
