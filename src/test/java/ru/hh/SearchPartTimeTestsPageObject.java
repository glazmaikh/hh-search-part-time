package ru.hh;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.hh.pages.AdvancedSearchPage;

@Disabled
public class SearchPartTimeTestsPageObject extends TestBase {
    private AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    TestData testData = new TestData();
    @Test
    void fillSearchFormTest() {
        advancedSearchPage.openPage()
                .setProfileInput("Информационные технологии", "Тестировщик")
                .setRegion("Россия")
                .setSideJob(testData.getTypesJob("Неполный день",
                        "От 4 часов в день",
                        "По выходным",
                        "По вечерам"))
                .getVacancies();

        advancedSearchPage.verifyResultSideJob(
                testData.getTypesJob("Неполный день",
                        "От 4 часов в день",
                        "По выходным",
                        "По вечерам"
                )
        );

        advancedSearchPage.verifyResultRegion("Россия");
    }

//    @Test
//    void loginTest() {
//        open("/signup");
//    }
}
