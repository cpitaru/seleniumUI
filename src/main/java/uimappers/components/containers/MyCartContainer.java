package uimappers.components.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import java.util.List;

import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class MyCartContainer extends BaseContainer {
    private WebDriverUtilities driverUtilities;

    public static final String CART_LIST_CONTAINER_XPATH = "//*[@id=\"checkout\"]/div/section/div/ul";
    private static final String PRODUCT_NAME_XPATH = "//*[@id=\"checkout\"]//ul/li/div[2]/h2/a";
    private static final String REMOVE_FROM_CART_BUTTON_XPATH = "//*[@id=\"checkout\"]/div/section/div/ul//button[1]";

    public MyCartContainer() {
        super();
        PageFactory.initElements(getDriver(), this);
        driverUtilities = new WebDriverUtilities();
    }

    public boolean checkIfProductIsPresent(String productName) {
        String titleXpath = String.format(PRODUCT_NAME_XPATH, productName);
        String productXpath = CART_LIST_CONTAINER_XPATH + titleXpath;
        WebElement element = getDriver().findElement(By.xpath(productXpath));

        return element.isDisplayed();
    }

    public void removeProductsFromCart() {
        List<WebElement> wishListProducts = bodyContainer.findElements(By.xpath(CART_LIST_CONTAINER_XPATH));
        for(WebElement currentProduct: wishListProducts) {
            WebElement removeButton = currentProduct.findElement(By.xpath(REMOVE_FROM_CART_BUTTON_XPATH));
            driverUtilities.waitForElementToBeClickable(removeButton,MIN_TIMEOUT);

            removeButton.click();
        }
    }
}
