import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YandexSearchTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.headless = false; // установите true для запуска без UI
        SelenideLogger.addListener("AllureSelenide", new io.qameta.allure.selenide.AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true)
        );
    }

    @Test
    @DisplayName("Тест по поиску в Яндекс")
    void SearchTest() {
        step("Открываем браузер на странице Яндекса");
        open("https://ya.ru");
        sleep(2000);

        step("Вводим в поисковую строку значение");
        $(By.id("text"))
                .setValue("Тестирование Selenide")
                .pressEnter();
        sleep(2000);

        step("Проверить, что результаты загрузились");
        $(By.id("search-result"))
                .shouldBe(Condition.visible);
        sleep(2000);

        step("Проверить если есть модальное окно - закрыть его");
        try {
            $(By.xpath("//button[@aria-label='Нет, спасибо']"))
                    .shouldBe(Condition.visible)
                    .click();
        } catch (Exception e) {
            step("Окно не появилось, продолжаем тест");
        }
        sleep(2000);

        step("Проверить логотип Яндекс");
        $(By.xpath("//a[@aria-label='Яндекс']"))
                .shouldBe(Condition.visible);
    }
}