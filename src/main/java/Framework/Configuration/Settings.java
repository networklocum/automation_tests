package Framework.Configuration;

import Framework.User;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.InvalidArgumentException;


public class Settings {
    public static BrowserType browser;
    public static ConfigProvider config;

    /**
     * Constructor.
     */
    public Settings() {
        loadSettings();
        Configuration.timeout = 20000;
    }

    /**
     * Will load settings based on properties from {@link ConfigProvider}
     */
    private void loadSettings() {
        config = new ConfigProvider();
        browser = BrowserType.Browser(config.getBrowser());
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
    }

    /**
     * Provides information about default environment URL.
     *
     * @return URL which is default for specified environment.
     */
    public static String getDefaultUrl() {
        if (config.getEnvironment().equalsIgnoreCase("dev")) {
            return config.getDevUrl();
        }
        if (config.getEnvironment().equalsIgnoreCase("stage")) {
            return config.getStageUrl();
        }
        if (config.getEnvironment().equalsIgnoreCase("prod")) {
            return config.getProdUrl();
        }
        throw new InvalidArgumentException("Environment was not specified correctly");
    }

    public static User GetDefaultUser() {
        return new User(config.getMainUserName(), config.getDefaultUserPassword());
    }
}
