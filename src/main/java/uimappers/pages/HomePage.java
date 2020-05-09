package uimappers.pages;

import constants.UserMenuOptions;
import properties.PropertiesConfig;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;
import static properties.PropertiesKeys.LOGOUT_URL;

public class HomePage {
    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    public HomePage() {
        topHorizontalMenu = new TopHorizontalMenu();
        userMenu = new UserMenu();
        driverUtilities = new WebDriverUtilities();
    }

    public LoginPage navigateToLoginPage() {
        topHorizontalMenu.openUserMenu();

        return topHorizontalMenu.clickOnLoginButton();
    }

    public SearchResultsPage searchProduct(String searchProduct) {
        topHorizontalMenu.search(searchProduct);
        return new SearchResultsPage();
    }

    public void openUserMenu() {
        topHorizontalMenu.openUserMenu();
    }

    public void logout(UserMenuOptions userMenuOptions) {
        try {
            topHorizontalMenu.openUserMenu();
            userMenu.clickOnUserMenuOption(userMenuOptions.getUserMenuOption());
        } catch (org.openqa.selenium.json.JsonException | org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            System.out.println("User is not on a good page!");
        } finally {
            String currentUrl = getDriver().getCurrentUrl();
            if(currentUrl.equals("https://altex.ro/cont/intra/")) {
                System.out.println("Log out");
                getDriver().get(PropertiesConfig.getProperty(LOGOUT_URL));
                driverUtilities.waitUntilPageIsLoaded(DEFAULT_TIMEOUT);
            }

        }
    }

}
