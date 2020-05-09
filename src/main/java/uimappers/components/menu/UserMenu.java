package uimappers.components.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.components.grid.SearchResultGrid;
import uimappers.pages.WishlistPage;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class UserMenu {
    private static final String USERNAME_MESSAGE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/div[2]/div[1]/div";
    private static final String USER_MENU_OPTION_XPATH = "//a[text()='%s']";
    private static final String WISHLIST_MESSAGE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/h1";

    private WebDriverUtilities driverUtilities;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div")
    private WebElement horizontalMenuContainer;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div//ul/li[8]/a")
    private WebElement wishlistOption;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/div[2]")
    private WebElement userMessageContainer;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/h1")
    private WebElement wishListMessageContainer;

    public UserMenu() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(),this);
    }

    public String getUsernameMessage(String usernameMessage) {
        driverUtilities.waitForElementToBeVisible(userMessageContainer, DEFAULT_TIMEOUT);

        //construct the xpath
        String userNameMessageXpath = String.format(USERNAME_MESSAGE_XPATH,MIN_TIMEOUT);
        WebElement userNameMessageElement = getDriver().findElement(By.xpath(userNameMessageXpath));

        return userNameMessageElement.getText();
    }

    public void clickOnUserMenuOption(String userMenuOption) {
        String userMenuOptionXpath = String.format(USER_MENU_OPTION_XPATH, userMenuOption);
        driverUtilities.waitForElementToBeVisible(By.xpath(userMenuOptionXpath),MIN_TIMEOUT);
        WebElement userMenuOptionElement = getDriver().findElement(By.xpath(userMenuOptionXpath));

        Actions action = new Actions(getDriver());
        action.moveToElement(userMenuOptionElement).perform();

        driverUtilities.waitForElementToBeClickable(userMenuOptionElement, MIN_TIMEOUT);
        userMenuOptionElement.click();
    }

    public WishlistPage navigateToWishlistPage() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        wishlistOption.click();

        return new WishlistPage();
    }

    public String getWishlistMessage(String message) {
        driverUtilities.waitForElementToBeVisible(wishListMessageContainer, DEFAULT_TIMEOUT);

        //construct the xpath
        String wishlistMessageXpath = String.format(WISHLIST_MESSAGE_XPATH,MIN_TIMEOUT);
        WebElement wishlistMessageElement = getDriver().findElement(By.xpath(wishlistMessageXpath));

        return wishlistMessageElement.getText();
    }
}
