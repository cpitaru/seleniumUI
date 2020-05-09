package junit.wishlist;

import junit.base.BaseTests;
import org.junit.Before;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;
import uimappers.pages.LoginPage;
import uimappers.pages.WishlistPage;

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
        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.loginWithValidCredentials(emailAddress,password);
    }

}
