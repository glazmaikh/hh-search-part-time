package ru.hh.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacanciesListComponent {
    public void verifyResultListAppears() {
        ElementsCollection count = $$(".serp-item");
        $("[data-qa='vacancies-search-header']").should(appear);
        //todo работает только если: все вакансии на 1 странице, >=5 вакансий в десятке
        $("[data-qa='bloko-header-3']").shouldHave(text("Найдено " + count.size() + " вакансий"));
    }

    public void verifyResult(String key) {
        $(byText(key)).parent().parent().$("input:nth-child(1)").shouldBe(checked);
    }
}
