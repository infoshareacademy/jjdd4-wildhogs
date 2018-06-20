package com.infoshareacademy.jjdd4.wildhogs;

import java.util.LinkedHashMap;
import java.util.Map;

public class MealCreator {

    private Map<String, Recipe> mapOfMeals;

    public MealCreator() {

        mapOfMeals = new LinkedHashMap<>();
    }

    public Map<String, Recipe> getMapOfMeals() {
        return mapOfMeals;
    }

    public void setMapOfMeals(Map<String, Recipe> mapOfMeals) {
        this.mapOfMeals = mapOfMeals;
    }
}
