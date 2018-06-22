package com.infoshareacademy.jjdd4.wildhogs;

public class Main {

    public static void main(String[] args) {

        MealCreator mealCreator = new MealCreator();

        for (String key: mealCreator.getMapOfMeals().keySet()) {
            System.out.println(key);
        }


        }

    }
