package com.infoshareacademy.jjdd4.wildhogs.data;

import java.util.Arrays;

enum Option{
    EXIT("0"),
    SHOW_RECIPES("1"),
    SHOW_CHOSEN_RECIPES("2"),
    SHOW_SHOPPING_LIST("3"),
    SAVE_SHOPPING_LIST("4"),
    UNKNOWN("5");

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
