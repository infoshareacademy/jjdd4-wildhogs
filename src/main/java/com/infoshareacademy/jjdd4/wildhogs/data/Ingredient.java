package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Objects;

public class Ingredient {

    private final String name;
    private final double amount;
    private final Unit unit;

    public Ingredient(String name, double amount, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
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
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(name, that.name) &&
                unit == that.unit;
    }

    @Override
     public int hashCode() {
        return Objects.hash(name, amount, unit);
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

}
