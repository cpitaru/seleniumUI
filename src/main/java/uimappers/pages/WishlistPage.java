package uimappers.pages;

import uimappers.components.containers.WishListContainer;

public class WishlistPage {
    private WishListContainer wishListContainer;

    public WishlistPage() {
        wishListContainer = new WishListContainer();
    }

    public boolean verifyIfProductIsPresent(String product) {
        return wishListContainer.checkIfProductIsPresent(product);
    }

    public void removeAllProductsFromWishlist() {
        wishListContainer.removeProductsFromWishlist();
    }

}
