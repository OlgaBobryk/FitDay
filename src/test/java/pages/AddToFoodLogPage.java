package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddToFoodLogPage extends BasePage {
    private By addToFoodLogButton = By.xpath("//div[@id='food-add-actions']//div[@class='right']//a[1]");
    private By foodToAdd = By.xpath("//div[@id='food-add-dialog']//p[1]");


    public AddToFoodLogPage(WebDriver driver) {
        super(driver);
    }


    public FoodLogPage clickAddToFoodLogButton() {
        driver.findElement(addToFoodLogButton).click();
        return new FoodLogPage(driver);
    }

    public String expectedTitleOfFood() {
        return driver.findElement(foodToAdd).getText();


    }

}
