package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FakeMessageGenerator;

public class ProfilePage extends BasePage {

    private By editButtonForProfile = By.xpath("//div[@class='right']//a[@class='edit button']");
    private By saveButtonForProfile = By.xpath("//div[@class='actions']//div[@class='right']//a[2]");
    private By heightInput = By.xpath("//input[@id='profile-height-meters']");
    private By heightData=By.xpath("//span[@id='profile-height-form']");
    public String height1 = String.valueOf(FakeMessageGenerator.generateHeight());


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage clickEditButton() {
        driver.findElement(editButtonForProfile).click();
        return this;
    }

    public ProfilePage changeHeight() {
        WebElement element = driver.findElement(heightInput);
        element.clear();
        element.sendKeys(height1);
        return this;

    }

    public ProfilePage clickSaveButton() {
        driver.findElement(saveButtonForProfile).click();
        return this;
    }

    public String getExpectedHeight() {
        return height1;
    }

    public String checkHeight() {
        driver.findElement(editButtonForProfile).click();
        return driver.findElement(heightInput).getAttribute("value");

    }

}

