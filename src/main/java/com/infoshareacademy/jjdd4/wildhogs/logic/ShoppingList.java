package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.data.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {


    private final List<String> nameOfRecipes;
    private final List<Ingredient> shoppingList;


    public ShoppingList(String... namsOfRecipes) {
        nameOfRecipes = Arrays.asList(namsOfRecipes);
        shoppingList = new ArrayList<>();
    }


    public void save(){

    }
    public void print() {

    }

    public List<String> getNameOfRecipes() {
        return nameOfRecipes;
    }
}
