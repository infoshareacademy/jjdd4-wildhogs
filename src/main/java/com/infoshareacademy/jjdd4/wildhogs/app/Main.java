package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.data.SkeletonMenu;
import com.infoshareacademy.jjdd4.wildhogs.logic.MealCreator;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;


public class Main {

    public static void main(String[] args) {
        new Configuration() {
            @Override
            public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
                return new AppConfigurationEntry[0];
            }
        };

        MealCreator mealCreator = new MealCreator();

        for (String key: mealCreator.getMapOfMeals().keySet()) {
            System.out.println(key);
        }

        SkeletonMenu menu = new SkeletonMenu("Menu", "Home", "Weeklist", "KitchenBook");
        menu.printSkeletonMenu();
    }
}
