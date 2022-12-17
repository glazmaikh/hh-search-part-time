package ru.hh;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public List<String> getTypesJob(String... strings) {
        return new ArrayList<>(List.of(strings));
    }
}
