package Framework.Selenium;

import Framework.Configuration.Settings;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @Getter
    @Setter
    protected String path;

    public void navigate() {
        open(Settings.getDefaultUrl() + path);
    }

    public String getUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
