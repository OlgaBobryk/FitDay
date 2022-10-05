package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LifestylePage extends BasePage{
    List<WebElement> kindsOfLifestyle;
    private By saveButtonForLifestyle=By.xpath("//div[@class='actions']//div[@class='right']//a[2]");

    public LifestylePage(WebDriver driver) {
        super(driver);
    }

    public String  chooseLifestyle(){
        kindsOfLifestyle=driver.findElements(By.xpath("//table[@class='ib-list'][2]//td//label"));
        WebElement lifestyleElement= kindsOfLifestyle.get(3);
        lifestyleElement.click();
        return lifestyleElement.getText();

    }
    public ActivityLogPage clickSaveButtonForChangeLifestyle(){
        driver.findElement(saveButtonForLifestyle).click();
        return new ActivityLogPage(driver);
    }
}
