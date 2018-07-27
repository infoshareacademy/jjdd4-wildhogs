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
                new RecipeMatchQuality(recipe, recipeMatchQuality(recipe, fridgeList), recipe.getId()))
                .sorted((r1, r2) -> r1.matchQuality > r2.matchQuality ? -1 : 1)
                .filter(r -> r.matchQuality > 0.0)
                .map(r -> r.recipeId)
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
        double matchQuality = ingridientsInRecipe.stream().filter(recipeIngredient ->
                ingredients.stream().anyMatch(recipeIngredient::contains)).count();
        matchQuality /= ingredients.size();
        return matchQuality;
    }

    private class RecipeMatchQuality {
        public Recipe recipe;
        public double matchQuality;
        public long recipeId;

        public RecipeMatchQuality(Recipe recipe, double matchQuality, long recipeId) {
            this.recipe = recipe;
            this.matchQuality = matchQuality;
            this.recipeId = recipeId;
        }
    }
}
