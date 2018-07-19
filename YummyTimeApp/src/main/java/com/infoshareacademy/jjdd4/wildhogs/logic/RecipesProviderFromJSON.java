package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesProviderFromJSON {

    private static Logger logger = LoggerFactory.getLogger(RecipesProviderFromJSON.class);

    public static Recipe creator(JSONObject jsonObject) {
        Recipe recipe = null;
        try {
            String name = jsonObject.get("name").toString();
            Category category = Category.valueOf(jsonObject.get("category").toString().toUpperCase());
            String description = jsonObject.get("description").toString();
            String pathToPicture = jsonObject.get("url").toString();

            recipe = new Recipe(name, category, description);
            recipe.setPathToPicture(pathToPicture);
            logger.trace("Loading recipe : " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad category in recipes file: " + jsonObject.get("name").toString());
            logger.warn("Bad category in recipes file: " + jsonObject.get("name").toString());
            return null;
        }
        try {
            JSONArray indgredientJSON = (JSONArray) jsonObject.get("ingredients");
            for (Object ingredients : indgredientJSON) {

                String ingredientName = ((JSONObject) ingredients).get("name").toString();
                Double amount = Double.valueOf(((JSONObject) ingredients).get("amount").toString());
                Unit unit = Unit.valueOf(((JSONObject) ingredients).get("unit").toString().toUpperCase());


                Ingredient ingredient = new Ingredient(ingredientName, amount, unit, recipe);
                recipe.addIngredient(ingredient);
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad amount in recipes file in: " + recipe.getName());
            logger.warn("Bad amount in recipes file in: " + recipe.getName());

            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Bad unit in recipes file: " + recipe.getName());
            logger.warn("Bad unit in recipes file: " + recipe.getName());
            return null;
        }
        return recipe;
    }
}