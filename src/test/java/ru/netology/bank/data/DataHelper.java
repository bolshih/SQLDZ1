package ru.netology.bank.data;

import lombok.Value;

public class DataHelper {

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getAuthInfoWrong() {

        return new AuthInfo("vasya", "qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }
}


