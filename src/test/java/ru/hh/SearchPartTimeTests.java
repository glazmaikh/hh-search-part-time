package ru.hh;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SearchPartTimeTests extends TestBase {
    SelenideElement searchingForm = $("[data-qa='advanced-vacancy-search__form']");
    SelenideElement submitButton = $(".bloko-modal-footer").find(byText("Выбрать"));
    SelenideElement employmentFindDiv = $(".novafilters");
    ElementsCollection count = $$(".serp-item");

    @Test
    void createPartTimeSearchTest() {
        step("open Advanced Search page", () -> {
            open("/search/vacancy/advanced");
        });
        step("set category of profile", () -> {
            searchingForm.find(byText("Указать специализации")).click();
            $(".bloko-tree-selector-popup-content").find(byText("Информационные технологии"))
                    .ancestor("div").$(".bloko-tree-selector-item-spacer").click();
        });
        step("set profile", () -> {
            $(".bloko-tree-selector__items").find(byText("Тестировщик")).click();
            submitButton.click();
        });
        step("set region", () -> {
            searchingForm.find(byText("Москва")).ancestor(".bloko-tag-list")
                    .sibling(0).$(".bloko-input-text").val("Россия");
        });
        step("set remote", () -> {
            searchingForm.find(byText("Удаленная работа")).click();
        });
        step("set part-time employment", () -> {
            searchingForm.find(byText("Неполный день")).scrollTo().click();
            searchingForm.find(byText("От 4 часов в день")).click();
            searchingForm.find(byText("По выходным")).click();
            searchingForm.find(byText("По вечерам")).click();
        });
        step("check result", () -> {
            $(".search-submit-wrapper").find(byText("Найти")).click();
            $(".bloko-header-section-3").shouldHave(text("Найден"));

            employmentFindDiv.find(byText("Неполный день")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("От 4 часов в день")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("По выходным")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("По вечерам")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("Россия")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("Тестировщик")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
            employmentFindDiv.find(byText("Удаленная работа")).ancestor("label")
                    .$(".bloko-checkbox__input").shouldBe(checked);
        });
    }
}
