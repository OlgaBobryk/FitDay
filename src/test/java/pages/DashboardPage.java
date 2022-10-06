package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    private By logoutLink = By.xpath("//a[@class='logout']");
    private By articlesLink = By.xpath("//div[@id='menu']//ul//li[4]//a//span");
    private By addButtonFoodLog = By.xpath("//td[1]//a[@class ='add button']");
    private By addButtonActivityLog = By.xpath("//td[2]//a[@class ='add button']");
    private By profileLink = By.xpath("//div[@id='menu']//div[@class='fd-submenu']//ul[1]//li[3]//a");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean logoutLinkIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
        return driver.findElement(logoutLink).isDisplayed();
    }

    public MainFitDayArticlesPage clickArticlesLink() {
        driver.findElement(articlesLink).click();
        return new MainFitDayArticlesPage(driver);
    }

    public FoodLogPage clickAddButtonFoodLog() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//a[@class ='add button']")));
        driver.findElement(addButtonFoodLog).click();
        return new FoodLogPage(driver);

    }

    public ActivityLogPage clickAddButtonActivityLog() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]//a[@class ='add button']")));
        driver.findElement(addButtonActivityLog).click();
        return new ActivityLogPage(driver);
    }

    public ProfilePage clickProfileLink() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='menu']//div[@class='fd-submenu']//ul[1]//li[3]//a")));
        driver.findElement(profileLink).click();
        return new ProfilePage(driver);
    }
}
