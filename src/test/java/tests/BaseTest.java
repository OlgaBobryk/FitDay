package tests;

import drivermanager.DriverFactory;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseTest {
    DriverManager driverManager;

    @BeforeMethod
    @Parameters({"browserType"})
    public void setup(@Optional("chrome") String browser) {
        DriverFactory factory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;
        } else if (browser.equals("remote")) {
            type = DriverType.REMOTE;
        }
        driverManager = factory.getManager(type);
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }
    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}