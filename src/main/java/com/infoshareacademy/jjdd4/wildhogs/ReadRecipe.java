package com.infoshareacademy.jjdd4.wildhogs;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadRecipe {


    public void read(Source source) {
        try {
            String a;
            FileReader reader = new FileReader(source.getSource());

        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path!");
            e.printStackTrace();
        }
    }
}
