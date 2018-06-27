package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.data.SkeletonMenu;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

public class Main {

    public static void main(String[] args) {
        new Configuration();


//        for (String key: mealCreator.getMapOfMeals().keySet()) {
//            System.out.println(key);
//        }

        SkeletonMenu menu = new SkeletonMenu();
        menu.printMenu();
        menu.optionPicker();
    }
}
