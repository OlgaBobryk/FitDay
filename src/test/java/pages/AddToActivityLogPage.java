package pages;

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


    public AddToActivityLogPage addHoursForActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='hours']")));
        WebElement hours = driver.findElement(hoursInput);
        hours.clear();
        hours.sendKeys(timeHours);
        return this;
    }

    public AddToActivityLogPage addMinutesForActivity() {
        WebElement minutes = driver.findElement(minutesInput);
        minutes.clear();
        minutes.sendKeys(timeMinutes);
        return this;
    }

    public ActivityLogPage clickAddToActivityButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activity-add-top']//div[@class='right']//a")));
        driver.findElement(addToActivityLogButton).click();
        return new ActivityLogPage(driver);

    }

    public String getTitleOfExpectedActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activity-add-top']//p[1]")));
        return driver.findElement(activityToAdd).getText();

    }
}

