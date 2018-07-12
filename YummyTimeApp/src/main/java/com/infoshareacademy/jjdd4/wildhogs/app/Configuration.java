package com.infoshareacademy.jjdd4.wildhogs.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration extends Properties {

    private static final String CONFIG_PATH = "YummyTimeApp/config.properties";
    private final Properties properties;

    public Configuration(Properties properties) {
        this.properties = properties;
    }

    public Configuration() {

        properties = new Properties();

        try {
            properties.load(new FileInputStream(CONFIG_PATH));
        } catch (IOException e) {
            System.err.println("nie wczytano pliku konfiguracyjnego");
        }
    }

    public String getJsonPath() {
        return properties.getProperty("YummyTimeApp/jsonPath", "YummyTimeApp/recipes.json");
    }

    public String getSavedRecipesFilePath() {
        return properties.getProperty("savedRecipesFilePath", "ShoppingList.txt");
    }
}
