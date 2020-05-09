package driverprovider;

import org.openqa.selenium.support.ui.WebDriverWait;

import static driverprovider.DriverInstance.getDriver;

public class WaitDriverProvider {
    public WaitDriverProvider() {
    }

    public static WebDriverWait waitProvider(int timeout) {
        return new WebDriverWait(getDriver(),timeout);
    }
}
