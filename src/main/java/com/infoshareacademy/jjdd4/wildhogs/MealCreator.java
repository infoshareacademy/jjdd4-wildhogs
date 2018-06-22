package com.infoshareacademy.jjdd4.wildhogs;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class MealCreator {

    private Map<String, Recipe> mapOfMeals;

    public MealCreator() {

        mapOfMeals = new LinkedHashMap<>();

        Source source = new Source();
        JSONObject jsonObject = ReadRecipeFromJSON.read(source);
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");
        for (Object recipe : recipesArray) {
            Recipe recipeCreated = CreateRecipesFromJSON.creator((JSONObject) recipe);

            if (recipeCreated != null) {
                mapOfMeals.put(recipeCreated.getName(), recipeCreated);
            }
        }
    }



    public Map<String, Recipe> getMapOfMeals() {
        return mapOfMeals;
    }

    public void setMapOfMeals(Map<String, Recipe> mapOfMeals) {
        this.mapOfMeals = mapOfMeals;
    }
}
