package ru.netology.bank.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomLogin() {
        return faker.name().username();
    }

    public static String generateRandomPass() {
        return faker.internet().password();
    }

    public static AuthInfo genRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPass());
    }

    @Value
    public static class VerificationCode {
        private String code;
    }
}


