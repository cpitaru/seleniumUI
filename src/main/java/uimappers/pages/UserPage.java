package uimappers.pages;

import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.webdriverutils.WebDriverUtilities;

public class UserPage {
    private WebDriverUtilities driverUtilities;
    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;

    public UserPage() {
        driverUtilities = new WebDriverUtilities();
        topHorizontalMenu = new TopHorizontalMenu();
        userMenu = new UserMenu();
    }

    public SumarContPage openUserMenu(String option) {
        userMenu.clickOnUserMenuOption(option);
        return new SumarContPage();
    }

    public String userNameMessage(String userName) {
        return userMenu.getUsernameMessage(userName);
    }


    public WishlistPage openUserMenuForWishlist(String option) {
        userMenu.openMenu();
        userMenu.clickOnUserMenuOption(option);
        return new WishlistPage();
    }



}
