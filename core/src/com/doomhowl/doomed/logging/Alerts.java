package com.doomhowl.doomed.logging;

import java.util.logging.Logger;

public class Alerts {
    private static final Logger LOGGER = Logger.getGlobal();

    public static void error(String msg) {
        LOGGER.severe(msg);
    }

    public static void errorNotFound(String path) {
        Alerts.error("File or directory " + path + " does not exist!");
    }
}
