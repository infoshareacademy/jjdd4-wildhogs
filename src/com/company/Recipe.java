package com.company;

import java.util.*;

public class Recipe {

    private String name;
    private Enum category;
    private String description;
    List<Ingredient> list;


    public Recipe(String name, Enum category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        list = new LinkedList<>();

    }


    public void addIngredient(Ingredient in) {

        list.add(in);

    }


    public List<Ingredient> showList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("============\n");
        sb.append(name);
        sb.append("\n============\n");
        sb.append("What you need:");
        sb.append("\n");
        for (Ingredient i : list) {
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
                Objects.equals(list, recipe.list);
    }

    @Override

    public int hashCode() {

        return Objects.hash(name, category, description, list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getCategory() {
        return category;
    }

    public void setCategory(Enum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getList() {
        return list;
    }

    public void setList(List<Ingredient> list) {
        this.list = list;
    }
}
