package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTable resultTable = new ResultTable();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    public FillFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public FillFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public FillFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public FillFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public FillFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public FillFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public FillFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public FillFormPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public FillFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public FillFormPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public FillFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public FillFormPage setState(String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public FillFormPage setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public FillFormPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public FillFormPage checkResultTable() {
        resultTable.checkVisibility();

        return this;
    }

    public FillFormPage checkResult(String key, String value) {
        resultTable.checkResults(key, value);

        return this;
    }

}