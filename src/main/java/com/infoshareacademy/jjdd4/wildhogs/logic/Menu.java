package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import com.infoshareacademy.jjdd4.wildhogs.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private MealCreator mealCreator = new MealCreator();
    private ShoppingList shoppingList;
    private ViewRecipesByCategory viewRecipesByCategory;
    private List<String> pickedRecipe = new ArrayList<>();
    private Configuration config = new Configuration();

    public void printMenu() {
        System.out.println();
        System.out.println("=======MENU=======");
        System.out.println("0. EXIT");
        System.out.println("1. SHOW RECIPES BY THE CATEGORY");
        System.out.println("2. SHOW PICKED RECIPES");
        System.out.println("3. YOUR SHOPPING LIST - VIEW");
        System.out.println("4. SAVE YOUR SHOPPING LIST");
        System.out.print("Choose what do You want to do now: ");
    }

    public void printCategory() {
        System.out.println();
        System.out.println("=======CATEGORIES=======");
        System.out.println("1. BREAKFAST");
        System.out.println("2. LUNCH");
        System.out.println("3. DINNER");
        System.out.println("4. SUPPER");
        System.out.println("5. BACK");
        System.out.print("Pick a category by number: ");
    }

    public void optionPicker() {
        Option option;
        do {
            printMenu();
            option = Option.fromNumber(sc.nextLine());
            switch (option) {
                case EXIT:
                    System.out.println("ENDING SESSION");
                    break;
                case SHOW_RECIPES_BY_CATEGORY:
                    printCategory();
                    Category category = Category.fromNumber(sc.nextLine());

                    viewRecipesByCategory = new ViewRecipesByCategory(category, mealCreator);
                    viewRecipesByCategory.printResultByCategory();
                    pickedRecipe.add(viewRecipesByCategory.getNamePicked());

                    if (!pickedRecipe.isEmpty()) {
                        shoppingList = new ShoppingList(mealCreator, pickedRecipe);
                    }
                    break;
                case SHOW_CHOSEN_RECIPES:
                    if (!pickedRecipe.isEmpty()) {
                        System.out.println(pickedRecipe);
                    } else {
                        System.out.println("You picked nothing!");
                    }
                    break;
                case SHOW_SHOPPING_LIST:
                    if (!pickedRecipe.isEmpty()) {
                        shoppingList.print();
                    } else {
                        System.out.println("Your shopping list is empty!");
                    }
                    break;
                case SAVE_SHOPPING_LIST:
                    if (shoppingList != null) {
                        shoppingList.save();
                        System.out.println("Your list was saved to file " + config.getSavedRecipesFilePath() + ".");
                    } else {
                        System.out.println("Empty list. Nothing to save.");
                    }
                    break;
                case UNKNOWN:
                    System.out.println("Wrong value");
                    break;
            }
        } while (!option.equals(Option.EXIT));
    }
}
