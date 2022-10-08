package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ActivityTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ActivityTest.class.getName());


    @Test(priority = 2, description = "User chooses activity from the list, inputs time for this activity and adds it to Log")

    public void checkActivity() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to ActivityLog Page");
        dashboardPage.clickAddButtonActivityLog();
        ActivityLogPage activityLogPage = new ActivityLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", ActivityLogPage.class.getName()));
        LOGGER.info("Choose kind of activity");
        activityLogPage.chooseActivity();
        LOGGER.info("Choose activity");
        activityLogPage.addActivity();
        AddToActivityLogPage addToActivityLogPage = new AddToActivityLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", AddToActivityLogPage.class.getName()));
        LOGGER.info(String.format("Get the title %s of expected activity ", addToActivityLogPage.getTitleOfExpectedActivity()));
        String expectedActivity = addToActivityLogPage.getTitleOfExpectedActivity();
        LOGGER.info("Enter activity time");
        addToActivityLogPage.addHoursForActivity();
        addToActivityLogPage.addMinutesForActivity();
        LOGGER.info("Add activity to Log and");
        addToActivityLogPage.clickAddToActivityButton();
        LOGGER.info(String.format("Get title %s of chosen activity",activityLogPage.getTitleOfActivityToAdd() ));
        String actualActivity = activityLogPage.getTitleOfActivityToAdd();
        LOGGER.info(String.format("Check if actual activity %s and expected  activity %s are identical", actualActivity, expectedActivity));
        Assert.assertEquals(actualActivity, expectedActivity, "Activity wasn't added");

    }

    @Test(priority = 1, description = "User changes type of Lifestyle. Calories are changed")

    public void changeLifestyleTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to ActivityLog Page");
        dashboardPage.clickAddButtonActivityLog();
        ActivityLogPage activityLogPage = new ActivityLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", ActivityLogPage.class.getName()));
        LOGGER.info("Go to LifeStyle Page");
        activityLogPage.clickLifeStyleChoose();
        LifestylePage lifestylePage = new LifestylePage(driver);
        LOGGER.info(String.format("Page %s initialized", LifestylePage.class.getName()));
        LOGGER.info(String.format("Choose Lifestyle and get title %s of it", lifestylePage.chooseLifestyle()));
        String expectedLifestyle = lifestylePage.chooseLifestyle();
        LOGGER.info("Save new LifeStyle");
        lifestylePage.clickSaveButtonForChangeLifestyle();
        LOGGER.info(String.format("Get title %s of actual LifeStyle", activityLogPage.getActualKindOfLifestyle()));
        String actualLifeStyle = activityLogPage.getActualKindOfLifestyle();
        LOGGER.info(String.format("Check if actual LifeStyle %s and expected LifeStyle %s are identical", actualLifeStyle, expectedLifestyle));
        Assert.assertEquals(actualLifeStyle, expectedLifestyle, "Lifestyles are different");


    }
}
