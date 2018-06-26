package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.data.SkeletonMenu;

public class Main {

    public static void main(String[] args) {
        new Configuration();





        SkeletonMenu menu = new SkeletonMenu("Menu", "Home", "Weeklist", "KitchenBook");
        menu.printSkeletonMenu();
//        for (String key: mealCreator.getMapOfMeals().keySet()) {
//            System.out.println(key);
//        }

//        ShoppingList myList = new ShoppingList("Grilled Mexican Street Corn", "Mustard Potato Salad");
//
//        System.out.println(myList.getNameOfRecipes().toString());
    }
}
