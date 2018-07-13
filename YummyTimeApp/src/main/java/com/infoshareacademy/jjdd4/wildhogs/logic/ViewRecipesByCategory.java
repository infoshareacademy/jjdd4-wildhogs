package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Category;
import com.infoshareacademy.jjdd4.wildhogs.data.Recipe;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ViewRecipesByCategory {
    private static Logger logger = LoggerFactory.getLogger(ViewRecipesByCategory.class.getName());

    private final Category category;
    private Scanner sc = new Scanner(System.in);
    private MealCreator mealViewer;
    private List<String> searchingByCategory;
    private String namePicked = "";

    public ViewRecipesByCategory(Category category, MealCreator mealCreator) {
        this.category = category;
        mealViewer = mealCreator;
        searchingByCategory = new ArrayList<>();

        searchingByCategory = mealCreator.getMapOfMeals().entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(r -> (Category.valueOf(category.toString()).equals(r.getCategory())))
                .map(Recipe::getName)
                .collect(Collectors.toList());
    }

    public void pickYourMealLogic() {
        printResultByCategory();
        pickAMealByTheNumber();
    }

    public String getNamePicked() {
        return namePicked;
    }

    private void printResultByCategory() {

        if (!category.equals(Category.BACK)) {
            if (searchingByCategory.isEmpty() && !category.equals(Category.BACK)) {
                System.out.println(" \nSorry, we ran out of recipes. Your list is empty.");
                logger.warn("Application ran out of recipes");
            } else {
                System.out.println("\nYou picked " + category + " category. Here are all the recipes: \n");
                logger.info("Showing all recipes from "+ category  + " category");
            }

            System.out.println("0. Back");
            for (int i = 0; i < searchingByCategory.size(); i++) {

                System.out.println(i + 1 + ". " + searchingByCategory.get(i));
            }
        }
    }

    private void pickAMealByTheNumber() {
        System.out.print("\nPick a meal number: ");
        String input="";
        Integer pick = 0;
        try {
            input = sc.nextLine();
            pick = Integer.valueOf(input);
            logger.info("Picked number " + pick);
        } catch (NumberFormatException e) {
            System.out.println("That's not a proper input. Please try again.");
            logger.warn("Improper value in the input : " + input);

        }

        for (int i = 0; i < searchingByCategory.size(); i++) {

            final int temp = i;
            if (pick == i + 1) {
                System.out.println("Success");
                Recipe recipe = mealViewer.getMapOfMeals().entrySet().stream()
                        .filter(r -> r.getKey().equals(searchingByCategory.get(temp)))
                        .map(r -> r.getValue())
                        .findFirst().get();

                System.out.println("\n" + recipe.getName() + "\n");
                System.out.println(recipe.getDescription() + "\n");
                recipe.getMap().entrySet().stream().map(r -> r.getValue()).forEach(System.out::println);
                System.out.println("\nDo you want to add the recipe into your shopping list? \n 1. - Yes \n 2. - No. Let's go back");
                Integer pick2 = Integer.valueOf(sc.nextLine());

                if (pick2 == 1) {
                    namePicked = recipe.getName();
                    System.out.println("Added recipe to the list");
                    logger.info("Added recipe to the list : " + recipe.getName());
                    break;

                } else if (pick2 == 2) {
                    logger.info("Didn't add the recipe to the list : " + recipe.getName());
                    break;
                }
            }
        }
    }


}