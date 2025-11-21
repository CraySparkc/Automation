package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.elements.ModalExitButton;
import pages.elements.SearchInput;
import pages.elements.SearchReasult;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    protected final SearchInput searchInput = new SearchInput("Поисковая строка Яндекса", $(By.id("text")));
    protected final SearchReasult pageReasults = new SearchReasult("Результаты поиска", $(By.id("search-result")));
    protected final SearchReasult logoYa = new SearchReasult("Логотип Яндекса", $(By.xpath("//a[@aria-label='Яндекс']")));
    protected final ModalExitButton exitButton = new ModalExitButton("Кнопка нет спасибо на модальном окне Сделать Яндекс основным браузером", $(By.xpath("//button[@aria-label='Нет, спасибо']")));

    @Step("Открыть страницу Яндекса")
    public SearchPage openYandex(){
        open("https://ya.ru");
        return this;
    }

    public SearchPage fullSearch(){
       openYandex().searchInput.SearchForText("Git шпаргалка");
       pageReasults.SearchReasultCheck();
       exitButton.ModalCheck();
       logoYa.SearchReasultCheck();
       return this;
    }
}
