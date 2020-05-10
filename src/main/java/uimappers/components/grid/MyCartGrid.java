package uimappers.components.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class MyCartGrid extends BaseGrid {
    private WebDriverUtilities driverUtilities;
    private static final String BUYING_CART_XPATH = "//*[@id=\"checkout\"]/div/section/div/h2";
    private static final String AFTER_EMPTYING_CART = "//*[@id=\"checkout\"]/div/section/div/h2";


    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/h2")
    private WebElement buyingCart;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div/div")
    private WebElement afterEmptyingCartMessage;

    @FindBy(xpath = "//*[@id=\"__next\"]")
    private WebElement myGridContainer;

    public MyCartGrid() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(),this);
    }

    public String getSearchResultMessageFromMyCart(String message) {
        driverUtilities.waitForElementToBeVisible(buyingCart, DEFAULT_TIMEOUT);

        //construct the xpath
        String buyingCartMessageXpath = String.format(BUYING_CART_XPATH,MIN_TIMEOUT);
        WebElement buyingCartMessageElement = getDriver().findElement(By.xpath(buyingCartMessageXpath));

        return buyingCartMessageElement.getText();
    }

    public String getEmptyCartMessage(String emptyMessage) {
        driverUtilities.waitForElementToBeVisible(myGridContainer, DEFAULT_TIMEOUT);

        //construct the xpath
        String emptyingCartMessageXpath = String.format(AFTER_EMPTYING_CART,MIN_TIMEOUT);
        WebElement emptyingCartMessageElement = getDriver().findElement(By.xpath(emptyingCartMessageXpath));

        return emptyingCartMessageElement.getText();
    }
}
