package uimappers.components.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.components.grid.SearchResultGrid;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class UserMenu {
    private static final String USERNAME_MESSAGE_XPATH = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/a/div[3]/span";
    private static final String USER_MENU_OPTION_XPATH = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/ul";

    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]")
    private WebElement userMenuContainer;

    public UserMenu() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(),this);
    }

    public String getUsernameMessage(String username) {
        driverUtilities.waitForElementToBeVisible(userMenuContainer, DEFAULT_TIMEOUT);

        //construct the xpath
        String userNameXpath = String.format(USERNAME_MESSAGE_XPATH,MIN_TIMEOUT);
        WebElement userNameElement = getDriver().findElement(By.xpath(userNameXpath));

        return userNameElement.getText();
    }

    public void clickOnUserMenuOption(String userMenuOption) {
        String userMenuOptionXpath = String.format(USER_MENU_OPTION_XPATH,userMenuOption);
        driverUtilities.waitForElementToBeVisible(By.xpath(userMenuOptionXpath),MIN_TIMEOUT);
        WebElement userMenuOptionElement = getDriver().findElement(By.xpath(userMenuOptionXpath));

        Actions action = new Actions(getDriver());
        action.moveToElement(userMenuOptionElement).perform();

        driverUtilities.waitForElementToBeClickable(userMenuOptionElement, MIN_TIMEOUT);
        userMenuOptionElement.click();
    }

}
