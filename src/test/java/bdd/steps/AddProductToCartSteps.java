package bdd.steps;

import bdd.utils.SharedData;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class AddProductToCartSteps extends Steps {

    private SharedData sharedData;

    @When("I search after a $product")
    public void whenISearchAfterAProduct(String product) {
        sharedData.searchResultsPage = sharedData.homePage.searchProduct("casti gaming razer");
    }

    @When("I add the $product to my Cart")
    public void whenIAddTheProductToMyCart(String product) {
        sharedData.searchResultsPage.addProductToCart("Casti Gaming Wireless RAZER Nari, stereo, multiplatforma, dongle 2.4Ghz, 3.5mm, negru");
    }

    @When("I close the modal view")
    public void whenICloseTheModalView() {
        sharedData.searchResultsPage.closeModalView();
    }

    @Then("the modal view is closed and $message from Results page is displayed")
    public void thenTheModalViewIsClosed(String message) {
        String actualMessage = sharedData.searchResultsPage.assertionTextFromSearchResultPage("Rezultate cautare ");
        Assert.assertTrue(actualMessage.contains("Rezultate"));
    }
}
