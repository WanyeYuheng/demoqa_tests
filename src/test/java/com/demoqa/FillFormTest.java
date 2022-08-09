package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Tester");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(new ByText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(new ByText("Music")).click();
        $("#hobbiesWrapper").$(new ByText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("image/test.png");
        $("#currentAddress").setValue("some address");
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $(".table-responsive table").shouldHave(text("Tester"), text("Test"),
                text("test@test.com"), text("Other"), text("31 August,2000"),
                text("Maths"), text("Music"), text("Sports"), text("test.png"),
                text("some address"), text("Haryana Karnal"));

    }
}
