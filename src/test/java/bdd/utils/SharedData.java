package bdd.utils;

import driverprovider.DriverInstance;
import driverprovider.WaitDriverProvider;
import org.openqa.selenium.WebDriver;
import uimappers.pages.*;
import uimappers.webdriverutils.WebDriverUtilities;

public class SharedData {
    public WebDriver driver;
    public DriverInstance driverInstance;
    public WaitDriverProvider waitDriverProvider;
    public WebDriverUtilities driverUtilities;

    /**
     * pages
     */

    public HomePage homePage;
    public LoginPage loginPage;
    public UserPage userPage;
    public SearchResultsPage searchResultsPage;
    public WishlistPage wishlistPage;
    public MyCartPage myCartPage;
}
