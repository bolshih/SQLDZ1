package ru.netology.bank.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.bank.data.DataHelper;
import ru.netology.bank.data.SQLHelper;
import ru.netology.bank.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.bank.data.SQLHelper.cleanDatabase;

public class BankTest {
    @AfterAll
    static void tearDown() {
        cleanDatabase();
    }

    @BeforeEach
    public void setup() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    void souldTestLogin() {
        new LoginPage().loginCorr(DataHelper.getAuthInfo()).verify(SQLHelper.getCode());
    }

    @Test
    void souldTestLoginWrongData() {
        var authInfo = DataHelper.genRandomUser();
        var loginPage = new LoginPage();
        loginPage.loginWr(authInfo);
    }


}
