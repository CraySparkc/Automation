package pages;

import com.codeborne.selenide.SelenideElement;
import pages.elements.CalendarDatePicker;
import pages.elements.ResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticePage {

    private final CalendarDatePicker calendar = new CalendarDatePicker();
    private final ResultModal result = new ResultModal();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            mobilePhoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsAutocompleteInput = $("#subjectsInput"),
            hobbiesCheckboxWrapper = $("#hobbiesWrapper"),
            pictureUploader = $("#uploadPicture"),
            addressTextarea = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateAndCitySelectWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit");
            //pageHeader = $(".main-header"),
            //formHeader = $(".practice-form-wrapper > h5");


    public PracticePage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticePage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticePage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticePage setGender(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public PracticePage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);
        return this;
    }

    public PracticePage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticePage setSubjects(String value) {
        subjectsAutocompleteInput.setValue(value).pressEnter();
        return this;
    }

    public PracticePage setHobby(String value) {
        hobbiesCheckboxWrapper.$(byText(value)).click();
        return this;
    }

    public PracticePage setPicture(String value) {
        pictureUploader.uploadFromClasspath(value);
        return this;
    }

    public PracticePage setAddress(String value) {
        addressTextarea.setValue(value);
        return this;
    }

    public PracticePage setState(String value) {
        stateDropdown.click();
        stateAndCitySelectWrapper.$(byText(value)).click();
        return this;
    }

    public void setCity(String value) {
        cityDropdown.click();
        stateAndCitySelectWrapper.$(byText(value)).click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public PracticePage checkResultsTableVisible() {
        result.checkVisible();
        return this;
    }

    public PracticePage checkResult(String key, String value) {
        result.checkResult(key, value);
        return this;
    }

    public PracticePage checkResultIsEmpty(String key) {
        result.checkResultIsEmpty(key);
        return this;
    }

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        //pageHeader.shouldHave(text("Practice Form"));
        //formHeader.shouldHave(text(FORM_HEADER_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
