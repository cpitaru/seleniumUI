package junit.wishlist;

import constants.UserMenuOptions;
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

public class WishlistTests extends BaseTests {
    private HomePage homePage;
    private WishlistPage wishlistPage;
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
    public void addProductToWishlist() {
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.clickAutentificare("Autentificare");
        loginPage.setLoginEmailInputField("email",emailAddress);
        loginPage.setLoginPasswordInputField("password",password);

        UserPage userPage = loginPage.clickAutentificare("Autentificare");

        SearchResultsPage searchResultsPage = homePage.searchProduct("casti gaming razer");
        searchResultsPage.addSearchResultsToFavorites("Casti Gaming Wireless RAZER Nari, stereo, multiplatforma, dongle 2.4Ghz, 3.5mm, negru");

        /*

         DON'T KNOW HOW TO CLICK ON THE USER DROPDOWN

        */

        wishlistPage = userPage.openUserMenuForWishlist("Wishlist");
        String actualMessage2 = wishlistPage.assertionTextFromWishlistPage("Wishlist");
        Assert.assertTrue(actualMessage2.contains("Wish"));
    }

    @After
    public void tearDown() {
//        homePage.logout(UserMenuOptions.LOG_OUT);
        driver.quit();
    }

}
