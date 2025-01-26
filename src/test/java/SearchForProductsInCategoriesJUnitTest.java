import com.codeborne.selenide.Configuration;
import data.Categories;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchForProductsInCategoriesJUnitTest extends TestBaseForStore {

    @EnumSource(Categories.class)
    @ParameterizedTest(name = "В категории {0} должен быть выбранный товар")
    void searchForProductsInCategoriesJUnitTest(Categories category) {
        open("");
        $("[class=list-group").$(byText(category.name())).click();
        $("[id=tbodyid]").shouldHave(text(category.text));
    }
}
