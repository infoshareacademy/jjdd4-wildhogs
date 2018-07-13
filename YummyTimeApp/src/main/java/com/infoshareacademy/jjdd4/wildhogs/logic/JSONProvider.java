package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import com.infoshareacademy.jjdd4.wildhogs.app.Main;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class JSONProvider {

    private static Logger logger = LoggerFactory.getLogger(JSONProvider.class.getName());

    public static JSONObject read(Configuration configuration) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        logger.info("Looking for JSON path in config file");
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(configuration.getJsonPath()));
            logger.info("JSON file was loaded");

        } catch (Exception e) {
            logger.warn("JSON file was not found!");
            System.out.println("File not found!");
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }
}
