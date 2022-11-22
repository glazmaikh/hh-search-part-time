package ru.hh.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.hh.pages.components.ProfileComponent;
import ru.hh.pages.components.VacanciesListComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdvancedSearchPage {
    private final String TITLE_TEXT = "Поиск вакансий";
    private ProfileComponent profileComponent = new ProfileComponent();
    private VacanciesListComponent vacanciesListComponent = new VacanciesListComponent();

    private SelenideElement
            profileInput = $("[data-qa=resumesearch__profroles-switcher]"),
            regionInput = $("[data-qa=advanced-search__selected-regions]"),
            partWork = $("data-qa='advanced-search__part_time-item_employment_part'"),
            fourWork = $("data-qa='advanced-search__part_time-item-label_from_four_to_six_hours_in_a_day'"),
            weekendWork = $("data-qa='advanced-search__part_time-item-label_only_saturday_and_sunday'"),
            eveningWork = $("data-qa='advanced-search__part_time-item-label_start_after_sixteen'");

    public AdvancedSearchPage openPage() {
        open("/search/vacancy/advanced");
        $(".bloko-header-1").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('.banner-place-frame').remove()");
        return this;
    }

    public AdvancedSearchPage setProfileInput(String category, String profile) {
        profileInput.scrollTo().click();
        profileComponent.verifyModalAppears();
        profileComponent.setProfile(category, profile);
        return this;
    }

    public AdvancedSearchPage setRegion(String region) {
        if (!regionInput.getText().equals("Россия")) {
            $(regionInput).$(".bloko-tag-button").click();
            $("[data-qa='advanced-search-region-add']").val(region);
        }
        return this;
    }

    public AdvancedSearchPage setSideJob(String job) {
        $(byText("Подработка")).scrollTo();
        $(byText(job)).click();
        return this;
    }

    public AdvancedSearchPage getVacancies() {
        $("[data-qa='advanced-search-submit-button']").should(appear).click();
        return this;
    }

    public AdvancedSearchPage verifyResult(String key) {
        vacanciesListComponent.verifyResultListAppears();
        vacanciesListComponent.verifyResult(key);
        return this;
    }
}
