package Framework.Configuration;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utilitarian class which provides initialization of all project properties as well access to them.
 */
public class ConfigProvider {

    private final Properties properties = new Properties();

    private final String devUrl;
    private final String stageUrl;
    private final String prodUrl;
    private final String grid;
    private final String port;
    private final String device;
    private final String browser;
    private final String environment;
    private final String project;
    private final String headerAuth;
    private final String defaultUserPassword;
    private final String mainUser;
    private final String appiumUrl;
    private final String threadsCount;

    /**
     * Constructor. Provides initialization of all class fields.
     */

    public ConfigProvider() {
        try (InputStream propertyStream = ConfigProvider.class.getResourceAsStream("/environment.properties")) {
            properties.load(propertyStream);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while loading selenium.properties", e);
        }
        devUrl = getConfigParameter("dev.public.site.url");
        stageUrl = getConfigParameter("stage.public.site.url");
        prodUrl = getConfigParameter("prod.public.site.url");
        grid = getConfigParameter("selenium.grid", "localhost");
        appiumUrl = getConfigParameter("appium.url", "http://localhost:4723/wd/hub");
        port = getConfigParameter("selenium.grid.port", "4444");
        device = getConfigParameter("device", "Nexus 6");
        project = getConfigParameter("project", "Rota");
        environment = getConfigParameter("environment", "stage");
        browser = getConfigParameter("selenium.browser");
        headerAuth = getConfigParameter("header.auth", "");
        mainUser = getConfigParameter("main.user", "Framework.User");
        defaultUserPassword = getConfigParameter("user.password", "Testpassword1");
        threadsCount = getConfigParameter("thread.count", "1");
    }

    public String getAppiumUrl() {
        return appiumUrl;
    }

    public String getMainUserName() {
        return mainUser;
    }

    public String getDefaultUserPassword() {
        return defaultUserPassword;
    }


    public String getStageUrl() {
        return stageUrl;
    }

    public String getHeaderAuth() {
        return headerAuth;
    }

    public String getDevUrl() {
        return devUrl;
    }

    public String getProdUrl() {
        return prodUrl;
    }


    public String getBrowser() {
        return browser;
    }

    private String getConfigParameter(String key) {
        return getConfigParameter(key, null);
    }

    private String getConfigParameter(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null) {
            if (properties.getProperty(key) != null) {
                return properties.getProperty(key);
            } else if (defaultValue != null) {
                return defaultValue;
            }
            throw new RuntimeException("Configuration value not found for key '" + key + "'");
        }
        return value;
    }

    public String getProject() {
        return project;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getGrid() {
        return grid;
    }

    public String getPort() {
        return port;
    }

    public String getDevice() {
        return device;
    }

    public String getThreadsCount() {
        return threadsCount;
    }

}

