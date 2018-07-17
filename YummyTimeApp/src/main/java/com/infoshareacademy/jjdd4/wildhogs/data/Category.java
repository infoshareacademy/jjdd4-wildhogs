package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Arrays;

public enum Category {

    BREAKFAST("1"),
    LUNCH("2"),
    DINNER("3"),
    SUPPER("4"),
    BACK("5"),
    WRONG_VALUE("6");

    private String categoryNumber;

    Category(String num) {
        categoryNumber = num;
    }

    public static Category fromNumber(String categoryNumber) {
        return Arrays
                .stream(values())
                .filter(p->p.categoryNumber.equals(categoryNumber))
                .findFirst()
                .orElse(Category.WRONG_VALUE);
    }
}