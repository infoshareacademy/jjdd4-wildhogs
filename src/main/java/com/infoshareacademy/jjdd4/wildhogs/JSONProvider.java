package com.infoshareacademy.jjdd4.wildhogs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONProvider {

    public static JSONObject read(Source source) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(source.getSource()));

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("ParseException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception e");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
