package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FakeMessageGenerator;

public class ProfilePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProfilePage.class.getName());


    private By editButtonForProfile = By.xpath("//div[@class='right']//a[@class='edit button']");
    private By saveButtonForProfile = By.xpath("//div[@class='actions']//div[@class='right']//a[2]");
    private By heightInput = By.xpath("//input[@id='profile-height-meters']");
    public String height1 = String.valueOf(FakeMessageGenerator.generateHeight());


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Edit button")
    public ProfilePage clickEditButton() {
        LOGGER.debug(String.format("Attempt to click Edit button find %s", editButtonForProfile));
        driver.findElement(editButtonForProfile).click();
        return this;
    }

    @Step("Change Height")
    public ProfilePage changeHeight() {
        LOGGER.debug(String.format("Attempt to clear field find %s", heightInput));
        WebElement element = driver.findElement(heightInput);
        element.clear();
        LOGGER.debug(String.format("Attempt to input new value of height %s", height1));
        element.sendKeys(height1);
        return this;

    }

    @Step("Save changing of height")
    public ProfilePage clickSaveButton() {
        LOGGER.debug(String.format("Attempt to click Save button find %s", saveButtonForProfile));
        driver.findElement(saveButtonForProfile).click();
        return this;
    }

    @Step("Get expected value of height")
    public String getExpectedHeight() {
        return height1;
    }

    @Step("Check actual value of height")
    public String checkValueOfHeight() {
        driver.findElement(editButtonForProfile).click();
        return driver.findElement(heightInput).getAttribute("value");

    }

}

