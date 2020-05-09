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
        loginPage.setLoginEmailInputField("email",ALTEX_EMAIL);
        loginPage.setLoginPasswordInputField("password",ALTEX_PASSWORD);

        UserPage userPage = loginPage.clickAutentificare("Autentificare");
        String actualMessage = userPage.userNameMessage("Cosmin");
        Assert.assertTrue(actualMessage.contains("Cosmin"));
    }

    @After
    public void tearDown() {
        homePage.logout(UserMenuOptions.LOG_OUT);
    }
}
