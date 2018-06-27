package com.infoshareacademy.jjdd4.wildhogs.data;

import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import java.util.ArrayList;
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
        System.out.println("1. wyswietl wszystkie  przepisy");
        System.out.println("2. wystwietl wybrane przepisy");
        System.out.println("3. wyswietl liste zakupow");
        System.out.println("4. zapisz liste zakupow");
        System.out.println("Chose Your destiny: ");
    }

    public void optionPicker (){
        Option option;
        do {
            option = Option.fromNumber(sc.nextLine());
            switch (option) {

                case EXIT:
                    System.out.println("wyjscie");
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
            }
            printMenu();
        }while (!option.equals(Option.EXIT));
    }
}

//    private String menu;
//    private String home;
//    private String weeklist;
//    private String kitchenBook;
//
//    public SkeletonMenu(String menu, String home, String weeklist, String kitchenBook) {
//        this.menu = menu;
//        this.home = home;
//        this.weeklist = weeklist;
//        this.kitchenBook = kitchenBook;
////    }
//public void printSkeletonMenu() {
//    System.out.println(this.menu + "\n" + this.home + "\n" + this.weeklist + "\n" + this.kitchenBook);
//}