package uimappers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static constants.TimeOutConstants.MIN_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class SumarContPage {
    private WebDriverUtilities driverUtilities;
    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;

    private static final String USERNAME_MESSAGE_XPATH = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/div[2]/div[1]/div/p[1]/strong";

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/div[2]/div[1]/div/p[1]/strong")
    private WebElement assertionTextFromSumarContPage;

    public SumarContPage() {
        driverUtilities = new WebDriverUtilities();
        topHorizontalMenu = new TopHorizontalMenu();
        userMenu = new UserMenu();
    }

    public String getUsernameMessage(String message) {
        driverUtilities.waitForElementToBeVisible(assertionTextFromSumarContPage, DEFAULT_TIMEOUT);

        //construct the xpath
        String userNameXpath = String.format(USERNAME_MESSAGE_XPATH,MIN_TIMEOUT);
        WebElement userMessage = getDriver().findElement(By.xpath(userNameXpath));

        return userMessage.getText();
    }

    public void openUserMenu(String option) {
        userMenu.clickOnUserMenuOption(option);
    }

    public String assertionTextFromSumarContPage(String userName) {
        return userMenu.getUsernameMessage(userName);
    }

}