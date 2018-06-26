package com.infoshareacademy.jjdd4.wildhogs.data;

import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;
import com.infoshareacademy.jjdd4.wildhogs.logic.ShoppingList;

import java.util.Arrays;
import java.util.List;

public class SkeletonMenu {
    private String menu;
    private String home;
    private String weeklist;
    private String kitchenBook;

    public SkeletonMenu(String menu, String home, String weeklist, String kitchenBook) {
        this.menu = menu;
        this.home = home;
        this.weeklist = weeklist;
        this.kitchenBook = kitchenBook;


        MealCreator mealCreator = new MealCreator();
        for (String key: mealCreator.getMapOfMeals().keySet()) {
            System.out.println(key);
        }
        List<String> nazwy = Arrays.asList("Red Velvet Pancakes", "Savory Garlic Butter Shrimp Scampi");
        ShoppingList shoppingList = new ShoppingList(mealCreator, nazwy);
        System.out.println(shoppingList.getShoppingList().toString());

    }

    public void printSkeletonMenu() {
        System.out.println(this.menu + "\n" + this.home + "\n" + this.weeklist + "\n" + this.kitchenBook);
    }

    public String getMenu() {
        return this.menu;
    }

    public String getHome() {
        return this.home;
    }

    public String getWeeklist() {
        return this.weeklist;
    }

    public String getKitchenBook() {
        return this.kitchenBook;
    }
}


