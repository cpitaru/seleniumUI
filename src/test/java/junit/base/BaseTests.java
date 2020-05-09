package junit.base;

import driverprovider.DriverInstance;
import driverprovider.WaitDriverProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import uimappers.webdriverutils.WebDriverUtilities;

public class BaseTests {
    protected static WaitDriverProvider waitDriverProvider;
    protected static WebDriver driver;
    protected static WebDriverUtilities driverUtilities;

    @BeforeClass
    public static void beforeClass() {
        driver = DriverInstance.getDriver();
        driverUtilities = new WebDriverUtilities();
        waitDriverProvider = new WaitDriverProvider();
    }

    @AfterClass
    public static void afterClass() {
        DriverInstance.quitDriver();
    }
}
