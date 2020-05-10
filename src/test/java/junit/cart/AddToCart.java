package junit.cart;

import junit.base.BaseTests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import properties.PropertiesConfig;
import uimappers.pages.*;

import static constants.TimeOutConstants.PAGE_LOADING_TIMEOUT;
import static properties.PropertiesKeys.ALTEX_EMAIL;
import static properties.PropertiesKeys.ALTEX_PASSWORD;

public class AddToCart extends BaseTests {
    private HomePage homePage;
    private MyCartPage myCartPage;
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
    public void addProductToCart() {
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.clickAutentificare("Autentificare");
        loginPage.setLoginEmailInputField("email", emailAddress);
        loginPage.setLoginPasswordInputField("password", password);

        UserPage userPage = loginPage.clickAutentificare("Autentificare");

        SearchResultsPage searchResultsPage = homePage.searchProduct("casti gaming razer");
        searchResultsPage.addProductToCart("Casti Gaming Wireless RAZER Nari, stereo, multiplatforma, dongle 2.4Ghz, 3.5mm, negru");
        searchResultsPage.closeModalView();

        String actualMessage = searchResultsPage.assertionTextFromSearchResultPage("Rezultate cautare ");
        Assert.assertTrue(actualMessage.contains("Rezultate"));

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
