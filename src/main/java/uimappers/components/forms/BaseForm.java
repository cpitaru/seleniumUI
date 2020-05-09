package uimappers.components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.webdriverutils.WebDriverUtilities;

import static constants.TimeOutConstants.DEFAULT_TIMEOUT;
import static driverprovider.DriverInstance.getDriver;

public class BaseForm {
    private WebDriverUtilities driverUtilities;

    private static final String FORM_EMAIL_FIELD_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/input[1]";
    private static final String FORM_PASSWORD_FIELD_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/input[2]";
    private static final String FORM_LOGIN_BUTTON_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button";
    private static final String FORM_REGISTER_LINK_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form/div[3]/div/a";
    private static final String FORM_FORGOT_PASSWORD_LINK_XPATH = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/div/a";



    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/div[2]/div/form")
    private WebElement formContainer;

    public BaseForm() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public void setEmailFieldValue(String fieldName, String fieldValue) {
        //construct the xpath for email and password fields
        String emailFieldXpath = String.format(FORM_EMAIL_FIELD_XPATH, fieldName);
        driverUtilities.waitForElementToBeClickable(By.xpath(emailFieldXpath),DEFAULT_TIMEOUT);


        WebElement formEmailField = formContainer.findElement(By.xpath(emailFieldXpath));

        //set value for email and password fields
        formEmailField.clear();
        formEmailField.sendKeys(fieldValue);

        driverUtilities.waitForElementAttributeToContain(formEmailField,"value",fieldValue,DEFAULT_TIMEOUT);
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

        String emailFieldXpath = String.format(FORM_EMAIL_FIELD_XPATH, fieldName);
        WebElement formEmailField = formContainer.findElement(By.xpath(emailFieldXpath));

        return formEmailField.getAttribute("value");
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


}
