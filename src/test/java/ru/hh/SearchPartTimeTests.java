package ru.hh;

import org.junit.jupiter.api.Test;
import ru.hh.pages.AdvancedSearchPage;

public class SearchPartTimeTests extends TestBase {
    private AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    @Test
    void fillSearchFormTest() {
        advancedSearchPage.openPage()
                .setProfileInput("Информационные технологии", "Тестировщик")
                .setRegion("Россия")
                .setSideJob("Неполный день")
                .setSideJob("От 4 часов в день")
                .setSideJob("По выходным")
                .setSideJob("По вечерам")
                .getVacancies();

        advancedSearchPage.verifyResult("Неполный день")
                .verifyResult("От 4 часов в день")
                .verifyResult("По выходным")
                .verifyResult("По вечерам");
    }

//    @Test
//    void loginTest() {
//        open("/signup");
//    }
}
