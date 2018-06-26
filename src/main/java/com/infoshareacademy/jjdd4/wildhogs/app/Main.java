package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

public class Main {

    public static void main(String[] args) {
//        new Configuration();

        MealCreator mealCreator = new MealCreator();

//        for (String key: mealCreator.getMapOfMeals().keySet()) {
//            System.out.println(key);
//        }

        ShoppingList myList = new ShoppingList("Grilled Mexican Street Corn", "Mustard Potato Salad");

        System.out.println(myList.getNameOfRecipes().toString());
    }
}
