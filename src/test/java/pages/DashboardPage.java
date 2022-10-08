package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(DashboardPage.class.getName());


    private By logoutLink = By.xpath("//a[@class='logout']");
    private By articlesLink = By.xpath("//div[@id='menu']//ul//li[4]//a//span");
    private By addButtonFoodLog = By.xpath("//td[1]//a[@class ='add button']");
    private By addButtonActivityLog = By.xpath("//td[2]//a[@class ='add button']");
    private By profileLink = By.xpath("//div[@id='menu']//div[@class='fd-submenu']//ul[1]//li[3]//a");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Log out link is displayed")
    public boolean logoutLinkIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
        return driver.findElement(logoutLink).isDisplayed();
    }

    @Step("Go to Article Page")
    public MainFitDayArticlesPage clickArticlesLink() {
        LOGGER.debug(String.format("Attempt to click link find %s and open Article Page", articlesLink));
        driver.findElement(articlesLink).click();
        return new MainFitDayArticlesPage(driver);
    }

    @Step("Go to FoodLog")
    public FoodLogPage clickAddButtonFoodLog() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//a[@class ='add button']")));
        LOGGER.debug(String.format("Attempt to click the Add button find %s and go to FoodLog Page", addButtonFoodLog));
        driver.findElement(addButtonFoodLog).click();
        return new FoodLogPage(driver);

    }

    @Step("Go to ActivityLog")
    public ActivityLogPage clickAddButtonActivityLog() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]//a[@class ='add button']")));
        LOGGER.debug(String.format("Attempt to click the Add button find %s and go to ActivityLog Page", addButtonActivityLog));
        driver.findElement(addButtonActivityLog).click();
        return new ActivityLogPage(driver);
    }

    @Step("Go to Profile")
    public ProfilePage clickProfileLink() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='menu']//div[@class='fd-submenu']//ul[1]//li[3]//a")));
        LOGGER.debug(String.format("Attempt to click link find %s and go to Profile Page", profileLink));
        driver.findElement(profileLink).click();
        return new ProfilePage(driver);
    }
}
