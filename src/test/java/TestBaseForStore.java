import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseForStore {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://www.demoblaze.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
