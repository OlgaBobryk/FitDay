package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginToFitDayWithValidDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.logoutLinkIsDisplayed(), "User didn't log in");

    }

    @Test
    public void loginToFitDayUnregisteredUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginUnregisteredUser();
        Assert.assertTrue(loginPage.logInFormDisplayed(), "Login Form isn't displayed, User is logged");
    }


}

