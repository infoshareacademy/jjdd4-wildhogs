package com.infoshareacademy.jjdd4.wildhogs;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {

    private final List<String> searchingByCategory;
    private final Category category;
    Scanner sc = new Scanner(System.in);
    MealCreator mealViewer;

    // This method uses MealCreator class. It provides recipes names of the input category.

    public ViewRecipesByCategory(Category category, MealCreator mealCreator) {
        this.category = category;

        mealViewer = mealCreator;

        searchingByCategory = mealCreator.getMapOfMeals().entrySet().stream()
                .map(r -> r.getValue())
                .filter(r -> (Category.valueOf(category.toString()).equals(r.getCategory())))
                .map(r -> r.getName())
                .collect(Collectors.toList());
    }
    // This method prints out all recipes from given category.

    public void printResultByCategory() {

        if (searchingByCategory.isEmpty()) {
            System.out.println("Sorry, we ran out of recipes. Your list is empty.");
        } else {
            System.out.println("You picked " + category + " category. Here are all the recipes:" + System.lineSeparator());
        }

        for (int i = 0; i < searchingByCategory.size() ; i++) {

            System.out.println(i+1+". "+searchingByCategory.get(i));

        }

        System.out.print("Pick a meal number: ");
        Integer pick = Integer.valueOf(sc.nextLine());


        for (int i = 0; i < searchingByCategory.size(); i++) {

            final int k = i;
            if (pick == i + 1) {
                System.out.println("Success");
                System.out.println(searchingByCategory.get(i));
                Recipe recipe = mealViewer.getMapOfMeals().entrySet().stream()
                        .filter (r -> r.getKey().equals(searchingByCategory.get(k)))
                        .map(r -> r.getValue())
                        .findFirst().get();

                System.out.println(recipe);

            }
        }
    }
}