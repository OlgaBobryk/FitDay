package tests;

import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import pages.LoginPage;
import testData.PrepareRegistrationData;

public class CreateNewAccountTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateNewAccountTest.class.getName());


    @Test(description = "User creates the account with incorrect data ")

    public void createAccountWithIncorrectPassword() {
        CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
        LOGGER.info(String.format("Page %s initialized", CreateNewAccountPage.class.getName()));
        LOGGER.info(String.format("Open %s page", CreateNewAccountPage.class.getName()));
        createNewAccountPage.openRegistrationPage();
        LOGGER.info("Fill registration form with incorrect password");
        RegistrationModel registrationModel = PrepareRegistrationData.getIncorrectPassword();
        LOGGER.info(String.format("Input username %s",registrationModel.getUsername() ));
        createNewAccountPage.inputUsername(registrationModel.getUsername());
        LOGGER.info(String.format("Input password %s",registrationModel.getPassword()));
        createNewAccountPage.inputPassword(registrationModel.getPassword());
        LOGGER.info(String.format("Confirm password %s",registrationModel.getPassword()));
        createNewAccountPage.confirmPassword(registrationModel.getPassword());
        LOGGER.info(String.format("Input email %s",registrationModel.getEmail()));
        createNewAccountPage.inputEmail(registrationModel.getEmail());
        LOGGER.info("End registration");
        createNewAccountPage.clickSignUpButton();
        LOGGER.info("Check if Error message is displayed");
        Assert.assertTrue(createNewAccountPage.errorMessageForPasswordIsDisplayed(), "Error message isn't displayed");

    }
}
