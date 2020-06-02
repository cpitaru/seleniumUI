package bdd.setup;

import bdd.utils.SharedData;
import constants.UserMenuOptions;
import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.*;
import static properties.PropertiesKeys.*;

public class BrowserBasicSteps extends Steps {
    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public BrowserBasicSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities();
        this.sharedData = sharedData;
        sharedData.driver = DriverInstance.getDriver();
    }

    @Given("I open ALTEX home page")
    public void openAltexPage() {
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        sharedData.homePage = new HomePage();
    }

    @AfterStory
    public void tearDown() {
        DriverInstance.quitDriver();
    }

    @BeforeScenario
    public void beforeScenario() {
        sharedData.driver = DriverInstance.getDriver();
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        sharedData.homePage = new HomePage();

    }

//    @AfterScenario
//    public void afterScenario() {
//        sharedData.homePage.logout(UserMenuOptions.LOG_OUT);
//    }


}
