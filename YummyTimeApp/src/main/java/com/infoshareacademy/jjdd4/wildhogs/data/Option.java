package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Arrays;

public enum Option {

    SHOW_RECIPES_BY_CATEGORY("1"),
    SHOW_CHOSEN_RECIPES("2"),
    SHOW_SHOPPING_LIST("3"),
    SAVE_SHOPPING_LIST("4"),
    EXIT("5"),
    UNKNOWN("6");

    private String optionNumber;

    Option(String opt) {
        optionNumber = opt;
    }

    public static Option fromNumber(String optionNumber) {
        return Arrays.stream(values())
                .filter(o -> o.optionNumber.equals(optionNumber))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
