import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchForTextAboutTaxJUnitTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://www.demoblaze.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @ValueSource(strings = {
            "Sony vaio i5", "Sony vaio i7", "MacBook air", "Dell i7 8gb"
    })
    @ParameterizedTest(name = "В карточке {0} должна быть надпись про включенный в стоимость налог")
    void successfulSearchForTextAboutTaxJUnitTest(String category) {
        open("");
        $("[onclick=\"byCat('notebook')\"]").click();
        $("[id=tbodyid]").$(byText(category)).click();
        $("[class=price-container]").shouldHave(text(" *includes tax"));
    }
}
