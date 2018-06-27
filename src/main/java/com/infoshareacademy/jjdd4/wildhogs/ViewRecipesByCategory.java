package com.infoshareacademy.jjdd4.wildhogs;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {

    private final List<String> searchingByCategory;
    private List<String> pickedRecipe;
    private final Category category;
    Scanner sc = new Scanner(System.in);
    MealCreator mealViewer;

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
            System.out.println("Sorry, we ran out of recipes. Your list is empty.");
        } else {
            System.out.println("You picked " + category + " category. Here are all the recipes: \n");
        }

        for (int i = 0; i < searchingByCategory.size(); i++) {

            System.out.println(i + 1 + ". " + searchingByCategory.get(i));
        }

        System.out.print("Pick a meal number: ");
        Integer pick = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < searchingByCategory.size(); i++) {

            final int k = i;
            if (pick == i + 1) {
                System.out.println("Success");
                Recipe recipe = mealViewer.getMapOfMeals().entrySet().stream()
                        .filter(r -> r.getKey().equals(searchingByCategory.get(k)))
                        .map(r -> r.getValue())
                        .findFirst().get();

                System.out.println(recipe.getName());
                System.out.println(recipe.getDescription());
                recipe.getList().entrySet().stream().map(r -> r.getValue()).forEach(System.out::println);
                System.out.println("Do you want do add the recipe to shopping list? \n 1. - Yes \n 2. - Back");
                Integer pick2 = Integer.valueOf(sc.nextLine());
                if (pick2 == 1) {

                    pickedRecipe.add(recipe.getName());

                } else if (pick2 == 2){

                    break;
                }
            }
        }
    }
}