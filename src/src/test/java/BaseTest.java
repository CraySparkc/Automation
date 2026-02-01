import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {
    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 60000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
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
