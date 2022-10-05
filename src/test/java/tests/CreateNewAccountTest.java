package tests;

import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import testData.PrepareRegistrationData;

public class CreateNewAccountTest extends BaseTest {

    @Test
    public void createAccountWithIncorrectPassword() {
        CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
        createNewAccountPage.openRegistrationPage();
        RegistrationModel registrationModel = PrepareRegistrationData.getIncorrectPassword();
        createNewAccountPage.inputUsername(registrationModel.getUsername());
        createNewAccountPage.inputPassword(registrationModel.getPassword());
        createNewAccountPage.confirmPassword(registrationModel.getPassword());
        createNewAccountPage.inputEmail(registrationModel.getEmail());
        createNewAccountPage.clickSignUpButton();
        Assert.assertTrue(createNewAccountPage.errorMessageForPasswordIsDisplayed(),"Error message isn't displayed");

    }
}
