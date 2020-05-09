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

    public void openUserMenu(String option) {
        userMenu.clickOnUserMenuOption(option);
    }

    public String userNameMessage(String userName) {
        return userMenu.getUsernameMessage(userName);
    }



}
