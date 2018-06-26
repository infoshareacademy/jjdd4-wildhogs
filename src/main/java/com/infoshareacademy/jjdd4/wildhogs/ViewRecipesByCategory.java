package com.infoshareacademy.jjdd4.wildhogs;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {

    private final List<String> searchingByCategory;
    private final Category category;
    Scanner sc = new Scanner(System.in);
    MealCreator ml ;

    // This method uses MealCreator class. It provides recipes names of the input category.

    public ViewRecipesByCategory(Category category, MealCreator mealCreator) {
        this.category = category;

        ml=mealCreator;

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
            System.out.println("You chose " + category + " category. Here are all the recipes:" + System.lineSeparator());
        }

        for (int i = 0; i <searchingByCategory.size() ; i++) {

            System.out.println(i+1+". "+searchingByCategory.get(i));

        }

        System.out.print("choose your destiny(pick a number): ");
        Integer pick = sc.nextInt();


        for (int i = 0; i <searchingByCategory.size() ; i++) {

            if (pick==i+1)
                System.out.println("wybrano");
                System.out.println(searchingByCategory.get(i));



        }

    }
}