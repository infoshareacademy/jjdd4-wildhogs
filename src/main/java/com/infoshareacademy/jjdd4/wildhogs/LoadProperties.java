package com.infoshareacademy.jjdd4.wildhogs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProperties {

    public static final String resourcesPath = "/home/mateuszmazur/jjdd4-wildhogs/src/main/Resources/config.properties";

    public static void getSettings() {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(resourcesPath));
            Enumeration<?> enumeration = prop.propertyNames();

            System.out.println("Setting:\n");
            while (enumeration.hasMoreElements()) {
                String propertyName = enumeration.nextElement().toString();
                System.out.println(propertyName + " ==> " + prop.get(propertyName));
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
    }
}
