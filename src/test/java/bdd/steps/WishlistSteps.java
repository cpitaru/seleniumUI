package bdd.steps;

import bdd.utils.SharedData;
import driverprovider.DriverInstance;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.PAGE_LOADING_TIMEOUT;
import static properties.PropertiesKeys.*;

public class WishlistSteps extends Steps {

    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public WishlistSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities();
        this.sharedData = sharedData;
        sharedData.driver = DriverInstance.getDriver();
    }

    @When("I add the $product to my Wishlist")
    public void whenIAddTheProductToMyWishlist(String product) {
        sharedData.searchResultsPage.addSearchResultsToFavorites("Casti Gaming Wireless RAZER Nari, stereo, multiplatforma, dongle 2.4Ghz, 3.5mm, negru");
    }

    @When("I click on user dropdown")
    public void whenIClickOnUserDropdown() {
        sharedData.homePage.navigateToLoginPage();
    }

    @When("select Wishlist option")
    public void whenSelectWishlistOption() {
        sharedData.wishlistPage = sharedData.userPage.openUserMenuForWishlist("Wishlist");
    }

    @Then("the product was added to my Wishlist")
    public void thenTheProductWasAddedToMyWishlist(String message) {
        message = sharedData.wishlistPage.assertionTextFromWishlistPage("Wishlist");
        Assert.assertTrue(message.contains("Wish"));
    }

    @Given("I open ALTEX home page")
    public void openAltexPage() {
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        sharedData.driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        sharedData.homePage = new HomePage();
    }

    @Given("I open login dropdown")
    public void givenIOpenLoginDropdown() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }

    @When("I click on $login button")
    @Given("I click on $login button")
    public void whenIClickOnLoginButton(String autentificare) {
        sharedData.userPage = sharedData.loginPage.clickAutentificare(autentificare);
    }

    @When("I enter valid $email address")
    @Given("I enter valid $email address")
    public void whenIEnterValidEmailAddress(String eMailAddress) {
        eMailAddress = PropertiesConfig.getProperty(ALTEX_EMAIL);
        sharedData.loginPage.setLoginEmailInputField("email", eMailAddress);
    }

    @When("I enter valid $password")
    @Given("I enter valid $password")
    public void whenIEnterValidPassword(String password) {
        password = PropertiesConfig.getProperty(ALTEX_PASSWORD);
        sharedData.loginPage.setLoginPasswordInputField("password", password);
    }


}
