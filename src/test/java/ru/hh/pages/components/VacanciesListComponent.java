package ru.hh.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class VacanciesListComponent {
    public void verifyResultListAppears() {
        ElementsCollection count = $$(".serp-item");
        $("[data-qa='vacancies-search-header']").should(appear);
        //todo работает только если: все вакансии на 1 странице, >=5 вакансий в десятке
        $("[data-qa='bloko-header-3']").shouldHave(text("Найдено " + count.size() + " вакансий"));
    }

    public void verifyResultSideJob(String key) {
        $(byText(key)).parent().parent().$("input:nth-child(1)").shouldBe(checked);
    }

    public void verifyResultRegion(String key) {
        $(byText("Регион")).scrollTo();
        List<SelenideElement> regionsList = $$(xpath("//input[@value='113']"));
        for (SelenideElement se : regionsList) {
            if (se.getText().equals(key)) {
                se.should(checked);
            }
        }
        //System.out.println($(".bloko-text bloko-text_strong").parent().getAttribute("class"));
        //System.out.println($(".novafilters-group-wrapper").$(byText("Регион")));
    }
}
