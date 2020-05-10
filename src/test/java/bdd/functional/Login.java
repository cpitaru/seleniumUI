package bdd.functional;

import bdd.utils.SharedData;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import properties.PropertiesConfig;

import static properties.PropertiesKeys.ALTEX_EMAIL;
import static properties.PropertiesKeys.ALTEX_PASSWORD;

public class Login extends Steps {
    private SharedData sharedData;

    public Login(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @When("I enter valid email address")
    public void whenIEnterValidEmailAddress() {
        String eMailAddress = PropertiesConfig.getProperty(ALTEX_EMAIL);
        sharedData.loginPage.setLoginEmailInputField("email", eMailAddress);
    }

    @When("I enter valid password")
    public void whenIEnterValidPassword() {
        String password = PropertiesConfig.getProperty(ALTEX_PASSWORD);
        sharedData.loginPage.setLoginEmailInputField("email", password);
    }

    @When("I click on login button")
    public void whenIClickOnLoginButton(String autentificare) {
        sharedData.userPage = sharedData.loginPage.clickAutentificare(autentificare);
    }

    @When("I access Sumar cont page")
    public void whenIAccessSumarContPage(String option) {
        sharedData.sumarContPage = sharedData.userPage.openUserMenu(option);
    }

    @Then("I verify that Cosmin Test is displayed")
    public void thenIVerifyThatCosminTestIsDisplayed(String message) {
        String actualMessage = sharedData.userPage.userNameMessage(message);
        Assert.assertTrue(actualMessage.contains(message));
    }

}
