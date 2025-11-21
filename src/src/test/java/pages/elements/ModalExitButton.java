package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class ModalExitButton {
    private String name;
    private SelenideElement selector;

    public ModalExitButton(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    @Step("Проверить если есть модальное окно - закрыть его")
    public ModalExitButton ModalCheck(){
        try {
            selector.shouldBe(Condition.visible)
                    .click();
        } catch (Exception e) {
            step("Окно не появилось, продолжаем тест");
        }
        sleep(2000);
        return this;
    }
}
