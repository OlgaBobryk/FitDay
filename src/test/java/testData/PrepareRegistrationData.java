package testData;

import models.RegistrationModel;
import utils.FakeMessageGenerator;

public class PrepareRegistrationData {

    public static RegistrationModel getIncorrectPassword() {
        String password = FakeMessageGenerator.generatePassword();


        return RegistrationModel
                .builder()
                .username(FakeMessageGenerator.generateUsername())
                .password(password)
                .confirmPassword(password)
                .email(FakeMessageGenerator.generateEmail())
                .build();
    }

}
