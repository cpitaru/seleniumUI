package uimappers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uimappers.components.grid.SearchResultGrid;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.webdriverutils.WebDriverUtilities;

public class SearchResultsPage {
    private TopHorizontalMenu topHorizontalMenu;
    private SearchResultGrid searchResultGrid;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[3]/div[1]/a")
    private WebElement userDropdown;

    public SearchResultsPage() {
        topHorizontalMenu = new TopHorizontalMenu();
        searchResultGrid = new SearchResultGrid();
        userMenu = new UserMenu();
        driverUtilities = new WebDriverUtilities();
    }

    public void addSearchResultsToFavorites(String productName) {
        searchResultGrid.clickFavoritesIcon(productName);
    }

    public void openUserMenu(String option) {
        userMenu.clickOnUserMenuOption(option);
    }

    public WishlistPage navigateToWishlistPage() {
        return userMenu.navigateToWishlistPage();
    }



}
