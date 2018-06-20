package com.infoshareacademy.jjdd4.wildhogs;

public class Main {

    public static void main(String[] args) {


        MealCreator ml = new MealCreator();
        ml.getMapOfMeals().put("gaspacio", new Recipe("Gazpaccio", Category.DINNER, "tutaj leci przepis"));
        ml.getMapOfMeals().get("gaspacio").addIngredient("chicken", new Ingredient("chicken breast", 400, Unit.GRAMS));
        ml.getMapOfMeals().get("gaspacio").addIngredient("pasta", new Ingredient("pasta pene", 0.4, Unit.KILOGRAMS));
        ml.getMapOfMeals().get("gaspacio").addIngredient("apple", new Ingredient("apple", 2, Unit.UNIT));

        System.out.println(ml.getMapOfMeals().get("gaspacio").toString());


    }
}
