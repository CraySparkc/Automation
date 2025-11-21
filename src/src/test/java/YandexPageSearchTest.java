import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class YandexPageSearchTest extends BaseTest{
    protected final SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Тест по поиску в Яндекс через PageObject и PageElement")
    @Tag("two")
    public void YandexSearchCheck(){
        searchPage.fullSearch();
    }
}
