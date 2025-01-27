import data.Categories;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

public class TestsForStoreJUnitTest extends TestBaseForStore {

    @EnumSource(Categories.class)
    @ParameterizedTest(name = "В категории {0} должен быть выбранный товар")
    void searchForProductsInCategoriesJUnitTest(Categories category) {
        open("");
        $("[class=list-group").$(byTextCaseInsensitive(category.name())).click();
        $("[id=tbodyid]").shouldHave(text(category.text));
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
