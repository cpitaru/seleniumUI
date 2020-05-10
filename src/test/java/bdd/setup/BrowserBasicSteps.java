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

    @AfterStory
    public void tearDown() {
        DriverInstance.quitDriver();
    }

    @BeforeScenario
    public void beforeScenario() {
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
    public void afterScenario() {
        sharedData.homePage.logout(UserMenuOptions.LOG_OUT);
    }

    @Given("I open ALTEX home page")
    public void openAltexPage() {
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        sharedData.homePage = new HomePage();
    }

    @Given("I open login dropdown")
    public void givenIOpenLoginDropdown() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }
}
