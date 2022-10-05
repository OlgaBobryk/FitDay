package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ArticleTest extends BaseTest {
    @Test
    public void checkArticleSection() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFitDayWithValidData();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickArticlesLink();
        MainFitDayArticlesPage mainFitDayArticlesPage = new MainFitDayArticlesPage(driver);
        mainFitDayArticlesPage.clickSectionOfArticleLink();
        SectionArticlesPage sectionsArticlesPage = new SectionArticlesPage(driver);
        String expectedSection = sectionsArticlesPage.getSectionTitle();
        sectionsArticlesPage.chooseArticle();
        ArticlePage articlePage = new ArticlePage(driver);
        Assert.assertEquals(articlePage.checkSection(), expectedSection, "It's an another section");
    }
}
