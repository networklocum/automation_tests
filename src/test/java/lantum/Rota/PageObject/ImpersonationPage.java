package lantum.Rota.PageObject;

import Framework.Selenium.BasePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ImpersonationPage extends BasePage {
    private SelenideElement searchInput = $("input[name=search]");
    private ElementsCollection searchResults = $$("div[ng-repeat=\"user in users\"]");

    public DashboardPage impersonate(String username){
        searchInput.shouldBe(Condition.appear, Duration.ofSeconds(15));
        searchInput.sendKeys(username);
        searchResults.shouldBe(CollectionCondition.sizeNotEqual(0));
        searchResults.first().click();
        return new DashboardPage();
    }
}
