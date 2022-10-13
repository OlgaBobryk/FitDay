package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());


    private By usernameFieldForLogin = By.xpath("//input[@id='username']");
    private By passwordFieldForLogin = By.xpath("//input[@name='Password']");
    private By loginButton = By.xpath("//input[@name='login']");
    private By logInForm = By.xpath("//h1");
    private By upgradeLink = By.xpath("//h2//a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page for Login")
    public LoginPage openLoginPage() {
        LOGGER.debug(String.format("Attempt to open url %s", Urls.LOGIN_URL));
        driver.get(Urls.LOGIN_URL);
        return this;
    }

    @Step("Login of registered user")
    public DashboardPage loginToFitDayWithValidData() {
        LOGGER.debug(String.format("Attempt to input username %s into field find %s", Credentials.USERNAME_FOR_LOGIN, usernameFieldForLogin));
        driver.findElement(usernameFieldForLogin).sendKeys(Credentials.USERNAME_FOR_LOGIN);
        LOGGER.debug(String.format("Attempt to input password %s into field find %s", Credentials.PASSWORD_FOR_LOGIN, passwordFieldForLogin));
        driver.findElement(passwordFieldForLogin).sendKeys(Credentials.PASSWORD_FOR_LOGIN);
        LOGGER.debug(String.format("Attempt to click the button find %s", loginButton));
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    @Step("Login of unregistered user")
    public DashboardPage loginUnregisteredUser() {
        LOGGER.debug(String.format("Attempt to input username %s into field find %s", FakeMessageGenerator.generateUsername(), usernameFieldForLogin));
        driver.findElement(usernameFieldForLogin).sendKeys(FakeMessageGenerator.generateUsername());
        LOGGER.debug(String.format("Attempt to input password %s into field find %s", FakeMessageGenerator.generatePassword(), passwordFieldForLogin));
        driver.findElement(passwordFieldForLogin).sendKeys(FakeMessageGenerator.generatePassword());
        LOGGER.debug(String.format("Attempt to click the button find %s", loginButton));
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    @Step("Login form is displayed")
    public boolean logInFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInForm));
        return driver.findElement(logInForm).isDisplayed();
    }

    @Step("Upgrade account to Premium")
    public void upgradeToPremium() {
        LOGGER.debug((String.format("Attempt to click link find %s", upgradeLink)));
        driver.findElement(upgradeLink).click();
        return;
    }
}
