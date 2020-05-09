package uimappers.pages;

import uimappers.components.forms.BaseForm;
import uimappers.webdriverutils.WebDriverUtilities;

public class LoginPage {

    private BaseForm loginForm;
    private WebDriverUtilities driverUtilities;

    public LoginPage() {
        loginForm = new BaseForm();
        driverUtilities = new WebDriverUtilities();
    }

    public void setLoginEmailInputField(String emailFieldName, String emailFieldValue) {
        loginForm.setEmailFieldValue(emailFieldName,emailFieldValue);
    }

    public void setLoginPasswordInputField(String passwordFieldName, String passwordFieldValue) {
        loginForm.setPasswordFieldValue(passwordFieldName,passwordFieldValue);
    }

    public UserPage clickAutentificare(String buttonName) {
        loginForm.clickLoginButton(buttonName);

        return new UserPage();
    }

    public UserPage loginWithValidCredentials(String emailAddress, String password) {
        setLoginEmailInputField("email", emailAddress);
        setLoginPasswordInputField("password", password);

        return clickAutentificare("Autentificare");
    }
}
