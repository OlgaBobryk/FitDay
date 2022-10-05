package pages;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

public class LoginPage extends BasePage {

    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@name='Password']");
    private By loginButton = By.xpath("//input[@name='login']");
    private By logInForm =By.xpath("//h1");
    private By upgradeLink=By.xpath("//h2//a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(Urls.LOGIN_URL);
        return this;
    }

    public DashboardPage loginToFitDayWithValidData() {
        driver.findElement(usernameField).sendKeys(Credentials.USERNAME_FOR_LOGIN);
        driver.findElement(passwordField).sendKeys(Credentials.PASSWORD_FOR_LOGIN);
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);

    }
    public DashboardPage loginUnregisteredUser(){
        driver.findElement(usernameField).sendKeys(FakeMessageGenerator.generateUsername());
        driver.findElement(passwordField).sendKeys(FakeMessageGenerator.generatePassword());
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
    public boolean logInFormDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        return driver.findElement(logInForm).isDisplayed();
    }

    public void upgradeToPremium(){
        driver.findElement(upgradeLink).click();
        return;
    }


}
