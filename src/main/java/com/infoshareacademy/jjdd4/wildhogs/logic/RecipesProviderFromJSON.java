package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RecipesProviderFromJSON {

public static Recipe creator(JSONObject jsonObject) {
        Recipe recipe = null;
        try {
            String name = jsonObject.get("name").toString();
            Category category = Category.valueOf(jsonObject.get("category").toString().toUpperCase());
            String description = jsonObject.get("description").toString();

            recipe = new Recipe(name, category, description);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad category in recipes file: " + jsonObject.get("name").toString());
            return null;
        }
        try {
            JSONArray ingridientsArray = (JSONArray) jsonObject.get("ingredients");
            for (Object ingridientJSON : ingridientsArray) {

                String nameI = ((JSONObject) ingridientJSON).get("name").toString();
                Double amount = Double.valueOf(((JSONObject) ingridientJSON).get("amount").toString());
                Unit unit = Unit.valueOf(((JSONObject) ingridientJSON).get("unit").toString().toUpperCase());

                Ingredient ingredient = new Ingredient(nameI, amount, unit);
                recipe.addIngredient(ingredient.getName(), ingredient);
            }
            } catch (NumberFormatException e) {
                System.out.println("Bad amount in recipes file in: " + recipe.getName());
                return null;
            } catch (IllegalArgumentException e) {
                System.out.println("Bad unit in recipes file: " + recipe.getName());
                return null;
            }
        return recipe;
    }
}