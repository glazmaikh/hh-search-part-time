package ru.hh.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfileComponent {
    public void verifyModalAppears() {
        $(".bloko-modal").should(appear);
        $(".bloko-modal-title").shouldHave(text("Специализация"));
    }

    public void setProfile(String category, String profile) {
        $(byText(category)).parent().parent().$(".bloko-tree-selector-item-spacer").click();
        $(byText(profile)).scrollTo().click();
        $("[data-qa='bloko-tree-selector-popup-submit']").click();
    }
}