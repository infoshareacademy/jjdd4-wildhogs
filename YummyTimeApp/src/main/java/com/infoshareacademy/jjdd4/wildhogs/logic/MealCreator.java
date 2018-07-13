package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class MealCreator {
    private static Logger logger = LoggerFactory.getLogger(MealCreator.class.getName());
    private Map<String, Recipe> mapOfMeals;

    public MealCreator() {

        logger.debug("Running MealCreator class");

        mapOfMeals = new LinkedHashMap<>();

        JSONObject jsonObject = JSONProvider.read(new Configuration());
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");
      if  (recipesArray != null){
        for (Object recipe : recipesArray) {

            Recipe recipeCreated = RecipesProviderFromJSON.creator((JSONObject) recipe);

            if (recipeCreated != null) {
                mapOfMeals.put(recipeCreated.getName(), recipeCreated);
            }
        }
      }
    }
    public Map<String, Recipe> getMapOfMeals() {
        logger.debug("Returning map of meals");
        return mapOfMeals;
    }
}
