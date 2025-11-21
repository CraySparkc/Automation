package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchReasult {
    private String name;
    private SelenideElement selector;

    public SearchReasult(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    @Step("Проверить, что результаты загрузились")
    public SearchReasult SearchReasultCheck(){
        selector.shouldBe(Condition.visible);
        sleep(2000);
        return this;
    }
}
