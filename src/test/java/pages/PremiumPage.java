package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PremiumPage extends BasePage {
    private By buyNowButton = By.xpath("//div[@class='Intro']//div[2]//span");


    public PremiumPage(WebDriver driver) {
        super(driver);
    }

    public FreeAccountPage clickBuyNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Intro']//div[2]//span")));
        driver.findElement(buyNowButton).click();
        return new FreeAccountPage(driver);
    }
}
