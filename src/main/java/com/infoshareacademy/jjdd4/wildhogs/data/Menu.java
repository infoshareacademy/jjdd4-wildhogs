package com.infoshareacademy.jjdd4.wildhogs.data;

import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    MealCreator mealCreator = new MealCreator();


    public void printMenu() {

        System.out.println("=======MENU=======");
        System.out.println("0. wyjscie");
        System.out.println("1. wyswietl wszystkie  przepisy");
        System.out.println("2. wystwietl wybrane przepisy");
        System.out.println("3. wyswietl liste zakupow");

    }
    public void optionPicker (){

        switch (Option.fromNumber(sc.nextLine())){

            case EXIT:
                System.out.println("wydupilo");
                break;
            case SHOW_RECIPES:
                System.out.println("pokazalo");
                break;
            case SHOW_CHOSEN_RECIPES:
                System.out.println("pokazalo wybrane");
                break;
            case SHOW_SHOPPING_LIST:
                System.out.println("gas");
                break;
        }
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