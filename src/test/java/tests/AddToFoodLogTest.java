package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToFoodLogPage;
import pages.DashboardPage;
import pages.FoodLogPage;
import pages.LoginPage;


public class AddToFoodLogTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(AddToFoodLogTest.class.getName());

    @Test(priority = 1, description = "User choose food from search list and add it to FoodLog")

    public void addFood() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to FoodLog Page");
        dashboardPage.clickAddButtonFoodLog();
        FoodLogPage foodLogPage = new FoodLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", FoodLogPage.class.getName()));
        LOGGER.info("Search food");
        foodLogPage.searchFood();
        AddToFoodLogPage addToFoodLogPage = new AddToFoodLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", AddToFoodLogTest.class.getName()));
        LOGGER.info(String.format("Get the title  %s of expected food name", addToFoodLogPage.getExpectedTitleOfFood()));
        String expectedFoodName = addToFoodLogPage.getExpectedTitleOfFood();
        LOGGER.info("Add food to Log");
        addToFoodLogPage.clickAddToFoodLogButton();
        LOGGER.info(String.format("Get the title  %s of actual food name", foodLogPage.actualTitleOfFood()));
        String actualFoodName=foodLogPage.actualTitleOfFood();
        LOGGER.info(String.format("Check if actual food name %s and expected food name  %s are identical",actualFoodName,expectedFoodName));
        Assert.assertEquals(actualFoodName, expectedFoodName, "Food wasn't added");

    }

    @Test(priority = 2, description = "User deletes food from FoodLog")
    public void deleteFood() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to ActivityLog Page");
        dashboardPage.clickAddButtonFoodLog();
        FoodLogPage foodLogPage = new FoodLogPage(driver);
        LOGGER.info(String.format("Page %s initialized", FoodLogPage.class.getName()));
        LOGGER.info(String.format("Get  amount %s of food title in Log before delete",foodLogPage.getAmountOfEditIconsBeforeDelete() ));
        int expectedAmount = foodLogPage.getAmountOfEditIconsBeforeDelete();
        LOGGER.info("Click the edit icon");
        foodLogPage.clickEditIcon();
        LOGGER.info("Delete food");
        foodLogPage.deleteFood();
        LOGGER.info(String.format("Get  amount %s of food title in Log after delete",foodLogPage.getAmountOfEditIconsAfterDelete()));
        int actualAmount=foodLogPage.getAmountOfEditIconsAfterDelete();
        LOGGER.info(String.format("Check if actual amount %s and expected amount  %s are identical",actualAmount,expectedAmount));
        Assert.assertEquals(actualAmount, expectedAmount, "Amount wasn't changed");


    }
}
