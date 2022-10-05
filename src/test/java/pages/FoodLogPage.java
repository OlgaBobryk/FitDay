package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;

public class FoodLogPage extends BasePage {

    private By foodSearch = By.xpath("//div[@id='food-search-bar']//form[@class='fd-search-bar']//input");
    List<WebElement> searchedFoodList;
    List<WebElement> addedFoodList;
    List<WebElement> editIconsList;
    private By amountInput = By.xpath("//div[@id='food-bottom']//td[@class='default-amount']//input[@name='amount']");
    private By deleteButton=By.xpath("//div[@id='food-bottom']//div[@class='ib-options']//a[1]");


    public FoodLogPage(WebDriver driver) {
        super(driver);
    }


    public AddToFoodLogPage searchFood() {
        driver.findElement(foodSearch).sendKeys("cake");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='food-search-all']//ul[@class='fd-breadcrumbs']//li//a[@class='default']")));
        searchedFoodList = driver.findElements(By.xpath("//tr[contains(@class, 'foods')]//td[@class='name']//a"));
        searchedFoodList.get(FakeMessageGenerator.generateNumberToThree()).click();
        return new AddToFoodLogPage(driver);
    }

    public String actualTitleOfFood() {
        addedFoodList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='name']"));
        int size = addedFoodList.size();
        return addedFoodList.get(size - 1).getText();
    }

    public int getAmountOfEditIconsBeforeDelete() {
        editIconsList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        return editIconsList.size();
    }

    public FoodLogPage clickEditIcon() {
        editIconsList=driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        editIconsList.get(FakeMessageGenerator.generateNumberToThree()).click();
        return this;
    }

    public FoodLogPage deleteFood() {
        driver.findElement(deleteButton).click();
        return this;

    }


    public int getAmountOfEditIconsAfterDelete() {
        editIconsList = driver.findElements(By.xpath("//div[@id='food-bottom']//div[@id='food-log']//td[@class='actions']"));
        return editIconsList.size();


    }
}

