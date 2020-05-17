package bdd.setup;

import bdd.utils.SharedData;
import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;
import uimappers.webdriverutils.WebDriverUtilities;

import static properties.PropertiesKeys.*;

public class StoryBasicSteps extends Steps {
    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public StoryBasicSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities();
        this.sharedData = sharedData;
        sharedData.driver = DriverInstance.getDriver();
    }

    @BeforeStory
    public void setUp() {
        sharedData.driver = DriverInstance.getDriver();
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        sharedData.homePage = new HomePage();

        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        //set email and password
        String eMailAddress = PropertiesConfig.getProperty(ALTEX_EMAIL);
        sharedData.loginPage.setLoginEmailInputField("email", eMailAddress);
        String password = PropertiesConfig.getProperty(ALTEX_PASSWORD);
        sharedData.loginPage.setLoginEmailInputField("email", password);
    }

    @AfterScenario
    public void afterScenario() throws Exception {
        sharedData.wishlistPage.removeAllProductsFromWishlist();
    }

    @AfterStory
    public void tearDown() {
        sharedData.driver.quit();
    }
}
