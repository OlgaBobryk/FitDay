package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PremiumPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(PremiumPage.class.getName());

    private By buyNowButton = By.xpath("//div[@class='Intro']//div[2]//span");


    public PremiumPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click BuyNow button")
    public FreeAccountPage clickBuyNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyNowButton));
        LOGGER.debug(String.format("Attempt to click BuyNow button find %s", buyNowButton));
        driver.findElement(buyNowButton).click();
        return new FreeAccountPage(driver);
    }
}
