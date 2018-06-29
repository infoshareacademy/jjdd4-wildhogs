package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {

    private final List<String> searchingByCategory;
    private final Category category;
    Scanner sc = new Scanner(System.in);
    MealCreator mealViewer;
    private String namePicked = "";

    public ViewRecipesByCategory(Category category, MealCreator mealCreator) {
        this.category = category;
        mealViewer = mealCreator;

        searchingByCategory = mealCreator.getMapOfMeals().entrySet().stream()
                .map(r -> r.getValue())
                .filter(r -> (Category.valueOf(category.toString()).equals(r.getCategory())))
                .map(r -> r.getName())
                .collect(Collectors.toList());
    }

    public void printResultByCategory() {

        if (searchingByCategory.isEmpty()) {
            System.out.println(" \n Sorry, we ran out of recipes. Your list is empty.");
        } else {
            System.out.println("\n You picked " + category + " category. Here are all the recipes: \n");
        }

        for (int i = 0; i < searchingByCategory.size(); i++) {

            System.out.println(i + 1 + ". " + searchingByCategory.get(i));
        }

        System.out.print("\n Pick a meal number: ");
        Integer pick = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < searchingByCategory.size(); i++) {

            final int k = i;
            if (pick == i + 1) {
                System.out.println("Success");
                Recipe recipe = mealViewer.getMapOfMeals().entrySet().stream()
                        .filter(r -> r.getKey().equals(searchingByCategory.get(k)))
                        .map(r -> r.getValue())
                        .findFirst().get();

                System.out.println("\n" + recipe.getName() + "\n");
                System.out.println(recipe.getDescription() + "\n");
                recipe.getMap().entrySet().stream().map(r -> r.getValue()).forEach(System.out::println);
                System.out.println("\n Do you want do add the recipe to shopping list? \n 1. - Yes \n 2. - No & go back");
                Integer pick2 = Integer.valueOf(sc.nextLine());

                if (pick2 == 1) {

                    namePicked = recipe.getName();
                    System.out.println("Success");
                    break;

                } else if (pick2 == 2) {

                    break;
                }
            }
        }
    }

    public String getNamePicked() {
        return namePicked;
    }
}