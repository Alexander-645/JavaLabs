package org.rptp.java.Logger;

import org.rptp.java.Main;

import javax.lang.model.element.Name;
import java.util.logging.*;

public class MyLogger {
    public String MyName;
    public static void getLogger() throws NoSuchFieldException {
        final Logger LOGGER_A = Logger.getLogger(("MyName"));
        final Logger LOGGER_J = Logger.getLogger("org.rptp.java");
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new XMLFormatter());
        LOGGER_A.setUseParentHandlers(false);
        LOGGER_A.log(Level.ALL, "");
    }
}
