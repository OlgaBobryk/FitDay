package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ArticleTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ArticleTest.class.getName());

    @Test (description = "User chooses an article from an section")
    @Description("User tries to choose an article and check its article section")

    public void checkArticleSection() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Log in to FitDay");
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        LOGGER.info(String.format("Page %s initialized", DashboardPage.class.getName()));
        LOGGER.info("Go to Article Page");
        dashboardPage.clickArticlesLink();
        MainFitDayArticlesPage mainFitDayArticlesPage = new MainFitDayArticlesPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainFitDayArticlesPage.class.getName()));
        LOGGER.info("Choose section of articles");
        mainFitDayArticlesPage.clickSectionOfArticleLink();
        SectionArticlesPage sectionsArticlesPage = new SectionArticlesPage(driver);
        LOGGER.info(String.format("Page %s initialized", SectionArticlesPage.class.getName()));
        LOGGER.info(String.format("Get the title %s of an expected article section", sectionsArticlesPage.getSectionTitle()));
        String expectedSection = sectionsArticlesPage.getSectionTitle();
        LOGGER.info("Choose an article of the section");
        sectionsArticlesPage.chooseArticle();
        ArticlePage articlePage = new ArticlePage(driver);
        LOGGER.info(String.format("Page %s initialized", ArticlePage.class.getName()));
        LOGGER.info(String.format("Get the title %s of an actual article section", articlePage.checkSection()));
        String actualSection = articlePage.checkSection();
        LOGGER.info(String.format("Check if an actual section %s and an  expected section %s are identical", actualSection,expectedSection));
        Assert.assertEquals(actualSection, expectedSection, "It's an another section");
    }
}
