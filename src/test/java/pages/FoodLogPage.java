package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;

public class FoodLogPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(FoodLogPage.class.getName());


    private By foodSearch = By.xpath("//div[@id='food-search-bar']//form[@class='fd-search-bar']//input");
    private List<WebElement> searchedFoodList;
    private List<WebElement> addedFoodList;
    private List<WebElement> editIconsList;
    private By deleteButton = By.xpath("//div[@id='food-bottom']//div[@class='ib-options']//a[1]");


    public FoodLogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search and choose food")
    public AddToFoodLogPage searchFood() {
        LOGGER.debug(String.format("Input food in search field find %s to list food", foodSearch));
        driver.findElement(foodSearch).sendKeys("cake");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='food-search-all']//ul[@class='fd-breadcrumbs']//li//a[@class='default']")));
        LOGGER.debug("Add to list all searched food, choose one and add");
        searchedFoodList = driver.findElements(By.xpath("//tr[contains(@class, 'foods')]//td[@class='name']//a"));
        searchedFoodList.get(FakeMessageGenerator.generateNumberToThree()).click();
        return new AddToFoodLogPage(driver);
    }

    @Step("Get  name of last added food")
    public String actualTitleOfFood() {
        addedFoodList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='name']"));
        int size = addedFoodList.size();
        return addedFoodList.get(size - 1).getText();
    }

    @Step("List and amount edit icons before delete")
    public int getAmountOfEditIconsBeforeDelete() {
        editIconsList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        return editIconsList.size();
    }

    @Step("Choose food for delete")
    public FoodLogPage clickEditIcon() {
        LOGGER.debug("Add edit icons for food  to list and choose one to click");
        editIconsList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        editIconsList.get(FakeMessageGenerator.generateNumberToThree()).click();
        return this;
    }

    @Step("Delete food")
    public FoodLogPage deleteFood() {
        LOGGER.debug(String.format("Attempt to click  Delete button find %s", deleteButton));
        driver.findElement(deleteButton).click();
        return this;

    }

    @Step("List and amount edit icons after delete")
    public int getAmountOfEditIconsAfterDelete() {
        editIconsList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        return editIconsList.size();


    }
}

