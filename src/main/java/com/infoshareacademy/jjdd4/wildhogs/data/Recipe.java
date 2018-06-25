package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Recipe {

    private final String name;
    private final Category category;
    private final String description;
    private final Map<String, Ingredient> ingredientsMap;

    public Recipe(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        ingredientsMap = new HashMap<>();
    }

    public void addIngredient(String name, Ingredient in) {

        ingredientsMap.put(name, in);
    }

    public Map<String, Ingredient> showList() {

        for (Ingredient i : ingredientsMap.values()) {
            System.out.println(i);
        }
        return ingredientsMap;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", ingredientsMap=" + ingredientsMap +
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
                Objects.equals(ingredientsMap, recipe.ingredientsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, ingredientsMap);
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

    public Map<String, Ingredient> getList() {
        return ingredientsMap;
    }

}
