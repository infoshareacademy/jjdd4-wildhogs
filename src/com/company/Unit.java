package com.company;

public enum Unit {

    KILOGRAMS("kg"),
    GRAMS("g"),
    LITERS("l"),
    MILILITERS("ml");

    private String description;

    Unit (String desc){
        description=desc;
    }

    public String getDescription() {
        return description;
    }
}
