package com.infoshareacademy.jjdd4.wildhogs.data;

import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    MealCreator mealCreator = new MealCreator();
    List<String> list = Arrays.asList("Grilled Mexican Street Corn", "Mustard Potato Salad");
    ShoppingList shoppingList = null;

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
                case SHOW_RECIPES:
                    System.out.println("pokaze przepisy po kategorii");
                    break;
                case SHOW_CHOSEN_RECIPES:
                    System.out.println("pokazalo wybrane");
                    break;
                case SHOW_SHOPPING_LIST:
                    System.out.println("shopping list");
                    shoppingList = new ShoppingList(mealCreator, list);
                    shoppingList.print();
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
