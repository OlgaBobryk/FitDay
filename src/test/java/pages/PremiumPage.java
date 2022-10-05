package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PremiumPage extends BasePage {
    private By buyNowButton = By.xpath("//div[@class='Intro']//div[2]//span");


    public PremiumPage(WebDriver driver) {
        super(driver);
    }

    public FreeAccountPage clickBuyNowButton() {
        driver.findElement(buyNowButton).click();
        return new FreeAccountPage(driver);
    }
}
