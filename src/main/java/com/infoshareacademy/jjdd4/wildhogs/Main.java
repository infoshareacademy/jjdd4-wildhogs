package com.infoshareacademy.jjdd4.wildhogs;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) {


        Source source = new Source();
        JSONObject jsonObject = ReadRecipeFromJSON.read(source);
        JSONArray recipesArray = (JSONArray) jsonObject.get("recipes");
        for (Object recipe : recipesArray) {
            Recipe recipeCreated = CreateRecipesFromJSON.creator((JSONObject) recipe);
            if (recipeCreated != null) {

                System.out.println(recipeCreated.getName());
                recipeCreated.showList();
                System.out.println("-----------------");
            }


        }

    }
}
