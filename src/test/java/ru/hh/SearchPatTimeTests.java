package ru.hh;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchPatTimeTests {

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://webdrivers/chromedriver.exe");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1932x1160";
        Configuration.browserPosition = "-6x0";
        Configuration.baseUrl = "https://hh.ru";
    }

    @Test
    void fillSearchFormTest() {
        open("/search/vacancy/advanced");
    }
}
