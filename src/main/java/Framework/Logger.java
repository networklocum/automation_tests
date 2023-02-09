package Framework;

import org.slf4j.LoggerFactory;

public class Logger {

    protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    /**
     * Used to print out information into INFO log level.
     */
    public static void info(String log) {
        logger.info(log);
    }

    /**
     * Used to print out information into ERROR log level.
     */
    public static void err(String log) {
        logger.error(log);
    }

    /**
     * Used to print out information into DEBUG log level
     */
    public static void debug(String log) {
        logger.debug(log);
    }
}


