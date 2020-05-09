package driverprovider;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.PropertiesConfig;

import static properties.PropertiesKeys.BROWSER_TYPE_CHROME;

public class DriverInstance {
    private static WebDriver driver;

    private static final String BROWSER = PropertiesConfig.getProperty(BROWSER_TYPE_CHROME);

    private DriverInstance() {
    }

    public static WebDriver getDriver() {
        switch (BROWSER) {
            case "chrome":
                initChromeDriver();
                break;
            default:
                throw new IllegalStateException("No driver has been found for value: " + BROWSER);
        }

        return driver;
    }

    public static void initChromeDriver() {
        if(driver == null) {
            getChromeDriverForWindows();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");

            driver = new ChromeDriver(chromeOptions);
        }
    }



    private static void getChromeDriverForWindows() {
        System.setProperty("webdriver.chrome.driver","D:/pageObject_seleniumUI/seleniumUI/src/main/resources/drivers/chromedriver.exe");
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
