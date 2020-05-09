package uimappers.components.containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.PAGE_LOADING_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class BaseContainer extends LoadableComponent<BaseContainer> {
    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//*[@id=\"__next\"]")
    protected WebElement bodyContainer;

    BaseContainer() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error {
        driverUtilities.waitForElementToBeVisible(bodyContainer, PAGE_LOADING_TIMEOUT);
    }
}
