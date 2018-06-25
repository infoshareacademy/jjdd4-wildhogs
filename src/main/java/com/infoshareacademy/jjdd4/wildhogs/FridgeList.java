package com.infoshareacademy.jjdd4.wildhogs;

import java.util.ArrayList;
import java.util.List;

public class FridgeList {

    private final List<String> recipesFromFridge;

    public FridgeList (MealCreator mealCreator, Ingredient... ingredients) {

        recipesFromFridge = new ArrayList<>();
    }
}