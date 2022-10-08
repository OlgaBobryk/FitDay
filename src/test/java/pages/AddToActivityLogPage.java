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

public class AddToActivityLogPage extends BasePage {

    private By addToActivityLogButton = By.xpath("//div[@id='activity-add-top']//div[@class='right']//a");
    private By hoursInput = By.xpath("//input[@name='hours']");
    private By minutesInput = By.xpath("//input[@name='minutes']");
    private String timeHours = String.valueOf(FakeMessageGenerator.generateHours());
    private String timeMinutes = String.valueOf(FakeMessageGenerator.generateMinutes());
    private By activityToAdd = By.xpath("//div[@id='activity-add-top']//p[1]");


    public AddToActivityLogPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LogManager.getLogger(AddToActivityLogPage.class.getName());

    @Step("Enter hours for activity")
    public AddToActivityLogPage addHoursForActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='hours']")));
        LOGGER.debug(String.format("Clear field find %s for enter hours", hoursInput));
        WebElement hours = driver.findElement(hoursInput);
        hours.clear();
        LOGGER.debug(String.format("Enter new hours %s", timeHours));
        hours.sendKeys(timeHours);
        return this;
    }

    @Step("Enter minutes for activity")
    public AddToActivityLogPage addMinutesForActivity() {
        LOGGER.debug(String.format("Clear field find %s for enter hours", minutesInput));
        WebElement minutes = driver.findElement(minutesInput);
        minutes.clear();
        LOGGER.debug(String.format("Enter new minutes %s", timeMinutes));
        minutes.sendKeys(timeMinutes);
        return this;
    }

    @Step("Click AddToActivityLog button")
    public ActivityLogPage clickAddToActivityButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activity-add-top']//div[@class='right']//a")));
        LOGGER.debug(String.format("Click AddToActivityLog button find %S", addToActivityLogButton));
        driver.findElement(addToActivityLogButton).click();
        return new ActivityLogPage(driver);

    }

    @Step("Get title of expected activity")
    public String getTitleOfExpectedActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activity-add-top']//p[1]")));
        return driver.findElement(activityToAdd).getText();

    }
}

