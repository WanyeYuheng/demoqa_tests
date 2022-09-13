package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FillFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FillFormWithPageObjectsTest {
    FillFormPage fillFormPage = new FillFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        fillFormPage.openPage()
                .setFirstName("Tester")
                .setLastName("Test")
                .setEmail("test@test.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("31", "August", "2000")
                .setSubjects("Maths")
                .setHobbies("Music")
                .setPicture("image/test.png")
                .setAddress("some address")
                .setState("Haryana")
                .setCity("Karnal");

        fillFormPage.clickSubmit();

        fillFormPage.checkResultTable()
                .checkResult("Student Name", "Tester Test")
                .checkResult("Student Email", "test@test.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "31 August,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "test.png")
                .checkResult("Address", "some address")
                .checkResult("State and City", "Haryana Karnal");

    }
}
