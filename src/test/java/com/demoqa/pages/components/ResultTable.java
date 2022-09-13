package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {

    public void checkVisibility() {
        $(".modal-dialog").should(appear);

    }

    public void checkResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }
}
