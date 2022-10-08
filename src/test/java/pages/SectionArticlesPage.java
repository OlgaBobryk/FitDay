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

public class SectionArticlesPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(SectionArticlesPage.class.getName());


    private By section = By.xpath("//h2[@id='page-title']");
    private List<WebElement> articlesList;
    private int indexOfArticle=FakeMessageGenerator.generateNumberToEighteen();

    public SectionArticlesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get section title")
    public String getSectionTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='page-title']")));
        return driver.findElement(section).getText();
    }

    @Step("Choose article")
    public ArticlePage chooseArticle() {
        LOGGER.debug(String.format("Add all article of its section to list,choose one by index %s",  indexOfArticle));
        articlesList = driver.findElements(By.xpath("//p[@class='more-link']//a"));
        articlesList.get(indexOfArticle).click();
        return new ArticlePage(driver);
    }
}
