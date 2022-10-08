package pages;


import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainFitDayArticlesPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(MainFitDayArticlesPage.class.getName());


    private List<WebElement> sectionsOfArticlesLinks;

    public MainFitDayArticlesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose and click article link")
    public SectionArticlesPage clickSectionOfArticleLink() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='columns-holder']//h2")));
        LOGGER.debug("Add links of article sections to list, choose one and click it");
        sectionsOfArticlesLinks = driver.findElements(By.xpath("//div[@class='columns-holder']//h2//a"));
        sectionsOfArticlesLinks.get(1).click();
        return new SectionArticlesPage(driver);

    }
}
