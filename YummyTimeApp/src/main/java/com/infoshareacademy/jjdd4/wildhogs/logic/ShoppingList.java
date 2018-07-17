package com.infoshareacademy.jjdd4.wildhogs.logic;
import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;
import com.infoshareacademy.jjdd4.wildhogs.data.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class ShoppingList {

    private static Logger logger = LoggerFactory.getLogger(ShoppingList.class);
    private final List<Ingredient> shoppingList;
    public final List<String> nameOfRecipes;

    public ShoppingList(MealCreator mealCreator, List<String> nameOfRecipes) {

        this.nameOfRecipes = nameOfRecipes;
        List<Ingredient> allIngredients = new ArrayList<>();

        for (String name : nameOfRecipes) {
            List<Ingredient> ingredientsInRecipe = mealCreator.getMapOfMeals().entrySet().stream()
                    .filter(e -> name.contains(e.getKey()))
                    .map(e -> e.getValue())
                    .flatMap(r -> r.getIngredientsList().stream())
                    .collect(toList());
            allIngredients.addAll(ingredientsInRecipe);
        }
        shoppingList = new ArrayList<>();

        for (Ingredient ingredient : allIngredients) {
            if (shoppingList.contains(ingredient)) {
                Ingredient ingredientAlreadyInList = shoppingList.get(shoppingList.indexOf(ingredient));
                if (!ingredientAlreadyInList.getUnit().equals(ingredient.getUnit())) {
                    unifyUnit(ingredientAlreadyInList);
                    unifyUnit(ingredient);
                }
                ingredientAlreadyInList.addToAmount(ingredient.getAmount());
            } else {
                shoppingList.add(new Ingredient(ingredient));
            }
        }
    }

    private void unifyUnit(Ingredient ingredient) {
        switch (ingredient.getUnit()) {
            case KILOGRAMS:
                ingredient.setUnit(Unit.GRAMS);
                ingredient.multiplyAmount(1000);
                break;
            case LITERS:
                ingredient.setUnit(Unit.MILLILITERS);
                ingredient.multiplyAmount(1000);
                break;
            case CUP:
                ingredient.setUnit(Unit.MILLILITERS);
                ingredient.multiplyAmount(250);
                break;
        }
    }

    public void save(){
        Path path = Paths.get("ShoppingList.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(listToString());
        }catch (Exception e) {
            System.out.println("Shopping list can't saved!");
        }
    }

    public void print() {
        System.out.println(listToString());
    }

    private String listToString() {
        String result = "Picked recipes: " + nameOfRecipes + "\r\n\r\n";
        for(Ingredient ingredient : shoppingList) {
            result += ingredient.getName() + " - "
                    + ingredient.getAmount() + " "
                    +ingredient.getUnit().getDescription()
                    +"\r\n";
        }
        return result;
    }
}
