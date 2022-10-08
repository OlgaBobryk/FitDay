package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {


    private By sectionLink = By.xpath("//div[@id='articles_container']//a");

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get title of article section")
    public String checkSection() {
        return driver.findElement(sectionLink).getText();
    }
}
