package lantum.Rota.PageObject;

import Framework.Selenium.BasePage;
import Framework.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private SelenideElement emailInput = $("#email");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement submitButton = $("button[type=submit]");

    public ImpersonationPage SignIn(User user) {
        AcceptCookies();
        emailInput.shouldBe(Condition.appear, Duration.ofSeconds(15));
        emailInput.sendKeys(user.Email);
        passwordInput.sendKeys(user.Password);
        submitButton.click();
        return new ImpersonationPage();
    }

    private void AcceptCookies(){
        $("#hs-eu-confirmation-button").click();
    }
}
