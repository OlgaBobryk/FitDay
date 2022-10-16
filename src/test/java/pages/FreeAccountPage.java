package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FreeAccountPage extends BasePage {

    private By createAccountButton = By.xpath("//div[@class='Holder']//div//a//span");

    public FreeAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Title of button for Premium")
    public String checkTitleOfButton() {
        return driver.findElement(createAccountButton).getText();
    }
}
