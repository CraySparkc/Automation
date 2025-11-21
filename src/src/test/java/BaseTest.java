import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
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

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
