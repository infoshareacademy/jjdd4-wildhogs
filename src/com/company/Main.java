package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        MealCreator ml = new MealCreator();
        ml.getMapOfMeals().put("gaspacio", new Recipe("Gazpaccio", Category.DINNER,"tutaj leci przepis"));
        ml.getMapOfMeals().get("gaspacio").addIngredient(new Ingredient("chicken breast",400,Unit.GRAMS));
        ml.getMapOfMeals().get("gaspacio").addIngredient(new Ingredient("pasta pene",0.4,Unit.KILOGRAMS));
        ml.getMapOfMeals().get("gaspacio").addIngredient(new Ingredient("apple",2));

        System.out.println(ml.getMapOfMeals().get("gaspacio").toString());




    }
}
