package lantum.Rota.PageObject;

import Framework.Selenium.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {
    private final SelenideElement rotaButton = $(By.xpath("//a[contains(text(),'Rota')]"));
    private final SelenideElement TemplatesButton = $(By.xpath("//span[text()='Templates']"));
    private final SelenideElement CreateTemplateButton = $(By.xpath("//button[text()='Create template']"));

    public DashboardPage openRotaTab(){
        rotaButton.click();
        return this;
    }

    public DashboardPage clickTemplatesButton(){
        TemplatesButton.click();
        return this;
    }

    public NewTemplateOverlay clickCreateTemplateButton(){
        CreateTemplateButton.click();
        return new NewTemplateOverlay();
    }

}
