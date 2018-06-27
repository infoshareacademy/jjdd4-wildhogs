package com.infoshareacademy.jjdd4.wildhogs.logic;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class ShoppingList {

    private final List<Ingredient> shoppingList;
    public final List<String> nameOfRecipes;

    public ShoppingList(MealCreator mealCreator, List<String> nameOfRecipes) {

        this.nameOfRecipes = nameOfRecipes;
        List<Ingredient> temp = mealCreator.getMapOfMeals().entrySet().stream()
                .filter(e -> nameOfRecipes.contains(e.getKey()))
                .map(e -> e.getValue())
                .flatMap(r -> r.getMap().values().stream())
                .collect(toList());

        shoppingList = new ArrayList<>();

        for (Ingredient ingredient: temp) {
            if (shoppingList.contains(ingredient)) {

                if (shoppingList.get(shoppingList.indexOf(ingredient)).getUnit().equals(ingredient.getUnit())) {
                    shoppingList.get(shoppingList.indexOf(ingredient)).addToAmount(ingredient.getAmount());
                } else {
                    int index = shoppingList.indexOf(ingredient);
                    switch (shoppingList.get(index).getUnit()) {
                        case KILOGRAMS:
                            shoppingList.get(index).setUnit(Unit.GRAMS);
                            shoppingList.get(index).multiplyAmount(1000);
                            break;
                        case LITERS:
                            shoppingList.get(index).setUnit(Unit.MILLILITERS);
                            shoppingList.get(index).multiplyAmount(1000);
                            break;
                        case CUP:
                            shoppingList.get(index).setUnit(Unit.MILLILITERS);
                            shoppingList.get(index).multiplyAmount(250);
                            break;
                    }
                    switch (ingredient.getUnit()) {
                        case KILOGRAMS:
                            shoppingList.get(index).addToAmount(ingredient.getAmount()*1000);
                            break;
                        case LITERS:
                            shoppingList.get(index).addToAmount(ingredient.getAmount()*1000);
                            break;
                        case CUP:
                            shoppingList.get(index).addToAmount(ingredient.getAmount()*250);
                            break;
                        default:
                            shoppingList.get(index).addToAmount(ingredient.getAmount());
                    }
                }
            } else {
                shoppingList.add(new Ingredient(ingredient));
            }
        }
    }

    public List<Ingredient> getShoppingList() {
        return shoppingList;
    }

    public void save(){

    }

    public void print() {
        System.out.println("Choosen recipes: " + nameOfRecipes + "\n");
        for(Ingredient ingredient : shoppingList) {
            System.out.println(ingredient.getName() + " "
                    + ingredient.getAmount() + " "
                    +ingredient.getUnit().getDescription());
        }
    }
}
