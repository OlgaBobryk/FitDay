package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RegistrationModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;


}
