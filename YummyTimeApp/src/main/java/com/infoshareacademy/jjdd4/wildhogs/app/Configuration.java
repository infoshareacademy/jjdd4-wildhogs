package com.infoshareacademy.jjdd4.wildhogs.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration extends Properties {
    private static Logger logger = LoggerFactory.getLogger(Configuration.class);
    private static final String CONFIG_PATH = "YummyTimeApp/config.properties";
    private final Properties properties;

    public Configuration(Properties properties) {
        this.properties = properties;
    }

    public Configuration() {

        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_PATH));
            logger.info("Loaded config file");
        } catch (IOException e) {

            System.err.println("Couldn't find config file!");
            logger.warn("Couldn't find config file!");
        }
    }

    public String getJsonPath() {
        return properties.getProperty("jsonPath", "YummyTimeApp/recipes.json");
    }


    public String getSavedRecipesFilePath() {
        return properties.getProperty("savedRecipesFilePath", "ShoppingList.txt");
    }

}
