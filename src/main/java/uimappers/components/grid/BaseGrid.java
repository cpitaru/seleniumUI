package uimappers.components.grid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sun.jvm.hotspot.debugger.Page;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class BaseGrid extends LoadableComponent<BaseGrid> {
    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//div[@id='__next']")
    protected WebElement gridContainer;

    @FindBy(xpath = "//ul[contains(@class,'Products Products--grid Products--4to2')]//li[contains(@class, 'Product')]")
    protected WebElement cardItem;


    public BaseGrid() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(),this);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        driverUtilities.waitForElementToBeVisible(gridContainer,DEFAULT_TIMEOUT);
    }


}
