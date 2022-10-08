package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.RetryAnalyzer;

public class ProfileTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ProfileTest.class.getName());


    @Test(retryAnalyzer = RetryAnalyzer.class, description = "User tries to change height in profile ")
    @Description("User tries to change height in profile")
    public void changeHeightInProfile() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to Profile");
        dashboardPage.clickProfileLink();
        ProfilePage profilePage = new ProfilePage(driver);
        LOGGER.info(String.format("Page %s initialized", ProfilePage.class.getName()));
        LOGGER.info("Edit profile");
        profilePage.clickEditButton();
        LOGGER.info("Change height");
        profilePage.changeHeight();
        LOGGER.info("Save new height");
        profilePage.clickSaveButton();
        LOGGER.info("Get actual height after changing");
        String actualResult = profilePage.checkValueOfHeight();
        LOGGER.info("Get expected height");
        String expectedResult = profilePage.getExpectedHeight();
        LOGGER.info(String.format("Check if actual %s and expected %s height are equals", actualResult,expectedResult));
        Assert.assertEquals(actualResult, expectedResult, "height data  is different");


    }

}
