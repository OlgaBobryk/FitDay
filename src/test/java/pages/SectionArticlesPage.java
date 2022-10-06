package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;

public class SectionArticlesPage extends BasePage {
    private By section = By.xpath("//h2[@id='page-title']");
    private List<WebElement> nutritionArticlesList;

    public SectionArticlesPage(WebDriver driver) {
        super(driver);
    }

    public String getSectionTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='page-title']")));
        return driver.findElement(section).getText();
    }

    public ArticlePage chooseArticle() {
        nutritionArticlesList = driver.findElements(By.xpath("//p[@class='more-link']//a"));
        nutritionArticlesList.get(FakeMessageGenerator.generateNumberToEighteen()).click();
        return new ArticlePage(driver);
    }
}
