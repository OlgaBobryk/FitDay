package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToFoodLogPage;
import pages.DashboardPage;
import pages.FoodLogPage;
import pages.LoginPage;


public class AddToFoodLogTest extends BaseTest {


    @Test(priority = 1, description = "User choose food from search list and add it to FoodLog")
    public void addFood() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddButtonFoodLog();
        FoodLogPage foodLogPage = new FoodLogPage(driver);
        foodLogPage.searchFood();
        AddToFoodLogPage addToFoodLogPage = new AddToFoodLogPage(driver);
        String expectedElement = addToFoodLogPage.expectedTitleOfFood();
        addToFoodLogPage.clickAddToFoodLogButton();
        Assert.assertEquals(foodLogPage.actualTitleOfFood(), expectedElement, "Food wasn't added");

    }

    @Test (priority = 2, description = "User deletes food from FoodLog")
    public void deleteFood() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAddButtonFoodLog();
        FoodLogPage foodLogPage = new FoodLogPage(driver);
        int expectedAmount = foodLogPage.getAmountOfEditIconsBeforeDelete();
        foodLogPage.clickEditIcon();
        foodLogPage.deleteFood();
        Assert.assertEquals(foodLogPage.getAmountOfEditIconsAfterDelete(), expectedAmount, "Amount wasn't changed");


    }
}
