package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchInput {
    private String name;
    private SelenideElement selector;

    public SearchInput(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    @Step("Поиск текста в строке поиска")
    public SearchInput SearchForText(String text){
        selector.shouldBe(Condition.visible)
                .setValue(text)
                .pressEnter();
        sleep(2000);
        return this;
    }
}
