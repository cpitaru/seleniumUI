package bdd.steps;

import bdd.utils.SharedData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import properties.PropertiesConfig;
import uimappers.pages.HomePage;

import static constants.TimeOutConstants.PAGE_LOADING_TIMEOUT;
import static properties.PropertiesKeys.*;

public class LoginSteps extends Steps {
    private SharedData sharedData;

    public LoginSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @When("I enter valid $email address")
    @Given("I enter valid $email address")
    public void whenIEnterValidEmailAddress(String eMailAddress) {
        eMailAddress = PropertiesConfig.getProperty(ALTEX_EMAIL);
        sharedData.loginPage.setLoginEmailInputField(eMailAddress);
    }

    @When("I enter valid $password")
    @Given("I enter valid $password")
    public void whenIEnterValidPassword(String password) {
        password = PropertiesConfig.getProperty(ALTEX_PASSWORD);
        sharedData.loginPage.setLoginPasswordInputField("password", password);
    }


    @When("I access $SumarCont page")
    public void whenIAccessSumarContPage(String option) {
        sharedData.sumarContPage = sharedData.userPage.openUserMenu(option);
    }

    @Then("I verify that $CosminTest is displayed")
    public void thenIVerifyThatCosminTestIsDisplayed(String message) {
        String actualMessage = sharedData.userPage.userNameMessage(message);
        Assert.assertTrue(actualMessage.contains(message));
    }

    @When("I click on $login button")
    @Given("I click on $login button")
    public void whenIClickOnLoginButton(String autentificare) {
        sharedData.userPage = sharedData.loginPage.clickAutentificare(autentificare);
    }



    @Given("I open login dropdown")
    public void givenIOpenLoginDropdown() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }

}
