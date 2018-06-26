package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ShoppingList {



    private final List<Ingredient> shoppingList;

    public ShoppingList(MealCreator mealCreator, List<String> nameOfRecipes) {

        List<Ingredient> temp = mealCreator.getMapOfMeals().entrySet().stream()
                .filter(e -> nameOfRecipes.contains(e.getKey()))
                .map(e -> e.getValue())
                .flatMap(r -> r.getMap().values().stream())
                .collect(toList());

        shoppingList = temp;
    }

    public List<Ingredient> getShoppingList() {
        return shoppingList;
    }

    public void save(){

    }
    public void print() {

    }


}
