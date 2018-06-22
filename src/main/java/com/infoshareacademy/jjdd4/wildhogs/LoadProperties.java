package com.infoshareacademy.jjdd4.wildhogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProperties {


    public LoadProperties() {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(getResourcesPath()));
            Enumeration<?> enumeration = prop.propertyNames();

            System.out.println("SETTINGS");
            System.out.println("========");
            while (enumeration.hasMoreElements()) {
                String propertyName = enumeration.nextElement().toString();
                System.out.println(propertyName + "= " + prop.get(propertyName));
            }

        } catch (IOException e) {
            System.err.println("nie wczytano pliku konfiguracyjnego");
        }
    }

    public String getResourcesPath() {
        return new File("config.properties").getAbsolutePath();
    }
}
