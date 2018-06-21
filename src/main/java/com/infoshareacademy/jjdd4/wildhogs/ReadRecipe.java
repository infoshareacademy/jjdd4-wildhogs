package com.infoshareacademy.jjdd4.wildhogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadRecipe {


    public void read(Source source) {
        try {
            String a;
            FileReader reader = new FileReader(source.getSource());
            a = reader.toString().;

            System.out.println(a);


        } catch (FileNotFoundException e) {
            System.out.println("Wrong file path!");
            e.printStackTrace();
        }


    }
}
