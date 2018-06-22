package com.infoshareacademy.jjdd4.wildhogs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProperties {

    private static final String RESOURCES_PATH = "config.properties";

    public static void printSettings() {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(RESOURCES_PATH));
            Enumeration<?> enumeration = prop.propertyNames();

            System.out.println("SETTINGS");
            System.out.println("========");
            while (enumeration.hasMoreElements()) {
                String propertyName = enumeration.nextElement().toString();
                System.out.println(propertyName + ": " + prop.get(propertyName));
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
