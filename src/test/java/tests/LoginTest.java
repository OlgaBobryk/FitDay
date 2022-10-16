package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(priority = 2, description = "User performs login to the account with valid data")
    @Description("User tries to login with valid data")
    public void loginToFitDayWithValidDate() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Check if user is registered and if he can log in");
        Assert.assertTrue(dashboardPage.logoutLinkIsDisplayed(), "User didn't log in");
    }

    @Test(priority = 1, description = "User performs login to the account with invalid data")
    @Description("User tries to login with invalid data")
    public void loginToFitDayUnregisteredUser() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginUnregisteredUser();
        LOGGER.info("Check if user isn't registered and if he can't log in");
        Assert.assertTrue(loginPage.logInFormDisplayed(), "Login Form isn't displayed, User is logged");
    }
}

