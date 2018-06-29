package com.infoshareacademy.jjdd4.wildhogs.data;

import com.infoshareacademy.jjdd4.wildhogs.logic.ViewRecipesByCategory;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private MealCreator mealCreator = new MealCreator();
    private ShoppingList shoppingList;
    private ViewRecipesByCategory viewRecipesByCategory;
    private List<String> pickedRecipe = new ArrayList<>();

    public void printMenu() {
        System.out.println("=======MENU=======");
        System.out.println("0. EXIT");
        System.out.println("1. MENU");
        System.out.println("2. SHOW RECIPES BY THE CATEGORY");
        System.out.println("3. SHOW PICKED RECIPES");
        System.out.println("4. YOUR SHOPPING LIST - VIEW");
        System.out.println("5. SAVE YOUR SHOPPING LIST");
        System.out.print("Choose what do You want to do now: ");
    }

    public void optionPicker() {
        printMenu();
        Option option;
        do {
            option = Option.fromNumber(sc.nextLine());
            switch (option) {
                case EXIT:
                    System.out.println("ENDING SESSION");
                    break;
                case MENU:
                    printMenu();
                    break;
                case SHOW_RECIPES_BY_CATEGORY:
                    viewRecipesByCategory = new ViewRecipesByCategory(Category.LUNCH, mealCreator);
                    viewRecipesByCategory.printResultByCategory();
                    pickedRecipe.add(viewRecipesByCategory.getNamePicked());
                    break;
                case SHOW_CHOSEN_RECIPES:
                    if (pickedRecipe != null) {
                        System.out.println(pickedRecipe);
                    } else {
                        System.out.println("You picked nothing!");
                    }
                    break;
                case SHOW_SHOPPING_LIST:
                    if(pickedRecipe != null) {
                        shoppingList = new ShoppingList(mealCreator, pickedRecipe);
                        shoppingList.print();
                    } else {
                        System.out.println("Your shopping list is empty!");
                    }
                    break;
                case SAVE_SHOPPING_LIST:
                    if (shoppingList != null) {
                        shoppingList.save();
                        System.out.println("Your list was saved to file.");
                    } else {
                        System.out.println("Empty list! Nothing to print.");
                    }
                    break;
                case UNKNOWN:
                    System.out.println("Wrong value");
                    break;
            }
            System.out.println("\r\nChoose another option from MAIN MENU, press 1 to see MENU ");
        } while (!option.equals(Option.EXIT));
    }
}
