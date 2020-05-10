package uimappers.components.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class SearchResultGrid extends BaseGrid {
    private WebDriverUtilities driverUtilities;
    private static final String PRODUCT_TITLE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[2]/div[3]/div/div[1]/button/div/div";
    private static final String ADD_TO_CART_XPATH = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[2]/div[1]/div/div/div/div/button";
    private static final String SEARCH_RESULT_MESSAGE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[1]/h1";

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[text()='Produsul a fost adaugat cu succes in wishlist']")
    private WebElement notification;

    @FindBy(xpath = "/html/body/div[2]/div[2]/i")
    private WebElement closeModalViewButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/a/div/div/div")
    private WebElement seeCartFromModalView;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[1]/h1")
    private WebElement searchResultsText;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]")
    private WebElement searchResultContainer;

    public SearchResultGrid() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(),this);
    }

    public void clickFavoritesIcon(String product) {
        String favoritesIconXpath = String.format(PRODUCT_TITLE_XPATH, product);

        driverUtilities.waitForElementToBeClickable(By.xpath(favoritesIconXpath),DEFAULT_TIMEOUT);
        WebElement element = getDriver().findElement(By.xpath(favoritesIconXpath));
        element.click();

        driverUtilities.waitForElementToBeClickable(notification,DEFAULT_TIMEOUT);
    }

    public void clickAddToCartButton(String product) {
        String addToCartButtonXpath = String.format(ADD_TO_CART_XPATH, product);

        driverUtilities.waitForElementToBeClickable(By.xpath(addToCartButtonXpath),MIN_TIMEOUT);
        WebElement element = getDriver().findElement(By.xpath(addToCartButtonXpath));
        element.click();

        driverUtilities.waitForElementToBeClickable(closeModalViewButton,DEFAULT_TIMEOUT);
    }

    public void closeModalView() {
        driverUtilities.waitForElementToBeClickable(closeModalViewButton,DEFAULT_TIMEOUT);
        closeModalViewButton.click();
    }

    public String getSearchResultMessage(String message) {
        driverUtilities.waitForElementToBeVisible(searchResultContainer, DEFAULT_TIMEOUT);

        //construct the xpath
        String searchResultMessageXpath = String.format(SEARCH_RESULT_MESSAGE_XPATH,MIN_TIMEOUT);
        WebElement searchResultMessageElement = getDriver().findElement(By.xpath(searchResultMessageXpath));

        return searchResultMessageElement.getText();
    }

    public void seeMyCartFromModal() {
        driverUtilities.waitForElementToBeClickable(seeCartFromModalView,DEFAULT_TIMEOUT);
        seeCartFromModalView.click();
    }

}
