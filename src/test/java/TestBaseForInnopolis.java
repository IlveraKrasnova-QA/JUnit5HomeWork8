import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseForInnopolis {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://www.innopolis.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
