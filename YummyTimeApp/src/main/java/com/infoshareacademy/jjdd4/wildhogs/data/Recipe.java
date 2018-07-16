package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.*;

public class Recipe {

    private final String name;
    private String pathToPicture = "";
    private final Category category;
    private final String description;
    private final List<Ingredient> ingredientsList;

    public Recipe(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        ingredientsList = new ArrayList<>();
    }

//    public Recipe(void aVoid) {
//        this.getDescription(); //FOR RecipesProviderFromJSONTest
//    }

    public void addIngredient(Ingredient ingredient) {
        ingredientsList.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                "url='" + pathToPicture + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", ingredientsList=" + ingredientsList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) &&
                Objects.equals(category, recipe.category) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(ingredientsList, recipe.ingredientsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, ingredientsList);
    }


    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }
}
