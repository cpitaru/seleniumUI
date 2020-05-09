package uimappers.components.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import java.util.List;

import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class WishListContainer extends BaseContainer {
    private WebDriverUtilities driverUtilities;

    public static final String PRODUCT_CONTAINER_XPATH = "//*[@id=\"__next\"]//ul[contains(@class, 'Products Products--list')]";
    private static final String PRODUCT_NAME_XPATH = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/ul/li/div/div[3]/h2/a[text()='%s']";
    private static final String REMOVE_FROM_WISHLIST_BUTTON_XPATH = "//*[@id=\\\"__next\\\"]//button/div/div/div[text()='Sterge']";

    public WishListContainer() {
        super();
        PageFactory.initElements(getDriver(), this);
        driverUtilities = new WebDriverUtilities();
    }

    public boolean checkIfProductIsPresent(String productName) {
        String titleXpath = String.format(PRODUCT_NAME_XPATH, productName);
        String productXpath = PRODUCT_CONTAINER_XPATH + titleXpath;
        WebElement element = getDriver().findElement(By.xpath(productXpath));

        return element.isDisplayed();
    }

    public void removeProductsFromWishlist() {
        List<WebElement> wishListProducts = bodyContainer.findElements(By.xpath(PRODUCT_CONTAINER_XPATH));
        for(WebElement currentProduct: wishListProducts) {
            WebElement removeButton = currentProduct.findElement(By.xpath(REMOVE_FROM_WISHLIST_BUTTON_XPATH));
            driverUtilities.waitForElementToBeClickable(removeButton,MIN_TIMEOUT);

            removeButton.click();
        }
    }

}
