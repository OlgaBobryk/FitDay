package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateNewAccountPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateNewAccountPage.class.getName());


    private By usernameField = By.xpath("//input[@id='Username']");
    private By passwordField = By.xpath("//input[@id='Password1']");
    private By confirmPasswordField = By.xpath("//input[@id='Password2']");
    private By emailField = By.xpath("//input[@name='Email']");
    private By signupButton = By.xpath("//input[@value='Sign Up']");
    private By errorMessageForPassword = By.xpath("//p[@class='error'][2]");

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page with registration form")
    public CreateNewAccountPage openRegistrationPage() {
        LOGGER.debug(String.format("Attempt to open Url %s", Urls.CREATE_ACCOUNT_URL));
        driver.get(Urls.CREATE_ACCOUNT_URL);
        return this;
    }

    @Step("Input username")
    public CreateNewAccountPage inputUsername(String username) {
        LOGGER.debug(String.format("Attempt to input username %s into the field find %s", username,usernameField));
        driver.findElement(this.usernameField).sendKeys(username);
        return this;
    }

    @Step("Input password")
    public CreateNewAccountPage inputPassword(String password) {
        LOGGER.debug(String.format("Attempt to input password %s into the field find %s", password,passwordField));
        driver.findElement(this.passwordField).sendKeys(password);
        return this;
    }

    @Step("Confirm password")
    public CreateNewAccountPage confirmPassword(String password) {
        LOGGER.debug(String.format("Attempt to confirm password %s into the field find %s", password,confirmPasswordField));
        driver.findElement(this.confirmPasswordField).sendKeys(password);
        return this;
    }

    @Step("Input email")
    public CreateNewAccountPage inputEmail(String email) {
        LOGGER.debug(String.format("Attempt to input email %s into the field find %s", email,emailField));
        driver.findElement(this.emailField).sendKeys(email);
        return this;
    }

    @Step("Click SignUp button")
    public CreateNewAccountPage clickSignUpButton() {
        LOGGER.debug(String.format("Attempt to click button find %s", signupButton));
        driver.findElement(signupButton).click();
        return this;
    }

    @Step("Error message is displayed")
    public boolean errorMessageForPasswordIsDisplayed() {
        return driver.findElement(errorMessageForPassword).isDisplayed();

    }

}
