package uimappers.pages;

import uimappers.components.containers.MyCartContainer;

public class MyCartPage {
    private MyCartContainer myCartContainer;

    public MyCartPage() {
        myCartContainer = new MyCartContainer();
    }

    public boolean verifyIfProductIsPresent(String product) {
        return myCartContainer.checkIfProductIsPresent(product);
    }

    public void removeAllProductsFromCart() {
        myCartContainer.removeProductsFromCart();
    }

}
