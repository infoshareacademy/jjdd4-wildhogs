package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Arrays;

enum Option{
    EXIT("0"),
    MENU("1"),
    SHOW_RECIPES("2"),
    SHOW_CHOSEN_RECIPES("3"),
    SHOW_SHOPPING_LIST("4"),
    SAVE_SHOPPING_LIST("5"),
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
