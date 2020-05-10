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

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[2]/div[1]/div/div/div/div/button")
    private WebElement addToCartButton;


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


    public void addProductToCart(String product) {
        searchResultGrid.clickAddToCartButton(product);
    }

    public void closeModalView() {
        searchResultGrid.closeModalView();
    }

    public String assertionTextFromSearchResultPage(String message) {
        return searchResultGrid.getSearchResultMessage(message);
    }


    public MyCartPage seeMyCartFromModalView() {
        searchResultGrid.seeMyCartFromModal();
        return new MyCartPage();
    }
}
