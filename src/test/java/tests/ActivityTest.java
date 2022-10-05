package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ActivityTest extends BaseTest {
    @Test
    public void checkActivity() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddButtonActivityLog();
        ActivityLogPage activityLogPage = new ActivityLogPage(driver);
        activityLogPage.chooseActivity();
        activityLogPage.addActivity();
        AddToActivityLogPage addToActivityLogPage = new AddToActivityLogPage(driver);
        addToActivityLogPage.addHoursForActivity();
        addToActivityLogPage.addMinutesForActivity();
        String expectedActivity = addToActivityLogPage.getTitleOfExpectedActivity();
        addToActivityLogPage.clickAddToActivityButton();
        Assert.assertEquals(activityLogPage.checkActivityToAdd(), expectedActivity, "Activity wasn't added");

    }

    @Test
    public void changeLifestyleTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddButtonActivityLog();
        ActivityLogPage activityLogPage = new ActivityLogPage(driver);
        activityLogPage.clickLifeStyleChoose();
        LifestylePage lifestylePage = new LifestylePage(driver);
        lifestylePage.chooseLifestyle();
        lifestylePage.clickSaveButtonForChangeLifestyle();
        Assert.assertEquals(activityLogPage.getActualKindOfLifestyle(),lifestylePage.chooseLifestyle(), "Lifestyles are different");


    }
}
