package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealCreatorTest {

    @Test
    void getMapOfMeals() {
        Configuration configuration = new Configuration();
        JSONObject jsonObject = JSONProvider.read(configuration);
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");

    }

    @Test
    void setMapOfMeals() {
        Configuration configuration = new Configuration();
        JSONObject jsonObject = JSONProvider.read(configuration);
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");

    }
}