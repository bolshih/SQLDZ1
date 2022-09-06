package ru.netology.bank.pages;


import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class CabinetPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");

    public CabinetPage() {
        heading.shouldBe(visible);
    }
}
