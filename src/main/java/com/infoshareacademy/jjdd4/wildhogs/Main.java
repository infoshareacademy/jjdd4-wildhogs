package com.infoshareacademy.jjdd4.wildhogs;

public class Main {

    public static void main(String[] args) {


        MealCreator mealCreator = new MealCreator();

        // For ViewRecipesByCategory testing.

        ViewRecipesByCategory viewRecipesByCategory = new ViewRecipesByCategory(Category.LUNCH, mealCreator);
        viewRecipesByCategory.printResultByCategory();

//        for (String key: mealCreator.getMapOfMeals().keySet()) {
//            System.out.println(key);
//        }
//        new Configuration();
    }
}
