package lantum.Rota.PageObject;

import Framework.Selenium.BasePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lantum.Rota.Model.Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TemplatesPage extends BasePage {
    private SelenideElement StaffTypesSelect = $(By.xpath("//div[@data-testid=\"multi-summary-dropdown\"]//div[contains(text(),'Select staff type')]"));
    private ElementsCollection DropdownOptions = $$(By.xpath("//label[@data-testid='option-with-checkbox']/label"));
    private ElementsCollection Templates = $$(By.xpath("//div[@role='row']"));

    public TemplatesPage FilterByStaffType(String staffType) {
        StaffTypesSelect.click();
        DropdownOptions.should(CollectionCondition.sizeGreaterThan(0));
        DropdownOptions.filter(Condition.text(staffType)).first().click();
        return this;
    }

    public void VerifyTemplatePresence(Template template) {
        //TODO: add verifications of created date and weeks schedule
        SelenideElement templateRow = $(By.xpath(String.format("//div[text()='%s']/ancestor::div[@role='row']", template.getName())));
        templateRow.shouldBe(Condition.exist);
        templateRow.find(By.xpath(".//div[@data-testid='badge']")).should(Condition.text("Published"));
        templateRow.find(By.xpath(".//div[contains(@id,'cell-staff-type-name')]/div")).should(Condition.text(template.getStaffType()));
        templateRow.find(By.xpath(".//div[contains(@id,'cell-site-name')]/div")).should(Condition.text(template.getSite()));
        templateRow.find(By.xpath(".//div[contains(@id,'cell-type')]")).should(Condition.text(template.getType()));
    }
}
