package com.infoshareacademy.jjdd4.wildhogs;

import java.util.Objects;

public class Ingredient {

    final private String name;
    final private double amount;
    final private Unit unit;

    public Ingredient(String name, double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" ");
        sb.append(amount);
        sb.append(" ");
        sb.append(unit);
        sb.append(" ");


        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(name, that.name) &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, amount, unit);
    }
}

