package uimappers.components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class BaseForm {
    private WebDriverUtilities driverUtilities;

    private static final String INAPOI_LA_SITE_BUTTON_XPATH = "//*[@id=\"page-promo\"]/header/div/div[1]/div/nav/div/div[1]/a";
    private static final String FORM_PASSWORD_FIELD_XPATH = "//div[contains(@class,'ContWindow')]//input[@name='password']";
    private static final String FORM_LOGIN_BUTTON_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button";
    private static final String FORM_REGISTER_LINK_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/div/a";
    private static final String FORM_FORGOT_PASSWORD_LINK_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/div/a";


    @FindBy(xpath = "//div[contains(@class,'ContWindow')]//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='Session-loggedOut']")
    private WebElement formContainer;

    @FindBy(xpath = "//*[@id=\"page-promo\"]/header/div/div[1]")
    private WebElement promoHeader;

    @FindBy(xpath = "//*[@id=\"page-promo\"]/header/div/div[1]/div/nav/div/div[1]/a")
    private WebElement inapoiLaSiteLink;

    public BaseForm() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public void setEmailFieldValue(String fieldValue) {
        //construct the xpath for email and password fields
        driverUtilities.waitForElementToBeVisible(formContainer,DEFAULT_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(emailField,DEFAULT_TIMEOUT);


        //set value for email and password fields
//        new Actions(getDriver()).moveToElement(emailField).click().perform();

        emailField.sendKeys("abcc@gmail.com");

        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(Keys.BACK_SPACE);

        emailField.click();

//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", emailField);
//        executor.executeScript("arguments[0].setAttribute('value', arguments[1])", emailField, fieldValue);

        emailField.clear();
        emailField.sendKeys(fieldValue);


        driverUtilities.waitForElementAttributeToContain(emailField,"value",fieldValue,DEFAULT_TIMEOUT);

//        executor.executeScript("arguments[0].click();", emailField);
//        executor.executeScript("arguments[0].setAttribute('value', arguments[1])", emailField, fieldValue);
    }

    public void setPasswordFieldValue(String fieldName, String fieldValue) {
        //construct the xpath for email and password fields
        String passwordFieldXpath = String.format(FORM_PASSWORD_FIELD_XPATH, fieldName);
        driverUtilities.waitForElementToBeClickable(By.xpath(passwordFieldXpath),DEFAULT_TIMEOUT);

        WebElement formpasswordField = formContainer.findElement(By.xpath(passwordFieldXpath));

        //set value for email and password fields

        formpasswordField.clear();
        formpasswordField.sendKeys(fieldValue);

        driverUtilities.waitForElementAttributeToContain(formpasswordField,"value",fieldValue,DEFAULT_TIMEOUT);

    }

    public String getEmailFieldValue(String fieldName) {
        //wait for form to be visible
        driverUtilities.waitForElementToBeVisible(formContainer,DEFAULT_TIMEOUT);

        return emailField.getAttribute("value");
    }

    public String getPasswordFieldValue(String fieldName) {
        //wait for form to be visible
        driverUtilities.waitForElementToBeVisible(formContainer,DEFAULT_TIMEOUT);

        String passwordFieldXpath = String.format(FORM_PASSWORD_FIELD_XPATH, fieldName);
        WebElement formpasswordField = formContainer.findElement(By.xpath(passwordFieldXpath));

        return formpasswordField.getAttribute("value");
    }

    public void clickLoginButton(String buttonName) {
        String buttonXpath = String.format(FORM_LOGIN_BUTTON_XPATH, buttonName);
        WebElement formButton = formContainer.findElement(By.xpath(buttonXpath));
        driverUtilities.waitForElementToBeClickable(formButton,DEFAULT_TIMEOUT);

        formButton.click();
    }

    public void clickOnRegisterLink(String linkTitle) {
        String linkXpath = String.format(FORM_REGISTER_LINK_XPATH,linkTitle);

        driverUtilities.waitForElementToBeClickable(formContainer,DEFAULT_TIMEOUT);
        WebElement link = formContainer.findElement(By.xpath(linkXpath));
        link.click();
    }

    public void clickOnForgotPasswordLink(String linkTitle) {
        String linkXpath = String.format(FORM_FORGOT_PASSWORD_LINK_XPATH,linkTitle);

        driverUtilities.waitForElementToBeClickable(formContainer,DEFAULT_TIMEOUT);
        WebElement link = formContainer.findElement(By.xpath(linkXpath));
        link.click();
    }

    public void clickOnInapoiLaSiteLink(String linkTitle) {
        String linkXpath = String.format(INAPOI_LA_SITE_BUTTON_XPATH,linkTitle);

        driverUtilities.waitForElementToBeClickable(promoHeader,DEFAULT_TIMEOUT);
        WebElement link = promoHeader.findElement(By.xpath(linkXpath));
        link.click();
        inapoiLaSiteLink.click();
    }


}
