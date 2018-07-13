package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import com.infoshareacademy.jjdd4.wildhogs.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Logger logger = LoggerFactory.getLogger(Menu.class.getName());
    private Scanner sc = new Scanner(System.in);
    private MealCreator mealCreator = new MealCreator();
    private ShoppingList shoppingList;
    private List<String> pickedRecipe = new ArrayList<>();

    public void optionPicker() {
        Option option;
        do {
            printMenu();
            option = Option.fromNumber(sc.nextLine());
            switch (option) {
                case EXIT:
                    logger.debug("Exit");
                    System.out.println("ENDING SESSION");
                    break;
                case SHOW_RECIPES_BY_CATEGORY:
                    printCategory();
                    picksAMealByTheNumberAndAddsToShoppingList();
                    break;
                case SHOW_CHOSEN_RECIPES:
                    logger.debug("Showing picked recipes");
                    ifNotEmptyShowsPickedRecipes();
                    break;
                case SHOW_SHOPPING_LIST:
                    logger.debug("Showing shopping list");
                    ifNotEmptyShowsShoppingList();
                    break;
                case SAVE_SHOPPING_LIST:
                    ifShoppingListNotNullSavesToFile();
                    break;
                case UNKNOWN:
                    logger.debug("Wrong value given");
                    System.out.println("Wrong value");
                    break;
            }
        } while (!option.equals(Option.EXIT));
    }

    private void ifNotEmptyShowsShoppingList() {
        if (!pickedRecipe.isEmpty()) {
            shoppingList.print();
        } else {
            System.out.println("Your shopping list is empty!");
            logger.warn("Returning empty list");
        }
    }

    private void ifNotEmptyShowsPickedRecipes() {
        if (!pickedRecipe.isEmpty()) {
            System.out.println(pickedRecipe);
        } else {
            System.out.println("You picked nothing!");
            logger.warn("Tried to read empty recipe list without success");
        }
    }

    private void ifShoppingListNotNullSavesToFile() {
        if (shoppingList != null) {
            shoppingList.save();
            System.out.println("\nYour list was saved to file " + new Configuration().getSavedRecipesFilePath() + ".");
            logger.info("Saved list to " + new Configuration().getSavedRecipesFilePath() + ".");
        } else {
            System.out.println("\nEmpty list. Nothing to save.");
            logger.warn("Tried to save empty list without success");
        }
    }

    private void picksAMealByTheNumberAndAddsToShoppingList() {
        Category category = Category.fromNumber(sc.nextLine());
        if (category != Category.BACK) {
            ViewRecipesByCategory viewRecipesByCategory = new ViewRecipesByCategory(category, mealCreator);
            viewRecipesByCategory.pickYourMealLogic();
            if (!viewRecipesByCategory.getNamePicked().equals("")) {
                pickedRecipe.add(viewRecipesByCategory.getNamePicked());
            }
            if (!pickedRecipe.isEmpty()) {
                shoppingList = new ShoppingList(mealCreator, pickedRecipe);
            }
        }
    }

    private void printMenu() {
        logger.debug("Showing menu");
        System.out.println();
        System.out.println("=======MENU=======");
        System.out.println("0. EXIT");
        System.out.println("1. SHOW RECIPES BY THE CATEGORY");
        System.out.println("2. SHOW PICKED RECIPES");
        System.out.println("3. YOUR SHOPPING LIST - VIEW");
        System.out.println("4. SAVE YOUR SHOPPING LIST");
        System.out.print("Choose what do You want to do now: ");
    }

    private void printCategory() {
        logger.debug("Showing categories");
        System.out.println();
        System.out.println("=======CATEGORIES=======");
        System.out.println("1. BREAKFAST");
        System.out.println("2. LUNCH");
        System.out.println("3. DINNER");
        System.out.println("4. SUPPER");
        System.out.println("5. BACK");
        System.out.print("Pick a category by the number: ");
    }
}
