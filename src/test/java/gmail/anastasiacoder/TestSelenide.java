package gmail.anastasiacoder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenide {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    public void checkJUnit5(){
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5 extension"));
    }
}
