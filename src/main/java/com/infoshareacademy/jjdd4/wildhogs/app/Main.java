package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.data.Menu;

public class Main {

    public static void main(String[] args) {
        new Configuration();


//        for (String key: mealCreator.getMapOfMeals().keySet()) {
//            System.out.println(key);
//        }

        Menu menu = new Menu();
        menu.printMenu();
        menu.optionPicker();
    }
}
