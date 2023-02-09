package lantum.Rota.PageObject;

import Framework.Selenium.BasePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lantum.Rota.Model.Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewTemplateOverlay extends BasePage {
    ElementsCollection selectElements = $$(By.xpath("//form[@data-testid='template-editor-form']//div[contains(@class,'react-select__placeholder')]"));
    ElementsCollection dropdownOptions = $$(By.xpath("//div[contains(@class,'react-select__option')]/div"));
    ElementsCollection shiftTypes = $$(".shift-type");
    ElementsCollection shiftDays = $$(".table-row div.empty-shift-type");
    SelenideElement nameInput = $("#templateName");
    SelenideElement publishButton = $(By.xpath("//button[text()='Publish']"));

    public TemplatesPage createTemplate(Template template) {
        select("Select a site", template.Site);
        select("Select a template type", template.Type);
        select("Select staff type", template.StaffType);
        select("Select number of weeks", Integer.toString(template.NumberOfWeeks));
        nameInput.sendKeys(template.Name);
        selectShiftTypes();
        publishButton.click();
        return new TemplatesPage();
    }

    private void select(String dropDownName, String option) {
        selectElements.should(CollectionCondition.anyMatch("", x -> x.getText().equals(dropDownName)));
        selectElements.stream().filter(x -> x.text().equals(dropDownName)).findFirst().get().click();

        dropdownOptions.should(CollectionCondition.anyMatch("", x -> x.getText().equals(option)));
        dropdownOptions.stream().filter(x -> x.text().equals(option)).findFirst().get().click();
    }

    private void selectShiftTypes() {
        //TODO: expand for receiving matrix with types and days as input parameter
        shiftTypes.first().click();
        shiftDays.first().click();
    }
}
