package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;


public class ActivityLogPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ActivityLogPage.class.getName());

    private By searchForActivity = By.xpath("//select[@id='activity-browse']");
    private By activityListResultsTable = By.xpath("//form[@id='result-activities']//table[@class='ib-list results']");
    private By addIcon = By.xpath("//a[@class='add icon']");
    private By activity = By.xpath("//table[@class='ib-list']//tbody/tr[contains(@class, 'activity')]//td[1]");
    private List<WebElement> addIconList;
    private List<WebElement> activityList;
    private By lifeStyle = By.xpath("//td[@class='name']//a");
    private int selectedIndex=FakeMessageGenerator.generateNumberToEighteen();


    public ActivityLogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose kind of activity from list")
    public ActivityLogPage chooseActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchForActivity));
        WebElement dropdownList = driver.findElement(searchForActivity);
        Select selectOption = new Select(dropdownList);
        LOGGER.debug(String.format("Attempt to choose one kind of activities by index %s from dropdownList find %s", selectedIndex, searchForActivity));
        selectOption.selectByIndex(selectedIndex);
        return this;
    }

    @Step("Choose activity")
    public AddToActivityLogPage addActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(activityListResultsTable));
        LOGGER.debug(String.format("Attempt to choose activity by index %s from List and click addIcon ", 0));
        addIconList = driver.findElements(addIcon);
        addIconList.get(0).click();
        return new AddToActivityLogPage(driver);
    }

    @Step("Get title of activity")
    public String getTitleOfActivityToAdd() {
        activityList = driver.findElements(activity);
        LOGGER.debug(String.format("Attempt to get amount %s of activity", activityList.size()));
        int size = activityList.size();
        return activityList.get(size - 1).getText();
    }

    @Step("Go to LifeStyle Page")
    public LifestylePage clickLifeStyleChoose() {
        LOGGER.debug(String.format("Attempt to click link Lifestyle %s and to open new page", lifeStyle));
        driver.findElement(lifeStyle).click();
        return new LifestylePage(driver);
    }

    @Step("Get kind of Lifestyle after changing")
    public String getActualKindOfLifestyle() {
        return driver.findElement(lifeStyle).getText();
    }
}
