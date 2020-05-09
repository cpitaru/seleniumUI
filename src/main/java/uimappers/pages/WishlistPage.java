package uimappers.pages;

import uimappers.components.containers.WishListContainer;
import uimappers.components.menu.UserMenu;

public class WishlistPage {
    private WishListContainer wishListContainer;
    private UserMenu userMenu;

    public WishlistPage() {
        userMenu = new UserMenu();
        wishListContainer = new WishListContainer();
    }

    public boolean verifyIfProductIsPresent(String product) {
        return wishListContainer.checkIfProductIsPresent(product);
    }

    public void removeAllProductsFromWishlist() {
        wishListContainer.removeProductsFromWishlist();
    }

    public String assertionTextFromWishlistPage(String message) {

        return userMenu.getWishlistMessage(message);
    }
}
