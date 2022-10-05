package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest {
    @Test
    public void changeHeightInProfile() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickProfileLink();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickEditButton();
        profilePage.changeHeight();
        profilePage.clickSaveButton();
        String actualResult = profilePage.checkHeight();
        String expectedResult = profilePage.getExpectedHeight();
        Assert.assertEquals(actualResult, expectedResult, "height data  is different");


    }

}
