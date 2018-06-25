package com.infoshareacademy.jjdd4.wildhogs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {


    private final List<String> searchingByCategory;
    public ViewRecipesByCategory (Category category, MealCreator mealCreator) {

        searchingByCategory = new ArrayList<>();

        mealCreator.getMapOfMeals().entrySet().stream()
                .map(r -> r.getValue())
                .filter(r -> (Category.valueOf(category.toString()).equals(r.getCategory())))
                .collect(Collectors.toList());
    }

    public List<String> getSearchingByCategory() {
        return searchingByCategory;
    }
}

