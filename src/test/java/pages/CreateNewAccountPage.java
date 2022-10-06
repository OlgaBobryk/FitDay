package pages;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewAccountPage extends BasePage {
    private By username = By.xpath("//input[@id='Username']");
    private By password = By.xpath("//input[@id='Password1']");
    private By confirmPassword = By.xpath("//input[@id='Password2']");
    private By email = By.xpath("//input[@name='Email']");
    private By signupButton = By.xpath("//input[@value='Sign Up']");
    private By errorMessageForPassword = By.xpath("//p[@class='error'][2]");

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewAccountPage openRegistrationPage() {
        driver.get(Urls.CREATE_ACCOUNT_URL);
        return this;
    }

    public CreateNewAccountPage inputUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
        return this;
    }

    public CreateNewAccountPage inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public CreateNewAccountPage confirmPassword(String password) {
        driver.findElement(confirmPassword).sendKeys(password);
        return this;
    }

    public CreateNewAccountPage inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }


    public CreateNewAccountPage clickSignUpButton() {
        driver.findElement(signupButton).click();
        return this;
    }

    public boolean errorMessageForPasswordIsDisplayed() {
        return driver.findElement(errorMessageForPassword).isDisplayed();

    }

}
