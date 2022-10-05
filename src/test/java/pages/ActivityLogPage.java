package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;

public class ActivityLogPage extends BasePage {

    private By searchForActivity = By.xpath("//select[@id='activity-browse']");
    List<WebElement> addIconList;
    List<WebElement> activityList;
    private By lifeStyle = By.xpath("//td[@class='name']//a");


    public ActivityLogPage(WebDriver driver) {
        super(driver);
    }

    public ActivityLogPage chooseActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='activity-browse']")));
        WebElement dropdownList = driver.findElement(searchForActivity);
        Select selectOption = new Select(dropdownList);
        selectOption.selectByIndex(FakeMessageGenerator.generateNumberToEighteen());
        return this;
    }

    public AddToActivityLogPage addActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='result-activities']//table[@class='ib-list results']")));
        addIconList = driver.findElements(By.xpath("//a[@class='add icon']"));
        addIconList.get(1).click();
        return new AddToActivityLogPage(driver);
    }

    public String checkActivityToAdd() {
        activityList = driver.findElements(By.xpath("//table[@class='ib-list']//tbody/tr[contains(@class, 'activity')]//td[1]"));
        int size = activityList.size();
        return activityList.get(size - 1).getText();

    }

    public LifestylePage clickLifeStyleChoose() {
        driver.findElement(lifeStyle).click();
        return new LifestylePage(driver);
    }

    public String getActualKindOfLifestyle() {
        return driver.findElement(lifeStyle).getText();


    }
}
