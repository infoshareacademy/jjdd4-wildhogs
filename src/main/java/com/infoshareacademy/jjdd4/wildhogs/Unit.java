package com.infoshareacademy.jjdd4.wildhogs;

public enum Unit {

    KILOGRAMS("kg"),
    GRAMS("g"),
    LITERS("l"),
    MILLILITERS("ml"),
    CUP("cup"),
    CLOVES("cloves"),
    CENTIMETERS("cm"),
    UNIT("unit"),
    TEASPOON("ts") {

    };

    private String description;
    Unit(String desc) {
        description = desc;
    }
    public String getDescription() {
        return description;
    }
}
