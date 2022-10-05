package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FreeAccountPage;
import pages.LoginPage;
import pages.PremiumPage;

public class PremiumTest extends BaseTest {
    @Test
    public void upgradeToPremium() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.upgradeToPremium();
        PremiumPage premiumPage = new PremiumPage(driver);
        premiumPage.clickBuyNowButton();
        FreeAccountPage accountPage = new FreeAccountPage(driver);
        Assert.assertEquals(accountPage.checkTitleOfButton(), "Create Premium Account", "It's impossible to upgrade to Premium");
    }
}
