package drivermanager;

import constants.Credentials;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class RemoteDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 12");
        browserOptions.setCapability("browserVersion", "15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1");
        sauceOptions.put("name", "FitDay Create Account");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            threadLocalDriver.set(new RemoteWebDriver(new URL(Credentials.REMOTE_URL), browserOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
