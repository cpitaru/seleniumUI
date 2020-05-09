package uimappers.pages;

import uimappers.components.grid.SearchResultGrid;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.webdriverutils.WebDriverUtilities;

public class SearchResultsPage {
    private TopHorizontalMenu topHorizontalMenu;
    private SearchResultGrid searchResultGrid;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    public SearchResultsPage() {
        topHorizontalMenu = new TopHorizontalMenu();
        searchResultGrid = new SearchResultGrid();
        userMenu = new UserMenu();
        driverUtilities = new WebDriverUtilities();
    }

    public void addSearchResultsToFavorites(String productName) {
        searchResultGrid.clickFavoritesIcon(productName);
    }

    public WishlistPage navigateToWishlistPage() {
        return topHorizontalMenu.navigateToWishlistPage();
    }

}
