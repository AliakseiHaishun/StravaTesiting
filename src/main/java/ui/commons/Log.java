package ui.commons;

import java.util.logging.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger("Logger");


    public static void info(String message) {
        logger.info(message);
    }

}
