package uimappers.components.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class SearchResultGrid extends BaseGrid {
    private WebDriverUtilities driverUtilities;
    private static final String PRODUCT_TITLE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/" +
            "div[2]/ul/li[1]/div/div[2]/div[3]/div[3]/div/div[1]/button[contains(@class,'Wishlist')]";

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[text()='Produsul a fost adaugat cu succes in wishlist']")
    private WebElement notification;

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
}
