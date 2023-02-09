package lantum.Swaps;

import Framework.BrowserProvider;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.AppiumClickOptions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwapsTests {
    @BeforeTest
    public static void  ConfigureAgent(){
        Configuration.browser = BrowserProvider.class.getName();
        Configuration.browserSize = null;
        open();
    }

    @Test
    public static void AddSwapsTest() throws MalformedURLException {
        $(By.xpath(".//*[@text='Enter email address']")).shouldBe(Condition.exist, Duration.ofSeconds(180));
        $(By.xpath(".//*[@text='Enter email address']")).sendKeys("serhii.severyn+test+5@lantum.com");
        $(By.xpath(".//*[@text='Enter password']")).sendKeys("TestTesting122333");
        $(By.xpath(".//*[@text='Log in']")).click();
        $(By.xpath(".//*[@text='Create a new swap']")).shouldBe(Condition.exist, Duration.ofSeconds(180));
        $(By.xpath(".//*[@text='Create a new swap']/parent::android.view.ViewGroup")).click(AppiumClickOptions.tap());
        $(By.xpath(".//*[@class='android.widget.HorizontalScrollView']//*[class='android.widget.EditText'][1]")).shouldBe(Condition.exist, Duration.ofSeconds(20));
        $(By.xpath(".//*[@class='android.widget.HorizontalScrollView']//*[class='android.widget.EditText'][1]")).sendKeys("Study");
    }
}
