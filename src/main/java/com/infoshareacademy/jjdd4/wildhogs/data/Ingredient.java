package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Objects;

public class Ingredient {

    private final String name;
    private double amount;
    private Unit unit;

    public Ingredient(String name, double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient(Ingredient ingredient) {
        this.name = ingredient.name;
        this.amount = ingredient.amount;
        this.unit = ingredient.unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, unit);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }


    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void multiplyAmount(int multi) {
        amount *= multi;
    }
     public void addToAmount(double adder) {
        amount += adder;
     }
}
