import data.PracticeData;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticePage;
import static io.qameta.allure.Allure.step;

public class PracticePageTest extends BaseTest {

    private final PracticeData data = new PracticeData();
    private final PracticePage practicePage = new PracticePage();

    @DisplayName("Заполить все поля на форме")
    @Flaky
    @Test
    void maxDataFillFormTest() {
        step("Открыть форму для практики", practicePage::openPage);

        step("Заполнить форму", () -> practicePage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobilePhone(data.mobilePhone)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subject)
                .setHobby(data.hobbie)
                .setPicture(PracticeData.PICTURE)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city));

        step("Подтвердить заполнение формы", practicePage::clickSubmit);

        step("Проверить результаты", () -> {
            practicePage.checkResultsTableVisible().checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.mobilePhone)
                    .checkResult("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                    .checkResult("Subjects", data.subject)
                    .checkResult("Hobbies", data.hobbie)
                    .checkResult("Picture", PracticeData.PICTURE)
                    .checkResult("Address", data.address)
                    .checkResult("State and City", data.state + " " + data.city);
        });
    }

        @DisplayName("Заполнить форму с минимальным набором значений")
        @Test
        void minDataFillFormTest() {
            step("Открыть форму для практики", practicePage::openPage);

            step("Заполнить форму", () -> {
                practicePage.setFirstName(data.firstName)
                        .setLastName(data.lastName)
                        .setGender(data.gender)
                        .setMobilePhone(data.mobilePhone)
                        .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth);
            });

            step("Подтвердить заполнение формы", practicePage::clickSubmit);

            step("Проверить результаты", () -> {
                practicePage.checkResultsTableVisible()
                        .checkResult("Student Name", data.firstName + " " + data.lastName)
                        .checkResultIsEmpty("Student Email")
                        .checkResult("Gender", data.gender)
                        .checkResult("Mobile", data.mobilePhone)
                        .checkResult("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                        .checkResultIsEmpty("Subjects")
                        .checkResultIsEmpty("Hobbies")
                        .checkResultIsEmpty("Picture")
                        .checkResultIsEmpty("Address")
                        .checkResultIsEmpty("State and City");
            });
    }
}
