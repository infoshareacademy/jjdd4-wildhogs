package com.infoshareacademy.jjdd4.wildhogs.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ConcurrentNavigableMap;

public class Configuration extends Properties {

    public static final String CONFIG_PATH = "config.properties";
    private final Properties properties;

    public Configuration(Properties properties ){

        this.properties = properties;
    }

    public Configuration() {

        properties = new Properties();

        try {
            properties.load(new FileInputStream(CONFIG_PATH));

//            System.out.println("SETTINGS");
//            System.out.println("========");

//            Enumeration<?> enumeration = properties.propertyNames();
//            while (enumeration.hasMoreElements()) {
//                String propertyName = (String) enumeration.nextElement();
//                String propertyValue = (String) properties.get(propertyName);
//
//                System.out.println(propertyName + "= " + propertyValue);
//            }
        } catch (IOException e) {
            System.err.println("nie wczytano pliku konfiguracyjnego");
        }
    }

    public String getJsonPath() {
        return properties.getProperty("jsonPath", "recipes.json");
    }
}
