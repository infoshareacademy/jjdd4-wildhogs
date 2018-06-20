package com.infoshareacademy.jjdd4.wildhogs;

import java.util.*;

public class Recipe {

    private String name;
    private Category category;
    private String description;
    private Map<String,Ingredient> ingredientsMap;


    public Recipe(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        ingredientsMap = new HashMap<>();

    }


    public void addIngredient(String name, Ingredient in) {

        ingredientsMap.put(name,in);

    }


    public Map<String,Ingredient> showList() {

        for(Ingredient i:ingredientsMap.values()){
            System.out.println(i);
        }

        return ingredientsMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("============\n");
        sb.append(name);
        sb.append("\n============\n");
        sb.append("What you need:");
        sb.append("\n");
        for (Ingredient i : ingredientsMap.values()) {
            sb.append(i.toString());
            sb.append("\n");
        }


        sb.append("============\n");
        sb.append(description);
        sb.append("\n============\n");


        return sb.toString();
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

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String,Ingredient> getList() {
        return ingredientsMap;
    }

    public void setMap(Map<String,Ingredient> ingredientsMap) {
        this.ingredientsMap = ingredientsMap;
    }
}
