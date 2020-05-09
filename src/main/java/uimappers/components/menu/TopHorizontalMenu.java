package uimappers.components.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.pages.LoginPage;
import uimappers.pages.MyCartPage;
import uimappers.pages.SumarContPage;
import uimappers.pages.WishlistPage;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class TopHorizontalMenu {

    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div")
    private WebElement horizontalMenuContainer;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[2]/a")
    private WebElement homePageButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[4]/form/div/div[1]/input")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[4]/form/div/div[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/a")
    private WebElement userMenuDropdown;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div//ul/li[8]/a")
    private WebElement wishlistOption;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button")
    private WebElement loginbutton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/div/a")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[2]/a")
    private WebElement myCart;

    public TopHorizontalMenu() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnLoginButton() {
        driverUtilities.waitForElementToBeVisible(userMenuDropdown, DEFAULT_TIMEOUT);
        userMenuDropdown.click();
        loginbutton.click();

        return new LoginPage();
    }

    public UserMenu openUserMenu() {
        driverUtilities.waitForElementToBeClickable(userMenuDropdown,MIN_TIMEOUT);
        Actions action = new Actions(getDriver());
        action.moveToElement(userMenuDropdown).click();

        return new UserMenu();
    }

    public MyCartPage openMyCartMenu() {
        driverUtilities.waitForElementToBeVisible(myCart,MIN_TIMEOUT);
        myCart.click();

        return new MyCartPage();
    }

    public WishlistPage navigateToWishlistPage() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        wishlistOption.click();

        return new WishlistPage();
    }

    public SumarContPage navigateToSumarContPage() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        wishlistOption.click();

        return new SumarContPage();
    }

    public void search(String product) {
        driverUtilities.waitForElementToBeClickable(searchBar,MIN_TIMEOUT);
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(product);
        driverUtilities.waitForElementAttributeToContain(searchBar,"value",product,MIN_TIMEOUT);

        searchBar.click();
    }
}
