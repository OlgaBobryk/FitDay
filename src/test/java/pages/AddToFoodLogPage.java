package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AddToFoodLogTest;


public class AddToFoodLogPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AddToFoodLogPage.class.getName());


    private By addToFoodLogButton = By.xpath("//div[@id='food-add-actions']//div[@class='right']//a[1]");
    private By foodToAdd = By.xpath("//div[@id='food-add-dialog']//p[1]");


    public AddToFoodLogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click AddToFoodLog button")
    public FoodLogPage clickAddToFoodLogButton() {
        LOGGER.debug(String.format("Click button find %s", addToFoodLogButton));
        driver.findElement(addToFoodLogButton).click();
        return new FoodLogPage(driver);
    }

    @Step("Get expected food name")
    public String getExpectedTitleOfFood() {
        return driver.findElement(foodToAdd).getText();


    }

}
