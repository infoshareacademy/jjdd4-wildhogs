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
        System.out.println("0. wyjscie");
        System.out.println("1. MENU");
        System.out.println("2. wyswietl wszystkie  przepisy");
        System.out.println("3. wystwietl wybrane przepisy");
        System.out.println("4. YOUR SHOPPING LIST - VIEW");
        System.out.println("5. SAVE YOUR SHOPPING LIST");
        System.out.println("Chose what do You want to do now: ");
    }

    public void optionPicker (){
        printMenu();
        Option option;
        do {
            option = Option.fromNumber(sc.nextLine());
            switch (option) {

                case EXIT:
                    System.out.println("wyjscie");
                    break;
                case MENU:
                    printMenu();
                    break;
                case SHOW_RECIPES:
                    System.out.println("pokaze przepisy po kategori");
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
                        System.out.println("Your List is write to file.");
                    } else {
                        System.out.println("Empty List! Nothing to write.");
                    }
                    break;
                case UNKNOWN:
                    System.out.println("Wrong value");
                    break;
            }
            System.out.println("\r\n Chose what next, or press 1 to see MENU: ");
        }while (!option.equals(Option.EXIT));
    }
}