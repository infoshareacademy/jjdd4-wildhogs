package com.infoshareacademy.jjdd4.wildhogs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONProvider {

    public static JSONObject read(Source source) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(source.getSource()));

        } catch (Exception e) {
            System.out.println("File not found!");
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }
}
