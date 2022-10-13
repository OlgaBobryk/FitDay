package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LifestylePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LifestylePage.class.getName());

    private By kindOfLifestyle=By.xpath("//table[@class='ib-list'][2]//td//label");
    private List<WebElement> kindsOfLifestyle;
    private By saveButtonForLifestyle = By.xpath("//div[@class='actions']//div[@class='right']//a[2]");


    public LifestylePage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose Lifestyle")
    public String chooseLifestyle() {
        LOGGER.debug("Add all kinds of LifeStyle to list");
        kindsOfLifestyle = driver.findElements(kindOfLifestyle);
        WebElement lifestyleElement = kindsOfLifestyle.get(3);
        lifestyleElement.click();
        return lifestyleElement.getText();
    }

    @Step("Save Lifestyle")
    public ActivityLogPage clickSaveButtonForChangeLifestyle() {
        LOGGER.debug(String.format("Click save button find %s", saveButtonForLifestyle));
        driver.findElement(saveButtonForLifestyle).click();
        return new ActivityLogPage(driver);
    }
}
