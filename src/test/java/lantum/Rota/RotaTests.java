package lantum.Rota;

import Framework.Configuration.Settings;
import Framework.Reporting.Xray;
import lantum.Rota.Model.Template;
import lantum.Rota.PageObject.LoginPage;
import lantum.Rota.TestData.TemplateFactory;
import lantum.Rota.TestData.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class RotaTests {
    protected Settings settings;

    @BeforeClass
    public void LoadSettings() {
        settings = new Settings();
    }

    @Test
    @Xray(labels = "rota-smoke", test = "TEST-265")
    public void RollingRotaTest() {
        Template template = TemplateFactory.DefaultRollingTemplate();
        open(settings.getDefaultUrl());

        LoginPage loginPage = new LoginPage();
        loginPage.SignIn(settings.GetDefaultUser())
                .impersonate(Users.getManagerUser())
                .openRotaTab()
                .clickTemplatesButton()
                .clickCreateTemplateButton()
                .createTemplate(template)
                .FilterByStaffType("Consultant")
                .VerifyTemplatePresence(template);
    }
}
