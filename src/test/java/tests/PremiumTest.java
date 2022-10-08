package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FreeAccountPage;
import pages.LoginPage;
import pages.PremiumPage;
import utils.RetryAnalyzer;

public class PremiumTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(PremiumTest.class.getName());

    @Test (description = "User tries to upgrade the account to Premium", retryAnalyzer = RetryAnalyzer.class)
    public void upgradeToPremium() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Upgrade account to Premium");
        loginPage.upgradeToPremium();
        PremiumPage premiumPage = new PremiumPage(driver);
        LOGGER.info(String.format("Page %s initialized", PremiumPage.class.getName()));
        LOGGER.info("Buy Premium");
        premiumPage.clickBuyNowButton();
        FreeAccountPage accountPage = new FreeAccountPage(driver);
        LOGGER.info(String.format("Page %s initialized", FreeAccountPage.class.getName()));
        LOGGER.info(String.format("Check if the CreatePremiumAccount button  is %s",accountPage.checkTitleOfButton()));
        Assert.assertEquals(accountPage.checkTitleOfButton(), "Create Premium Account", "It's impossible to upgrade to Premium");
    }
}
