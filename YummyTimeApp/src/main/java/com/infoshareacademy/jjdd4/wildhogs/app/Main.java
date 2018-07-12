package com.infoshareacademy.jjdd4.wildhogs.app;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.infoshareacademy.jjdd4.wildhogs.logic.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {



    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("starting app");
        Menu menu = new Menu();
        menu.optionPicker();

        logger.info("ending app");

logger.error("test");

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
