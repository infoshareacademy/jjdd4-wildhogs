package com.company;

import java.util.Objects;

public class Ingredient {

    private double number;
    private String name;
    private double value;
    private Unit unit;

    //***************************************
    //********FOR  meat 200g ETC
    //***************************************
    public Ingredient(String name, double value, Unit unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;
    }

    //***************************************
    //********FOR 2 apples ETC
    //***************************************
    public Ingredient(String name, double number) {
        this.number = number;
        this.name = name;
    }

    //***************************************
    //********FOR an apple ETC
    //***************************************
    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.number, number) == 0 &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(name, that.name) &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, name, value, unit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (number != 0) {
            if (number % 1.0 == 0) {
                sb.append((int) number);

            } else
                sb.append(number);
            sb.append(" ");
            sb.append(name);
            if (number != 1) {
                sb.append("s");
            }
        } else if (value != 0) {
            sb.append(name);
            sb.append(" ");
            if (value % 1.0 == 0) {
                sb.append((int) value);
            } else
                sb.append(value);
            sb.append(unit.getDescription());
        } else if (name != null && value == 0 && number == 0) {
            if (name.toLowerCase().startsWith("^[aeiou]")) {
                sb.append("an");
            } else sb.append("a");

            sb.append(" ");
            sb.append(name);
        }


        return sb.toString();
    }


    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

