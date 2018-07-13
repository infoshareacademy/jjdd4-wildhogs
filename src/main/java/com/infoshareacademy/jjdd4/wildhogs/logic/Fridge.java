package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import java.util.*;
import java.util.stream.Collectors;

public class Fridge {

    private List<String> ingridientsThatWeHave = Arrays.asList("chicken", "bbq chicken", "kfc chicken");
    private MealCreator mealCreator = new MealCreator();

    public void showFilterRecipe() {

        List<Recipe> recipes = mealCreator.getMapOfMeals().entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());

        List<RecipeMatchQuality> recipesWithMatchQuality = recipes.stream().map(recipe ->
                new RecipeMatchQuality(recipe, recipeMatchQuality(recipe, ingridientsThatWeHave)))
                .sorted((r1, r2) -> r1.matchQuality > r2.matchQuality ? -1 : 1)
                .collect(Collectors.toList());
    }


    private class RecipeMatchQuality {
        public Recipe recipe;
        public double matchQuality;
        public RecipeMatchQuality(Recipe recipe, double matchQuality) {
            this.recipe = recipe;
            this.matchQuality = matchQuality;
        }
    }


    private double recipeMatchQuality(Recipe recipe, List<String> ingredients) {
        Set<String> ingridientsInRecipe = recipe.getMap().keySet();
        double matchQuality = ingridientsInRecipe.stream().filter(recipeIngredient ->
                ingredients.stream().anyMatch(recipeIngredient::contains)).count();
        matchQuality /= ingredients.size();
        return matchQuality;
    }
}
