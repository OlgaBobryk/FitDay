package utils;

import com.github.javafaker.Faker;


public class FakeMessageGenerator {

    public static String generateUsername() {
        return new Faker().name().username();
    }

    public static String generatePassword() {
        return new Faker().numerify("#####");
    }

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generateAmount() {
        return new Faker().numerify("#");
    }

    public static Double generateHeight() {
        return new Faker().number().randomDouble(2, 1, 2);
    }

    public static int generateHours() {
        return new Faker().number().numberBetween(1, 24);
    }

    public static Integer generateMinutes() {
        return new Faker().number().numberBetween(1, 60);
    }

    public static Integer generateNumberToEighteen() {
        return new Faker().random().nextInt(2, 18);
    }

    public static Integer generateNumberToThree() {
        return new Faker().random().nextInt(1, 3);
    }
}


