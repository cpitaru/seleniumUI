package uimappers.pages;

import uimappers.components.containers.MyCartContainer;
import uimappers.components.grid.MyCartGrid;
import uimappers.components.grid.SearchResultGrid;
import uimappers.components.menu.TopHorizontalMenu;

public class MyCartPage {
    private MyCartContainer myCartContainer;
    private MyCartGrid myCartGrid;
    private TopHorizontalMenu topHorizontalMenu;

    public MyCartPage() {
        myCartContainer = new MyCartContainer();
        myCartGrid = new MyCartGrid();
        topHorizontalMenu = new TopHorizontalMenu();
    }

    public boolean verifyIfProductIsPresent(String product) {
        return myCartContainer.checkIfProductIsPresent(product);
    }

    public void removeProductsFromCart(String products) {
        myCartContainer.removeProductsFromCart(products);
    }

    public String assertionTextFromMyCartPage(String message) {
        return myCartGrid.getSearchResultMessageFromMyCart(message);
    }

    public String assertionTextFromMyCartPageAfterEmptyingCart(String emptyCartMessage) {
        return myCartGrid.getEmptyCartMessage(emptyCartMessage);
    }
}
