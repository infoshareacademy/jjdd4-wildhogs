package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.logic.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("STARTING SESSION");

        Menu menu = new Menu();
        menu.optionPicker();

        logger.info("ENDING SESSION");
    }
}
