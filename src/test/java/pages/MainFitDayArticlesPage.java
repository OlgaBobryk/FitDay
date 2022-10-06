package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainFitDayArticlesPage extends BasePage {
    private List<WebElement> sectionsOfArticlesLinks;

    public MainFitDayArticlesPage(WebDriver driver) {
        super(driver);
    }

    public SectionArticlesPage clickSectionOfArticleLink() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='columns-holder']//h2")));
        sectionsOfArticlesLinks = driver.findElements(By.xpath("//div[@class='columns-holder']//h2//a"));
        WebElement elementArticle = sectionsOfArticlesLinks.get(1);
        elementArticle.click();
        return new SectionArticlesPage(driver);

    }
}
