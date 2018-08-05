package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class Fridge {

    public List<Long> showFilterRecipe(List<Recipe> listOfRecipes, List<String> fridgeList) {

        if (listOfRecipes == null || fridgeList == null) {
            return null;
        }
        List<Long> idRecipesSortedByMatchQuality = listOfRecipes.stream().map(recipe ->
                new RecipeMatchQuality(recipe, recipeMatchQuality(recipe, fridgeList)))
                .filter(r -> r.matchQuality > 0.0)
                .sorted((r1, r2) -> (int)Math.signum(r2.matchQuality - r1.matchQuality))
                .map(r -> r.recipe.getId())
                .collect(Collectors.toList());

        if (idRecipesSortedByMatchQuality.isEmpty()) {
            return null;
        }
        return idRecipesSortedByMatchQuality;
    }

    private double recipeMatchQuality(Recipe recipe, List<String> ingredients) {
        Set<String> ingridientsInRecipe = recipe.getIngredientsList().stream()
                .map(i -> i.getName())
                .collect(Collectors.toSet());
        double matchQuality = ingridientsInRecipe.stream()
                .filter(recipeIngredient -> ingredients.stream().anyMatch(recipeIngredient::contains))
                .count();
        matchQuality /= ingredients.size();
        return matchQuality;
    }

    private class RecipeMatchQuality {
        public Recipe recipe;
        public double matchQuality;

        public RecipeMatchQuality(Recipe recipe, double matchQuality) {
            this.recipe = recipe;
            this.matchQuality = matchQuality;
        }
    }
}
