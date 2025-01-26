import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BlockSearchInCategoryJUnitTest extends TestBaseForInnopolis {

    @CsvSource(value = {
            "Университет Иннополис, Контакты",
            "Лицей Иннополис, Контакты"
    })
    @ParameterizedTest(name = "В категории {0} должнен быть блок {1}")
    void successfulBlockSearchInCategoryJUnitTest(String category, String block) {
        open("ru");
        $("[data-menu=\"headmenu3\"]").click();
        $("[class=\"header_menu is-open\"]").$(byText(category)).click();
        $("[class=\"facts__list\"]").shouldHave(text(block));

    }


}
