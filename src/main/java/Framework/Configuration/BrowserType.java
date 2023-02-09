package Framework.Configuration;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum BrowserType {
    FIREFOX,
    CHROME,
    SAFARI;

    private static Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

    /** Provides initialization of string keys for browser types. */
    static {
        browsersMap.put("firefox", BrowserType.FIREFOX);
        browsersMap.put("chrome", BrowserType.CHROME);
        browsersMap.put("safari", BrowserType.SAFARI);
    }

    /**
     * Used for access to browser type through key value.
     *
     * @param name String parameter which stands for key value for specific browser type.
     * @return Browser type which corresponds to entered key value.
     */
    public static BrowserType Browser(String name) {
        BrowserType browserType = null;
        if (name != null) {
            browserType = browsersMap.get(name.toLowerCase().trim());
            if (browserType == null) {
                throw new UnknownBrowserException("Unknown browser [" + name + "]. Use one of following: "
                        + StringUtils.join(browsersMap.keySet().toArray(), ", "));
            }
        }

        return browserType;
    }

}


